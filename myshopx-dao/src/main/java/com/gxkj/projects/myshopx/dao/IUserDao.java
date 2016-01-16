package com.gxkj.projects.myshopx.dao;


import com.gxkj.projects.myshopx.entitys.UserT;

/**
 * Created by dell on 2016/1/13.
 */
public interface IUserDao  {

    /**
     * 新增用户
     * @param user
     * @return
     */
    public int addUser(UserT user) ;
}
