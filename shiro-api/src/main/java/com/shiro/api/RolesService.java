package com.shiro.api;

import java.util.Set;

import com.shiro.module.Roles;

/**
 * 
 * @author happyeveryday
 * 注释：角色服务api
 * 2018年9月19日下午8:42:52
 */
public interface RolesService {
    
	/**
	 * 根据用户名查找角色
	 * @param username
	 * @return 角色集合
	 */
	Set<Roles> findByUserName(String username);
}
