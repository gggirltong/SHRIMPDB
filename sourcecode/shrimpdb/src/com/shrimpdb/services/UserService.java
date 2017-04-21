package com.shrimpdb.services;

import java.util.List;

import com.shrimpdb.entity.User;

public interface UserService {
	
	public void insertData(User user);
	
	public void insertRole(User user);
	
	
	public List<User> getTeacherList();
	public List<User> getuserlist();
	public List<User> getStudentList() 	;
	public User findByownerid(String id);
	public List<User> findbyid(Long id);
	public User findByLoginName(String loginName);
    public String entryptPassword(String plainPassword);	
	public boolean checkLoginName(String loginName);
	public String jsonString(User user);
	public boolean checkEmail(String email);

	public User getUser(Long id);

	public void updateData(User user);

	public String UpdateRole(String id);

	
}
