package com.gxkj.projects.myshopx.services;

import com.alibaba.fastjson.JSON;
import com.gxkj.common.utils.ListPager;
import com.gxkj.projects.myshopx.entitys.User;
import com.gxkj.projects.myshopx.enums.GenderEnums;
import com.gxkj.projects.myshopx.enums.UserStatusEnum;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;


public class UserTServiceImplTest extends BaseSpringTest {
//
        Logger LOG = LoggerFactory.getLogger(UserTServiceImplTest.class);

    @Autowired
    private UserService userService;

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




    /**
     * 自定义查询SQL的例子
     */
    @Test
    public void doListTest(){
        ListPager<User> userLists =  userService.doHqlPage(0,20,null);
        LOG.info("userLists="+JSON.toJSONString(userLists));
    }
    @Test
    public void doSqlPageTest(){
        ListPager<User> pager =  userService.doSqlPageTest(0,10,0,"");
        LOG.info("pager="+ JSON.toJSONString(pager));
    }
}