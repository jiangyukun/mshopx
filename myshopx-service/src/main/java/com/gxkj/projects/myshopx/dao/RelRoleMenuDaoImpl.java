package com.gxkj.projects.myshopx.dao;

import com.gxkj.common.hibernate.HibernateBaseRepositoryImpl;
import com.gxkj.projects.myshopx.entitys.AdminMenu;
import com.gxkj.projects.myshopx.entitys.Role;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RelRoleMenuDaoImpl   extends HibernateBaseRepositoryImpl {

    /**
     * 删除角色与菜单关系
     * @param roleId
     */
    public void deleteRelRoleMenuByRoleId(String roleId){
        String sql = "delete from rel_role_menu where roleid = :roleid";
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("roleid", roleId);
        this.executeUpdateBySql(sql,param);
    }

    /**
     * 根据角色ID查询菜单
     * @param roleid
     * @return
     */
    public List<AdminMenu> getMenuByRoleId(String roleid){
        String sql = "select menu.* from admin_menu as menu , rel_role_menu rel where rel.menuid = menu.id and rel.roleid=:roleid";
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("roleid", roleid);
        return  this.selectListBySQL(sql,param,AdminMenu.class);
    }
}
