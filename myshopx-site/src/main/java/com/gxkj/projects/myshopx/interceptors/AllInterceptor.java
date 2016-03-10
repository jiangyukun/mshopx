package com.gxkj.projects.myshopx.interceptors;

/**
 * Created by dell on 2016/3/10.
 */
import com.gxkj.common.utils.SystemGlobals;
import com.gxkj.projects.myshopx.enums.ErrorCodeEnum;
import freemarker.ext.beans.BeansWrapper;
import freemarker.template.TemplateModelException;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

public class AllInterceptor implements WebRequestInterceptor {

    /**
     * 在请求处理之前执行，该方法主要是用于准备资源数据的，然后可以把它们当做请求属性放到WebRequest中
     */
    @Override
    public void preHandle(WebRequest request) throws Exception {
        // TODO Auto-generated method stub
        System.out.println("AllInterceptor...............................");
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

        setDefaultStaticModel(modelMap);
    }

    /**
     * 该方法将在整个请求完成之后，也就是说在视图渲染之后进行调用，主要用于进行一些资源的释放
     */
    @Override
    public void afterCompletion(WebRequest request, Exception exception)
            throws Exception {
        // TODO Auto-generated method stub
        System.out.println(exception + "-=-=--=--=-=-=-=-=-=-=-=-==-=--=-=-=-=");
    }


    /*******************************
     *  个性定制，需要添加的静态类
     */
    private static Class[] defaultStaticClasses={ SystemGlobals.class,
            RandomStringUtils.class,
            ErrorCodeEnum.class,
            RandomUtils.class};
    protected static void setDefaultStaticModel(ModelMap modelMap) {
        for (Class clz : defaultStaticClasses) {
            String name = clz.getSimpleName();
            modelMap.addAttribute(name, getStaticModel(clz));
        }
    }

    private static Object getStaticModel(Class clz) {
        BeansWrapper wrapper = BeansWrapper.getDefaultInstance();
        try {
            return wrapper.getStaticModels().get(clz.getName());
        } catch (TemplateModelException e) {
            e.printStackTrace();
        }
        return null;
    }

}