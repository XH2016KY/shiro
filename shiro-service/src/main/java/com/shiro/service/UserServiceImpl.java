package com.shiro.service;

import org.springframework.stereotype.Service;

import com.shiro.api.UserService;
import com.shiro.mapper.UserMapper;
import com.shiro.module.User;

/**
 * 
 * @author happyeveryday
 * 注释：用户服务实现
 * 2018年9月17日下午5:39:38
 */
@Service("userServiceImpl")
public class UserServiceImpl implements UserService{

	private final UserMapper userMapper;
	
	/**
	 * 构造器注入{@link com.shiro.mapper.UserMapper}
	 * @param userMapper
	 */
	public UserServiceImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public User findByName(String username) {
		return userMapper.findByName(username);
	}
	
	
	
}
