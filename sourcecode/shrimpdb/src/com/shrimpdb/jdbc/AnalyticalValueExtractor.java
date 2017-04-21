package com.shrimpdb.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.shrimpdb.entity.AnalyticalValue;

public class AnalyticalValueExtractor implements ResultSetExtractor<AnalyticalValue>{

	@Override
	public AnalyticalValue extractData(ResultSet resultSet) throws SQLException,
			DataAccessException {
		AnalyticalValue queryResult= new AnalyticalValue();
		queryResult.setId(resultSet.getLong(1));
		queryResult.setSample_id(resultSet.getLong(2));
		queryResult.setMountname(resultSet.getString(3));
		queryResult.setSpotname(resultSet.getString(4));
		queryResult.setAge204(resultSet.getLong(5));
		queryResult.setErr204(resultSet.getLong(6));
		queryResult.setAge208(resultSet.getLong(7));
		queryResult.setErr208(resultSet.getLong(8));
		queryResult.setU(resultSet.getLong(9));
		queryResult.setTh(resultSet.getLong(10));
		queryResult.setUTh(resultSet.getLong(11));
		queryResult.setFileop(resultSet.getString(12));
	
		return queryResult;
	}

}
