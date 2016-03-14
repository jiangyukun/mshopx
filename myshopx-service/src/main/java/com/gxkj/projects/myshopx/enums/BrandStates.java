package com.gxkj.projects.myshopx.enums;

/**
 * Created by xubaoyong on 2016/3/14.
 */
public enum BrandStates {

    NORMAL( "正常"),DEL( "删除");;

    private String name;



    BrandStates(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
