package com.gxkj.projects.myshopx.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by dell on 2016/2/4.
 */
@Controller
@RequestMapping("/admin")
public class AdminIndexController {

    Logger LOG = LoggerFactory.getLogger(AdminIndexController.class);


    @RequestMapping(value="index",method= RequestMethod.GET)
    public String index(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){
//        ListPager<User> userList =  userTService.doSqlPageTest(0,10,0,"");
        return "admin/index";
    }
}
