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
 * 注释：角色实体
 * 2018年9月19日下午5:27:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Roles implements Serializable{
    /**
     * 角色rid
     */
	private Integer rid;
	/**
	 * 角色rname
	 */
	private String rname;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 最后一次更新时间
	 */
	private Date updateTime;
}
