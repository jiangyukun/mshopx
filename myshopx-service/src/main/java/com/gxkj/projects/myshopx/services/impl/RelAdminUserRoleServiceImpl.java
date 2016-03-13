package com.gxkj.projects.myshopx.services.impl;

import com.gxkj.projects.myshopx.dao.RelAdminUserRoleDaoImpl;
import com.gxkj.projects.myshopx.entitys.Role;
import com.gxkj.projects.myshopx.services.RelAdminUserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelAdminUserRoleServiceImpl implements RelAdminUserRoleService {

    Logger LOG = LoggerFactory.getLogger(RelAdminUserRoleServiceImpl.class);

    @Autowired
    private RelAdminUserRoleDaoImpl relAdminUserRoleDao;

    public List<Role> getRoleByUserId(String userId) {
        return relAdminUserRoleDao.getRoleByUserId(userId);
    }
}
