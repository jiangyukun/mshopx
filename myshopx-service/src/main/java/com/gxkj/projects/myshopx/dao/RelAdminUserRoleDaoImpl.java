package com.gxkj.projects.myshopx.dao;

import com.gxkj.common.hibernate.HibernateBaseRepositoryImpl;
import com.gxkj.projects.myshopx.entitys.Role;
import com.gxkj.projects.myshopx.enums.RoleState;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RelAdminUserRoleDaoImpl extends HibernateBaseRepositoryImpl {

    /**
     * 删除用户与角色关联关系
     * @param userid
     */
    public void deleteRelAdminUserRoleByUserId(String userid){
        String sql = "delete from rel_admin_user_role where user_id = :user_id";
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("user_id", userid);
        this.executeUpdateBySql(sql,param);
    }

    /**
     * 根据用户ID查询用户角色
     * @param userId
     * @return
     */
    public List<Role> getRoleByUserId(String userId){
        String sql = "select role.* from role,rel_admin_user_role rel where rel.admin_role_id = role.id and rel.user_id = :userId";
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("userId", userId);
        return  this.selectListBySQL(sql,param,Role.class);
    }
}
