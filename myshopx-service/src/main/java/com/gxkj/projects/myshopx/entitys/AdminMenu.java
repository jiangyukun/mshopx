package com.gxkj.projects.myshopx.entitys;

import com.gxkj.common.validate.Add;
import com.gxkj.common.validate.Update;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 后台菜单
 */
@Entity
@Table(name = "admin_menu")
public class AdminMenu extends BaseModel{

    private static final long serialVersionUID = 45148739947309160L;
    @Column(name="name",nullable = false)
    @NotNull(message = "{admin_menu.name.null}", groups = {Add.class, Update.class})
    private String name;    //名称

    @Column(name="url",nullable = false)
    private String url;         //路径

    @Column(name="is_button",nullable = false)
    @org.hibernate.annotations.Type(type="yes_no")
    private Boolean  isButton;  //是菜单还是按钮

    @Column(name="parent_id",nullable = false)
    private String parentId;    //上级菜单ID

    @Column(name="action",nullable = false)
    private String action;

    @Column(name="desc",nullable = false)
    private String desc;    //菜单描述

    @Column(name="sort",nullable = false)
    private double sort;        //排序

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getButton() {
        return isButton;
    }

    public void setButton(Boolean button) {
        isButton = button;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public double getSort() {
        return sort;
    }

    public void setSort(double sort) {
        this.sort = sort;
    }
}
