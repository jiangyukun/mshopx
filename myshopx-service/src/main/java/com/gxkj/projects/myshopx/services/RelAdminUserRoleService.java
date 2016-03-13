package com.gxkj.projects.myshopx.services;

import com.gxkj.projects.myshopx.entitys.Role;

import java.util.List;

/**
 * Created by xubaoyong on 2016/3/13.
 */
public interface RelAdminUserRoleService {

    public List<Role> getRoleByUserId(String userId);
}
