package com.gxkj.projects.myshopx.enums;

/**
 * Created by xubaoyong on 2016/3/10.
 */
public enum RoleState {
    NORMAL( "正常"),DEL( "删除");;

    private String name;



    RoleState(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
