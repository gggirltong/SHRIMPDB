package com.shrimpdb.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.shrimpdb.entity.User;

public class UserExtractor implements ResultSetExtractor<User> {

	public User extractData(ResultSet resultSet) throws SQLException,
			DataAccessException {
	
        User user = new User();
		user.setId(resultSet.getLong(1));
		user.setUsername(resultSet.getString(2));
		user.setName(resultSet.getString(3));
		user.setPassword(resultSet.getString(4));
		user.setPinyin(resultSet.getString(5));
		user.setPhone(resultSet.getString(6));
		user.setEmail(resultSet.getString(7));
		user.setUnit(resultSet.getString(8));
		user.setDepartment(resultSet.getString(9));
		user.setDegree(resultSet.getString(10));
		user.setAddress(resultSet.getString(11));		
		user.setType(resultSet.getLong(12));
		user.setLogin_date(resultSet.getString(13));
		user.setCreate_date(resultSet.getString(14));
		user.setExpire_date(resultSet.getString(15));
		user.setRemarks(resultSet.getString(16));
		user.setDel_flag(resultSet.getLong(17));		
		user.setImag(resultSet.getString(18));
		user.setPapera(resultSet.getString(19));
		user.setPaperb(resultSet.getString(20));
		user.setPaperc(resultSet.getString(21));
		user.setRemarka(resultSet.getString(22));
		user.setRemarkb(resultSet.getString(23));
        user.setRemarkc(resultSet.getString(24));      
		return user;
	}

}
