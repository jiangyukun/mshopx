package com.gxkj.projects.myshopx.services.impl;

import com.gxkj.common.exceptions.ValidateException;
import com.gxkj.common.utils.ValidatorUtil;
import com.gxkj.projects.myshopx.dao.RoleDaoImpl;
import com.gxkj.projects.myshopx.entitys.Role;
import com.gxkj.projects.myshopx.entitys.User;
import com.gxkj.projects.myshopx.services.AdminRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Date;

@Service
public class AdminRoleServiceImpl implements AdminRoleService {

    Logger LOG = LoggerFactory.getLogger(AdminRoleServiceImpl.class);

    @Autowired
    private RoleDaoImpl roleDao;

    @Autowired
    private ValidatorUtil validatorUtil;


    public void doAddRole(User user, Role entity) throws ValidateException {
        entity.setCreatedAt(new Date());
        entity.setUpdatedAt(new Date());
        validatorUtil.validate(entity,true);
        roleDao.insert(entity);
    }


    public void doUpdateRole(User user, Role entity) throws ValidateException {
        Role dbentity = roleDao.selectById((Serializable) entity.getId(),Role.class);

        entity.setCreatedAt(dbentity.getCreatedAt());
        entity.setUpdatedAt(new Date());
        validatorUtil.validate(entity,true);
        roleDao.updateByMerge(entity);
    }


    public void doDeleteRole(User user, String id) {
        roleDao.deleteById(id,Role.class);
    }


    public Role getRoleById(String id) {
        return roleDao.selectById(id,Role.class);
    }
}
