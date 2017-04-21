
package com.shrimpdb.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.shrimpdb.entity.News;
import com.shrimpdb.jdbc.NewsRowMapper;

@Repository
public class NewsDaoImply implements NewsDao {
	@Autowired
	DataSource dataSource;
	
	@Override
	public void updateData(News news) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "UPDATE news set TITLE = ?, CONTENT = ? ,DATEUPLOAD = ? where id = ?" ;
		jdbcTemplate.update(sql, new Object[] {news.getTitle(),news.getContent(),new java.sql.Timestamp(new java.util.Date().getTime()),news.getId()});
	}
	
	@Override
	public News News_one (Long id) {
		
		List<News> newsList = new ArrayList<News>();
		String sql = "select n.ID, n.TITLE, n.CONTENT, n.flag,n.DATEUPLOAD from news n where n.id="+id; 
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		newsList = jdbcTemplate.query(sql, new NewsRowMapper());
		if(newsList.isEmpty()) {
			return null;
		}
		return newsList.get(0);
	}

	@Override
	public  News  getPtgk(){
		
		List<News> ptgkList = new ArrayList<News>();
		String sql = "select n.ID, n.TITLE, n.CONTENT, n.flag,n.DATEUPLOAD from news n where n.flag=0"; 
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		ptgkList = jdbcTemplate.query(sql, new NewsRowMapper());
		if(ptgkList.isEmpty()) {
			return null;
		}
		return ptgkList.get(0);
	}
	
	@Override
	public  News  getsybz(){
		
		List<News> ptgkList = new ArrayList<News>();
		String sql = "select n.ID, n.TITLE, n.CONTENT, n.flag,n.DATEUPLOAD from news n where n.flag=1"; 
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		ptgkList = jdbcTemplate.query(sql, new NewsRowMapper());
		if(ptgkList.isEmpty()) {
			return null;
		}
		return ptgkList.get(0);
	}
	@Override
	public  News  getsfbz(){
		
		List<News> sfbz = new ArrayList<News>();
		String sql = "select n.ID, n.TITLE, n.CONTENT, n.flag,n.DATEUPLOAD from news n where n.flag=4"; 
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		sfbz = jdbcTemplate.query(sql, new NewsRowMapper());
		if(sfbz.isEmpty()) {
			return null;
		}
		return sfbz.get(0);
	}
	@Override
    public List<News>  getNewsList(){
		List<News> newsList = new ArrayList<News>();
		String sql = "select n.ID, n.TITLE, n.CONTENT, n.flag,n.DATEUPLOAD from news n order by DATEUPLOAD desc" ;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		newsList = jdbcTemplate.query(sql, new NewsRowMapper());
		return newsList;
	}
	@Override
    public List<News>  newsListJSON(News news){
		List<News> newsList = new ArrayList<News>();
		
		String sql = "select n.ID, n.TITLE, n.CONTENT, n.flag,n.DATEUPLOAD from news n order by DATEUPLOAD desc" ;
		
		int page = news.getPage();
		int rp =news.getRp();
		int offset=(page - 1) * rp;
		sql += " limit " + offset + "," + rp;
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		newsList = jdbcTemplate.query(sql, new NewsRowMapper());
		return newsList;
	}
	@Override
    public int count(){
		
		String sql = "select count(*) from news n order by DATEUPLOAD desc" ;
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		int count = jdbcTemplate.queryForInt(sql);
		return count;
	}
	@Override
	public void insertData(News news) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "INSERT INTO news (TITLE, CONTENT,flag, DATEUPLOAD) VALUES (?,?,?,?)";
		jdbcTemplate.update(sql, new Object[] {news.getTitle(),news.getContent(),news.getFlag(),new java.sql.Timestamp(new java.util.Date().getTime())});
    }
	@Override
	public void deleteData(Long id) {
		String sql = "DELETE from news where id = " + id;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql);

	}
	
	
}
