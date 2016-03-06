package com.gxkj.common.exceptions;

/**
 * Created by xubaoyong on 2016/3/6.
 */
public class BusinessException extends RuntimeException  {
    private static final long serialVersionUID = 7692747165638512813L;

    private String statusCode;

    private String errorMsg;

    public BusinessException(String statusCode,String errorMsg){
        super(errorMsg);
        this.errorMsg = errorMsg;
        this.statusCode = statusCode;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
