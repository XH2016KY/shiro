package com.shiro.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.shiro.api.UserService;
import com.shiro.module.User;

/**
 * 
 * @author happyeveryday
 * 注释：用户控制层
 * 2018年9月17日下午6:12:27
 */
@Controller
public class UserController {

	
	private final UserService userService;
	
	/**
	 * 构造器注入{@link com.shiro.api.UserService}}
	 * @param userService
	 */
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "/find",method = RequestMethod.GET)
	@ResponseBody
	public User findByName() {
		return userService.findByName("user");
		
	}
	
	
	@RequestMapping(value = "Login" ,method = RequestMethod.POST,
			produces="application/json;charset=utf-8")
	@ResponseBody
	public String Login(User user) throws Exception{
		// 获取主体
		Subject subject = SecurityUtils.getSubject();
		// 创建图个token
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),
				user.getPassword());
		subject.login(token);
		return "登陆GGG";
	}
	
	@RequiresRoles("admin1")
	@RequestMapping(value = "/testRole1",method = RequestMethod.GET,
			produces="application/json;charset=utf-8")
	@ResponseBody
	public String testRole1() {
		return "admin:GGG";
		
	}
	
	@RequiresRoles("admin")
	@RequestMapping(value = "/testRole2",method = RequestMethod.GET,
			produces="application/json;charset=utf-8")
	@ResponseBody
	public String testRole2() {
		return "admin:GGG";
		
	}
	
	@RequiresPermissions({"user:add","user:delete"})
	@RequestMapping(value = "/boot",method = RequestMethod.GET,
	        produces="application/json;charset=utf-8")
	public String boot() {
		return "login";
		
	}
	
	@RequestMapping(value = "/css",method = RequestMethod.GET)
	public String boot1() {
		return "baseCss";
		
	}
	
	@RequestMapping(value = "/down",method = RequestMethod.GET)
	public String boot2() {
		return "Down";
		
	}
	
}
