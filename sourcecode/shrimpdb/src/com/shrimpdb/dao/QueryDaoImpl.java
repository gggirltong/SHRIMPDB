package com.shrimpdb.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.shrimpdb.entity.AnalyticalValue;
import com.shrimpdb.entity.QueryResult;
import com.shrimpdb.entity.Sample_detail;
import com.shrimpdb.jdbc.AnalyticalValueRowMapper;
import com.shrimpdb.jdbc.QueryResultRowMapper;
import com.shrimpdb.jdbc.SampleDetailRowMapper;
@Repository
public class QueryDaoImpl implements QueryDao{
	@Autowired
	DataSource dataSource;
	@Override
	public List<Sample_detail> listSample() {	
		List<Sample_detail> list = new ArrayList<Sample_detail>();
	//	String sql = "select a.sample_id,a.mountname,a.spotname,a.age204,a.err204,a.age208,a.err208,a.U,a.Th,a.UTh,a.fileop,s.id,s.code,s.lithologic,s.postion,s.operator,s.operate_time,s.LonEW,s.LonDeg,s.LonMin,s.LonSec,s.LatNS,s.LatDeg,s.LatMin,s.LatSec,s.instrument from analytical_value a,sample_detail s where s.id=a.sample_id ";
		String sql = "select s.id,s.main,s.code,s.lithologic,s.postion,s.lonlat,s.operate_time,s.last_operator,s.last_operate_time,s.LonEW,s.LonDeg,s.operator,s.LonMin,s.LonSec,s.latitude,s.LatNS,s.LatDeg,s.LatMin,s.LatSec,s.age,s.instrument,s.flag,s.dataid,s.systemid,s.userid,s.testid,s.remarkaa,s.remarkbb,s.remarkee  from sample_detail s where s.flag=0 and s.dataid=1";	
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		list = jdbcTemplate.query(sql, new SampleDetailRowMapper());
		return list;	
	}
	@Override
	public List<AnalyticalValue> analyticalValue(Long id) {
		List<AnalyticalValue> list = new ArrayList<AnalyticalValue>();
		String sql = "select a.id, a.sample_id,a.mountname,a.spotname,a.age204,a.err204,a.age208,a.err208,a.U,a.Th,a.UTh,a.fileop from analytical_value a where a.sample_id="+id ;			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			list = jdbcTemplate.query(sql, new AnalyticalValueRowMapper());
			return list;
	}
	@Override
	public List<QueryResult> jsonage(int samplearr) {
		List<QueryResult> list = new ArrayList<QueryResult>();
		String sql = "select a.id,a.sample_id,a.mountname,a.spotname,a.age204,a.err204,a.age208,a.err208,a.U,a.Th,a.UTh,a.fileop,s.id,s.code,s.lithologic,s.postion,s.operator,s.operate_time,s.LonEW,s.LonDeg,s.LonMin,s.LonSec,s.LatNS,s.LatDeg,s.LatMin,s.LatSec,s.instrument,s.flag from analytical_value a,sample_detail s  where s.id=a.sample_id and s.flag=0 and s.dataid=1 and a.sample_id="+samplearr+" order by a.age204 asc";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		list = jdbcTemplate.query(sql, new QueryResultRowMapper());	
		return list;
	}
	@Override
	public int update(List<Sample_detail> sampleresult) {
		for(int i=0;i<sampleresult.size();i++)
		{	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "UPDATE  sample_detail set lonlat=?, latitude=? where id=? ";
		jdbcTemplate.update(
				sql,
				new Object[] {sampleresult.get(i).getLonlat(),sampleresult.get(i).getLatitude(),sampleresult.get(i).getId()});
		}	// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<Sample_detail> typeSample(Long id) {
		// TODO Auto-generated method stub
		List<Sample_detail> list = new ArrayList<Sample_detail>();
		//	String sql = "select a.sample_id,a.mountname,a.spotname,a.age204,a.err204,a.age208,a.err208,a.U,a.Th,a.UTh,a.fileop,s.id,s.code,s.lithologic,s.postion,s.operator,s.operate_time,s.LonEW,s.LonDeg,s.LonMin,s.LonSec,s.LatNS,s.LatDeg,s.LatMin,s.LatSec,s.instrument from analytical_value a,sample_detail s where s.id=a.sample_id ";
			String sql = "select s.id,s.main,s.code,s.lithologic,s.postion,s.lonlat,s.operate_time,s.last_operator,s.last_operate_time,s.LonEW,s.LonDeg,s.operator,s.LonMin,s.LonSec,s.latitude,s.LatNS,s.LatDeg,s.LatMin,s.LatSec,s.age,s.instrument,s.flag,s.dataid,s.systemid,s.userid,s.testid,s.remarkaa,s.remarkbb,s.remarkee  from sample_detail s where s.flag=0 and s.dataid=1 ";
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			list = jdbcTemplate.query(sql, new SampleDetailRowMapper());
			return list;
		
	}
	@Override
	public List<Sample_detail> personSample(Long id) {
		// TODO Auto-generated method stub
		List<Sample_detail> list = new ArrayList<Sample_detail>();
		//	String sql = "select a.sample_id,a.mountname,a.spotname,a.age204,a.err204,a.age208,a.err208,a.U,a.Th,a.UTh,a.fileop,s.id,s.code,s.lithologic,s.postion,s.operator,s.operate_time,s.LonEW,s.LonDeg,s.LonMin,s.LonSec,s.LatNS,s.LatDeg,s.LatMin,s.LatSec,s.instrument from analytical_value a,sample_detail s where s.id=a.sample_id ";
			String sql = "select s.id,s.main,s.code,s.lithologic,s.postion,s.lonlat,s.operate_time,s.last_operator,s.last_operate_time,s.LonEW,s.LonDeg,s.operator,s.LonMin,s.LonSec,s.latitude,s.LatNS,s.LatDeg,s.LatMin,s.LatSec,s.age,s.instrument,s.flag,s.dataid,s.systemid,s.userid,s.testid,s.remarkaa,s.remarkbb,s.remarkee from sample_detail s where s.flag=0 and s.dataid=1 and s.userid ="+id;
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			list = jdbcTemplate.query(sql, new SampleDetailRowMapper());
			return list;
		
	}
	@Override
	public List<Sample_detail> booklist(Long id) {
		// TODO Auto-generated method stub
		List<Sample_detail> list = new ArrayList<Sample_detail>();
		//	String sql = "select a.sample_id,a.mountname,a.spotname,a.age204,a.err204,a.age208,a.err208,a.U,a.Th,a.UTh,a.fileop,s.id,s.code,s.lithologic,s.postion,s.operator,s.operate_time,s.LonEW,s.LonDeg,s.LonMin,s.LonSec,s.LatNS,s.LatDeg,s.LatMin,s.LatSec,s.instrument from analytical_value a,sample_detail s where s.id=a.sample_id ";
			String sql = "select s.id,s.main,s.code,s.lithologic,s.postion,s.lonlat,s.operate_time,s.last_operator,s.last_operate_time,s.LonEW,s.LonDeg,s.operator,s.LonMin,s.LonSec,s.latitude,s.LatNS,s.LatDeg,s.LatMin,s.LatSec,s.age,s.instrument,s.flag,s.dataid,s.systemid,s.userid,s.testid,s.remarkaa,s.remarkbb,s.remarkee from sample_detail s where  s.dataid <> '1' and s.userid ="+id;		
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			list = jdbcTemplate.query(sql, new SampleDetailRowMapper());
			return list;	
	}
	@Override
	public List<Sample_detail> sampleclass(int cdd) {
		List<Sample_detail> list = new ArrayList<Sample_detail>();
		//	String sql = "select a.sample_id,a.mountname,a.spotname,a.age204,a.err204,a.age208,a.err208,a.U,a.Th,a.UTh,a.fileop,s.id,s.code,s.lithologic,s.postion,s.operator,s.operate_time,s.LonEW,s.LonDeg,s.LonMin,s.LonSec,s.LatNS,s.LatDeg,s.LatMin,s.LatSec,s.instrument from analytical_value a,sample_detail s where s.id=a.sample_id ";
			String sql = "select s.id,s.main,s.code,s.lithologic,s.postion,s.lonlat,s.operate_time,s.last_operator,s.last_operate_time,s.LonEW,s.LonDeg,s.operator,s.LonMin,s.LonSec,s.latitude,s.LatNS,s.LatDeg,s.LatMin,s.LatSec,s.age,s.instrument,s.flag,s.dataid,s.systemid,s.userid,s.testid,s.remarkaa,s.remarkbb,s.remarkee from sample_detail s  where s.flag=0 and s.dataid=1 order by  s.id desc limit 1,"+cdd;		
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			list = jdbcTemplate.query(sql, new SampleDetailRowMapper());
		// TODO Auto-generated method stub
		return list;
	}
	@Override
	public List<Sample_detail> personopen(Long id) {
		// TODO Auto-generated method stub
				List<Sample_detail> list = new ArrayList<Sample_detail>();
				//	String sql = "select a.sample_id,a.mountname,a.spotname,a.age204,a.err204,a.age208,a.err208,a.U,a.Th,a.UTh,a.fileop,s.id,s.code,s.lithologic,s.postion,s.operator,s.operate_time,s.LonEW,s.LonDeg,s.LonMin,s.LonSec,s.LatNS,s.LatDeg,s.LatMin,s.LatSec,s.instrument from analytical_value a,sample_detail s where s.id=a.sample_id ";
					String sql = "select s.id,s.main,s.code,s.lithologic,s.postion,s.lonlat,s.operate_time,s.last_operator,s.last_operate_time,s.LonEW,s.LonDeg,s.operator,s.LonMin,s.LonSec,s.latitude,s.LatNS,s.LatDeg,s.LatMin,s.LatSec,s.age,s.instrument,s.flag,s.dataid,s.systemid,s.userid,s.testid,s.remarkaa,s.remarkbb,s.remarkee from sample_detail s where s.flag=0 and s.dataid=1 and s.userid ="+id;		
					JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
					list = jdbcTemplate.query(sql, new SampleDetailRowMapper());
					return list;
				
	}
	@Override
	public List<Sample_detail> personprivate(Long id) {
		// TODO Auto-generated method stub
		List<Sample_detail> list = new ArrayList<Sample_detail>();
		//	String sql = "select a.sample_id,a.mountname,a.spotname,a.age204,a.err204,a.age208,a.err208,a.U,a.Th,a.UTh,a.fileop,s.id,s.code,s.lithologic,s.postion,s.operator,s.operate_time,s.LonEW,s.LonDeg,s.LonMin,s.LonSec,s.LatNS,s.LatDeg,s.LatMin,s.LatSec,s.instrument from analytical_value a,sample_detail s where s.id=a.sample_id ";
			String sql = "select s.id,s.main,s.code,s.lithologic,s.postion,s.lonlat,s.operate_time,s.last_operator,s.last_operate_time,s.LonEW,s.LonDeg,s.operator,s.LonMin,s.LonSec,s.latitude,s.LatNS,s.LatDeg,s.LatMin,s.LatSec,s.age,s.instrument,s.flag,s.dataid,s.systemid,s.userid,s.testid,s.remarkaa,s.remarkbb,s.remarkee from sample_detail s where s.flag=1  and s.userid ="+id;		
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			list = jdbcTemplate.query(sql, new SampleDetailRowMapper());
			return list;
}
	@Override
	public void updataopen(List<Integer> numTable) {
		for(int i=0;i<numTable.size();i++)
		{	
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "UPDATE  sample_detail set  flag=? where id=? ";
		jdbcTemplate.update(
				sql,
				new Object[] {0,numTable.get(i)});
		}	// TODO Auto-generated method stub
		
		
	}
	//��ҳ��ͼ��ʾ��Ʒ�����
	@Override
	public List<Sample_detail> homeSample() {
		List<Sample_detail> list = new ArrayList<Sample_detail>();
		//	String sql = "select a.sample_id,a.mountname,a.spotname,a.age204,a.err204,a.age208,a.err208,a.U,a.Th,a.UTh,a.fileop,s.id,s.code,s.lithologic,s.postion,s.operator,s.operate_time,s.LonEW,s.LonDeg,s.LonMin,s.LonSec,s.LatNS,s.LatDeg,s.LatMin,s.LatSec,s.instrument from analytical_value a,sample_detail s where s.id=a.sample_id ";
		
		String sql = "select s.id,s.main,s.code,s.lithologic,s.postion,s.lonlat,s.operate_time,s.last_operator,s.last_operate_time,s.LonEW,s.LonDeg,s.operator,s.LonMin,s.LonSec,s.latitude,s.LatNS,s.LatDeg,s.LatMin,s.LatSec,s.age,s.instrument,s.flag,s.dataid,s.systemid,s.userid,s.testid,s.remarkaa,s.remarkbb,s.remarkee  from sample_detail s  where s.flag=0  order by s.id desc";	
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			list = jdbcTemplate.query(sql, new SampleDetailRowMapper());
			return list;	
		
	}
	@Override
	public void changedata(List<String> rem,List<Integer> ag) {
		for(int i=0;i<rem.size();i++)
		{	
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "UPDATE  sample_detail set remarkaa=? where id=? ";
		jdbcTemplate.update(
				sql,
				new Object[] {rem.get(i),ag.get(i)});
		}	// TODO Auto-generated method stu// TODO Auto-generated method stub		
	}
	@Override
	public List<AnalyticalValue> pickav() {
		List<AnalyticalValue> list = new ArrayList<AnalyticalValue>();
		String sql = "select a.id, a.sample_id,a.mountname,a.spotname,a.age204,a.err204,a.age208,a.err208,a.U,a.Th,a.UTh,a.fileop from analytical_value a order by a.id desc limit 8000,10000 " ;			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			list = jdbcTemplate.query(sql, new AnalyticalValueRowMapper());
			return list;
	}
	@Override
	
