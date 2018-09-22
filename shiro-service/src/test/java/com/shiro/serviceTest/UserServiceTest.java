package com.shiro.serviceTest;

import javax.annotation.Resource;

import org.junit.Test;

import com.shiro.BaseTest;
import com.shiro.api.UserService;
import com.shiro.module.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserServiceTest extends BaseTest{

	@Resource
	private UserService userService;
	
	@Test
	public void findByName() {
		User user2 = userService.findByName("user");
		log.info("结果:{}",user2);
	}
	
}
