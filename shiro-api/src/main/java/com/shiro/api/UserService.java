package com.shiro.api;

import com.shiro.module.User;

/**
 * 
 * @author happyeveryday
 * 注释：用户服务api
 * 2018年9月17日下午5:35:09
 */
public interface UserService {

	User findByName(String username);
}
