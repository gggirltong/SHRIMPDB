package com.shrimpdb.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.shrimpdb.entity.Menu;

public class MenuRowMapper implements RowMapper<Menu> {

	@Override
	public Menu mapRow(ResultSet resultSet, int arg1) throws SQLException {
		
		MenuExtractor menuExtractor= new MenuExtractor();
		return menuExtractor.extractData(resultSet);
	}

}
