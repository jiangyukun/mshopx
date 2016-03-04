package com.gxkj.projects.myshopx.controllers;

import com.gxkj.common.utils.ListPager;
import com.gxkj.projects.myshopx.entitys.User;
import org.apache.commons.collections.SetUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Set;

/**
 * Created by xubaoyong on 2016/2/28.
 */
@Controller
@RequestMapping("/admin")
public class AdminLoginController {

    Logger LOG = LoggerFactory.getLogger(AdminLoginController.class);

    @RequestMapping(value="login",method= RequestMethod.GET)
    public String index(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){

        ServletContext servletContext = request.getSession().getServletContext();
        if (servletContext == null)        {            return null;        }
        WebApplicationContext appContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);

//获取所有的RequestMapping
        Map<String, HandlerMapping> allRequestMappings = BeanFactoryUtils.beansOfTypeIncludingAncestors(appContext, HandlerMapping.class, true, false);

        for (HandlerMapping handlerMapping : allRequestMappings.values())        {
            //本项目只需要RequestMappingHandlerMapping中的URL映射
             if (handlerMapping instanceof RequestMappingHandlerMapping)
             {                RequestMappingHandlerMapping requestMappingHandlerMapping = (RequestMappingHandlerMapping) handlerMapping;
                 Map<RequestMappingInfo, HandlerMethod> handlerMethods = requestMappingHandlerMapping.getHandlerMethods();
                 for (Map.Entry<RequestMappingInfo, HandlerMethod> requestMappingInfoHandlerMethodEntry : handlerMethods.entrySet())                {
                     RequestMappingInfo requestMappingInfo = requestMappingInfoHandlerMethodEntry.getKey();
                     HandlerMethod mappingInfoValue = requestMappingInfoHandlerMethodEntry.getValue();
                     RequestMethodsRequestCondition methodCondition = requestMappingInfo.getMethodsCondition();
                     Set<RequestMethod> requestType = methodCondition.getMethods()  ;
                     PatternsRequestCondition patternsCondition = requestMappingInfo.getPatternsCondition();
                     Set<String> requestUrl = patternsCondition.getPatterns() ;
                     String controllerName = mappingInfoValue.getBeanType().toString();
                     String requestMethodName = mappingInfoValue.getMethod().getName();
                     Class<?>[] methodParamTypes = mappingInfoValue.getMethod().getParameterTypes();
                     LOG.info("requestUrl="+requestUrl+" ;controllerName="+controllerName+" ;requestMethodName="+requestMethodName);
                 }
                 break;
             }
        }

return "admin/login";
    }
}
