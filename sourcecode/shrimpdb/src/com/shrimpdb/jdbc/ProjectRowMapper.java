package com.shrimpdb.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.shrimpdb.entity.Menu;
import com.shrimpdb.entity.Project;

public class ProjectRowMapper implements RowMapper<Project> {

	@Override
	public Project mapRow(ResultSet resultSet, int arg1) throws SQLException {
		
		ProjectExtractor projectExtractor= new ProjectExtractor();
		return projectExtractor.extractData(resultSet);
	}

}
