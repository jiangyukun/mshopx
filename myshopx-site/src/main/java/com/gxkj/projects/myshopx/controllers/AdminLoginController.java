package com.gxkj.projects.myshopx.controllers;

import com.gxkj.common.utils.ListPager;
import com.gxkj.projects.myshopx.entitys.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xubaoyong on 2016/2/28.
 */
@Controller
@RequestMapping("/admin")
public class AdminLoginController {

    Logger LOG = LoggerFactory.getLogger(AdminLoginController.class);

    @RequestMapping(value="login",method= RequestMethod.GET)
    public String index(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){
        return "admin/login";
    }
}
