package com.shrimpdb.dao;

import java.util.List;

import com.shrimpdb.entity.User;

public interface UserDao {
	public void insertData(User user);

	//public List<User> getUserList();
	
	public List<User> getTeacherList();
	public List<User> getuserlist();
	public List<User> getStudentList();
	public List<User> findbyid(Long id);
	public List<User> userListJSON(User user);
	public int count(User user);
	//public void deleteData(Long id);
	//public User getUser(Long id);
	public User findByLoginName(String loginName);
	public User findByownerid(String id);
	//public void updateUserLoginTime(Long id);
	public User findByEmail(String email);
	public User getUser(Long id);
	public void updateData(User user);
	//public List<User> userList(User user);

	public void updateUserLoginTime(Long id);

	public void updatetype(int usertype, Long id);

	public String UpdateRole(String id);

	
	//public List<User> getTeacherListByOffice(Long officeId);

	//public List<User> getUserListByName(String name);

//	public List<User> getwUserList();

	//public User getUser(String loginName, String psw);

	//public List<User> getNUserList();

	//public List<User> userListJSON(User user);

	//public int count(User user);

	//public List<User> getUserListByOffice(Long id);
}
