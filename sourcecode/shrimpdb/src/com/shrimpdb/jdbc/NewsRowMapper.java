package com.shrimpdb.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.shrimpdb.entity.News;

public class NewsRowMapper implements RowMapper<News>{

	@Override
	public News mapRow(ResultSet resultSet, int arg) throws SQLException {
		
		NewsExtractor newsExtractor= new NewsExtractor();
		return newsExtractor.extractData(resultSet);
	}

}