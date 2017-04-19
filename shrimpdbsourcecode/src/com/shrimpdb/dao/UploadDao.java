package com.shrimpdb.dao;

import java.util.List;

import com.shrimpdb.entity.AnalyticalValue;
import com.shrimpdb.entity.Project;
import com.shrimpdb.entity.Sample_detail;
import com.shrimpdb.entity.Uploadcontents;

public interface UploadDao {

	void insertData(Uploadcontents sample_detail);

	void insertProject(Uploadcontents projects);

	Project selectProject(String sysid);

	Sample_detail selectsampledetail(String sysid);
	void saveValue(AnalyticalValue analyticalValue);

	void insertremark(AnalyticalValue spotchangevalue);

}
