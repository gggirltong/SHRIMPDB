package com.shrimpdb.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.shrimpdb.entity.Role;

public class RoleExtractor implements ResultSetExtractor<Role> {

	@Override
	public Role extractData(ResultSet resultSet) throws SQLException,
			DataAccessException {
		
		Role role= new Role();
		role.setId(resultSet.getLong(1));
		role.setName(resultSet.getString(2));
		return role;
	}

}
