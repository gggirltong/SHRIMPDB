package com.shrimpdb.entity;

import java.io.Serializable;

public class Menu implements Serializable{

	/**
	 * 权限�?
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String permission;// 权限
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}

}
