package com.shrimpdb.jdbc;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.shrimpdb.entity.QueryResult;

public class QueryResultRowMapper implements RowMapper<QueryResult>{

	@Override
	public QueryResult mapRow(ResultSet resultSet, int arg1) throws SQLException {		
		QueryResultExtractor queryResultExtractor=new QueryResultExtractor();
		return queryResultExtractor.extractData(resultSet);
	}}
