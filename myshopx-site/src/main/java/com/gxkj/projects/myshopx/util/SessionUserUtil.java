package com.gxkj.projects.myshopx.util;

import com.gxkj.projects.myshopx.controllers.AdminLoginController;
import com.gxkj.projects.myshopx.dto.UserDto;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by xubaoyong on 2016/3/13.
 */
public class SessionUserUtil {
    /**
     * 查询管理员权限范围内的Authids
     * @param request
     * @return
     */
    public static String getUserAuthIds(HttpServletRequest request){
        UserDto dto= (UserDto) request.getSession().getAttribute(AdminLoginController.sessionUserDtoKey);
        if(dto == null ){
            return "";
        }else{
            return dto.getAuthIds();
        }
    }

    public static String getUserMenuUrls(HttpServletRequest request){
        UserDto dto= (UserDto) request.getSession().getAttribute(AdminLoginController.sessionUserDtoKey);
        if(dto == null ){
            return "";
        }else{
            return dto.getMenuUrls();
        }
    }
}
