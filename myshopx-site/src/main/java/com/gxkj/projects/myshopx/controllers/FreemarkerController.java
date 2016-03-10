package com.gxkj.projects.myshopx.controllers;

import com.gxkj.common.utils.SystemGlobals;
import com.gxkj.projects.myshopx.entitys.User;
import com.gxkj.projects.myshopx.enums.ErrorCodeEnum;
import freemarker.ext.beans.BeansWrapper;
import freemarker.template.TemplateModelException;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Controller
@RequestMapping("/freemarker")
public class FreemarkerController {

    @RequestMapping(value="",method= RequestMethod.GET)
    public String index(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){
        User user = new User();
        user.setQq("346745719");
        modelMap.addAttribute("user", user) ;
        SystemGlobals.setPreference("test","abc");

//        setDefaultStaticModel(modelMap);
        return "demo/freemarker";
    }


}
