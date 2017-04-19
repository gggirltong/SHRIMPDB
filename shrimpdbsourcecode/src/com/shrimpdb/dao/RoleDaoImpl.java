package com.shrimpdb.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.shrimpdb.entity.Role;
import com.shrimpdb.jdbc.RoleRowMapper;

@Repository
public class RoleDaoImpl implements RoleDao{

	@Autowired
	DataSource dataSource;
	
	@Override
	public Role getRole(Long id) {
		
		List<Role> roleList = new ArrayList<Role>();
		String sql = "select r.id, r.name from shrimpdb_role r where r.id= " + id;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		roleList = jdbcTemplate.query(sql, new RoleRowMapper());
		if(roleList.isEmpty()) {
			return null;
		}
		return roleList.get(0);
	}
	
	

}
