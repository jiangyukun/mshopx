/*
 * Copyright 2014 ucfgoup.com All right reserved. This software is the
 * confidential and proprietary information of ucfgoup.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with ucfgoup.com.
 */
package com.gxkj.projects.myshopx.dao;



import com.gxkj.projects.myshopx.entitys.UserT;

import java.util.List;
import java.util.Map;

/**
 * 用户数据库操作接口类，对应的数据表为user
 * @date 2014-6-3
 * @author weirongneng
 */
public interface UserMapper {
    /**
     * 新增用户
     * @param user
     * @return
     */
    public int addUser(UserT user) ;

    /**
     * 分页查看用户测试
     * @return
     */
    List<UserT> doPageQuery();
}
