package com.shrimpdb.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shrimpdb.dao.UserDao;
import com.shrimpdb.dao.UserRoleDao;
import com.shrimpdb.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userdao;
	@Autowired
	private UserRoleDao userRoledao;
	@Override
	public boolean checkLoginName(String loginName) {
		User user1 = userdao.findByLoginName(loginName);
			if (user1 != null) {
				return true;
			}
			return false;
	}
	
	@Override
	public void insertData(User user) {		
		String pw= entryptPassword(user.getPassword());
		user.setPassword(pw);
		userdao.insertData(user);
	}
	
	@Override
	public String entryptPassword(String plainPassword) {
		return plainPassword;
		//byte[] salt = Digests.generateSalt(8);
		//byte[] hashPassword = Digests.sha1(plainPassword.getBytes(), salt, 1024);
		//return Encodes.encodeHex(salt) + Encodes.encodeHex(hashPassword);
		//com.lioms.common.MD5 md5 = new com.lioms.common.MD5();
		//return md5.getMD5String(plainPassword);
	}
	@Override
	public User findByLoginName(String loginName) {		
		return userdao.findByLoginName(loginName);
	}
	@Override
	public User findByownerid(String id){		
		return userdao.findByownerid(id);
	}
	@Override
	public void insertRole(User user) {
	userRoledao.insertRole(user);
	}

	
	@Override
	public boolean checkEmail(String email) {
		User user1 = userdao.findByEmail(email);
		if (user1 != null) {
			return true;
		}
		return false;
	}
	
	public List<User> getTeacherList() 	{
		List<User>list= userdao.getTeacherList();
		
		return list;
	}
	public List<User> getStudentList() 	{
		List<User>list= userdao.getStudentList();
		
		return list;
	}
	
	public List<User> getuserlist()
	{
		List<User> userlist= userdao.getuserlist();
		return userlist;
	}
	@Override
	public List<User> findbyid(Long id)
	{
		List<User> userlist= userdao.findbyid(id);
		return userlist;
	}
	
	@Override
	public String jsonString(User user) {
		List<User> list = userdao.userListJSON(user);
		StringBuffer jsonString = new StringBuffer();
		int len=list.size();		
		   for(int j=0;j<1;j++){
				jsonString.append("[");
		   for(int i=0;i<len;i++){								
			    jsonString.append("{");	
			    jsonString.append("\"id\":");//真实姓名
			
			    jsonString.append(list.get(i).getId());	
			   
			    jsonString.append(",\"name\":");//真实姓名
			    jsonString.append("\"");
			    jsonString.append(list.get(i).getName());	
			    jsonString.append("\"");
		        jsonString.append(",\"phone\":");
				jsonString.append(list.get(i).getPhone());			
				jsonString.append(",\"email\":");
				jsonString.append("\"");
				jsonString.append(list.get(i).getEmail());
				jsonString.append("\"");
				jsonString.append(",\"unit\":");
				jsonString.append("\"");
				jsonString.append(list.get(i).getUnit());
				jsonString.append("\"");
				jsonString.append(",\"department\":");
				jsonString.append("\"");
				jsonString.append(list.get(i).getDepartment());
				jsonString.append("\"");
				jsonString.append(",\"createdate\":");
				jsonString.append("\"");
				jsonString.append(list.get(i).getCreate_date());
				jsonString.append("\"");
				jsonString.append(",\"papera\":");
				jsonString.append("\"");
				jsonString.append(list.get(i).getPapera());
				jsonString.append("\"");
				jsonString.append(",\"paperb\":");
				jsonString.append("\"");
				jsonString.append(list.get(i).getPaperb());
				jsonString.append("\"");
				jsonString.append(",\"paperc\":");
				jsonString.append("\"");
				jsonString.append(list.get(i).getPaperc());
				jsonString.append("\"");
				jsonString.append(",\"image\":");
				jsonString.append("\"");
				jsonString.append(list.get(i).getImag());
				jsonString.append("\"");				
				jsonString.append(",\"degree\":");
				jsonString.append("\"");	
				jsonString.append(list.get(i).getDegree());
				jsonString.append("\"");	
				jsonString.append(",\"type\":");//用户类型
			    jsonString.append(list.get(i).getType());
				jsonString.append("}");
			if(i<len-1)jsonString.append(",");
			}
			jsonString.append("]");	
		}	
		return jsonString.toString();
	}
	
	@Override
	public User getUser(Long id) {
		return userdao.getUser(id);
	}
	
	
	@Override
	public void updateData(User user) {		
		User user1=user;
		String password=user1.getPassword();
		String pw= entryptPassword(password);
	    user.setPassword(pw);	
	 	userdao.updateData(user);

	}

	@Override
	public String UpdateRole(String id) {
		return userdao.UpdateRole(id);
		
	}
	
	
	
	
	
	
	
	/*
	

	@Override
	public UserRole getUserRole(Long id) {
		
		return userRoledao.getRole(id);
	}

	
	@Override
	public List<User> getUserList() {
		return userdao.getUserList();
	}
	
	

	@Override
	public void deleteData(Long id) {
		userdao.deleteData(id);

	}

	@Override
	public User getUser(Long id) {
		return userdao.getUser(id);
	}
	@Override
	public User getUser(String loginName, String psw) {
		return userdao.getUser(loginName,psw);
	}
	
	
	




	

	@Override
	public List<User> userList(User user) {
		return userdao.userList(user);
	}

	@Override
	public List<User> getwUserList() {
				
		List<User>list= userdao.getwUserList();
		PYUSER comp = new PYUSER();
		Collections.sort(list, comp);
		return list;
	}

	@Override
	public List<User> getNUserList() {
		List<User>list= userdao.getNUserList();
		PYUSER comp = new PYUSER();
		Collections.sort(list, comp);
		return list;
	}
	@Override
	public String jsonString(User user) {
		
		int page = user.getPage();
		int rp =user.getRp();
		
		List<User> list = userdao.userListJSON(user);
		StringBuffer jsonString = new StringBuffer();
		jsonString.append("{\"page\":" + page);
		jsonString.append(",\"total\":" + userdao.count(user));
		jsonString.append(",\"rows\":[");
		int xh = (page - 1) * rp;
		for(int i = 0; i < list.size(); ++i){
			User u = list.get(i);
			++xh;
			jsonString.append("{\"id\":\"" + i + "\"");

			// 序号->仪器名称->姓名->手机号码->样品名称->申请日期->状�?->操作
			jsonString.append(",\"cell\":[\"" + xh + "\",\"" + u.getLogin_name() + "\",\"" + u.getName() + "\",\"" + u.getCreate_date() + "\",\"" + u.getMobile() + "\",\"" + u.getEmail() + "\",\"" + u.getRemarks() + "\",\"" + u.getId() + "\"]},");
		}
		if(!list.isEmpty()) {
			jsonString.deleteCharAt(jsonString.length()-1);
		}
		jsonString.append("]}");
		return jsonString.toString();
	}
	@Override
	public String jsonString21(User user) {
		
		int page = user.getPage();
		int rp =user.getRp();
		
		List<User> list = userdao.userListJSON(user);
		StringBuffer jsonString = new StringBuffer();
		jsonString.append("{\"page\":" + page);
		jsonString.append(",\"total\":" + userdao.count(user));
		jsonString.append(",\"rows\":[");
		int xh = (page - 1) * rp;
		for(int i = 0; i < list.size(); ++i){
			User u = list.get(i);
			++xh;
			jsonString.append("{\"id\":\"" + i + "\"");

			// 序号->仪器名称->姓名->手机号码->样品名称->申请日期->状�?->操作
			jsonString.append(",\"cell\":[\"" + xh + "\",\"" + u.getLogin_name() + "\",\"" + u.getName() + "\",\"" + u.getCreate_date() + "\",\"" + u.getExpire_date() + "\",\"" + u.getMobile() + "\",\"" + u.getEmail() + "\",\"" + u.getId() + "\"]},");
		}
		if(!list.isEmpty()) {
			jsonString.deleteCharAt(jsonString.length()-1);
		}
		jsonString.append("]}");
		return jsonString.toString();
	}

	@Override
	public List<User> getUserListByOffice(Long id) {
		// TODO Auto-generated method stub
		return userdao.getTeacherListByOffice(id);
	}*/
	
}
