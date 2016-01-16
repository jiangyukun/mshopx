package com.gxkj.projects.myshopx.services.impl;

import com.gxkj.projects.myshopx.dao.IUserDao;
import com.gxkj.projects.myshopx.entitys.UserT;
import com.gxkj.projects.myshopx.services.UserTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2016/1/14.
 */
@Service
public class UserTServiceImpl  implements UserTService {


    @Autowired
    private IUserDao iUserDao;

    public int addUser(UserT user) {
        return iUserDao.addUser(user);
    }
}
