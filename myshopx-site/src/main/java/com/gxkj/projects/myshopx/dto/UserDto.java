package com.gxkj.projects.myshopx.dto;

import com.gxkj.projects.myshopx.entitys.AdminMenu;
import com.gxkj.projects.myshopx.entitys.Role;
import com.gxkj.projects.myshopx.entitys.User;

import java.util.List;
import java.util.Set;


public class UserDto extends User {
    private static final long serialVersionUID = 4032877944223342478L;

    private List<Role> roleList;

    private Set<AdminMenu> menuSet;

    private String authIds;

    private String menuUrls;

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public Set<AdminMenu> getMenuSet() {
        return menuSet;
    }

    public void setMenuSet(Set<AdminMenu> menuSet) {
        this.menuSet = menuSet;
    }

    public String getAuthIds() {
        return authIds;
    }

    public void setAuthIds(String authIds) {
        this.authIds = authIds;
    }

    public String getMenuUrls() {
        return menuUrls;
    }

    public void setMenuUrls(String menuUrls) {
        this.menuUrls = menuUrls;
    }
}
