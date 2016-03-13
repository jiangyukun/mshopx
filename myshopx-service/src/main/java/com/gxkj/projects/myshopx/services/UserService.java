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

    public ListPager<User> doHqlPage(int pagenNo, int pageSize,User user,boolean admin);

    public ListPager<User> doSqlPageTest(int pagenNo, int pageSize,User user,boolean admin);

    public User doLogin(User user) throws ValidateException;

    public User getByQq(String qq);

    public void setAdmin(User user,String id);

    public void cancleAdmin(User user, String id);

    /**
     * 设置用户角色
     * @param operator
     * @param targetUserId
     * @param roleIds
     */
    public void setroles(User operator,String targetUserId,String roleIds);

//    public void doAdd(User user);
}
