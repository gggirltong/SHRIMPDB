package com.shrimpdb.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.shrimpdb.entity.UserRole;

public class UserRoleExtractor implements ResultSetExtractor<UserRole> {

	@Override
	public UserRole extractData(ResultSet resultSet) throws SQLException,
			DataAccessException {
		
		UserRole userRole=new UserRole();
		
		userRole.setRoleId(resultSet.getLong(1));
		userRole.setLoginName(resultSet.getString(2));
		return userRole;
	}

}
