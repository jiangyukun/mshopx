package com.gxkj.projects.myshopx.dao;

import com.gxkj.common.hibernate.HibernateBaseRepositoryImpl;
import com.gxkj.common.utils.ListPager;
import com.gxkj.projects.myshopx.entitys.Role;
import com.gxkj.projects.myshopx.enums.RoleState;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class RoleDaoImpl extends HibernateBaseRepositoryImpl {

    public ListPager<Role> doPageHQL(int pagenNo, int pageSize, Role role){
        ListPager<Role> pager = new ListPager<Role>();
        pager.setPageNo(pagenNo);
        pager.setRowsPerPage(pageSize);
        String hql  = " from Role u  where  u.state != :delState ";
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("delState", RoleState.DEL);

        if(StringUtils.isNotBlank(role.getName())){
            hql += " and name like :name";
            param.put("name","%"+role.getName()+"%");
        }
        return  this.selectPageByHql(hql,param,pager);
    }
}
