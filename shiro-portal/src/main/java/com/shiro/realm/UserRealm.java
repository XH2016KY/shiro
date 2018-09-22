package com.shiro.realm;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import com.shiro.api.PermissionsService;
import com.shiro.api.RolesService;
import com.shiro.api.UserService;
import com.shiro.module.Permissions;
import com.shiro.module.Roles;
import com.shiro.module.User;
import lombok.extern.slf4j.Slf4j;
/**
 * 
 * @author happyeveryday
 * 注释：用户权限认证与授权
 * 2018年9月18日上午12:16:42
 */
@Slf4j
public class UserRealm extends AuthorizingRealm{
	
	/** 注入userService */
	@Autowired
	private UserService userService;
	/** 注入rolesService*/
	@Autowired
	private RolesService rolesService;
	/** 注入permissionsService*/
	@Autowired
	private PermissionsService permissionsService;
	
    /**
     *  授权
     */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		// 1.从主体中获取用户名
		String userName = (String) principals.getPrimaryPrincipal();
		// 2.从数据库或者缓存中获取权限数据
		Set<String> roles = getRolesByUserName(userName);
		// 3.从数据库或者缓存中获取权限数据
		Set<String> permissions = getPermissionByName(userName);
		// 4.对角色和权限受权
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		simpleAuthorizationInfo.setRoles(roles);
		simpleAuthorizationInfo.setStringPermissions(permissions);
		return simpleAuthorizationInfo;
	}
	
	/**
	 * 获取对应用户的所有权限
	 * @param userName
	 * @return
	 */
	private Set<String> getPermissionByName(String userName) {
		Set<String> sets = new HashSet<>();
		List<String> allPermissions = permissionsService.findByUserName(userName)
		.stream()
		.map(Permissions::getPname)
		.collect(Collectors.toList());
		for(String permission : allPermissions) {
			sets.add(permission);
		}
		log.info("权限结果集合:{}",sets);
    	return sets;
	}

	/**
	 * 获取对应用户的所有角色
	 * @param userName
	 * @return
	 */
    private Set<String> getRolesByUserName(String userName) {
    	// 存放角色信息
    	Set<String> sets = new HashSet<>();
        List<String> rolesList = rolesService.findByUserName(userName)
        .stream()
        .map(Roles::getRname)
    	.collect(Collectors.toList());
        for(String roles : rolesList) {
        	sets.add(roles);
        }
        log.info("结果集合:{}",sets);
    	return sets;	
	}
   
	/**
	 *  认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 1.从主体传过来认证信息中,获取用户名
		String username = (String) token.getPrincipal();
		log.info("用户名:{}",username);
		// 2.通过用户名到数据库中获取凭证
		String password = getPasswordByUserName(username);
		// 3.判断凭证
		log.info("密码:{}",password );
		if(password == null) {
			return null;// 认证信息为空，认证失败
		}
		// 认证不为空,加密返回认证信息
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username,password,"userRealm");
		authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes("jdk"));
		return authenticationInfo;
	}
    /**
     *  根据主体名找凭证
     *  @param username  主体名
     *  @return                  凭证
     */
	private String getPasswordByUserName(String username) {
		User user = userService.findByName(username);
		log.info("密码{}",user.getPassword());
		return user!=null?user.getPassword():null;
	}
	
	public static void main(String[] args) {
		Md5Hash md5Hash = new Md5Hash("123456","jdk");
		System.out.println(md5Hash.toString());
		//9da9701f342bb3fc404e7d0514ac97cd
	}

}
