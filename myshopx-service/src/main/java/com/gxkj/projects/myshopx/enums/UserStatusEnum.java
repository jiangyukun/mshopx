package com.gxkj.projects.myshopx.enums;


public enum UserStatusEnum {

    NORMAL("NORMAL","正常");

    private String value;

    private String desc;



    UserStatusEnum(String value, String desc){
        this.value = value;
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
