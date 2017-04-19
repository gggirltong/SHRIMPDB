package com.shrimpdb.dao;

import java.util.List;

import com.shrimpdb.entity.RoleMenu;

public interface RoleMenuDao {
	
	public List<RoleMenu> getMenuIdList(Long id);

}
