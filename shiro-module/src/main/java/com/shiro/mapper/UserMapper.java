package com.shiro.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.shiro.module.User;

public interface UserMapper {
	
	/**
	 * 通过用户名查询
	 * @param username
	 * @return
	 */
	@Select(value = "select * from user where username = #{username}")
	User findByName(@Param("username")String username);

}
