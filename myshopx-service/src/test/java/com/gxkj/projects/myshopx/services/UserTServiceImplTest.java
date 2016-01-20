package com.gxkj.projects.myshopx.services;

import com.alibaba.fastjson.JSON;
import com.gxkj.projects.myshopx.entitys.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by dell on 2016/1/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-hibernate.xml","classpath:spring-service.xml"})
public class UserTServiceImplTest extends AbstractJUnit4SpringContextTests {
//
        Logger LOG = LoggerFactory.getLogger(UserTServiceImplTest.class);
    @Autowired
    private UserTService userTService;

//    @Test
//    public void test1() {
//        for(int i = 101 ;i < 102; i++){
//            UserT u = new UserT();
//            u.setId(UUID.randomUUID().toString());
//            u.setUserName("name_"+i);
//            u.setPassword(i+"-"+i);
//            int r = userTService.addUser(u);
//
//            LOG.info(r+"="+JSON.toJSONString(u));
//        }
//       // logger.info(JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd HH:mm:ss"));
//    }
    @Test
    public void doPageTest(){
//        PageInfo page =  userTService.doPager("",1,2);
//        LOG.info("page="+JSON.toJSONString(page));
    }

    @Test
    public void doAddTest(){
        for(int i=0;i<100;i++){
            User u = new User();
            u.setAge(i+10);
            u.setHeadUrl("head"+i);
            u.setUserName("uname_"+i);
            u = userTService.addUser(u);
            LOG.info("u="+JSON.toJSONString(u));
        }
    }
    @Test
    public void doListTest(){
        List<User> userLists =  userTService.doListTest(10,null);
        LOG.info("userLists="+JSON.toJSONString(userLists));
    }
}