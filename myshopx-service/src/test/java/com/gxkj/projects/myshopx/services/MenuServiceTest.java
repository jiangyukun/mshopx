package com.gxkj.projects.myshopx.services;

import com.alibaba.fastjson.JSON;
import com.gxkj.projects.myshopx.entitys.Menu;
import com.gxkj.projects.myshopx.enums.MenuTyp;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * Created by xubaoyong on 2016/2/28.
 */
public class MenuServiceTest extends BaseSpringTest {

    Logger LOG = LoggerFactory.getLogger(MenuServiceTest.class);

    @Autowired
    private MenuService menuService;

    @Test
    public void doAddTest(){
        Menu menu = new Menu();
        menu.setMenuAction("");
        menu.setMenuName("菜单管理");
        menu.setMenuTyp(MenuTyp.MENU);
        menu.setParentId("0");
        menu.setSeq(1);
        menu.setCreatedAt(new Date());
        menu.setUpdatedAt(new Date());

        menuService.addMenu(menu);
        LOG.info("new add menu`id is {}",menu.getId());
    }
    @Test
    public void getAllMenuTest(){
        List<Menu>  menus =  menuService.getAllMenu();
        LOG.info("menus is {}", JSON.toJSONString(menus));
    }
}
