package com.gxkj.projects.myshopx.interceptors;

/**
 * Created by dell on 2016/3/10.
 */

import com.alibaba.fastjson.JSON;
import com.gxkj.common.exceptions.AuthorityException;
import com.gxkj.common.utils.SystemGlobals;
import com.gxkj.projects.myshopx.controllers.AdminLoginController;
import com.gxkj.projects.myshopx.dto.UserDto;
import com.gxkj.projects.myshopx.entitys.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminUrlInterceptor extends HandlerInterceptorAdapter {

    Logger LOG = LoggerFactory.getLogger(AdminUrlInterceptor.class);
    /**
     * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion()
     */
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        if(ex!=null){
            ex.printStackTrace();
        }

        super.afterCompletion(request, response, handler, ex) ;
    }

    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
                           Object arg2, ModelAndView arg3) throws Exception {

        super.postHandle(arg0, arg1, arg2, arg3) ;
    }

    public boolean preHandle(HttpServletRequest req, HttpServletResponse response,
                             Object handler) throws Exception {
//		MethodNameResolver methodNameResolver = new InternalPathMethodNameResolver();
//		System.out.println("methodName="+methodNameResolver.getHandlerMethodName(req));
//		System.out.println("权限拦截---------------");

//		HandlerMethod handlerMethod = (HandlerMethod) handler;
//		Method method = handlerMethod.getMethod();

        String url = req.getRequestURI();
        String ctx = req.getContextPath();
        url = url.replace(ctx, "");
//        if(logger.isDebugEnabled()){
//            Enumeration<String> keys = req.getParameterNames();
//            while(keys.hasMoreElements()) {
//                String k = keys.nextElement();
//                logger.debug( "{}={}",k ,req.getParameter(k));
//            }
//
//            Map pathVariables = (Map) req.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
//            if(pathVariables!=null){
//                Set set = pathVariables.keySet();
//                Iterator it =set.iterator();
//                while(it.hasNext()){
//                    logger.debug("{}",it.next());
//                }
//            }
//        }



        if(url.indexOf("bdunion.txt")>=0){
            return true;
        }
        if(url.indexOf("/exception")>=0 || url.indexOf("/games")>=0){
            return true;
        }
        if(url.indexOf("/admin")>=0){
            //管理员过滤
            if(url.equals("/admin/")|| url.indexOf("login")>=0 || url.indexOf("dologin")>=0 || url.indexOf("logout")>=0){
                return true;
            }
            User user = (User) req.getSession().getAttribute(AdminLoginController.sessionUserKey);
            UserDto dto = (UserDto) req.getSession().getAttribute(AdminLoginController.sessionUserDtoKey);


            if(SystemGlobals.getPreference("system.admin.allow.urls").indexOf(","+url+",")>=0){
                return true;
            }
            if(dto != null){
                String authPath = dto.getMenuUrls();
                if((","+authPath+",").indexOf(","+url+",")>=0){
                    return true;
                }else {
                    throw new AuthorityException(url);
                }
            }else {
                LOG.info("您无权访问"+url);
            }
        }else {
            //前台来的
            if(		"/".equals(url)
                    ||"".equals(url)
                    ||  url.indexOf("/story/")>=0
                    ||  url.indexOf("/xuetang")>=0
                    ||  url.indexOf("/login")>=0
                    || url.indexOf("reg")>=0
                    ||  url.indexOf("/exception")>=0
                    ||  url.indexOf("/red5")>=0
                    ||  url.indexOf("/yanzhengma")>=0
                    ||  url.indexOf("/about")>=0
                    ||  url.indexOf("/findbackpassword")>=0) {
                return true;
            }

            return  true;

        }


        return false;
    }




}