package com.gxkj.projects.myshopx.services.impl;

import com.gxkj.projects.myshopx.dao.RelRoleMenuDaoImpl;
import com.gxkj.projects.myshopx.entitys.AdminMenu;
import com.gxkj.projects.myshopx.services.RelRoleMenuSerivice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelRoleMenuSeriviceImpl implements RelRoleMenuSerivice {

    Logger LOG = LoggerFactory.getLogger(RelRoleMenuSeriviceImpl.class);

    @Autowired
    private RelRoleMenuDaoImpl relRoleMenuDao;

    public List<AdminMenu> getAdminMenuListByRoleId(String roleId) {
        return relRoleMenuDao.getMenuByRoleId(roleId);
    }
}
