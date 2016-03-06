package com.gxkj.projects.myshopx.services;

import com.gxkj.common.exceptions.ValidateException;
import com.gxkj.projects.myshopx.entitys.AdminMenu;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by xubaoyong on 2016/3/6.
 */
public class AdminMenuServiceTest  extends BaseSpringTest {

    Logger LOG = LoggerFactory.getLogger(AdminMenuServiceTest.class);

    @Autowired
    private  AdminMenuService adminMenuService;

    @Test
    public void doAddTest(){
        try {
//            doAddMenu("商品管理","",false,"0","",1);
//            doAddMenu("商品分页页面","/admin/goods/pager",false,"297e40e3534c28be01534c28c6d10000","",1);
//            doAddMenu("商品分页查看","/admin/goods/dopager",true,"297e40e3534c28be01534c28c6d10000","",1);
//            doAddMenu("增加商品","/admin/goods/doadd",true,"297e40e3534c28be01534c28c6d10000","",1);
            doAddMenu("修改商品","/admin/goods/doadd",true,"297e40e3534c28be01534c28c6d10000","",1);
            doAddMenu("放到回收站","/admin/goods/toecyclebin",true,"297e40e3534c28be01534c28c6d10000","",1);
            doAddMenu("回收站","/admin/goods/ecyclebin",false,"297e40e3534c28be01534c28c6d10000","",1);
            doAddMenu("删除","/admin/goods/dodel",false,"297e40e3534c28be01534c28c6d10000","",1);
            doAddMenu("还原","/admin/goods/dodel",false,"297e40e3534c28be01534c28c6d10000","",1);
        } catch (ValidateException e) {
            e.printStackTrace();
        }
    }

    private void doAddMenu(String name,String url,boolean isButton,String parentId,String action,double sort) throws ValidateException {

        AdminMenu adminMenu = adminMenuService.getAdminMenuByName(name);
        if(adminMenu == null){
            adminMenu = new AdminMenu();
            adminMenu.setCreatedAt(new Date());
            adminMenu.setParentId(parentId);
            adminMenu.setUpdatedAt(new Date());
            adminMenu.setAction(action);
            adminMenu.setButton(isButton);
            adminMenu.setName(name);
            adminMenu.setUrl(url);
            adminMenu.setSort(sort);
            adminMenuService.doAddAdminMenu(null,adminMenu);
        }else{
            adminMenu.setUpdatedAt(new Date());
            adminMenuService.doUpdateAdminMenu(null,adminMenu);
        }





    }


}
