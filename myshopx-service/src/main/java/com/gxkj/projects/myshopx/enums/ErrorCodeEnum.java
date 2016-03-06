package com.gxkj.projects.myshopx.enums;

/**
 * Created by xubaoyong on 2016/3/5.
 */
public enum ErrorCodeEnum {

    NORMAL("0000000","正常"),
    VALID_FIELD_ERROR("0000001","字段验证错误");

    private String code;

    private String msg;

    ErrorCodeEnum(String code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
