package com.gxkj.projects.myshopx.services;

import com.gxkj.projects.myshopx.entitys.UserT;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * Created by dell on 2016/1/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml","classpath:spring-service.xml"})
public class UserTServiceImplTest extends AbstractJUnit4SpringContextTests {
//    private static final Logger logger = Logger.getLogger(UserTServiceImplTest.class);
    @Autowired
    private UserTService userTService;

    @Test
    public void test1() {

        UserT u = new UserT();
        u.setId(UUID.randomUUID().toString());
        u.setUserName("wode ceshi ");
        u.setPassword("33");
       int r = userTService.addUser(u);
        System.out.println("result = "+r);


       // logger.info(JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd HH:mm:ss"));
    }
}