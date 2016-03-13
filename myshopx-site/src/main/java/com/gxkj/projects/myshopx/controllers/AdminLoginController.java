package com.gxkj.projects.myshopx.controllers;

import com.alibaba.fastjson.JSONArray;
import com.gxkj.common.exceptions.ValidateException;
import com.gxkj.common.utils.ListPager;
import com.gxkj.projects.myshopx.dto.ReturnData;
import com.gxkj.projects.myshopx.dto.UserDto;
import com.gxkj.projects.myshopx.entitys.AdminMenu;
import com.gxkj.projects.myshopx.entitys.Role;
import com.gxkj.projects.myshopx.entitys.User;
import com.gxkj.projects.myshopx.enums.ErrorCodeEnum;
import com.gxkj.projects.myshopx.services.RelAdminUserRoleService;
import com.gxkj.projects.myshopx.services.RelRoleMenuSerivice;
import com.gxkj.projects.myshopx.services.UserService;
import org.apache.commons.collections.SetUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by xubaoyong on 2016/2/28.
 */
@Controller
@RequestMapping("/admin")
public class AdminLoginController {

    Logger LOG = LoggerFactory.getLogger(AdminLoginController.class);

    public static final String sessionUserKey = "user";

    public static final String sessionUserDtoKey = "userdto";
    @Autowired
    private UserService userService;

    @Autowired
    private RelAdminUserRoleService relAdminUserRoleService;

    @Autowired
    private RelRoleMenuSerivice relRoleMenuSerivice;

    @RequestMapping(value="login",method= RequestMethod.GET)
    public String index(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){

        ServletContext servletContext = request.getSession().getServletContext();
        if (servletContext == null)        {            return null;        }
        WebApplicationContext appContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);

//获取所有的RequestMapping
        Map<String, HandlerMapping> allRequestMappings = BeanFactoryUtils.beansOfTypeIncludingAncestors(appContext, HandlerMapping.class, true, false);

        for (HandlerMapping handlerMapping : allRequestMappings.values())        {
            //本项目只需要RequestMappingHandlerMapping中的URL映射
             if (handlerMapping instanceof RequestMappingHandlerMapping)
             {                RequestMappingHandlerMapping requestMappingHandlerMapping = (RequestMappingHandlerMapping) handlerMapping;
                 Map<RequestMappingInfo, HandlerMethod> handlerMethods = requestMappingHandlerMapping.getHandlerMethods();
                 for (Map.Entry<RequestMappingInfo, HandlerMethod> requestMappingInfoHandlerMethodEntry : handlerMethods.entrySet())                {
                     RequestMappingInfo requestMappingInfo = requestMappingInfoHandlerMethodEntry.getKey();
                     HandlerMethod mappingInfoValue = requestMappingInfoHandlerMethodEntry.getValue();
                     RequestMethodsRequestCondition methodCondition = requestMappingInfo.getMethodsCondition();
                     Set<RequestMethod> requestType = methodCondition.getMethods()  ;
                     PatternsRequestCondition patternsCondition = requestMappingInfo.getPatternsCondition();
                     Set<String> requestUrl = patternsCondition.getPatterns() ;
                     String controllerName = mappingInfoValue.getBeanType().toString();
                     String requestMethodName = mappingInfoValue.getMethod().getName();
                     Class<?>[] methodParamTypes = mappingInfoValue.getMethod().getParameterTypes();
                     LOG.info("requestUrl="+requestUrl+" ;controllerName="+controllerName+" ;requestMethodName="+requestMethodName);
                 }
                 break;
             }
        }
         return "admin/login";
    }

    @RequestMapping(value="dologin",method= RequestMethod.POST)
    @ResponseBody
    public ReturnData<User> dologin(User user, HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws ValidateException {
        ReturnData<User> returnData = new ReturnData<User>();
        user = userService.doLogin(user);
        UserDto dto = null;
        //看看用户角色，和用户可查看的菜单
        if(user  != null){
            dto = new UserDto();
            BeanUtils.copyProperties(user,dto);
            if(dto.isAdmin()){
                List<Role> roleList =  relAdminUserRoleService.getRoleByUserId(user.getId());
                dto.setRoleList(roleList);
                if(roleList != null){
                    //设置用户可以查看的菜单
                    Set<AdminMenu> menuSet = new HashSet<AdminMenu>();
                    JSONArray roleNameJSONArray = new JSONArray();
                    for(Role item : roleList){
                        List<AdminMenu> menuList =   relRoleMenuSerivice.getAdminMenuListByRoleId(item.getId());
                        menuSet.addAll(menuList);

                        roleNameJSONArray.add(item.getName());
                    }
                    dto.setMenuSet(menuSet);
                    LOG.info("QQ["+dto.getQq()+"]拥有这些角色："+roleNameJSONArray.toJSONString());


                    StringBuffer urls = new StringBuffer();
                    StringBuffer authorityIds = new StringBuffer();
                    int menuIndex = 0;
                    int authorityIndex = 0;

                    JSONArray menuAuthorityIdJSONArray = new JSONArray();
                    JSONArray menuUrlJSONArray = new JSONArray();
                    JSONArray menuNameJSONArray = new JSONArray();
                    for(AdminMenu menuItem :menuSet){
                        if(authorityIndex == 0 && StringUtils.isNoneBlank(menuItem.getAuthorityId())){
                            authorityIds.append(menuItem.getAuthorityId());
                            authorityIndex++;
                        }
                        if(menuIndex == 0 && StringUtils.isNoneBlank(menuItem.getUrl())){
                            urls.append(menuItem.getUrl());
                            menuIndex ++;
                        }
                        if(authorityIndex >0  && StringUtils.isNoneBlank(menuItem.getAuthorityId())){
                            authorityIds.append(","+menuItem.getAuthorityId());
                        }
                        if(menuIndex >0 && StringUtils.isNoneBlank(menuItem.getUrl()) ){
                            urls.append(","+menuItem.getUrl());
                        }
                        if(  StringUtils.isNoneBlank(menuItem.getAuthorityId()) ){
                            menuAuthorityIdJSONArray.add(menuItem.getAuthorityId());
                        }
                        if(  StringUtils.isNoneBlank(menuItem.getUrl()) ){
                            menuUrlJSONArray.add(menuItem.getUrl());
                        }
                        if(  StringUtils.isNoneBlank(menuItem.getName()) ){
                            menuNameJSONArray.add(menuItem.getName());
                        }
                    }
                    LOG.info("QQ["+dto.getQq()+"]可查看这些菜单："+menuNameJSONArray.toJSONString());
                    LOG.info("QQ["+dto.getQq()+"]可查看这些菜单URL："+menuUrlJSONArray.toJSONString());
                    LOG.info("QQ["+dto.getQq()+"]拥有这些权限："+menuAuthorityIdJSONArray.toJSONString());
                    dto.setMenuUrls(urls.toString());
                    dto.setAuthIds(authorityIds.toString());
                }
            }

        }
        request.getSession().setAttribute(sessionUserKey,user);
        request.getSession().setAttribute(sessionUserDtoKey,dto);

        returnData.setEntity(user);
        returnData.setStatusCode(ErrorCodeEnum.NORMAL.getCode());
        return returnData;
    }
}
