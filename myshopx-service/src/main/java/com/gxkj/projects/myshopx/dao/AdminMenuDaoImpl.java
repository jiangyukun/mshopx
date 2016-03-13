package com.gxkj.projects.myshopx.dao;

import com.gxkj.common.hibernate.HibernateBaseRepositoryImpl;
import com.gxkj.projects.myshopx.entitys.AdminMenu;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AdminMenuDaoImpl extends HibernateBaseRepositoryImpl {

    public List<AdminMenu> getAllAdminMenu() {
        String hql = "from AdminMenu order by sort,createdAt";
        return this.selectListByHQL(hql,new HashMap<>());
    }

    public AdminMenu getAdminMenuByName(String name) {
        String hql = "from AdminMenu where name=:name order by sort,createdAt";
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("name",name);
        return this.selectFirstOneByHQL(hql,param);
    }
}
