package com.shiro.enums.StatusEnums;

import lombok.Getter;

/**
 * 
 * @author happyeveryday
 * 注释：用户登陆状态
 * 2018年9月18日上午12:44:49
 */
@Getter
public enum LoginStatusEnum {

	LOGIN_SICCESS(0,"登陆成功"),
	NO_USER(1,"用户不存在"),
	PASSWORD_ERROR(2,"密码错误");
	
	/** 状态码*/
	private Integer code;
	/** 状态信息*/
	private String msg;
	
	LoginStatusEnum(Integer code,String msg){
		this.code = code;
		this.msg = msg;
	}
	
}
