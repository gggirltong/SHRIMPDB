package com.shrimpdb.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.shrimpdb.entity.Role;

public class RoleRowMapper implements RowMapper<Role> {

	@Override
	public Role mapRow(ResultSet resultSet, int arg1) throws SQLException {
		
		RoleExtractor roleExtractor= new RoleExtractor();
		
		return roleExtractor.extractData(resultSet);
	}

}
