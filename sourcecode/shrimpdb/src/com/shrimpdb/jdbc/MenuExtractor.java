package com.shrimpdb.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.shrimpdb.entity.Menu;

public class MenuExtractor implements ResultSetExtractor<Menu> {

	@Override
	public Menu extractData(ResultSet resultSet) throws SQLException,
			DataAccessException {
		Menu menu= new Menu();
		
		menu.setId(resultSet.getLong(1));
		menu.setPermission(resultSet.getString(2));
		return menu;
	}

}
