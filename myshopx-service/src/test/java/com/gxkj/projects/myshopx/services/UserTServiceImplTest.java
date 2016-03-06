package com.gxkj.projects.myshopx.services;

import com.alibaba.fastjson.JSON;
import com.gxkj.common.utils.ListPager;
import com.gxkj.projects.myshopx.entitys.User;
import com.gxkj.projects.myshopx.enums.GenderEnums;
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


    @Test
    public void doAddUserTest(){
//        for(int i=101;i<102;i++){

        int i= 103;
            User u = new User();

            u.setCreatedAt(new Date());
            u.setUpdatedAt(new Date());
            u.setPassword(11+"");
            u.setStaus("1");

            u.setGender(GenderEnums.MAN);
            u.setQq("346745719");
           // u.setAdmin(false);
            u = userService.addUser(u);
            LOG.info("u="+JSON.toJSONString(u));
//        }
    }

    /**
     * 自定义查询SQL的例子
     */
    @Test
    public void doListTest(){
        List<User> userLists =  userService.doListTest(0,null);
        LOG.info("userLists="+JSON.toJSONString(userLists));
    }
    @Test
    public void doSqlPageTest(){
        ListPager<User> pager =  userService.doSqlPageTest(0,10,0,"");
        LOG.info("pager="+ JSON.toJSONString(pager));
    }
}