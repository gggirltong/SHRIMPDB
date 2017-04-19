package com.shrimpdb.dao

import com.shrimpdb.entity.Sample_detail;
public class UploadDaoImpl implements UploadDao{
	@Override
	public void insertData(Sample_detail sample_detail) {
	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	String sql = "INSERT INTO sample_detail (code, lithologic, postion, LonEW,LonDeg,LonMin,LonSec,latNS,LatDeg,LatMin,LatSec) VALUES (  ?, ?, ?, ?, ?,?,?,?,?,?,?)";
	jdbcTemplate.update(
			sql,
			new Object[] { sample_detail.getCode(),sample_detail.getLithologic(),sample_detail.getPostion(),sample_detail.getLonEW(),sample_detail.getLonDeg(),sample_detail.getMain(),sample_detail.getLonSec(),sample_detail.getLatNS(),sample_detail.getLatDeg(),sample_detail.getLatMin(),sample_detail.getLatSec() });
}
}