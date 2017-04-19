package com.shrimpdb.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.shrimpdb.entity.Menu;
import com.shrimpdb.entity.SampleMount;

public class SampleMountExtractor implements ResultSetExtractor<SampleMount> {

	@Override
	public SampleMount extractData(ResultSet resultSet) throws SQLException,
			DataAccessException {
		SampleMount samplemount= new SampleMount();		
		samplemount.setId(resultSet.getLong(1));
		samplemount.setMountname(resultSet.getString(2));
		samplemount.setMountimg_url(resultSet.getString(3));
		samplemount.setMakeid(resultSet.getLong(4));
		samplemount.setMakedate(resultSet.getString(5));	
		samplemount.setTestid(resultSet.getLong(6));
		samplemount.setTestdate(resultSet.getString(7));
		samplemount.setProcessdate(resultSet.getString(8));
		samplemount.setFlag(resultSet.getLong(9));
		samplemount.setOpfile(resultSet.getString(10));
		samplemount.setRemarka(resultSet.getString(11));
		samplemount.setRemarkb(resultSet.getString(12));
		samplemount.setRemarkc(resultSet.getString(13));
		samplemount.setRemarkd(resultSet.getString(14));
		samplemount.setRemarke(resultSet.getString(15));
		samplemount.setRemarkf(resultSet.getString(16));
		samplemount.setMakename(resultSet.getString(17));
		return samplemount;
	}

}
