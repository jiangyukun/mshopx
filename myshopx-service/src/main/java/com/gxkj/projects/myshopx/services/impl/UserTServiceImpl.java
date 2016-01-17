package com.gxkj.projects.myshopx.services.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxkj.projects.myshopx.dao.UserMapper;
import com.gxkj.projects.myshopx.entitys.UserT;
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
    private UserMapper userMapper;

    public int addUser(UserT user) {
        return userMapper.addUser(user);
    }


    public PageInfo<UserT> doPager(String cname, int pageNo, int pagesize) {
        //获取第1页，10条内容，默认查询总数count
        PageHelper.startPage(pageNo, pagesize);
        List<UserT> list = userMapper.doPageQuery();
        PageInfo<UserT> page = new PageInfo(list);
        return null;
    }
}
