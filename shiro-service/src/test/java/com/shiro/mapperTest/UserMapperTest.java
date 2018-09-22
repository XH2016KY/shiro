package com.shiro.mapperTest;

import javax.annotation.Resource;
import org.junit.Test;
import com.shiro.BaseTest;
import com.shiro.mapper.UserMapper;
import com.shiro.module.User;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserMapperTest  extends BaseTest{

	@Resource
	private UserMapper userMapper;
	
	@Test
	public void findByNameTest() {
		User user1 = userMapper.findByName("user");
		log.info("结果:{}",user1);
	}
}
