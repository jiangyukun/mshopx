package com.gxkj.projects.myshopx.enums;

/**
 * Created by xubaoyong on 2016/2/28.
 */
public enum MenuTyp {

    MENU("MENU","菜单"),BUTTON("BUTTON","按钮");

    private String value;

    private String desc;

    MenuTyp(String value, String desc){
        this.desc = desc;
        this.value = value;
    }

}
