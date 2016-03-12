package com.gxkj.projects.myshopx.dao;

import com.gxkj.common.hibernate.HibernateBaseRepositoryImpl;
import com.gxkj.common.utils.ListPager;
import com.gxkj.projects.myshopx.entitys.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2016/1/19.
 */
@Repository
public class UserDaoImpl extends HibernateBaseRepositoryImpl {


    public ListPager<User> doPageHQL(int pagenNo,int pageSize,User user,boolean admin){
        ListPager<User> pager = new ListPager<User>();
        pager.setPageNo(pagenNo);
        pager.setRowsPerPage(pageSize);
        String hql  = " from User u where 1=1 ";
        Map<String,Object> param = new HashMap<String,Object>();

        if(admin){
            hql += " and admin = :admin";
            param.put("admin",true);
        }
        if(user != null) {
            if(StringUtils.isNoneBlank(user.getQq())){
                hql += " and qq = :qq";
                param.put("qq",user.getQq());
            }
            if(StringUtils.isNoneBlank(user.getUname())){
                hql += " and uname = :uname";
                param.put("uname",user.getUname());
            }
        }
        return  this.selectPageByHql(hql,param,pager);
    }

    public ListPager<User> doPageSQL( int pagenNo,int pageSize,User user,boolean admin){
        ListPager<User> pager = new ListPager<User>();
        pager.setPageNo(pagenNo);
        pager.setRowsPerPage(pageSize);
        String hql  = " select id,user_name as userName , age, gender, create_at createdAt ,admin  from user u where gender is not null     ";
        Map<String,Object> param = new HashMap<String,Object>();
        if(admin){
            hql += " and is_admin = 'Y'";
        }
       // hql += " order by id";
        this.selectPageBySQL(hql,param,pager,User.class);
        return pager;
    }

    public User getUserByQQ(String qq) {
        String sql  = " from User u where qq =:qq ";
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("qq",qq);
        return this.selectFirstOneByHQL(sql,param);
    }

    public void setAdminUser(String id){
        String updateSql = "update user set is_admin = 'Y' where id = :id";
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("id",id);
        this.executeUpdateBySql(updateSql,param);
    }
    public void cancleAdmin(String id){
        String updateSql = "update user set is_admin = 'N' where id = :id";
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("id",id);
        this.executeUpdateBySql(updateSql,param);
    }
}
