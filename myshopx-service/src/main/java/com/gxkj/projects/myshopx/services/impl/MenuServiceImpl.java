package com.gxkj.projects.myshopx.services.impl;

import com.gxkj.projects.myshopx.dao.MenuDaoImpl;
import com.gxkj.projects.myshopx.entitys.Menu;
import com.gxkj.projects.myshopx.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xubaoyong on 2016/2/28.
 */
@Service
public class MenuServiceImpl  implements MenuService {

    @Autowired
    private MenuDaoImpl menuDao;

    public Menu addMenu(Menu menu) {
        menuDao.insert(menu);
        return menu;
    }


    public Menu updateMenu(Menu menu) {
        menuDao.update( menu);
        return menu;
    }


    public void deleteMenu(String menuId) {
        menuDao.deleteById(menuId,Menu.class);
    }


    public List<Menu> getAllMenu() {
        return menuDao.getAllMenu();
    }
}
