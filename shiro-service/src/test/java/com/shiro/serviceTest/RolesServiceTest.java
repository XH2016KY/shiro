package com.shiro.serviceTest;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.junit.Test;
import com.shiro.BaseTest;
import com.shiro.api.RolesService;
import com.shiro.module.Roles;

public class RolesServiceTest extends BaseTest{

	@Resource
	private RolesService rolesService;
	
	@Test
	public void findByName() {
	    Set<Roles> roles = rolesService.findByUserName("user");
	    List<String> collect = roles.stream().map(Roles::getRname).collect(Collectors.toList());
	    System.out.println(collect);
	}
	
}
