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
 * 注释：权限实体
 * 2018年9月19日下午11:44:32
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Permissions implements Serializable{
    /**
     * 权限pid
     */
	private Integer pid;
	/**
	 * 权限名
	 */
	private String pname;
	/**
	 * 权限创建时间
	 */
	private Date createTime;
	/**
	 * 权限更新时间
	 */
	private Date updateTime;
	
	
}
