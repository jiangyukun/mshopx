package com.gxkj.projects.myshopx.controllers;

import com.gxkj.common.utils.ListPager;
import com.gxkj.projects.myshopx.dto.ReturnData;
import com.gxkj.projects.myshopx.entitys.AdminMenu;
import com.gxkj.projects.myshopx.entitys.Role;
import com.gxkj.projects.myshopx.entitys.User;
import com.gxkj.projects.myshopx.enums.ErrorCodeEnum;
import com.gxkj.projects.myshopx.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/admin/adminuser")
public class AdminUserController {
    private static final Logger LOG = LoggerFactory.getLogger(AdminUserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value="")
    public String index(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){
        String mv = "admin/adminuser";
        return mv;
    }
    @RequestMapping(value="dopager")
    @ResponseBody
    public ReturnData<ListPager<User>>  dopager(User user,  int pageno,int pagesize,HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){
        ReturnData<ListPager<User>> returnData = new ReturnData<ListPager<User>>();
        ListPager<User> pager =  userService.doHqlPage(pageno,pagesize,user,true);
        returnData.setEntity(pager);
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
}
