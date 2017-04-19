package com.shrimpdb.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.shrimpdb.entity.AnalyticalValue;
import com.shrimpdb.entity.Project;
import com.shrimpdb.entity.Sample_detail;
import com.shrimpdb.entity.Uploadcontents;
import com.shrimpdb.jdbc.ProjectRowMapper;
import com.shrimpdb.jdbc.SampleDetailRowMapper;
@Repository
public class UploadDaoImpl implements UploadDao{
	@Autowired
	DataSource dataSource;

	@Override
	public void insertData(Uploadcontents sample_detail) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "INSERT INTO sample_detail (main,code, lithologic, postion ,lonlat,LonEW,LonDeg,LonMin,LonSec,operate_time,latitude,LatNS,LatDeg,LatMin,LatSec,flag,dataid,systemid,userid,testid,remarkaa,remarkbb,remarkee) VALUES (  ?,?,?, ?, ?, ?,?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(
				sql,
				new Object[] {sample_detail.getMain(), sample_detail.getCode(),sample_detail.getLithologic(),sample_detail.getPostion(),sample_detail.getLonlat(),sample_detail.getLonEW(),sample_detail.getLonDeg(),sample_detail.getLonMin(),sample_detail.getLonSec(),sample_detail.getOperate_time(),sample_detail.getLatitude(),sample_detail.getLatNS(),sample_detail.getLatDeg(),sample_detail.getLatMin(),sample_detail.getLatSec(),sample_detail.getFlag(),sample_detail.getDataid(),sample_detail.getSystemid(),sample_detail.getUserid(),sample_detail.getTestid(),sample_detail.getRemarkaa(),sample_detail.getRemarkbb(),sample_detail.getRemarkee()});
	}
	@Override
	public void insertProject(Uploadcontents projects) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "INSERT INTO project_info (systemeid,person, name, samplename ,projectcode,source,number,sampling_date,method,remarka,remarkb,remarkc,remarkd) VALUES ( ?, ?, ?, ?, ?, ?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(
				sql,
				new Object[] {projects.getSystemid(),projects.getPerson(),projects.getName(),projects.getSamplename(),projects.getProjectcode(),projects.getSource(),projects.getNumber(),projects.getSampling_date(),projects.getMethod(),projects.getRemarka(),projects.getRemarkb(),projects.getRemarkc(),projects.getRemarkd()});
	}
	@Override
	public Sample_detail selectsampledetail(String sysid) {
		
			Sample_detail list = new 	Sample_detail();
			String sql = "select s.id,s.main,s.code,s.lithologic,s.postion,s.lonlat,s.operate_time,s.last_operator,s.last_operate_time,s.LonEW,s.LonDeg,s.operator,s.LonMin,s.LonSec,s.latitude,s.LatNS,s.LatDeg,s.LatMin,s.LatSec,s.age,s.instrument,s.flag,s.dataid,s.systemid,s.userid,s.testid,s.remarkaa,s.remarkbb,s.remarkee from sample_detail s where s.main="+sysid;			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			list = jdbcTemplate.query(sql, new SampleDetailRowMapper()).get(0);
			return list;
		
		
	}
	@Override
	public Project selectProject(String sysid) {
		// TODO Auto-generated method stub
		Project list=new Project();
		String sql="select p.id,p.systemeid,p.userid,p.person,p.name,p.samplename,p.projectcode,p.source,p.number,p.sampling_date,p.method,p.remarka,p.remarkb,p.remarkc,p.remarkd from project_info p where p.systemeid ="+sysid;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		list = jdbcTemplate.query(sql, new ProjectRowMapper()).get(0);
		
		return list;
	}
	@Override
	public void saveValue(AnalyticalValue list) {
		// TODO Auto-generated method stubvalu	   
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "INSERT INTO analytical_value (sample_id,mountname,spotname, age204, err204 ,age208,err208,U,Th,UTh,fileop,testdate,testtime) VALUES ( ?, ?,?, ?, ?, ?, ?,?,?,?,?,?,?)";
		jdbcTemplate.update(
				sql,
				new Object[] {list.getSample_id(),list.getMountname(),list.getSpotname(),list.getAge204(),list.getErr204(),list.getAge208(),list.getErr208(),list.getU(),list.getTh(),list.getUTh(),list.getFileop(),list.getTestdate(),list.getTesttime()});
		}
	@Override
	public void insertremark(AnalyticalValue spotchangevalue) {
		
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "UPDATE  analytical_value set  testdate=? where id=?";
		jdbcTemplate.update(
				sql,
				new Object[] {spotchangevalue.getTestdate(),spotchangevalue.getId()});
		
	
	}
	}
	

	