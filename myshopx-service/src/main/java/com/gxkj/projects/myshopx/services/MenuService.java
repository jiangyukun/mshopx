package com.gxkj.projects.myshopx.services;

import com.gxkj.projects.myshopx.entitys.Menu;

import java.util.List;

/**
 * Created by xubaoyong on 2016/2/28.
 */
public interface MenuService {

    public Menu addMenu(Menu menu);

    public Menu updateMenu(Menu menu);

    public void deleteMenu(String menuId);

    public List<Menu> getAllMenu();
}
