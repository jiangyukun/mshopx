package com.gxkj.projects.myshopx.services;

import com.gxkj.common.exceptions.ValidateException;
import com.gxkj.projects.myshopx.entitys.Role;
import com.gxkj.projects.myshopx.entitys.User;

/**
 * Created by xubaoyong on 2016/3/10.
 */
public interface AdminRoleService {

    public void doAddRole(User user , Role entity) throws ValidateException;

    public void doUpdateRole(User user , Role entity) throws ValidateException;

    public void doDeleteRole(User user, String id);

    public Role getRoleById(String id);
}
