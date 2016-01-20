package com.gxkj.projects.myshopx.services.impl;


import com.gxkj.projects.myshopx.dao.UserDao;
import com.gxkj.projects.myshopx.entitys.User;
import com.gxkj.projects.myshopx.services.UserTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dell on 2016/1/14.
 */
@Service
public class UserTServiceImpl  implements UserTService {


    @Autowired
    private UserDao userDao;

    public User addUser(User user) {

        return  userDao.save(user);
    }


    public List<User> doListTest(int age, String name) {
        return userDao.doListTest(age,name);
    }


}
