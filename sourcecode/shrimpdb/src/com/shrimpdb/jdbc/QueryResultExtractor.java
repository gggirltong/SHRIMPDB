package com.shrimpdb.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.shrimpdb.entity.QueryResult;

public class QueryResultExtractor implements ResultSetExtractor<QueryResult>{

	@Override
	public QueryResult extractData(ResultSet resultSet) throws SQLException,
			DataAccessException {
		QueryResult queryResult= new QueryResult();
		queryResult.setId(resultSet.getLong(1));
		queryResult.setSample_id(resultSet.getLong(2));
		queryResult.setMountname(resultSet.getString(3));
		queryResult.setSpotname(resultSet.getString(4));
		queryResult.setAge204(resultSet.getString(5));
		queryResult.setErr204(resultSet.getString(6));
		queryResult.setAge208(resultSet.getString(7));
		queryResult.setErr208(resultSet.getString(8));
		queryResult.setU(resultSet.getString(9));
		queryResult.setTh(resultSet.getString(10));
		queryResult.setUTh(resultSet.getString(11));
		queryResult.setFileop(resultSet.getString(12));
		queryResult.setCode(resultSet.getString(13));
		queryResult.setLithologic(resultSet.getString(14));
		queryResult.setPostion(resultSet.getString(15));
		queryResult.setOperator(resultSet.getString(16));
		queryResult.setOperate_time(resultSet.getString(17));
		queryResult.setLonEW(resultSet.getString(18));
		queryResult.setLonDeg(resultSet.getString(19));
		queryResult.setLonMin(resultSet.getString(20));
		queryResult.setLonSec(resultSet.getString(21));
		queryResult.setLatNS(resultSet.getString(22));
		queryResult.setLatDeg(resultSet.getString(23));
		queryResult.setLatMin(resultSet.getString(24));
     	queryResult.setLatSec(resultSet.getString(25));
     	queryResult.setInstrument(resultSet.getString(26));
     	queryResult.setFlag(resultSet.getLong(27));
     
		return queryResult;
	}

}
