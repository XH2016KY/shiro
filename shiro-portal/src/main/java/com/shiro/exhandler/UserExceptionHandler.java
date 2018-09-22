package com.shiro.exhandler;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import com.shiro.enums.StatusEnums.LoginStatusEnum;
import com.shiro.enums.moduleEnums.PermissionsEnum;
import com.shiro.enums.moduleEnums.RolesEnum;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author happyeveryday 
 * 注释：处理UserController的异常 
 * 2018年9月18日上午1:12:50
 */
@ControllerAdvice
@Slf4j
public class UserExceptionHandler {
	
	 /**
     * 处理角色异常
     * @param e
     * @return
     */
	@ExceptionHandler(UnauthorizedException.class)
	@ResponseBody
	public String handleBindException(UnauthorizedException e) {
        String message = e.getMessage();
		log.info("GGG->{}",message);
	    if(message.contains("does not have role")) {	
	    	return RolesEnum.NO_ROLES.getMsg();	
	    }
	    return message.contains("Subject does not have permission")?
	    		PermissionsEnum.NO_PERMISSIONS.getMsg():"系统未知异常";
	    
	}


	/**
	 * 处理登陆异常
	 * 
	 * @param e
	 * @return
	 */
	@ExceptionHandler(AuthenticationException.class)
	@ResponseBody
	public String handleBindException(AuthenticationException e) {
		String message = e.getMessage();
		log.info("GGG---->{}", message);
		return message.contains("Authentication failed for token submission") ?
				LoginStatusEnum.NO_USER.getMsg() : "未知异常";
	}

	/**
	 * 处理密码异常
	 * 
	 * @param e
	 * @return
	 */
	@ExceptionHandler(IncorrectCredentialsException.class)
	@ResponseBody
	public String handleBindException(IncorrectCredentialsException e) {
		String message = e.getMessage();
		log.info("GGG---->{}", message);
		return message.contains("not match the expected credentials") ?
				LoginStatusEnum.PASSWORD_ERROR.getMsg(): "未知异常";
	}
}
