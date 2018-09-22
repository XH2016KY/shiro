package com.shiro.enums.moduleEnums;

import lombok.Getter;

@Getter
public enum RolesEnum {
	
	NO_ROLES(0,"你没有对应角色");
	
	/** 状态码*/
	private Integer code;
	/** 状态信息*/
	private String msg;
	
	 RolesEnum(Integer code,String msg){
		this.code = code;
		this.msg = msg;
	}

}
