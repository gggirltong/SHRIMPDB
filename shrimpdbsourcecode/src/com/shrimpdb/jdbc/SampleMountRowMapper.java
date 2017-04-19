package com.shrimpdb.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.shrimpdb.entity.Menu;
import com.shrimpdb.entity.SampleMount;

public class SampleMountRowMapper implements RowMapper<SampleMount> {

	@Override
	public SampleMount mapRow(ResultSet resultSet, int arg1) throws SQLException {
		
		SampleMountExtractor sampleMountExtractor= new SampleMountExtractor();
		return sampleMountExtractor.extractData(resultSet);
	}

}
