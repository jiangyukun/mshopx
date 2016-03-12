package com.gxkj.projects.myshopx.controllers;

import com.gxkj.common.exceptions.ValidateException;
import com.gxkj.common.utils.ListPager;
import com.gxkj.projects.myshopx.dto.ReturnData;
import com.gxkj.projects.myshopx.dto.RoleDto;
import com.gxkj.projects.myshopx.entitys.AdminMenu;
import com.gxkj.projects.myshopx.entitys.Role;
import com.gxkj.projects.myshopx.enums.ErrorCodeEnum;
import com.gxkj.projects.myshopx.enums.RoleState;
import com.gxkj.projects.myshopx.services.AdminRoleService;
import com.gxkj.projects.myshopx.services.RelRoleMenuSerivice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin/role")
public class AdminRoleController {
    private static final Logger LOG = LoggerFactory.getLogger(AdminRoleController.class);

    @Autowired
    private AdminRoleService adminRoleService;

    @Autowired
    private RelRoleMenuSerivice relRoleMenuSerivice;

    @RequestMapping(value="")
    public String index(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){
        String mv = "admin/admin_role";
        return mv;
    }
    @RequestMapping(value="dopage",method= RequestMethod.GET)
    @ResponseBody
    public  ReturnData<ListPager<RoleDto>> dopage(Role entity,
                         int pageno,int pagesize,
                         HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){

        ReturnData<ListPager<RoleDto>> returnData = new ReturnData<ListPager<RoleDto>>();

        ListPager<Role> pager =  adminRoleService.doHqlPage(pageno,pagesize,entity);
        ListPager<RoleDto> pager2 = new  ListPager<RoleDto>();
        BeanUtils.copyProperties(pager,pager2);
        if(pager.getPageData() != null && pager.getPageData().size() > 0){
                List<RoleDto> roleDtoList = new ArrayList<RoleDto>();
                for(Role role : pager.getPageData()){
                    RoleDto dto = new RoleDto();
                    BeanUtils.copyProperties(role,dto);
                    dto.setMenus( relRoleMenuSerivice.getAdminMenuListByRoleId(role.getId()));
                    roleDtoList.add(dto);
                }
                pager2.setPageData(roleDtoList);
        }
        returnData.setEntity(pager2);
        returnData.setStatusCode(ErrorCodeEnum.NORMAL.getCode());
        return returnData;

    }

    @RequestMapping(value="doadd",method= RequestMethod.POST)
    @ResponseBody
    public  ReturnData<Role>doAdd(Role entity,String menuIds,
                                  HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws ValidateException {

        ReturnData<Role> returnData = new ReturnData<Role>();
        adminRoleService.doAddRole(null,entity,menuIds);
        returnData.setEntity(entity);
        returnData.setStatusCode(ErrorCodeEnum.NORMAL.getCode());
        return returnData;
    }

    @RequestMapping(value="get",method= RequestMethod.GET)
    @ResponseBody
    public  ReturnData<Role>get(String id,
                                  HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws ValidateException {

        ReturnData<Role> returnData = new ReturnData<Role>();
        Role entity = adminRoleService.getRoleById(id);
        returnData.setEntity(entity);
        returnData.setStatusCode(ErrorCodeEnum.NORMAL.getCode());
        return returnData;
    }

    @RequestMapping(value="doupdate",method= RequestMethod.POST)
    @ResponseBody
    public  ReturnData<Role>doupdate(Role entity,String menuIds,
                                  HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws ValidateException {

        ReturnData<Role> returnData = new ReturnData<Role>();
        adminRoleService.doUpdateRole(null,entity, menuIds);
        returnData.setEntity(entity);
        returnData.setStatusCode(ErrorCodeEnum.NORMAL.getCode());
        return returnData;
    }

    @RequestMapping(value="setstatus",method= RequestMethod.POST)
    @ResponseBody
    public  ReturnData<Boolean>setstatus(String ids,RoleState state,
                                     HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws ValidateException {

        ReturnData<Boolean> returnData = new ReturnData<Boolean>();
        adminRoleService.doUpdateRoleState(null,ids,state);
        returnData.setEntity(true);
        returnData.setStatusCode(ErrorCodeEnum.NORMAL.getCode());
        return returnData;
    }
}
