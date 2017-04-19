package com.shrimpdb.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.shrimpdb.entity.UserRole;

public class UserRoleRowMapper implements RowMapper<UserRole>{

	@Override
	public UserRole mapRow(ResultSet resultSet, int arg1) throws SQLException {
		UserRoleExtractor userRoleExtractor=new UserRoleExtractor();
		return userRoleExtractor.extractData(resultSet);
	}

}
