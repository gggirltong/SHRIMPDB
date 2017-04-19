package com.shrimpdb.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shrimpdb.entity.AnalyticalValue;
import com.shrimpdb.entity.QueryResult;
import com.shrimpdb.entity.Sample_detail;
import com.shrimpdb.entity.User;
import com.shrimpdb.entity.UserRole;
import com.shrimpdb.common.PYusertype;
import com.shrimpdb.dao.QueryDao;
import com.shrimpdb.dao.UserDao;
import com.shrimpdb.dao.UserRoleDao;
import com.shrimpdb.dao.UserRoleDaoImpl;
@Service
public class QueyServiceImpl implements QueryService{
	@Autowired
	private QueryDao queryDao;
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserRoleDaoImpl userRoleDao;
	
	
	@Override
	public List<Sample_detail> sampleresult() {	
	User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");//锟斤拷取锟斤拷前锟斤拷录锟矫伙拷	
	if(user!=null)
	{   
		Long dd=user.getType();
		String s=dd.toString();
		List<Sample_detail> list=new ArrayList<Sample_detail>();
		list=null;
		int cdd=0;
		int i=Integer.parseInt(s);
		switch(i)
		{
		 case 4: 
		 { cdd=500;
			 list=queryDao.sampleclass(cdd);
			 break;}
		 case 5: 
		 {  cdd=1000;
			 list=queryDao.sampleclass(cdd);
			break;}
		 case 6: 
		 { cdd=5000;
			 list=queryDao.sampleclass(cdd);
			break;}
		 case 7: 
		 { cdd=100;
			 list=queryDao.sampleclass(cdd);
			break;}
		 case 8: 
		 { cdd=1;
			 list=queryDao.sampleclass(cdd);
			break;}
		 default: 
		 { list=queryDao.listSample();
			break;}
			
		}
		return list;}
	else
		return null;
		
	}
	
	@Override
	public List<Sample_detail> homeresult() {	
	
		return queryDao.homeSample();
		
	}
	
	@Override
	public List<AnalyticalValue> analyticalValue(Long id) {
		
		return queryDao.analyticalValue(id);
	}
	@Override
	public List<QueryResult> jsonage(Integer samplearr) {
		// TODO Auto-generated method stub
		return queryDao.jsonage(samplearr);
	}
	@Override
	public List<QueryResult> jsonagearray(List<Integer> samplearr) {
		// TODO Auto-generated method stub
		return queryDao.jsonagearray(samplearr);
	}
	//锟斤拷锟斤拷原始锟斤拷锟斤拷械锟絞ps锟斤拷锟斤拷为锟劫度撅拷纬锟斤拷锟斤拷锟�锟斤拷拥锟絪ample_detail锟斤拷锟叫碉拷lonlat锟斤拷latitude锟斤拷
	@Override
	public int update(List<Sample_detail> sampleresult) {
		// TODO Auto-generated method stub
		return queryDao.update(sampleresult);
	}
	@Override
	public List<Sample_detail> personresult(Long userid) {
	//	List<UserRole> userRoleList = userroleDao.getRoleList(userid);
	//UserRole 	userrole=userRoleList.get(0);
	//Long roleid=userrole.getRoleId();
		return queryDao.personSample(userid);
	}
	@Override
	public List<Sample_detail> booklist(Long id) {
		// TODO Auto-generated method stub
		return queryDao.booklist(id);
	}
	@Override
	public List<Sample_detail> openlist(Long id) {
		return queryDao.personprivate(id);
		
	}
	@Override
	public List<Integer> updataopen(List<Integer> numTable) {
		List<Integer>  retlist=new ArrayList<Integer>();		
		queryDao.updataopen(numTable);
		User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");//锟斤拷取锟斤拷前锟斤拷录锟矫伙拷	
		if(user!=null)
		{
			Long id=user.getId();
			List<User> userlist=userDao.findbyid(id);
			Long type2=userlist.get(0).getType();
			String type1=type2.toString();
			int type=Integer.parseInt(type1);
			List<Sample_detail> list=queryDao.personSample(id);
			List<Sample_detail> openlist=queryDao.personopen(id);
			int personnumber=list.size();
			int opennumber=openlist.size();
			PYusertype pytype=new PYusertype();
			int usertype=pytype.compare(type, personnumber, opennumber);
			retlist.add(usertype);
			retlist.add(personnumber);
			retlist.add(opennumber);
			if(usertype!=type)
			{
			userDao.updatetype(usertype,id);
	        userRoleDao.updatetype(usertype, id);			
			}
			else
				;
		}
		return retlist;
	
	}

	@Override
	public void changedata(List<String> rem,List<Integer> ag) {
		queryDao.changedata(rem,ag);
		
	}

	@Override
	public List<AnalyticalValue> pickav() {
		// TODO Auto-generated method stub
		return queryDao.pickav();
	}
	
	
}