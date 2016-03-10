package com.gxkj.projects.myshopx.services;

import com.alibaba.fastjson.JSON;
import com.gxkj.common.exceptions.ValidateException;
import com.gxkj.common.utils.ListPager;
import com.gxkj.projects.myshopx.entitys.Role;
import com.gxkj.projects.myshopx.entitys.User;
import com.gxkj.projects.myshopx.enums.RoleState;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by xubaoyong on 2016/3/10.
 */
public class AdminRoleServiceTest extends BaseSpringTest {

    Logger LOG = LoggerFactory.getLogger(AdminRoleServiceTest.class);

    @Autowired
    private AdminRoleService adminRoleService;

    @Test
    public void doListTest(){
        Role entity = new Role();
        entity.setName("roleName");
        entity.setUpdatedAt(new Date());
        entity.setCreatedAt(new Date());
        entity.setState(RoleState.NORMAL);

        try {
            adminRoleService.doAddRole(null,entity);
            LOG.info("entity="+ JSON.toJSONString(entity));
        } catch (ValidateException e) {
            e.printStackTrace();
        }


    }
}
