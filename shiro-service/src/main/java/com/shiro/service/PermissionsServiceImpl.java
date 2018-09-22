package com.shiro.service;

import java.util.Set;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.shiro.api.PermissionsService;
import com.shiro.mapper.PermissionsMapper;
import com.shiro.module.Permissions;

/**
 * 
 * @author happyeveryday
 * 注释：权限服务实现
 * 2018年9月20日上午12:56:26
 */
@Service("permissionsServiceImpl")
public class PermissionsServiceImpl implements PermissionsService{

	@Resource
	private PermissionsMapper permissionMapper;

	@Override
	public Set<Permissions> findByUserName(String username) {
		return permissionMapper.findByUserName(username);
	}
	
	
}
