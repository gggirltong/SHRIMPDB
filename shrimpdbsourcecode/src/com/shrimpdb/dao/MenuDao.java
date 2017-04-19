package com.shrimpdb.dao;

import java.util.List;

import com.shrimpdb.entity.Menu;

public interface MenuDao {
	
	public List<Menu> getMenueList(Long id);

	public Menu getMenu(Long id);

	public String getPermission(Long id);

}
