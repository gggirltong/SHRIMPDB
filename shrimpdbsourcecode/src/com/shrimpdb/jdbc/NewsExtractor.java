package com.shrimpdb.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;


import com.shrimpdb.entity.News;

public class NewsExtractor implements ResultSetExtractor<News>{

	@Override
	public News extractData(ResultSet resultSet) throws SQLException,
			DataAccessException {
		
		News news=new News();	
		news.setId(resultSet.getLong(1));
		news.setTitle(resultSet.getString(2));
		news.setContent(resultSet.getString(3));
		news.setFlag(resultSet.getString(4));
		news.setUpdate(resultSet.getString(5));
		return news;
	}

}
