package com.shrimpdb.services;

import java.io.File;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shrimpdb.entity.AnalyticalValue;
import com.shrimpdb.entity.Project;
import com.shrimpdb.entity.Sample_detail;
import com.shrimpdb.entity.Uploadcontents;

public interface UploadService {

	public void insertData(Uploadcontents sample_detail);

	public void insertProject(Uploadcontents projects);

	public Project selectProject(String sysid);

	public Sample_detail selectsampledetail(String sysid);

	public String saveFile(MultipartFile file, String path);

	public void saveValue();

	public void CreateTestvalue(String fileName, String id);

	void insertaccu(String fileName, String id);

	public void insertremark(AnalyticalValue aaa);

	public void readExcel(File file);
}
