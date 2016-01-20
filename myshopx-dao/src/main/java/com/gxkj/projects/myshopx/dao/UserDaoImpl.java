package com.gxkj.projects.myshopx.dao;

import com.gxkj.projects.myshopx.entitys.User;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.*;

/**
 * Created by dell on 2016/1/19.
 */

public class UserDaoImpl {
    @PersistenceContext
    private EntityManager em;

    public List<User> doListTest(int age,String userName){
        String sql  = "select u from User u where 1=1 ";
        Map<String,Object> param = new HashMap<String,Object>();
        if(age >= 0){
            sql += " and age = :age";
            param.put("age",age);
        }
        if(StringUtils.isNotBlank(userName)){
            sql += " and userName = :userName";
            param.put("userName",userName);
        }
        Query query = em.createQuery(sql);
        Set<String> stringKeys =  param.keySet();
        for (Iterator<String> it = stringKeys.iterator();it.hasNext();){
            String key = it.next();
            query.setParameter(key,param.get(key));
        }

        //if(StringUtils)
        return query.getResultList();
    }
}
