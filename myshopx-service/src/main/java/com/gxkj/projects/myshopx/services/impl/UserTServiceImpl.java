package com.gxkj.projects.myshopx.services.impl;

import com.gxkj.projects.myshopx.dao.UserMapper;
import com.gxkj.projects.myshopx.entitys.UserT;
import com.gxkj.projects.myshopx.services.UserTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dell on 2016/1/14.
 */
@Service
public class UserTServiceImpl  implements UserTService {


    @Autowired
    private UserMapper userMapper;

    public int addUser(UserT user) {
        return userMapper.addUser(user);
    }
}
