package com.gxkj.projects.myshopx.dao;

import com.gxkj.projects.myshopx.entitys.User;
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
public class UserDaoImpl extends BaseRepositoryImpl {


    public List<User> doListTest(int age, String userName){
        String sql  = " from User u where 1=1 ";
        Map<String,Object> param = new HashMap<String,Object>();
        if(age >= 0){
            sql += " and age = :age";
            param.put("age",age);
        }
        if(StringUtils.isNotBlank(userName)){
            sql += " and userName = :userName";
            param.put("userName",userName);
        }
        return super.selectByHQL(sql,param);
    }

//    public Page<User> getPagerUser(PageRequest pageable, String uname, int age){
//        String sql  = "select u from User u where 1=1 ";
//        Map<String,Object> param = new HashMap<String,Object>();
//        if(age > 0){
//            sql += " and age = :age";
//            param.put("age",age);
//        }
//        if(StringUtils.isNotBlank(uname)){
//            sql += " and userName = :userName";
//            param.put("userName",uname);
//        }
//
//        return super.doPageSelect(sql,param,pageable);
//    }
}
