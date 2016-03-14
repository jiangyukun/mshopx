package com.gxkj.projects.myshopx.dao;

import com.gxkj.common.hibernate.HibernateBaseRepositoryImpl;
import com.gxkj.common.utils.ListPager;
import com.gxkj.projects.myshopx.entitys.Brand;
import com.gxkj.projects.myshopx.entitys.Category;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CategoryDaoImpl  extends HibernateBaseRepositoryImpl {

    public ListPager<Category> doPageHQL(int pagenNo, int pageSize, Category Category){
        ListPager<Category> pager = new ListPager<Category>();
        pager.setPageNo(pagenNo);
        pager.setRowsPerPage(pageSize);
        String hql  = " from Category c   ";
        Map<String,Object> param = new HashMap<String,Object>();


        return  this.selectPageByHql(hql,param,pager);
    }
}
