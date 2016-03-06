package com.gxkj.projects.myshopx.services;

import com.gxkj.common.exceptions.ValidateException;
import com.gxkj.projects.myshopx.entitys.AdminMenu;
import com.gxkj.projects.myshopx.entitys.Goods;
import com.gxkj.projects.myshopx.entitys.Menu;
import com.gxkj.projects.myshopx.entitys.User;

import java.util.List;

/**
 * Created by xubaoyong on 2016/3/6.
 */
public interface AdminMenuService {

    public void doAddAdminMenu(User user , AdminMenu entity) throws ValidateException;

    public void doUpdateAdminMenu(User user , AdminMenu entity) throws ValidateException;

    public void doDeleteAdminMenu(User user, String id);

    public List<AdminMenu> getAllAdminMenu();

    public AdminMenu getAdminMenuByName(String name);
}
