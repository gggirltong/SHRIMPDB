package com.shrimpdb.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.shrimpdb.entity.Menu;
import com.shrimpdb.entity.Mount;

public class MountExtractor implements ResultSetExtractor<Mount> {

	@Override
	public Mount extractData(ResultSet resultSet) throws SQLException,
			DataAccessException {
		Mount mount= new Mount();		
		mount.setId(resultSet.getLong(1));
		mount.setCode(resultSet.getString(2));
		mount.setCreatedate(resultSet.getString(3));
		mount.setName(resultSet.getString(5));
		mount.setDepartment(resultSet.getString(6));
		mount.setUnit(resultSet.getString(7));
		
		mount.setPhone(resultSet.getString(8));
		return mount;
	}
	}

