package com.gxkj.projects.myshopx.dao;

import com.gxkj.common.hibernate.HibernateBaseRepositoryImpl;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xubaoyong on 2016/2/28.
 */
@Repository
public class MenuDaoImpl extends HibernateBaseRepositoryImpl {

    /**
     * 查询所有的菜单
     * @return
     */
    public List<Menu> getAllMenu( ){
        String hql = "from Menu";
         return this.selectListByHQL(hql,null);
    }
}
