package com.gxkj.projects.myshopx.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;


public class MessageController {

    @Autowired
    CookieLocaleResolver resolver;
//@Autowired SessionLocaleResolver resolver;
    /**
     * 语言切换
     */
    @RequestMapping(value="18n",method= RequestMethod.GET)
    public String  language(HttpServletRequest request, HttpServletResponse response, String language){
        language=language.toLowerCase();
        if(language==null||language.equals("")){
            return "demo/i18n" ;
        }else{
            if(language.equals("zh_cn")){
                resolver.setLocale(request, response, Locale.CHINA );
            }else if(language.equals("en")){
                resolver.setLocale(request, response, Locale.ENGLISH );
            }else{
                resolver.setLocale(request, response, Locale.CHINA );
            }
        }
        return "demo/i18n" ;
    }

}
