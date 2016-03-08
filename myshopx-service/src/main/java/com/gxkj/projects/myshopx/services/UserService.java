package com.gxkj.projects.myshopx.services;


import com.gxkj.common.exceptions.ValidateException;
import com.gxkj.common.utils.ListPager;
import com.gxkj.projects.myshopx.entitys.User;

import java.util.List;

/**
 * Created by dell on 2016/1/14.
 */
public interface UserService {

//    public User doAddUser(User adminUser,User user) throws ValidateException;
//
//    public void doUpdateUser(User adminUser,User user) throws ValidateException;

    public void doDeleteUser(User adminUser, String id);

    public ListPager<User> doHqlPage(int pagenNo, int pageSize,User user);

//    public User getUserByQQ(String qq);

    public ListPager<User> doSqlPageTest(int pagenNo, int pageSize,int age,   String userName);
//
//    public List<User> doListTest(int age, String name);

    public User doLogin(User user) throws ValidateException;
}
