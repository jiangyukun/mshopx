package com.gxkj.projects.myshopx.enums;


public enum UserStatusEnum {

    NORMAL( "正常");

    private String name;



    UserStatusEnum(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
