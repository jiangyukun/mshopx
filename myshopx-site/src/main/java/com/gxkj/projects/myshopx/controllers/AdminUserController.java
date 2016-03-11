package com.gxkj.projects.myshopx.controllers;

import com.gxkj.projects.myshopx.entitys.User;
import com.gxkj.projects.myshopx.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String dopager(User user, HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){
        String mv = "admin/adminuser";
        return mv;
    }
}
