package com.shiro.mapperTest;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.shiro.BaseTest;
import com.shiro.mapper.RolesMapper;
import com.shiro.module.Roles;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RolesMapperTest extends BaseTest{
	
	
	@Autowired
	private RolesMapper rolesMapper;
	
	@Test
	public void find() {
		Set<Roles> Result = rolesMapper.findByUserName("user");
		log.info("结果:{}",Result);
		List<String> collect = Result.stream().map(Roles::getRname).collect(Collectors.toList());
		System.out.println(collect);
	}

}
