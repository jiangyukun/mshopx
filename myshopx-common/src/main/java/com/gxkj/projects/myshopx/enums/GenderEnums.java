package com.gxkj.projects.myshopx.enums;

/**
 * Created by dell on 2016/2/4.
 */
public enum  GenderEnums {

    MAN("MAN","男"),WOMEN("WOMEN","女");

    private String value;

    private String desc;

    GenderEnums(String value,String desc){
        this.desc = desc;
        this.value = value;
    }

    public static void main(String[] args) {
        System.out.println(GenderEnums.MAN.name());
    }
}
