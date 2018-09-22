package com.shiro.module;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author happyeveryday
 * 注释： 用户实体
 * 2018年9月17日下午2:32:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements Serializable{
    /**
     * 用户uid
     */
	private Integer uid;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 用户密码
	 */
	private String password;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 最后一次更新时间
	 */
	private Date updateTime;
	
	
}