		public List<QueryResult> jsonagearray(List<Integer> samplearr) {
		
			List<QueryResult> list = new ArrayList<QueryResult>();
			StringBuilder sb = new StringBuilder(" a.sample_id in (");
			for(int i=0; i < samplearr.size(); i++) {
			int aa=samplearr.get(i);
			  sb.append(aa);
			  if(i < samplearr.size() - 1) {
			    sb.append(',');
			  }
			}
			sb.append(')');
		
		//	String sql = "select a.id,a.sample_id,a.mountname,a.spotname,a.age204,a.err204,a.age208,a.err208,a.U,a.Th,a.UTh,a.fileop,s.id,s.code,s.lithologic,s.postion,s.operator,s.operate_time,s.LonEW,s.LonDeg,s.LonMin,s.LonSec,s.LatNS,s.LatDeg,s.LatMin,s.LatSec,s.instrument,s.flag from analytical_value a,sample_detail s  where s.id=a.sample_id and s.flag=0 and s.dataid=1 and a.sample_id="+samplearr+" order by a.age204 asc";
			String sql = "select a.id,a.sample_id,a.mountname,a.spotname,a.age204,a.err204,a.age208,a.err208,a.U,a.Th,a.UTh,a.fileop,s.id,s.code,s.lithologic,s.postion,s.operator,s.operate_time,s.LonEW,s.LonDeg,s.LonMin,s.LonSec,s.LatNS,s.LatDeg,s.LatMin,s.LatSec,s.instrument,s.flag from analytical_value a,sample_detail s  where s.id=a.sample_id and s.flag=0 and s.dataid=1 and "+ sb.toString()+" order by a.age204 asc";
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			list = jdbcTemplate.query(sql, new QueryResultRowMapper());	
			return list;
		}
	
	
}