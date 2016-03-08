package com.gxkj.projects.myshopx.services;


import com.gxkj.common.exceptions.ValidateException;
import com.gxkj.common.utils.ListPager;
import com.gxkj.projects.myshopx.entitys.User;

import java.util.List;

/**
 * Created by dell on 2016/1/14.
 */
public interface UserService {


    public void doDeleteUser(User adminUser, String id);

    public ListPager<User> doHqlPage(int pagenNo, int pageSize,User user);



    public ListPager<User> doSqlPageTest(int pagenNo, int pageSize,int age,   String userName);


    public User doLogin(User user) throws ValidateException;
}
