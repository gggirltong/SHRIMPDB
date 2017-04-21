package com.shrimpdb.dao;

import java.util.List;

import com.shrimpdb.entity.User;
import com.shrimpdb.entity.UserRole;

public interface UserRoleDao {
	
	public UserRole getRole(Long id);

	public List<UserRole> getRoleList(Long id);

	public void insertRole(User user);

	void updatetype(int typeid, Long userid);

}
