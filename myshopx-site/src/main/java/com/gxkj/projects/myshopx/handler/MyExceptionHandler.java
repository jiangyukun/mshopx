package com.gxkj.projects.myshopx.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gxkj.common.dto.ValidateDescDto;
import com.gxkj.common.exceptions.BusinessException;
import com.gxkj.common.exceptions.ValidateException;
import com.gxkj.projects.myshopx.dto.ReturnData;
import com.gxkj.projects.myshopx.enums.ErrorCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by xubaoyong on 2016/3/5.
 */
public class MyExceptionHandler extends SimpleMappingExceptionResolver {

    private  static Logger LOG = LoggerFactory.getLogger(MyExceptionHandler.class);

    protected ModelAndView doResolveException(HttpServletRequest request,
                                              HttpServletResponse response, Object handler, Exception ex) {
        String viewName = determineViewName(ex, request);

        if (!StringUtils.isEmpty(viewName)) {// JSP格式返回
            if (!(request.getHeader("accept").indexOf("application/json") > -1 || (request
                    .getHeader("X-Requested-With")!= null && request
                    .getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1))) {
                // 如果不是异步请求
                // Apply HTTP status code for error views, if specified.
                // Only apply it if we're processing a top-level request.
                request.setAttribute("ex",ex);
                return getModelAndView(viewName, ex, request);
            } else {// JSON格式返回
                if (ex instanceof ValidateException){
                    ValidateException exception = (ValidateException)ex;
                    if(exception.isSingle()){
                        ReturnData<ValidateDescDto> returnData = new ReturnData<ValidateDescDto>();
                        returnData.setStatusCode(ErrorCodeEnum.VALID_FIELD_ERROR.toString());
                        returnData.setEntity(exception.getValidateDescDto());
                        try {
                            doWriteJsonData( response,returnData,ex);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }else {
                        ReturnData<List<ValidateDescDto>> returnData = new ReturnData<List<ValidateDescDto>>();
                        returnData.setStatusCode(ErrorCodeEnum.VALID_FIELD_ERROR.toString());
                        returnData.setEntity(exception.getValidateDescDtos());
                        try {
                            doWriteJsonData( response,returnData,ex);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }else if(ex instanceof BusinessException){
                    BusinessException  exception = (BusinessException)ex;
                }
                return null;
            }
        }
        return getModelAndView(viewName, ex, request);

    }

    private void doWriteJsonData(HttpServletResponse response,Object errorObj,Exception ex) throws IOException {

        if(errorObj != null){
            PrintWriter writer = response.getWriter();
            writer.write(JSON.toJSONString(errorObj));
            writer.flush();
        }else {
            ex.printStackTrace();
            LOG.error("{}",ex.getMessage());
        }
    }
}
