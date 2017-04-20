package com.shrimpdb.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.shrimpdb.entity.User;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet resultSet, int line) throws SQLException {
		UserExtractor userExtractor = new UserExtractor();
		return userExtractor.extractData(resultSet);
	}

}
