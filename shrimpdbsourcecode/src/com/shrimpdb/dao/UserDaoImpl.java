package com.shrimpdb.dao;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.shrimpdb.entity.User;
import com.shrimpdb.jdbc.UserRowMapper;


@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	DataSource dataSource;
	
	private String makeQuote(String raw) {
		return "'" + raw + "'";
	}
	@Override
	public User findByLoginName(String loginName) {
		String name=loginName;
        String namea= makeQuote(name);
		List<User> userList = new ArrayList<User>();
		String sql = "select u.id,u.username,u.name,u.password,u.pinyin, u.phone, u.email,u.unit,u.department,u.degree,u.address,u.type,u.login_date,u.create_date,u.expire_date,u.remarks,u.del_flag,u.imag,u.papera,u.paperb,u.paperc,u.remarka,u.remarkb,u.remarkc from shrimpdb_user u where u.del_flag =0 and u.username=" + namea ;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userList = jdbcTemplate.query(sql, new UserRowMapper());
		if(userList.isEmpty()) {
			return null;
		}
		return userList.get(0);
	}
@Override
	public User findByownerid(String id) {
		int iid=Integer.parseInt(id);
		List<User> userList = new ArrayList<User>();
		String sql = "select u.id,u.username,u.name,u.password,u.pinyin, u.phone, u.email,u.unit,u.department,u.degree,u.address,u.type,u.login_date,u.create_date,u.expire_date,u.remarks,u.del_flag,u.imag,u.papera,u.paperb,u.paperc,u.remarka,u.remarkb,u.remarkc from shrimpdb_user u  where u.flag =0 and u.id=" + iid ;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userList = jdbcTemplate.query(sql, new UserRowMapper());
		if(userList.isEmpty()) {
			return null;
		}
		return userList.get(0);
	}
	
	
	
	@Override
	public void insertData(User user) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "INSERT INTO shrimpdb_user (username, name, password, pinyin,phone,email,unit,department,degree,address,type,login_date,create_date,expire_date,remarks,del_flag,imag,papera,paperb,paperc,remarka,remarkb,remarkc) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, new Object[] { user.getUsername(),user.getName(),user.getPassword(),user.getPinyin(),user.getPhone(),user.getEmail(),user.getUnit(),user.getDepartment(),user.getDegree(),user.getAddress(),user.getType(),user.getLogin_date(),user.getCreate_date(),user.getExpire_date(),user.getRemarks(),user.getDel_flag(),user.getImag(),user.getPapera(),user.getPaperb(),user.getPaperc(),user.getRemarka(),user.getRemarkb(),user.getRemarkc()});
	
		}
	@Override
	public List<User> getTeacherList() {
		List<User> userList = new ArrayList<User>();
		String sql = "select u.id,u.username,u.name,u.password,u.pinyin, u.phone, u.email,u.unit,u.department,u.degree,u.address,u.type,u.login_date,u.create_date,u.expire_date,u.remarks,u.del_flag,u.imag,u.papera,u.paperb,u.paperc,u.remarka,u.remarkb,u.remarkc from shrimpdb_user u where u.type =1 " ;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userList = jdbcTemplate.query(sql, new UserRowMapper());
		return userList;
	}
	@Override
	public List<User> getStudentList() {
		List<User> userList = new ArrayList<User>();
		String sql = "select u.id,u.username,u.name,u.password,u.pinyin, u.phone, u.email,u.unit,u.department,u.degree,u.address,u.type,u.login_date,u.create_date,u.expire_date,u.remarks,u.del_flag,u.imag,u.papera,u.paperb,u.paperc,u.remarka,u.remarkb,u.remarkc from shrimpdb_user u where u.type =2" ;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userList = jdbcTemplate.query(sql, new UserRowMapper());
		return userList;
	}
	@Override
	public List<User> getuserlist() {
		List<User> userList = new ArrayList<User>();
		String sql = "select u.id,u.username,u.name,u.password,u.pinyin, u.phone, u.email,u.unit,u.department,u.degree,u.address,u.type,u.login_date,u.create_date,u.expire_date,u.remarks,u.del_flag,u.imag,u.papera,u.paperb,u.paperc,u.remarka,u.remarkb,u.remarkc from shrimpdb_user u where u.type <>0 " ;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userList = jdbcTemplate.query(sql, new UserRowMapper());
		return userList;
	}
	@Override
	public List<User> findbyid(Long id) {
		List<User> userList = new ArrayList<User>();
		String sql = "select u.id,u.username,u.name,u.password,u.pinyin, u.phone, u.email,u.unit,u.department,u.degree,u.address,u.type,u.login_date,u.create_date,u.expire_date,u.remarks,u.del_flag,u.imag,u.papera,u.paperb,u.paperc,u.remarka,u.remarkb,u.remarkc from shrimpdb_user u where u.id ="+id ;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userList = jdbcTemplate.query(sql, new UserRowMapper());
		return userList;
	}
	@Override
	public User findByEmail(String email) {
		List<User> userList = new ArrayList<User>();
		String sql = "select u.id,u.username,u.name,u.password,u.pinyin, u.phone, u.email,u.unit,u.department,u.degree,u.address,u.type,u.login_date,u.create_date,u.expire_date,u.remarks,u.del_flag,u.imag,u.papera,u.paperb,u.paperc,u.remarka,u.remarkb,u.remarkc from shrimpdb_user u where u.del_flag =0  and u.email=" + makeQuote(email);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userList = jdbcTemplate.query(sql, new UserRowMapper());
		if(userList.isEmpty()) {
			return null;
		}
		return userList.get(0);
	}
	@Override
	public List<User> userListJSON(User user) {
	
		List<User> userList = new ArrayList<User>();		
		String sql = "select u.id,u.username,u.name,u.password,u.pinyin, u.phone, u.email,u.unit,u.department,u.degree,u.address,u.type,u.login_date,u.create_date,u.expire_date,u.remarks,u.del_flag,u.imag,u.papera,u.paperb,u.paperc,u.remarka,u.remarkb,u.remarkc from shrimpdb_user u  where u.del_flag <>1 " ;				
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userList = jdbcTemplate.query(sql, new UserRowMapper());
		return userList;
	
	}
	@Override
	public int count(User user) {
		
		String sql = "select count(*)  from shrimpdb_user n  " ;		
	    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		int count = jdbcTemplate.queryForInt(sql);
		return count;
	}
	@Override
	public User getUser(Long id) {
		List<User> userList = new ArrayList<User>();
		String sql = "select u.id,u.username,u.name,u.password,u.pinyin, u.phone, u.email,u.unit,u.department,u.degree,u.address,u.type,u.login_date,u.create_date,u.expire_date,u.remarks,u.del_flag,u.imag,u.papera,u.paperb,u.paperc,u.remarka,u.remarkb,u.remarkc from shrimpdb_user u where u.id= " + id;			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userList = jdbcTemplate.query(sql, new UserRowMapper());
		if(userList.isEmpty()) {
			return null;
		}
		return userList.get(0);
	}
	@Override
	public void updateData(User user) {

		String sql = "UPDATE shrimpdb_user set username = ?, password = ?, name = ?,email = ?, tele = ? where id = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
  String pw=user.getPassword();
  String uname=user.getName();
  String email=user.getEmail();
		jdbcTemplate.update(sql, new Object[] { user.getUsername(),pw, uname,email,user.getPhone(), user.getId() });

	}
	@Override
	public void updateUserLoginTime(Long id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updatetype(int typeid,Long userid) {
		// TODO Auto-generated method stub
		String sql = "UPDATE shrimpdb_user set type = ? where id = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
  
		jdbcTemplate.update(sql, new Object[] { typeid,userid });
	
	}
	@Override
	public String UpdateRole(String id) {
		// TODO Auto-generated method stub
				String sql = "UPDATE shrimpdb_user set type = ? where id = ?";
				JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		  
				jdbcTemplate.update(sql, new Object[] { 7,id });
				
				return "1";
				}
	
/*
	
	
	@Override
	public List<User> getUserList() {
		List<User> userList = new ArrayList<User>();

		String sql = "select u.id, u.login_name,u.password, u.name, u.email,u.mobile,u.phone,u.type,u.parent_id,u.address,u.create_date,u.expire_date,u.remarks,u1.name from lioms_user u,lioms_user u1 order by u.create_date desc where u.del_flag =0 and u.parent_id=u1.id";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userList = jdbcTemplate.query(sql, new UserRowMapper());
		return userList;
	}
	@Override
	public List<User> getUserListByName(String name) {
		List<User> userList = new ArrayList<User>();

		String sql = "select u.id, u.login_name,u.password, u.name, u.email,u.mobile,u.phone,u.type,u.parent_id,u.office_id,u.address,u.create_date,u.expire_date,u.remarks,u1.name from lioms_user u,lioms_user u1 order by u.create_date desc where u.del_flag =0 and u.parent_id=u1.id and u.name="+ makeQuote(name);

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userList = jdbcTemplate.query(sql, new UserRowMapper());
		return userList;
	}
	@Override
	public List<User> getUserListByOffice(Long id) {
		List<User> userList = new ArrayList<User>();

		String sql = "select u.id, u.login_name,u.password, u.name, u.email,u.mobile,u.phone,u.type,u.parent_id,u.office_id,u.address,u.create_date,u.expire_date,u.remarks,u1.name from lioms_user u,lioms_user u1 order by u.create_date desc where u.del_flag =0 and u.parent_id=u1.id and u.office_id="+ id;

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userList = jdbcTemplate.query(sql, new UserRowMapper());
		return userList;
	}

	@Override
	public List<User> getTeacherListByOffice(Long officeId) {
		List<User> userList = new ArrayList<User>();

		String sql = "select u.id, u.login_name,u.password, u.name, u.email,u.mobile,u.phone,u.type,u.parent_id,u.office_id,u.address,u.create_date,u.expire_date,u.remarks,u1.name from lioms_user u,lioms_user u1 where u.type=5 and u.del_flag =0 and u.parent_id=u1.id and u.office_id="+ officeId;

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userList = jdbcTemplate.query(sql, new UserRowMapper());
		return userList;
	}
	@Override
	public List<User> getwUserList() {
		List<User> userList = new ArrayList<User>();

		String sql = "select u.id, u.login_name,u.password, u.name, u.email,u.mobile,u.phone,u.type,u.parent_id,u.office_id,u.address,u.create_date,u.expire_date,u.remarks,u1.name from lioms_user u,lioms_user u1 where u.type=7 and u.del_flag =0 and u.parent_id=u1.id and u.id<>565";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userList = jdbcTemplate.query(sql, new UserRowMapper());
		return userList;
	}
	@Override
	public List<User> getNUserList() {//选择校内用户
		List<User> userList = new ArrayList<User>();

		String sql = "select u.id, u.login_name,u.password, u.name, u.email,u.mobile,u.phone,u.type,u.parent_id,u.office_id,u.address,u.create_date,u.expire_date,u.remarks,u1.name from lioms_user u,lioms_user u1 where (u.type=5 or u.type=6) and u.del_flag =0 and u.parent_id=u1.id";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userList = jdbcTemplate.query(sql, new UserRowMapper());
		return userList;
	}
	@Override
	public void deleteData(Long id) {
		String sql = "UPDATE lioms_user set del_flag =1 where id = " + id;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql);

	}

	
	@Override
	public User getUser(Long id) {
		List<User> userList = new ArrayList<User>();
		String sql = "select u.id, u.login_name,u.password, u.name, u.email,u.mobile,u.phone,u.type,u.parent_id,u.office_id,u.address,u.create_date,u.expire_date,u.remarks,u1.name from lioms_user u,lioms_user u1 where u.parent_id=u1.id and u.id= " + id;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userList = jdbcTemplate.query(sql, new UserRowMapper());
		if(userList.isEmpty()) {
			return null;
		}
		return userList.get(0);
	}
	@Override
	public User getUser(String loginName,String psw) {//根据用户名和密码查找用户
		List<User> userList = new ArrayList<User>();
		String sql = "select u.id, u.login_name,u.password, u.name, u.email,u.mobile,u.phone,u.type,u.parent_id,u.office_id,u.address,u.create_date,u.expire_date,u.remarks,u1.name from lioms_user u,lioms_user u1 where u.del_flag =0 and u.parent_id=u1.id and u.login_name= " + makeQuote(loginName) +" and u.password= " + makeQuote(psw);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userList = jdbcTemplate.query(sql, new UserRowMapper());
		if(userList.isEmpty()) {
			return null;
		}
		return userList.get(0);
	}
	
	
	
	@Override
	public List<User> userList(User user) {
		
		String sql = "select u.id, u.login_name,u.password, u.name, u.email,u.mobile,u.phone,u.type,u.parent_id,u.office_id,u.address,u.create_date,u.expire_date,u.remarks,u1.name from lioms_user u,lioms_user u1 where u.del_flag =0 and u.parent_id=u1.id and u.type in (2,3,4,5,6,7)";

		Long uiid =user.getParent_id();
		Long type=user.getType();
		String qtype=user.getQtype();
		String query=user.getQuery();
		if (null != uiid && uiid > 0) {
			String ext = " and u.parent_id=" + uiid;
			sql += ext;
		}
		if (null != type) {
			String ext = " and u.type='" + type + "'";
			sql += ext;
		}	
		
		if (null != qtype && null != query) {
			String ext = " and u." + qtype + " like '%" + query + "%'";
			sql += ext;
		}
		if (!p.getSortname().isEmpty() && !p.getSortorder().isEmpty()) {
			sql += " order by u." + p.getSortname() + " " + p.getSortorder();
		}
		sql += " order by u.create_date desc ";
		List<User> userList = new ArrayList<User>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userList = jdbcTemplate.query(sql, new UserRowMapper());
		if(userList.isEmpty()) {
			return null;
		}
		return userList;
	}
	@Override
	public List<User> userListJSON(User user) {
		
		String sql = "select u.id, u.login_name,u.password, u.name, u.email,u.mobile,u.phone,u.type,u.parent_id,u.office_id,u.address,u.create_date,u.expire_date,u.remarks,u1.name from lioms_user u,lioms_user u1 where u.del_flag =0 and u.parent_id=u1.id and u.type in (2,3,4,5,6,7)";
		
		int page = user.getPage();
		int rp =user.getRp();
		int offset=(page - 1) * rp;
		Long uiid =user.getParent_id();
		Long type=user.getType();
		String qtype=user.getQtype();
		String query=user.getQuery();
		
		if (null != uiid && uiid > 0) {
			String ext = " and u.parent_id=" + uiid;
			sql += ext;
		}
		if (null != type ) {
			String ext = " and u.type='" + type + "'";
			sql += ext;
		}	
		
		if (null != qtype && null != query) {
			String ext = " and u." + qtype + " like '%" + query + "%'";
			sql += ext;
		}
		sql += " order by u.create_date desc ";
		sql += " limit " + offset + "," + rp;
		
		List<User> userList = new ArrayList<User>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userList = jdbcTemplate.query(sql, new UserRowMapper());

		return userList;
	}
	@Override
	public int count(User user) {
		
		String sql = "select count(*)" +
				" from lioms_user u,lioms_user u1 " +
				"where u.del_flag =0 and u.parent_id=u1.id and u.type in (2,3,4,5,6,7)";

		Long uiid =user.getParent_id();
		Long type=user.getType();
		String qtype=user.getQtype();
		String query=user.getQuery();
		
		if (null != uiid && uiid > 0) {
			String ext = " and u.parent_id=" + uiid;
			sql += ext;
		}
		if (null != type) {
			String ext = " and u.type='" + type + "'";
			sql += ext;
		}	
		
		if (null != qtype && null != query) {
			String ext = " and u." + qtype + " like '%" + query + "%'";
			sql += ext;
		}
		sql += " order by u.create_date desc ";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		int count = jdbcTemplate.queryForInt(sql);
		return count;
	}
	*/
	
}
