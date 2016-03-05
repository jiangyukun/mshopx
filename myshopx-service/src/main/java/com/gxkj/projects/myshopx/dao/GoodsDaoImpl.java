package com.gxkj.projects.myshopx.dao;

import com.gxkj.common.hibernate.HibernateBaseRepositoryImpl;
import com.gxkj.common.utils.ListPager;
import com.gxkj.projects.myshopx.entitys.Goods;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class GoodsDaoImpl extends HibernateBaseRepositoryImpl {

    public ListPager<Goods> doPageHQL(Goods goods, int pagenNo, int pageSize){
        ListPager<Goods> pager = new ListPager<Goods>();
        pager.setPageNo(pagenNo);
        pager.setRowsPerPage(pageSize);
        String hql  = " from Goods u where 1=1 ";
        Map<String,Object> param = new HashMap<String,Object>();

        return  this.selectPageByHql(hql,param,pager);
    }
}
