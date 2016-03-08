package com.gxkj.projects.myshopx.controllers;

import com.gxkj.common.exceptions.ValidateException;
import com.gxkj.projects.myshopx.dto.ReturnData;
import com.gxkj.projects.myshopx.entitys.User;
import com.gxkj.projects.myshopx.enums.ErrorCodeEnum;
import com.gxkj.projects.myshopx.services.UserService;
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

/**
 * Created by dell on 2016/3/8.
 */
@Controller
@RequestMapping("/admin")
public class LoginController {

    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value="dologin",method= RequestMethod.POST)
    @ResponseBody
    public ReturnData<User> dologin(User user, HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws ValidateException {
        ReturnData<User> returnData = new ReturnData<User>();
        userService.doLogin(user);
        returnData.setEntity(user);
        returnData.setStatusCode(ErrorCodeEnum.NORMAL.getCode());
        return returnData;
    }
}
