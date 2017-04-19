package com.shrimpdb.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;


import com.shrimpdb.entity.Project;

public class ProjectExtractor implements ResultSetExtractor<Project> {
   
	@Override
	public Project extractData(ResultSet resultSet) throws SQLException, DataAccessException 
	{
			Project project= new Project();
			
			project.setId(resultSet.getLong(1));
			project.setSystemeid(resultSet.getString(2));
			project.setUserid(resultSet.getLong(3));
			project.setPerson(resultSet.getString(4));
			project.setName(resultSet.getString(5));
			project.setSamplename(resultSet.getString(6));
			project.setProjectcode(resultSet.getString(7));
			project.setSource(resultSet.getString(8));
			project.setNumber(resultSet.getString(9));
			project.setSampling_date(resultSet.getString(10));
			project.setMethod(resultSet.getString(11));
			project.setRemarka(resultSet.getString(12));
			project.setRemarkb(resultSet.getString(13));
			project.setRemarkc(resultSet.getString(14));
			project.setRemarkd(resultSet.getString(15));
			return project;
	}

}
