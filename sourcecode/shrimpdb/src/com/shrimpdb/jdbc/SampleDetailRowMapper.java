package com.shrimpdb.jdbc;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.shrimpdb.entity.Sample_detail;

public class SampleDetailRowMapper implements RowMapper<Sample_detail>{
	@Override
	public Sample_detail mapRow(ResultSet resultSet, int arg1) throws SQLException {
		
		SampleDetailExtractor sampleDetailExtractor= new SampleDetailExtractor();
		return sampleDetailExtractor.extractData(resultSet);
	}
}