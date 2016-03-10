package com.gxkj.projects.myshopx.dao;

import com.gxkj.common.hibernate.HibernateBaseRepositoryImpl;
import com.gxkj.common.utils.ListPager;
import com.gxkj.projects.myshopx.entitys.Role;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class RoleDaoImpl extends HibernateBaseRepositoryImpl {

    public ListPager<Role> doPageHQL(int pagenNo, int pageSize, Role role){
        ListPager<Role> pager = new ListPager<Role>();
        pager.setPageNo(pagenNo);
        pager.setRowsPerPage(pageSize);
        String hql  = " from Role u   ";
        Map<String,Object> param = new HashMap<String,Object>();

//        if(StringUtils.isNotBlank(user.get)){
//            hql += " and userName = :userName";
//            param.put("userName",userName);
//        }
        return  this.selectPageByHql(hql,param,pager);
    }
}
