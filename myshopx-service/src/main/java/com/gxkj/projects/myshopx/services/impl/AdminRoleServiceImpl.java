package com.gxkj.projects.myshopx.services.impl;

import com.gxkj.common.exceptions.ValidateException;
import com.gxkj.common.utils.ListPager;
import com.gxkj.common.utils.ValidatorUtil;
import com.gxkj.projects.myshopx.dao.RelRoleMenuDaoImpl;
import com.gxkj.projects.myshopx.dao.RoleDaoImpl;
import com.gxkj.projects.myshopx.entitys.RelRoleMenu;
import com.gxkj.projects.myshopx.entitys.Role;
import com.gxkj.projects.myshopx.entitys.User;
import com.gxkj.projects.myshopx.enums.RoleState;
import com.gxkj.projects.myshopx.services.AdminRoleService;
import org.apache.commons.lang3.StringUtils;
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

    @Autowired
    private RelRoleMenuDaoImpl relRoleMenuDao;


    public void doAddRole(User user, Role entity,String menuIds) throws ValidateException {
        entity.setCreatedAt(new Date());
        entity.setUpdatedAt(new Date());
        validatorUtil.validate(entity,true);
        roleDao.insert(entity);

        //设置角色的菜单ID
        if(StringUtils.isNoneBlank(menuIds)){
            String[] menuIdArray = menuIds.split(",");
            for(String id : menuIdArray){
                RelRoleMenu relRoleMenu = new RelRoleMenu();
                relRoleMenu.setMenuid(id);
                relRoleMenu.setRoleid(entity.getId());
                relRoleMenuDao.insert(relRoleMenu);
            }
        }
    }


    public void doUpdateRole(User user, Role entity,String menuIds) throws ValidateException {
        Role dbentity = roleDao.selectById((Serializable) entity.getId(),Role.class);

        entity.setCreatedAt(dbentity.getCreatedAt());
        entity.setUpdatedAt(new Date());
        validatorUtil.validate(entity,true);
        roleDao.updateByMerge(entity);

        relRoleMenuDao.deleteRelRoleMenuByRoleId(entity.getId());
        //设置角色的菜单ID
        if(StringUtils.isNoneBlank(menuIds)){
            String[] menuIdArray = menuIds.split(",");
            for(String id : menuIdArray){
                RelRoleMenu relRoleMenu = new RelRoleMenu();
                relRoleMenu.setMenuid(id);
                relRoleMenu.setRoleid(entity.getId());
                relRoleMenuDao.insert(relRoleMenu);
            }
        }
    }


    public void doDeleteRole(User user, String id) {
        roleDao.deleteById(id,Role.class);
    }


    public Role getRoleById(String id) {
        return roleDao.selectById(id,Role.class);
    }


    public ListPager<Role> doHqlPage(int pagenNo, int pageSize, Role role) {
        return roleDao.doPageHQL(pagenNo,pageSize,role);
    }


    public boolean doUpdateRoleState(User user, String ids, RoleState state) {
        String[] idArray = ids.split(",");
        for(String id: idArray){
            Role  role = roleDao.selectById(id,Role.class);
            role.setState(state);
            role.setUpdatedAt(new Date());
            roleDao.update(role);
        }
        return true;
    }
}
