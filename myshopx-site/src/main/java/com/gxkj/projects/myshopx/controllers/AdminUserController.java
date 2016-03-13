package com.gxkj.projects.myshopx.controllers;

import com.alibaba.fastjson.JSON;
import com.gxkj.common.utils.ListPager;
import com.gxkj.projects.myshopx.dto.ReturnData;
import com.gxkj.projects.myshopx.dto.RoleDto;
import com.gxkj.projects.myshopx.dto.UserDto;
import com.gxkj.projects.myshopx.entitys.AdminMenu;
import com.gxkj.projects.myshopx.entitys.Role;
import com.gxkj.projects.myshopx.entitys.User;
import com.gxkj.projects.myshopx.enums.ErrorCodeEnum;
import com.gxkj.projects.myshopx.enums.RoleState;
import com.gxkj.projects.myshopx.services.AdminRoleService;
import com.gxkj.projects.myshopx.services.RelAdminUserRoleService;
import com.gxkj.projects.myshopx.services.UserService;
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
@RequestMapping("/admin/adminuser")
public class AdminUserController {
    private static final Logger LOG = LoggerFactory.getLogger(AdminUserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private AdminRoleService adminRoleService;

    @Autowired
    private RelAdminUserRoleService relAdminUserRoleService;

    @RequestMapping(value="")
    public String index(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){
        String mv = "admin/adminuser";
        return mv;
    }
    @RequestMapping(value="dopager")
    @ResponseBody
    public ReturnData<ListPager<UserDto>>  dopager(User user,  int pageno,int pagesize,HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){
        ReturnData<ListPager<UserDto>> returnData = new ReturnData<ListPager<UserDto>>();
        ListPager<UserDto> pager2 = new  ListPager<UserDto>();
        ListPager<User> pager =  userService.doHqlPage(pageno,pagesize,user,true);
        BeanUtils.copyProperties(pager,pager2);
        if(pager.getPageData() != null && pager.getPageData().size() > 0){
            List<UserDto> roleDtoList = new ArrayList<UserDto>();
            for(User uer : pager.getPageData()){
                UserDto dto = new UserDto();
                BeanUtils.copyProperties(uer,dto);
//                LOG.info("user={}", JSON.toJSONString(uer));
//                LOG.info("userid-1:{}",user.getId());
//                LOG.info("userid-2:{}",dto.getId());
                dto.setRoleList(relAdminUserRoleService.getRoleByUserId(dto.getId()));
                roleDtoList.add(dto);
            }
            pager2.setPageData(roleDtoList);
        }
        returnData.setEntity(pager2);
        returnData.setStatusCode(ErrorCodeEnum.NORMAL.getCode());
        return returnData;

    }

    @RequestMapping(value="getbyqq")
    @ResponseBody
    public  ReturnData<User> get(String qq, HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){
        ReturnData<User> returnData = new ReturnData<User>();
        User entity =  userService.getByQq(qq);
        returnData.setEntity(entity);
        returnData.setStatusCode(ErrorCodeEnum.NORMAL.getCode());
        return returnData;
    }
    @RequestMapping(value="setadmin")
    @ResponseBody
    public  ReturnData<Boolean> setadmin(String id, HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){
        ReturnData<Boolean> returnData = new ReturnData<Boolean>();
          userService.setAdmin(null,id);
        returnData.setEntity(true);
        returnData.setStatusCode(ErrorCodeEnum.NORMAL.getCode());
        return returnData;
    }
    @RequestMapping(value="cancleadmin")
    @ResponseBody
    public  ReturnData<Boolean> cancleadmin(String id, HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){
        ReturnData<Boolean> returnData = new ReturnData<Boolean>();
        userService.cancleAdmin(null,id);
        returnData.setEntity(true);
        returnData.setStatusCode(ErrorCodeEnum.NORMAL.getCode());
        return returnData;
    }

    @RequestMapping(value="canselroles",method= RequestMethod.GET)
    @ResponseBody
    public  ReturnData<ListPager<Role>> dopage(
                                                  int pageno, int pagesize,
                                                  HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){

        ReturnData<ListPager<Role>> returnData = new ReturnData<ListPager<Role>>();
        Role entity = new Role();
        entity.setState(RoleState.NORMAL);
        ListPager<Role> pager =  adminRoleService.doHqlPage(pageno,pagesize,entity);
        returnData.setEntity(pager);
        returnData.setStatusCode(ErrorCodeEnum.NORMAL.getCode());
        return returnData;
    }
    @RequestMapping(value="setroles",method= RequestMethod.POST)
    @ResponseBody
    public  ReturnData<Boolean> setroles( String roles,String userId,
            HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){

        ReturnData<Boolean> returnData = new ReturnData<Boolean>();
        Role entity = new Role();
        entity.setState(RoleState.NORMAL);
          userService.setroles( null,userId,roles);
        returnData.setEntity(true);
        returnData.setStatusCode(ErrorCodeEnum.NORMAL.getCode());
        return returnData;
    }
}
