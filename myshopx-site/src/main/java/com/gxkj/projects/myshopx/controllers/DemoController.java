package com.gxkj.projects.myshopx.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Controller
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    CookieLocaleResolver resolver;
    //@Autowired SessionLocaleResolver resolver;

    @RequestMapping(value="i18n",method= RequestMethod.GET)
    public String index(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){
        String language = request.getParameter("language");
        if(language==null||language.equals("")){
            return "demo/i18n" ;
        }else{
            language=language.toLowerCase();
            if(language.equals("zh_cn")){
                resolver.setLocale(request, response, Locale.CHINA );
            }else if(language.equals("en")){
                resolver.setLocale(request, response, Locale.ENGLISH );
            }else{
                resolver.setLocale(request, response, Locale.CHINA );
            }
        }
        return "demo/i18n";
    }
}
