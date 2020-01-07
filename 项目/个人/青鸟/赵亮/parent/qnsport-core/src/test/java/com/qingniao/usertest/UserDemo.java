package com.qingniao.usertest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qingniao.core.dao.UserTestMapper;
import com.qingniao.core.pojo.UserTest;
import com.qingniao.core.service.UserTestServiceImpl;

/**
 * 测试配置是否成功
 * @author quan
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext-*.xml"})
public class UserDemo {
	
	@Autowired
	UserTestMapper userTestMapper;
	
	@Autowired
	UserTestServiceImpl userService;
	
	@Test
	public void demo1() {
		UserTest userTest = new UserTest();
		userTest.setId(1);
		userTest.setUsername("张三");
		userTest.setPasswrod("123");
		userTestMapper.insertUserTest(userTest);
	}
	
	//测试事物
	@Test
	public void demo2() {
		UserTest userTest = new UserTest();
		userTest.setId(2);
		userTest.setUsername("赵六");
		userTest.setPasswrod("123456");
		userService.insertUserTest(userTest);
	}
}
