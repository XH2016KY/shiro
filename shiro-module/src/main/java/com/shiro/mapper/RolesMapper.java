package com.shiro.mapper;

import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.shiro.module.Roles;

public interface RolesMapper {
	
	/**
	 * 通过用户名查询所在用户的所有角色
	 * @return  角色集合
	 */
	@Select(value = "SELECT rname FROM\r\n" + 
		        "roles left JOIN user_roles\r\n" + 
			"on roles.rid = user_roles.rid\r\n" + 
			"LEFT JOIN user\r\n" + 
			"on user_roles.uid = `user`.uid\r\n" + 
			"where user.username = #{username}")
	Set<Roles> findByUserName(@Param("username")String username);

}
