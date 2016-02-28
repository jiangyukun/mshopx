package com.gxkj.projects.myshopx.entitys;

import com.gxkj.projects.myshopx.enums.GenderEnums;
import com.gxkj.projects.myshopx.enums.MenuTyp;

import javax.persistence.*;

/**
 * Created by xubaoyong on 2016/2/28.
 */
@Entity
@Table(name = "menu")
public class Menu extends BaseModel{

    private static final long serialVersionUID = -8193033028433954532L;


    @Column(name="menu_name")
    private String menuName;

    @Column(name="menu_action",length=128)
    private String menuAction;

    @Column(name="parent_id",length=64)
    private String parentId;


    @Column(name="menu_type",length=16)
    @Enumerated(EnumType.STRING)
    private MenuTyp menuTyp;

    @Column(name="seq",length=11)
    private double seq;


    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuAction() {
        return menuAction;
    }

    public void setMenuAction(String menuAction) {
        this.menuAction = menuAction;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public MenuTyp getMenuTyp() {
        return menuTyp;
    }

    public void setMenuTyp(MenuTyp menuTyp) {
        this.menuTyp = menuTyp;
    }

    public double getSeq() {
        return seq;
    }

    public void setSeq(double seq) {
        this.seq = seq;
    }
}
