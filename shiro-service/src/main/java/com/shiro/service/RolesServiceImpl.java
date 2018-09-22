package com.shiro.service;

import java.util.Set;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shiro.api.RolesService;
import com.shiro.mapper.RolesMapper;
import com.shiro.module.Roles;

/**
 * 
 * @author happyeveryday
 * 注释：角色服务实现
 * 2018年9月19日下午8:50:59
 */
@Service("rolesServiceImpl")
public class RolesServiceImpl implements RolesService{
	
	@Resource
	private RolesMapper rolesMapper;

	@Override
	public Set<Roles> findByUserName(String username) {
		return rolesMapper.findByUserName(username);
	}

	
}
