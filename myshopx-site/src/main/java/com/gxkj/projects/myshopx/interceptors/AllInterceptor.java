package com.gxkj.projects.myshopx.interceptors;

/**
 * Created by dell on 2016/3/10.
 */

import com.alibaba.fastjson.JSON;
import com.gxkj.projects.myshopx.controllers.AdminLoginController;
import com.gxkj.projects.myshopx.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

public class AllInterceptor implements WebRequestInterceptor {

    Logger LOG = LoggerFactory.getLogger(AllInterceptor.class);
    /**
     * 在请求处理之前执行，该方法主要是用于准备资源数据的，然后可以把它们当做请求属性放到WebRequest中
     */
    @Override
    public void preHandle(WebRequest request) throws Exception {
        // TODO Auto-generated method stub
//        LOG.info("AllInterceptor...............................");
        request.setAttribute("request", "request", WebRequest.SCOPE_REQUEST);//这个是放到request范围内的，所以只能在当前请求中的request中获取到
        request.setAttribute("session", "session", WebRequest.SCOPE_SESSION);//这个是放到session范围内的，如果环境允许的话它只能在局部的隔离的会话中访问，否则就是在普通的当前会话中可以访问
        request.setAttribute("globalSession", "globalSession", WebRequest.SCOPE_GLOBAL_SESSION);//如果环境允许的话，它能在全局共享的会话中访问，否则就是在普通的当前会话中访问


    }

    /**
     * 该方法将在Controller执行之后，返回视图之前执行，ModelMap表示请求Controller处理之后返回的Model对象，所以可以在
     * 这个方法中修改ModelMap的属性，从而达到改变返回的模型的效果。
     */
    @Override
    public void postHandle(WebRequest request, ModelMap modelMap) throws Exception {
        // TODO Auto-generated method stub
//        for (String key:modelMap.keySet())
//            System.out.println(key + "-------------------------");;
//        modelMap.put("name3", "value3");
//        modelMap.put("name1", "name1");

        RequestAttributes attributes =  RequestContextHolder.getRequestAttributes();
        Object user =  attributes.getAttribute(AdminLoginController.sessionUserKey,RequestAttributes.SCOPE_SESSION);
        Object userDto =  attributes.getAttribute(AdminLoginController.sessionUserDtoKey,RequestAttributes.SCOPE_SESSION);
		if(user != null && modelMap != null){
            modelMap.put(AdminLoginController.sessionUserKey,user);
            modelMap.put(AdminLoginController.sessionUserDtoKey,userDto);

            LOG.info("user={}", JSON.toJSONString(user));
        }


    }

    /**
     * 该方法将在整个请求完成之后，也就是说在视图渲染之后进行调用，主要用于进行一些资源的释放
     */
    @Override
    public void afterCompletion(WebRequest request, Exception exception)
            throws Exception {
        // TODO Auto-generated method stub
        if(exception != null){
            LOG.info(exception + "-=-=--=--=-=-=-=-=-=-=-=-==-=--=-=-=-=");
        }

    }




}