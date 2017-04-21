package com.shrimpdb.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.shrimpdb.entity.User;
import com.shrimpdb.entity.UserRole;
import com.shrimpdb.jdbc.UserRoleRowMapper;

@Repository
public class UserRoleDaoImpl implements UserRoleDao{
	
	@Autowired
	DataSource dataSource;
	
	@Override
	public UserRole getRole(Long id){
		List<UserRole> roleList = new ArrayList<UserRole>();
		String sql = "select u.role_id, u.user_id from shrimpdb_user_role u where u.user_id= " + id;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		roleList = jdbcTemplate.query(sql, new UserRoleRowMapper());
		if(roleList.isEmpty()) {
			return null;
		}
		return roleList.get(0);
		
	}
	@Override
	public List<UserRole> getRoleList(Long id){
		
		List<UserRole> roleList = new ArrayList<UserRole>();
		String sql = "select u.role_id, u.user_id from shrimpdb_user_role u where u.user_id= " + id;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		roleList = jdbcTemplate.query(sql, new UserRoleRowMapper());
		return roleList;	
	}
	@Override
	public void insertRole(User user) {

		String sql = "INSERT INTO shrimpdb_user_role ( role_id, user_id) VALUES ( ?, ?)";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql, new Object[] { user.getType(),user.getId() });
	}
	@Override
	public void updatetype(int typeid,Long userid) {
		// TODO Auto-generated method stub
		String sql = "UPDATE shrimpdb_user_role set role_id = ? where user_id = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
  
		jdbcTemplate.update(sql, new Object[] { typeid,userid });
	
	}
}
