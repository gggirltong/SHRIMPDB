package com.shrimpdb.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.shrimpdb.entity.AnalyticalValue;

public class AnalyticalValueRowMapper implements RowMapper<AnalyticalValue> {

	@Override
	public AnalyticalValue mapRow(ResultSet resultSet, int arg1) throws SQLException {	
		AnalyticalValueExtractor analyticalValueExtractor= new AnalyticalValueExtractor();
		return analyticalValueExtractor.extractData(resultSet);
	}

}
