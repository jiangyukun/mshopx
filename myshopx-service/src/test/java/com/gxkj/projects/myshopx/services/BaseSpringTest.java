package com.gxkj.projects.myshopx.services;


import com.alibaba.fastjson.JSON;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-*.xml"  })
public class BaseSpringTest {//extends AbstractTransactionalJUnit4SpringContextTests
	private  static Logger LOG = LoggerFactory.getLogger(BaseSpringTest.class);

	@Autowired
	ApplicationContext ctx;

	@BeforeClass
	public  static void init(){

		LOG.info("执行顺序：{}","@BeforeClass");
	}
	@Before
 	public   void before()  {
//		String[] names  = ctx.getBeanDefinitionNames();
		LOG.info("before beanNames = 111" );

 	}

}
