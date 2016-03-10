package com.gxkj.projects.myshopx.controllers;

import com.gxkj.common.exceptions.ValidateException;
import com.gxkj.projects.myshopx.dto.ReturnData;
import com.gxkj.projects.myshopx.entitys.User;
import com.gxkj.projects.myshopx.enums.ErrorCodeEnum;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/admin")
public class AdminLogoutController {

    @RequestMapping(value="logout",method= RequestMethod.GET)
    public String dologin(  HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws ValidateException {
        request.getSession().invalidate();
        return "admin/login";
    }
}
