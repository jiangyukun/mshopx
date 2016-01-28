package com.gxkj.projects.myshopx.services;


import com.gxkj.projects.myshopx.entitys.User;

import java.util.List;

/**
 * Created by dell on 2016/1/14.
 */
public interface UserTService {

    public User addUser(User user);

    public List<User> doListTest(int age, String name);

//     public Page<User> getPagerUser(int page, int pageSize,String uname,int age);


}
