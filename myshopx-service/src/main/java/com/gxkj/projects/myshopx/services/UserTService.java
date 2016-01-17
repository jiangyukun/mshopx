package com.gxkj.projects.myshopx.services;

import com.github.pagehelper.PageInfo;
import com.gxkj.projects.myshopx.entitys.UserT;

import java.util.List;

/**
 * Created by dell on 2016/1/14.
 */
public interface UserTService {

    public int addUser(UserT user);

    public PageInfo<UserT> doPager(String cname, int pageNo, int pagesize);
}
