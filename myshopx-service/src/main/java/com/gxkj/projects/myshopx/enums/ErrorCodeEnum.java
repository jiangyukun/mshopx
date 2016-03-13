package com.gxkj.projects.myshopx.enums;

/**
 * Created by xubaoyong on 2016/3/5.
 */
public enum ErrorCodeEnum {

    NORMAL("0000000","正常"),
    VALID_FIELD_ERROR("0000001","字段验证错误"),
    SYSTEM_ERROR("0000002","数据库执行错误"),
    NOAUTHORITY_ERROR("0000003","没有权限");

    private String code;

    private String msg;

    ErrorCodeEnum(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
