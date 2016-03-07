package com.gxkj.projects.myshopx.controllers;

import com.gxkj.projects.myshopx.dto.ReturnData;
import com.gxkj.projects.myshopx.entitys.AdminMenu;
import com.gxkj.projects.myshopx.enums.ErrorCodeEnum;
import com.gxkj.projects.myshopx.services.AdminMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by dell on 2016/2/4.
 */
@Controller
@RequestMapping("/admin")
public class AdminIndexController {

    Logger LOG = LoggerFactory.getLogger(AdminIndexController.class);

    @Autowired
    private AdminMenuService adminMenuService;

    @RequestMapping(value="index",method= RequestMethod.GET)
    public String index(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){
        return "admin/index";
    }


}
