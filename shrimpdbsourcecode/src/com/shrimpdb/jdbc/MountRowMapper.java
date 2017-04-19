package com.shrimpdb.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.shrimpdb.entity.AnalyticalValue;
import com.shrimpdb.entity.Menu;
import com.shrimpdb.entity.Mount;

public class MountRowMapper implements RowMapper<Mount> {

	@Override
	public Mount mapRow(ResultSet resultSet, int arg1) throws SQLException {
		
		MountExtractor mountExtractor= new MountExtractor();
		return mountExtractor.extractData(resultSet);
	}

}
