package com.shrimpdb.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.shrimpdb.entity.Menu;
import com.shrimpdb.jdbc.MenuRowMapper;

@Repository
public class MenuDaoImpl implements MenuDao{
	
	@Autowired
	DataSource dataSource;
	
	@Override
	public List<Menu> getMenueList(Long id){
		
		List<Menu> menueList=  new ArrayList<Menu>();
		
		String sql = "select m.id, m.permission from shrimpdb_menu m where m.id= " + id;;

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		menueList = jdbcTemplate.query(sql, new MenuRowMapper());
		return menueList;
	}
	@Override
	public Menu getMenu(Long id){
		
        List<Menu> menueList=  new ArrayList<Menu>();
		
		String sql = "select m.id, m.permission from shrimpdb_menu m where m.id= " + id;

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		menueList = jdbcTemplate.query(sql, new MenuRowMapper());
		if(menueList.isEmpty()) {
			return null;
		}
		return menueList.get(0);
	}
	@Override
	public String getPermission(Long id){
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		String permission= (String) jdbcTemplate.queryForObject("select permission from shrimpdb_menu where id= ?",
				                                                 new Object[] {id}, java.lang.String.class);

		return permission;
	}

}
