package com.shiro.mapper;

import java.util.Set;
import org.apache.ibatis.annotations.Param;
import com.shiro.module.Permissions;

public interface PermissionsMapper {

	/**
	 * 通过用户名
	 * @param username
	 * @return
	 */
	Set<Permissions> findByUserName(@Param("username")String username);
}
