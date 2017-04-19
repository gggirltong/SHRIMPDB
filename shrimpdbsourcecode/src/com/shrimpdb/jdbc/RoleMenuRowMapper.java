package com.shrimpdb.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.shrimpdb.entity.RoleMenu;

public class RoleMenuRowMapper implements RowMapper<RoleMenu>{

	@Override
	public RoleMenu mapRow(ResultSet resultSet, int arg1) throws SQLException {
		
		RoleMenuExtractor roleMenuExtractor=new RoleMenuExtractor();
		return roleMenuExtractor.extractData(resultSet);
	}

}
