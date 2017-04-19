package com.shrimpdb.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.shrimpdb.entity.RoleMenu;
import com.shrimpdb.jdbc.RoleMenuRowMapper;

@Repository
public class RoleMenuDaoImpl implements RoleMenuDao{

	@Autowired
	DataSource dataSource;
	
	@Override
	public List<RoleMenu> getMenuIdList(Long id) {
		
        List<RoleMenu> menueIdList=  new ArrayList<RoleMenu>();
		
		String sql = "select menu_id, role_id from shrimpdb_role_menu where role_id= " + id;;

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		menueIdList = jdbcTemplate.query(sql, new RoleMenuRowMapper());
		return menueIdList;
		
	}

}
