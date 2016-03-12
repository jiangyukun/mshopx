package com.gxkj.projects.myshopx.dto;

import com.gxkj.projects.myshopx.entitys.AdminMenu;
import com.gxkj.projects.myshopx.entitys.Role;

import java.util.List;


public class RoleDto extends Role {


    private static final long serialVersionUID = -6903694672894753299L;

    private List<AdminMenu> menus;

    public List<AdminMenu> getMenus() {
        return menus;
    }

    public void setMenus(List<AdminMenu> menus) {
        this.menus = menus;
    }
}
