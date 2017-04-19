package com.shrimpdb.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.shrimpdb.entity.RoleMenu;

public class RoleMenuExtractor implements ResultSetExtractor<RoleMenu>{

	@Override
	public RoleMenu extractData(ResultSet resultSet) throws SQLException,
			DataAccessException {
		
		RoleMenu roleMenu= new RoleMenu();
		
		roleMenu.setMenuid(resultSet.getLong(1));
		roleMenu.setRoleid(resultSet.getLong(2));
		return roleMenu;
	}

}
