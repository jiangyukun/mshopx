package com.gxkj.projects.myshopx.dao;

import com.gxkj.common.hibernate.HibernateBaseRepositoryImpl;
import com.gxkj.common.utils.ListPager;
import com.gxkj.projects.myshopx.entitys.Brand;
import com.gxkj.projects.myshopx.entitys.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BrandDaoImpl  extends HibernateBaseRepositoryImpl {

    public ListPager<Brand> doPageHQL(int pagenNo, int pageSize, Brand brand){
        ListPager<Brand> pager = new ListPager<Brand>();
        pager.setPageNo(pagenNo);
        pager.setRowsPerPage(pageSize);
        String hql  = " from Brand u   ";
        Map<String,Object> param = new HashMap<String,Object>();


        return  this.selectPageByHql(hql,param,pager);
    }
}
