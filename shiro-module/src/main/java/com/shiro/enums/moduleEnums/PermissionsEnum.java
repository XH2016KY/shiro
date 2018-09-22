package com.shiro.enums.moduleEnums;

import lombok.Getter;

@Getter
public enum PermissionsEnum {
	
	NO_PERMISSIONS(0,"你没有对应权限");
	
	/** 状态码*/
	private Integer code;
	/** 状态信息*/
	private String msg;
	
	 PermissionsEnum(Integer code,String msg){
		this.code = code;
		this.msg = msg;
	}

}
