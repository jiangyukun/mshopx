package com.gxkj.projects.myshopx.services.impl;


import com.gxkj.common.exceptions.ValidateException;
import com.gxkj.common.utils.ListPager;
import com.gxkj.common.utils.ValidatorUtil;
import com.gxkj.projects.myshopx.dao.UserDaoImpl;
import com.gxkj.projects.myshopx.entitys.User;
import com.gxkj.projects.myshopx.enums.UserStatusEnum;
import com.gxkj.projects.myshopx.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by dell on 2016/1/14.
 */
@Service
public class UserServiceImpl implements UserService {

    private  static Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDaoImpl userDao;

    @Autowired
    private ValidatorUtil validatorUtil;

    public void doDeleteUser(User adminUser, String id) {
        userDao.deleteById(id,User.class);
    }


    public ListPager<User> doHqlPage(int pagenNo, int pageSize, User user) {
        return userDao.doPageHQL( pagenNo, pageSize,user);
    }

    public User getUserByQQ(String qq) {
        return userDao.getUserByQQ(qq);
    }


    public ListPager<User> doSqlPageTest(int pagenNo, int pageSize, int age, String userName) {
        return userDao.doPageSQL(age,userName,pagenNo,pageSize);
    }


    public User doLogin(User user) throws ValidateException {
        User dbUser = userDao.getUserByQQ(user.getQq());
        if(dbUser == null){
            user.setCreatedAt(new Date());
            user.setUpdatedAt(new Date());
            user.setStaus(UserStatusEnum.NORMAL);
            user.setAdmin(false);
            user.setQq(user.getQq());
            validatorUtil.validate(user,true);
            userDao.insert(user);

            dbUser = user;
        }else{
            user =  dbUser;
        }
        return dbUser;
    }
}
