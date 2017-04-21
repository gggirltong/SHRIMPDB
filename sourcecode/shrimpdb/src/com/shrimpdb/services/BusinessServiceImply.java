package com.shrimpdb.services;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.shrimpdb.entity.AnalyticalValue;
import com.shrimpdb.entity.Mount;
import com.shrimpdb.entity.News;
import com.shrimpdb.entity.QueryResult;
import com.shrimpdb.entity.SampleMount;
import com.shrimpdb.entity.Sample_detail;
import com.shrimpdb.entity.User;
import com.shrimpdb.entity.UserRole;
import com.shrimpdb.common.PYusertype;
import com.shrimpdb.dao.BusinessDao;
import com.shrimpdb.dao.QueryDao;
import com.shrimpdb.dao.UserDao;
import com.shrimpdb.dao.UserRoleDao;
import com.shrimpdb.dao.UserRoleDaoImpl;
@Service
public class BusinessServiceImply implements BusinessService{
	@Autowired
	private BusinessDao businessDao;

	@Override
	public List<Mount> mountSample() {		
		return businessDao.listSample();
		
	}

	@Override
	public void insertData(SampleMount addmount) {
		// TODO Auto-generated method stub
		businessDao.insertData(addmount);
	}

	@Override
	public void updateflag(String[] arr, String sysnumber) {
		businessDao.updateflag(arr,sysnumber);	
	}

	@Override
	public List<SampleMount> measurement() {
		// TODO Auto-generated method stub
		return businessDao.measurement();
	}

	@Override
	public void UpdateMount(SampleMount measurement, String[] mountidarr) {
		businessDao.UpdateMount(measurement,mountidarr);	
		
	}

	@Override
	public void updatetestflag(String[] systemnumberdarr) {
		businessDao.updatetestflag(systemnumberdarr);	
		
	}

	@Override
	public String saveFile(MultipartFile file, String path) {
		String saveName = "";
		try {			
        	// 锟斤拷取锟侥硷拷锟侥猴拷缀锟斤拷
        	String fileName = file.getOriginalFilename();
        	String fileNameExt = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
        	
        	// 锟斤拷锟绞憋拷锟斤拷锟�
        	String szTemp = new SimpleDateFormat("yyyyMMddhhmmssSSS").format(new Date());
        	
        	// 锟斤拷锟斤拷募锟斤拷谋锟斤拷锟斤拷锟斤拷郑锟斤拷锟斤拷锟缴碉拷时锟斤拷锟斤拷+原锟饺的猴拷缀  
        	//saveName = fileName + "." + fileNameExt;
        	saveName = fileName ;
        	// 锟斤拷锟斤拷锟侥硷拷
        	java.io.File localFile = new java.io.File(path, fileName);
			file.transferTo(localFile);
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
		return saveName;
		
	}

	@Override
	public List<SampleMount> testlist() {
		// TODO Auto-generated method stub
		return businessDao.testlist();
	}

	@Override
	public void UpdateProcess(SampleMount addmount, String[] mountidarr) {
		businessDao.UpdateProcess(addmount,mountidarr);	
		
	}

	@Override
	public void updatedetailprocess(String[] systemnumberdarr) {
		businessDao.updatedetailprocess(systemnumberdarr);	
		
	}

	@Override
	public List<SampleMount> processlist() {
		// TODO Auto-generated method stub
		return businessDao.processlist();
	}

	@Override
	public List<SampleMount> resultlist(Long userid) {
		// TODO Auto-generated method stub
		return businessDao.resultlist(userid);
	}

	@Override
	public List<SampleMount> examplejson() {
		// TODO Auto-generated method stub
		return businessDao.examplejson();
	}

	@Override
	public List<Sample_detail> samplemount() {
		// TODO Auto-generated method stub
		return businessDao.samplemount();
	}
		
	}

	