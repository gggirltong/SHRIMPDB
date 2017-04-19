package com.shrimpdb.jdbc;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shrimpdb.entity.QueryResult;
import com.shrimpdb.entity.Sample_detail;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
public class SampleDetailExtractor implements ResultSetExtractor<Sample_detail> {
	@Override
	public Sample_detail extractData(ResultSet resultSet) throws SQLException,DataAccessException {
		Sample_detail  sampleDetail=new Sample_detail();
		sampleDetail.setId(resultSet.getLong(1));
		sampleDetail.setMain(resultSet.getLong(2));
		sampleDetail.setCode(resultSet.getString(3));
		sampleDetail.setLithologic(resultSet.getString(4));
		sampleDetail.setPostion(resultSet.getString(5));
		sampleDetail.setLonlat(resultSet.getDouble(6));
		sampleDetail.setOperate_time(resultSet.getString(7));
		sampleDetail.setLast_operator(resultSet.getString(8));
		sampleDetail.setLast_operate_time(resultSet.getString(9));
		sampleDetail.setLonEW(resultSet.getString(10));
		sampleDetail.setLonDeg(resultSet.getString(11));
		sampleDetail.setOperator(resultSet.getString(12));
		sampleDetail.setLonMin(resultSet.getString(13));
		sampleDetail.setLonSec(resultSet.getString(14));
		sampleDetail.setLatitude(resultSet.getDouble(15));
		sampleDetail.setLatNS(resultSet.getString(16));
		sampleDetail.setLatDeg(resultSet.getString(17));
		sampleDetail.setLatMin(resultSet.getString(18));
		sampleDetail.setLatSec(resultSet.getString(19));
		sampleDetail.setAge(resultSet.getString(20));
		sampleDetail.setInstrument(resultSet.getString(21));
		sampleDetail.setFlag(resultSet.getLong(22));
		sampleDetail.setDataid(resultSet.getLong(23));
		sampleDetail.setSystemid(resultSet.getString(24));
		sampleDetail.setUserid(resultSet.getLong(25));
		sampleDetail.setTestid(resultSet.getLong(26));
		sampleDetail.setRemarkaa(resultSet.getString(27));
		sampleDetail.setRemarkbb(resultSet.getString(28));
		sampleDetail.setRemarkee(resultSet.getString(29));		
		return sampleDetail;
	}

}
