package com.gxkj.projects.myshopx.services.impl;

import com.gxkj.common.exceptions.ValidateException;
import com.gxkj.common.utils.ValidatorUtil;
import com.gxkj.projects.myshopx.dao.AdminMenuDaoImpl;
import com.gxkj.projects.myshopx.entitys.AdminMenu;
import com.gxkj.projects.myshopx.entitys.User;
import com.gxkj.projects.myshopx.services.AdminMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminMenuServiceImpl implements AdminMenuService {

    @Autowired
    private ValidatorUtil validatorUtil;

    @Autowired
    private AdminMenuDaoImpl adminMenuDao;


    @Override
    public void doAddAdminMenu(User user, AdminMenu entity) throws ValidateException {
        validatorUtil.validate(entity,true);
        adminMenuDao.insert(entity);
    }


    public void doUpdateAdminMenu(User user, AdminMenu entity) throws ValidateException {
        validatorUtil.validate(entity,true);
        adminMenuDao.update(entity);
    }


    public void doDeleteAdminMenu(User user, String id) {
        adminMenuDao.deleteById(id,AdminMenu.class);
    }


    public List<AdminMenu> getAllAdminMenu() {
        return adminMenuDao.getAllAdminMenu();
    }

    @Override
    public AdminMenu getAdminMenuByName(String name) {
        return adminMenuDao.getAdminMenuByName(name);
    }
}
