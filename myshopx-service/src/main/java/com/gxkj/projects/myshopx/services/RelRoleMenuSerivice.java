package com.gxkj.projects.myshopx.services;


import com.gxkj.projects.myshopx.entitys.AdminMenu;

import java.util.List;

public interface RelRoleMenuSerivice {

    public List<AdminMenu> getAdminMenuListByRoleId(String roleId);
}
