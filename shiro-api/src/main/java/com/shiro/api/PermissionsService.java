package com.shiro.api;

import java.util.Set;
import com.shiro.module.Permissions;

/**
 * 
 * @author happyeveryday
 * 注释：权限服务api
 * 2018年9月20日上午12:46:12
 */
public interface PermissionsService {

	/**
	 * 通过用户名
	 * @param username
	 * @return
	 */
	Set<Permissions> findByUserName(String username);
}
