package com.shrimpdb.entity;

import java.io.Serializable;

public class UserRole implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long userId;
	private Long roleId;
	private String LoginName;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public String getLoginName() {
		return LoginName;
	}
	public void setLoginName(String loginName) {
		LoginName = loginName;
	}

}
