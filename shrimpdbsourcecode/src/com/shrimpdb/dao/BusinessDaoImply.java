package com.shrimpdb.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.shrimpdb.entity.Menu;
import com.shrimpdb.entity.Mount;
import com.shrimpdb.entity.SampleMount;
import com.shrimpdb.entity.Sample_detail;
import com.shrimpdb.jdbc.MenuRowMapper;
import com.shrimpdb.jdbc.MountRowMapper;
import com.shrimpdb.jdbc.SampleDetailRowMapper;
import com.shrimpdb.jdbc.SampleMountRowMapper;

@Repository
public class BusinessDaoImply implements BusinessDao{
	
	@Autowired
	DataSource dataSource;

	@Override
	public List<Mount> listSample() {
		List<Mount> list = new ArrayList<Mount>();
		//	String sql = "select a.sample_id,a.mountname,a.spotname,a.age204,a.err204,a.age208,a.err208,a.U,a.Th,a.UTh,a.fileop,s.id,s.code,s.lithologic,s.postion,s.operator,s.operate_time,s.LonEW,s.LonDeg,s.LonMin,s.LonSec,s.LatNS,s.LatDeg,s.LatMin,s.LatSec,s.instrument from analytical_value a,sample_detail s where s.id=a.sample_id ";
			String sql = "select s.id,s.code, s.operate_time,u.id,u.name,u.department,u.unit,u.phone from sample_detail s, shrimpdb_user u where s.flag=0 and s.dataid=0 and s.userid= u.id ";	
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			list = jdbcTemplate.query(sql, new MountRowMapper());
			return list;	
		
	}
	public List<SampleMount> examplejson() {
		List<SampleMount> list = new ArrayList<SampleMount>();
		//	String sql = "select a.sample_id,a.mountname,a.spotname,a.age204,a.err204,a.age208,a.err208,a.U,a.Th,a.UTh,a.fileop,s.id,s.code,s.lithologic,s.postion,s.operator,s.operate_time,s.LonEW,s.LonDeg,s.LonMin,s.LonSec,s.LatNS,s.LatDeg,s.LatMin,s.LatSec,s.instrument from analytical_value a,sample_detail s where s.id=a.sample_id ";
		//	String sql = "select s.id,s.code, s.operate_time,u.id,u.name,u.department,u.unit,u.phone from sample_detail s, shrimpdb_user u where s.flag=0 and s.dataid=0 and s.userid= u.id ";	
		  String sql = "select m.id,m.mountname, m.mountimg_url,m.makeid,m.makedate,m.testid,m.testdate,m.processdate,m.flag,m.opfile,m.remarka,m.remarkb,m.remarkc, s.dataid,s.operate_time, s.code, s.remarkaa from sample_mount m, sample_detail s where (s.dataid<>0 or s.dataid<>1)  and m.remarka=s.remarkaa";	
				
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			list = jdbcTemplate.query(sql, new SampleMountRowMapper());
			return list;	
		
	}
	@Override
	public void insertData(SampleMount addmount) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "INSERT INTO sample_mount (mountname, mountimg_url,makeid, makedate,flag,remarka) VALUES (?,?,?,?,?,?)";
		jdbcTemplate.update(sql, new Object[] {addmount.getMountname(),addmount.getMountimg_url(),addmount.getMakeid(),addmount.getMakedate(),addmount.getFlag(),addmount.getRemarka()});
	
	}

	@Override
	public void updateflag(String[] arr, String sysnumber) {
		for(int i=0;i<arr.length;i++)
		{
	    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "UPDATE  sample_detail set remarkaa=?, dataid= ? where id= ?";
		jdbcTemplate.update(sql, new Object[] {sysnumber,20,arr[i]});
	}
	}
	@Override
	public List<SampleMount> measurement() {
		    List<SampleMount> list = new ArrayList<SampleMount>();
		//	String sql = "select a.sample_id,a.mountname,a.spotname,a.age204,a.err204,a.age208,a.err208,a.U,a.Th,a.UTh,a.fileop,s.id,s.code,s.lithologic,s.postion,s.operator,s.operate_time,s.LonEW,s.LonDeg,s.LonMin,s.LonSec,s.LatNS,s.LatDeg,s.LatMin,s.LatSec,s.instrument from analytical_value a,sample_detail s where s.id=a.sample_id ";
			String sql = "select m.id,m.mountname, m.mountimg_url,m.makeid,m.makedate,m.testid,m.testdate,m.processdate,m.flag,m.opfile,m.remarka,m.remarkb,m.remarkc,m.remarkd,m.remarke,m.remarkf, u.id,u.name from sample_mount m ,shrimpdb_user u where m.makeid=u.id and m.flag= 0";	
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			list = jdbcTemplate.query(sql, new SampleMountRowMapper());
			return list;	
	}

	@Override
	public void UpdateMount(SampleMount measurement, String[] mountidarr) {
		for(int i=0;i<mountidarr.length;i++)
		{
	    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "UPDATE  sample_mount set testid=?, testdate= ?, flag=? where id= ?";
		jdbcTemplate.update(sql, new Object[] {measurement.getTestid(),measurement.getTestdate(),measurement.getFlag(),mountidarr[i]});
	}
	}

	@Override
	public void updatetestflag(String[] systemnumberdarr) {
		// TODO Auto-generated method stub
		for(int i=0;i<systemnumberdarr.length;i++)
		{
	    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "UPDATE  sample_detail set dataid=? where remarkaa= ?";
		jdbcTemplate.update(sql, new Object[] {30,systemnumberdarr[i]});
	    }
	}
	@Override
	public List<SampleMount> testlist() {
	       List<SampleMount> list = new ArrayList<SampleMount>();
			//	String sql = "select a.sample_id,a.mountname,a.spotname,a.age204,a.err204,a.age208,a.err208,a.U,a.Th,a.UTh,a.fileop,s.id,s.code,s.lithologic,s.postion,s.operator,s.operate_time,s.LonEW,s.LonDeg,s.LonMin,s.LonSec,s.LatNS,s.LatDeg,s.LatMin,s.LatSec,s.instrument from analytical_value a,sample_detail s where s.id=a.sample_id ";
	       String sql = "select m.id,m.mountname, m.mountimg_url,m.makeid,m.makedate,m.testid,m.testdate,m.processdate,m.flag,m.opfile,m.remarka,m.remarkb,m.remarkc,m.remarkd,m.remarke,m.remarkf, u.id,u.name from sample_mount m ,shrimpdb_user u where m.makeid=u.id and (m.flag= 1 or m.flag=2)";	
		   JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		   list = jdbcTemplate.query(sql, new SampleMountRowMapper());
		   return list;	
}

	@Override
	public void updatedetailprocess(String[] systemnumberdarr) {
		// TODO Auto-generated method stub
				for(int i=0;i<systemnumberdarr.length;i++)
				{
			    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
				String sql = "UPDATE  sample_detail set dataid=? where remarkaa= ?";
				jdbcTemplate.update(sql, new Object[] {50,systemnumberdarr[i]});
			}
		
	}

	@Override
	public void UpdateProcess(SampleMount addmount, String[] mountidarr) {
		for(int i=0;i<mountidarr.length;i++)
		{
	    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "UPDATE  sample_mount set remarkb=?, processdate= ?, flag=? where id= ?";
		jdbcTemplate.update(sql, new Object[] {addmount.getOpfile(),addmount.getProcessdate(),addmount.getFlag(),mountidarr[i]});
	
	}

	}

	@Override
	public List<SampleMount> processlist() {
		  List<SampleMount> list = new ArrayList<SampleMount>();
			//	String sql = "select a.sample_id,a.mountname,a.spotname,a.age204,a.err204,a.age208,a.err208,a.U,a.Th,a.UTh,a.fileop,s.id,s.code,s.lithologic,s.postion,s.operator,s.operate_time,s.LonEW,s.LonDeg,s.LonMin,s.LonSec,s.LatNS,s.LatDeg,s.LatMin,s.LatSec,s.instrument from analytical_value a,sample_detail s where s.id=a.sample_id ";
	      String sql = "select m.id,m.mountname, m.mountimg_url,m.makeid,m.makedate,m.testid,m.testdate,m.processdate,m.flag,m.opfile,m.remarka,m.remarkb,m.remarkc,m.remarkd,m.remarke,m.remarkf, u.id,u.name from sample_mount m ,shrimpdb_user u where m.makeid=u.id and m.flag= 3";	
		  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		  list = jdbcTemplate.query(sql, new SampleMountRowMapper());
		  return list;	

	}

	@Override
	public List<SampleMount> resultlist(Long id) {
		  List<SampleMount> list = new ArrayList<SampleMount>();
	  //	String sql = "select a.sample_id,a.mountname,a.spotname,a.age204,a.err204,a.age208,a.err208,a.U,a.Th,a.UTh,a.fileop,s.id,s.code,s.lithologic,s.postion,s.operator,s.operate_time,s.LonEW,s.LonDeg,s.LonMin,s.LonSec,s.LatNS,s.LatDeg,s.LatMin,s.LatSec,s.instrument from analytical_value a,sample_detail s where s.id=a.sample_id ";
	      String sql = "select m.id,m.mountname, m.mountimg_url,m.makeid,m.makedate,m.testid,m.testdate,m.processdate,m.flag,m.opfile,m.remarka,m.remarkb,m.remarkc,m.remarkd,m.remarke, s.code, s.remarkaa, s.userid from sample_mount m, sample_detail s where m.flag=3 and m.remarka=s.remarkaa and s.userid ="+id;	
		  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		  list = jdbcTemplate.query(sql, new SampleMountRowMapper());
		  return list;	
}
	@Override
	public List<Sample_detail> samplemount()
	       {
		    List<Sample_detail> list = new ArrayList<Sample_detail>();
		   //String sql = "select a.sample_id,a.mountname,a.spotname,a.age204,a.err204,a.age208,a.err208,a.U,a.Th,a.UTh,a.fileop,s.id,s.code,s.lithologic,s.postion,s.operator,s.operate_time,s.LonEW,s.LonDeg,s.LonMin,s.LonSec,s.LatNS,s.LatDeg,s.LatMin,s.LatSec,s.instrument from analytical_value a,sample_detail s where s.id=a.sample_id ";
			String sql = "select s.id,s.main,s.code,s.lithologic,s.postion,s.lonlat,s.operate_time,m.id,m.mountname,m.remarka,s.LonDeg,u.id,u.name,u.department,s.latitude,u.phone,u.unit,s.LatMin,s.LatSec,s.age,s.instrument,s.flag,s.dataid,s.systemid,s.userid,s.testid,s.remarkaa,s.remarkbb,s.remarkee  from sample_detail s, sample_mount m, shrimpdb_user u where s.flag<>1 and s.remarkaa=m.remarka and s.userid= u.id";	
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			list = jdbcTemplate.query(sql, new SampleDetailRowMapper());
			return list;	
			}
	
}