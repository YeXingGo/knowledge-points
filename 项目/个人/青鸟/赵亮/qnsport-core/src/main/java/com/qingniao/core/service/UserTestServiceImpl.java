package com.qingniao.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qingniao.core.dao.UserTestMapper;
import com.qingniao.core.pojo.UserTest;

/**
 * userTest的service类
 * 测试事物
 * @author quan
 *
 */

@Service
@Transactional
public class UserTestServiceImpl {
	@Autowired
	UserTestMapper userTestMapper;
	
	public void insertUserTest(UserTest user) {
		userTestMapper.insertUserTest(user);
		int a = 1/0;
	}
}
