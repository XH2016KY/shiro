package com.shiro.mapperTest;

import java.util.Set;

import javax.annotation.Resource;
import org.junit.Test;
import com.shiro.BaseTest;
import com.shiro.mapper.PermissionsMapper;
import com.shiro.module.Permissions;

public class PermissionsMapperTest extends BaseTest{

	@Resource
	private PermissionsMapper permissionsMapper;
	
	@Test
	public void Test() {
		Set<Permissions> all = permissionsMapper.findByUserName("user");
		System.out.println("权限个数"+all.size());
	}
}
