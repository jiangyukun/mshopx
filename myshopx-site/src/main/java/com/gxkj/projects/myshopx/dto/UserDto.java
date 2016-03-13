package com.gxkj.projects.myshopx.dto;

import com.gxkj.projects.myshopx.entitys.Role;
import com.gxkj.projects.myshopx.entitys.User;

import java.util.List;


public class UserDto extends User {
    private static final long serialVersionUID = 4032877944223342478L;

    private List<Role> roleList;

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}
