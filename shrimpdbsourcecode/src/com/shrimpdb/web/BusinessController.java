package com.shrimpdb.web;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import com.shrimpdb.entity.Mount;
import com.shrimpdb.entity.SampleMount;
import com.shrimpdb.entity.Sample_detail;
import com.shrimpdb.entity.User;
import com.shrimpdb.services.BusinessService;
import com.shrimpdb.services.UploadService;
@Controller
@RequestMapping("/business")
public class BusinessController{
	@Autowired
	BusinessService businessService;

	@RequiresPermissions("sys:mount:add")
	@RequestMapping(value = "/mount", method = RequestMethod.GET)
	public ModelAndView mount(Model model) {
		ModelAndView modelAndView = new ModelAndView("business/mount");	
		SampleMount addmount= new SampleMount();
		modelAndView.addObject("addmount", addmount);
		return modelAndView;	
	}
	@RequiresPermissions("sys:mount:add")
	@RequestMapping(value = "/mountlist",produces="text/plain;charset=UTF-8", method=RequestMethod.POST)
	public @ResponseBody
	String mountlist() {	
		List<Mount> sampleresult =businessService.mountSample();		
		StringBuffer jsonString = new StringBuffer();
		int len=sampleresult.size();		
	   for(int j=0;j<1;j++){
			jsonString.append("[");
		for(int i=0;i<len;i++){					
			//String lon=sampleresult.get(i).getLonDeg()+"."+sampleresult.get(i).getLonMin();//+sampleresult.get(i).getLonSec();//之前数据加上sec后不对
	        String code=sampleresult.get(i).getCode();        
			jsonString.append("{");			
    		jsonString.append("\"id\":");
			jsonString.append(i+1);	
			jsonString.append(",\"ssid\":");
			jsonString.append(sampleresult.get(i).getId().toString());	
	    	jsonString.append(",\"code\":");
	    	jsonString.append("\"");
			jsonString.append(code);
			jsonString.append("\"");
			jsonString.append(",\"name\":");
			jsonString.append("\"");
			jsonString.append(sampleresult.get(i).getName());
			jsonString.append("\"");
			jsonString.append(",\"unit\":");
			jsonString.append("\"");
			jsonString.append(sampleresult.get(i).getUnit());
			jsonString.append("\"");		
			jsonString.append(",\"phone\":");
			jsonString.append("\"");
			jsonString.append(sampleresult.get(i).getPhone());
			jsonString.append("\"");
			jsonString.append(",\"createdate\":");
			jsonString.append("\"");
			jsonString.append(sampleresult.get(i).getCreatedate());
			jsonString.append("\"");
			jsonString.append("}");
		if(i<len-1)jsonString.append(",");
		}
		jsonString.append("]");	
	}	
		return jsonString.toString();
	}
	//显示完成的样品的状态
	@RequiresPermissions("sys:mount:add")
	@RequestMapping(value = "/examplejson",produces="text/plain;charset=UTF-8", method=RequestMethod.POST)
	public @ResponseBody
	String examplejson() {	
		List<SampleMount> sampleresult =businessService.examplejson();		
		StringBuffer jsonString = new StringBuffer();
		int len=sampleresult.size();		
		 for(int j=0;j<1;j++){
				jsonString.append("[");
			for(int i=0;i<len;i++){					
				//String lon=sampleresult.get(i).getLonDeg()+"."+sampleresult.get(i).getLonMin();//+sampleresult.get(i).getLonSec();//之前数据加上sec后不对             
				jsonString.append("{");			
	    		jsonString.append("\"id\":");
				jsonString.append(i+1);	
				jsonString.append(",\"mountid\":");
				jsonString.append(sampleresult.get(i).getId());			
				jsonString.append(",\"code\":");
				jsonString.append("\"");
				jsonString.append(sampleresult.get(i).getRemarkf());	
				jsonString.append("\"");	
				jsonString.append(",\"mountname\":");
				jsonString.append("\"");
				jsonString.append(sampleresult.get(i).getMountname());	
				jsonString.append("\"");
		        jsonString.append(",\"sampledate\":");
		  	    jsonString.append("\"");
			    jsonString.append(sampleresult.get(i).getRemarke());
			    jsonString.append("\"");
				jsonString.append(",\"makedate\":");
				jsonString.append("\"");
				jsonString.append(sampleresult.get(i).getMakedate());
				jsonString.append("\"");
				jsonString.append(",\"finishdate\":");
				jsonString.append("\"");
				jsonString.append(sampleresult.get(i).getRemarkc());
				jsonString.append("\"");			
				jsonString.append(",\"dataid\":");
				jsonString.append("\"");
				jsonString.append(sampleresult.get(i).getRemarkd());
				jsonString.append("\"");
				jsonString.append(",\"processdate\":");
				jsonString.append("\"");
				jsonString.append(sampleresult.get(i).getProcessdate());
				jsonString.append("\"");						
				jsonString.append("}");
			if(i<len-1)jsonString.append(",");
			}
			jsonString.append("]");	
		}	
			return jsonString.toString();
	}
	
	
	@RequestMapping(value = "/addmount", method = RequestMethod.POST)
	public String addmount(@Valid SampleMount addmount,BindingResult result,Model model,HttpServletRequest request) {
	    Long flag=(long) 0;
	    addmount.setFlag(flag);	   
		Date date =new Date(); 	
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String number = df.format(date);
    	addmount.setMakedate(number);
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
    	String sysnumber = sdf.format(date);
        addmount.setRemarka(sysnumber);
    	User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");//锟斤拷取锟斤拷前锟斤拷录锟矫伙拷
		Long userid=user.getId();
		addmount.setMakeid(userid);
    	MultipartHttpServletRequest multipartHttpservletRequest=(MultipartHttpServletRequest) request;	       
    	MultipartFile file = multipartHttpservletRequest.getFile("paper1");
    	String path = request.getSession().getServletContext().getRealPath("files");   
    	businessService.saveFile(file, path);
    	String fileName1=file.getOriginalFilename();       
        //String saveName1=path+"/"+fileName1;//Linux写法
       // String saveName1=path+"\\"+fileName1;
        addmount.setMountimg_url(fileName1);
        businessService.insertData(addmount); 	
        String sampleid=request.getParameter("pName1");
  	  String[] arr=sampleid.split(",");
  	
        businessService.updateflag(arr,sysnumber);
		 return "redirect:/business/mount";
	
	}
	@RequiresPermissions("sys:test:add")
	@RequestMapping(value = "/measurement",produces="text/plain;charset=UTF-8", method=RequestMethod.POST)
	public @ResponseBody
	String measurement() {	
		List<SampleMount> sampleresult =businessService.measurement();		
		StringBuffer jsonString = new StringBuffer();
		int len=sampleresult.size();		
	   for(int j=0;j<1;j++){
			jsonString.append("[");
		for(int i=0;i<len;i++){					
			//String lon=sampleresult.get(i).getLonDeg()+"."+sampleresult.get(i).getLonMin();//+sampleresult.get(i).getLonSec();//之前数据加上sec后不对             
			jsonString.append("{");			
    		jsonString.append("\"id\":");
			jsonString.append(i+1);	
			jsonString.append(",\"mountid\":");
			jsonString.append(sampleresult.get(i).getId());			
			jsonString.append(",\"systemid\":");
			jsonString.append("\"");
			jsonString.append(sampleresult.get(i).getRemarka());	
			jsonString.append("\"");	
			jsonString.append(",\"mountname\":");
			jsonString.append("\"");
			jsonString.append(sampleresult.get(i).getMountname());	
			jsonString.append("\"");
	        jsonString.append(",\"mountimg\":");
	  	    jsonString.append("\"");
		    jsonString.append(sampleresult.get(i).getMountimg_url());
		    jsonString.append("\"");
			jsonString.append(",\"mountuser\":");
			jsonString.append("\"");
			jsonString.append(sampleresult.get(i).getMakename());
			jsonString.append("\"");
			jsonString.append(",\"mountdate\":");
			jsonString.append("\"");
			jsonString.append(sampleresult.get(i).getMakedate());
			jsonString.append("\"");		
			
			jsonString.append("}");
		if(i<len-1)jsonString.append(",");
		}
		jsonString.append("]");	
	}	
		return jsonString.toString();
	}
	
	
	
	
	@RequiresPermissions("sys:test:add")
	@RequestMapping(value = "/measurement", method = RequestMethod.GET)
	public ModelAndView measurement(Model model) {
		ModelAndView modelAndView = new ModelAndView("business/measurement");	
		
	SampleMount measurement= new SampleMount();
	modelAndView.addObject("measurement",measurement);
		return modelAndView;
	
	}
	
	
	
	
	
	
	
	//测试人员的测试页面用来显示样品和靶之间的关系
	@RequiresPermissions("sys:test:add")
	@RequestMapping(value = "/samplemount",produces="text/plain;charset=UTF-8", method=RequestMethod.POST)
	public @ResponseBody
	String samplemount() {	
		List<Sample_detail> sampleresult =businessService.samplemount();		
		StringBuffer jsonString = new StringBuffer();
		int len=sampleresult.size();		
	   for(int j=0;j<1;j++){
			jsonString.append("[");
		for(int i=0;i<len;i++){					
			//String lon=sampleresult.get(i).getLonDeg()+"."+sampleresult.get(i).getLonMin();//+sampleresult.get(i).getLonSec();//之前数据加上sec后不对             
			jsonString.append("{");			
    		jsonString.append("\"id\":");
			jsonString.append(i+1);	
			
			jsonString.append(",\"code\":");
			jsonString.append("\"");
			jsonString.append(sampleresult.get(i).getCode());	
			jsonString.append("\"");	
			jsonString.append(",\"mountname\":");
			jsonString.append("\"");
			jsonString.append(sampleresult.get(i).getLast_operate_time());	
			jsonString.append("\"");
	        jsonString.append(",\"username\":");
	  	    jsonString.append("\"");
		    jsonString.append(sampleresult.get(i).getLonMin());
		    jsonString.append("\"");
			jsonString.append(",\"department\":");
			jsonString.append("\"");
			jsonString.append(sampleresult.get(i).getLonSec());
			jsonString.append("\"");
			jsonString.append(",\"unit\":");
			jsonString.append("\"");
			jsonString.append(sampleresult.get(i).getLatDeg());
			jsonString.append("\"");
			jsonString.append(",\"datid\":");
			jsonString.append(sampleresult.get(i).getDataid());	
			
			jsonString.append("}");
		if(i<len-1)jsonString.append(",");
		}
		jsonString.append("]");	
	}	
		return jsonString.toString();
	}
	
	//测试人员点击样品靶测试以后改变样品靶表 标志状态及样品靶表测试状态
	@RequestMapping(value = "/changemount", method = RequestMethod.POST)
	public String changemount(@Valid SampleMount measurement,BindingResult result,Model model,HttpServletRequest request) {
	    Long flag=(long) 1;
	    measurement.setFlag(flag);	   
		Date date =new Date(); 	
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String number = df.format(date);
    	measurement.setTestdate(number);
    
    	User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");//锟斤拷取锟斤拷前锟斤拷录锟矫伙拷
		Long userid=user.getId();
		measurement.setTestid(userid);
		String mountid=request.getParameter("namemm");
		String systemnumber=request.getParameter("namess");
		String[] mountidarr=mountid.split(",");
		String[] systemnumberdarr=systemnumber.split(",");
		 	
		businessService.UpdateMount(measurement,mountidarr); 	  
        businessService.updatetestflag(systemnumberdarr);
		 return "redirect:/business/measurement";
	
	}
	
	@RequiresPermissions("sys:test:view")
	@RequestMapping(value = "/testlist", method = RequestMethod.GET)
	public ModelAndView testlist(Model model) {
		ModelAndView modelAndView = new ModelAndView("business/testlist");	 		
    	SampleMount testlist= new SampleMount();
    	modelAndView.addObject("testlist",testlist);
		return modelAndView;	
	}
	@RequiresPermissions("sys:test:view")
	@RequestMapping(value = "/testlist",produces="text/plain;charset=UTF-8", method=RequestMethod.POST)
	public @ResponseBody
	String testlist() {	
		List<SampleMount> sampleresult =businessService.testlist();		
		StringBuffer jsonString = new StringBuffer();
		int len=sampleresult.size();		
	   for(int j=0;j<1;j++){
			jsonString.append("[");
		for(int i=0;i<len;i++){					
			//String lon=sampleresult.get(i).getLonDeg()+"."+sampleresult.get(i).getLonMin();//+sampleresult.get(i).getLonSec();//之前数据加上sec后不对             
			jsonString.append("{");			
    		jsonString.append("\"id\":");
			jsonString.append(i+1);	
			jsonString.append(",\"mountid\":");
			jsonString.append(sampleresult.get(i).getId());			
			jsonString.append(",\"systemid\":");
			jsonString.append("\"");
			jsonString.append(sampleresult.get(i).getRemarka());	
			jsonString.append("\"");	
			jsonString.append(",\"mountname\":");
			jsonString.append("\"");
			jsonString.append(sampleresult.get(i).getMountname());	
			jsonString.append("\"");
	        jsonString.append(",\"testdate\":");
	  	    jsonString.append("\"");
		    jsonString.append(sampleresult.get(i).getTestdate());
		    jsonString.append("\"");
			jsonString.append(",\"op\":");
			jsonString.append("\"");
			jsonString.append(sampleresult.get(i).getOpfile());
			jsonString.append("\"");
			jsonString.append(",\"finishdate\":");
			jsonString.append("\"");
			jsonString.append(sampleresult.get(i).getRemarkc());
			jsonString.append("\"");			
			jsonString.append(",\"process\":");
			jsonString.append("\"");
			jsonString.append(sampleresult.get(i).getRemarkb());
			jsonString.append("\"");
			jsonString.append(",\"mountdate\":");
			jsonString.append("\"");
			jsonString.append(sampleresult.get(i).getMakedate());
			jsonString.append("\"");		
			
			jsonString.append("}");
		if(i<len-1)jsonString.append(",");
		}
		jsonString.append("]");	
	}	
		return jsonString.toString();
	}
	@RequestMapping(value = "/uploadprocess", method = RequestMethod.POST)
	public String uploadprocess(@Valid SampleMount addmount,BindingResult result,Model model,HttpServletRequest request) {
	    Long flag=(long) 3;
	    addmount.setFlag(flag);	   
		Date date =new Date(); 	
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String number = df.format(date);
    	addmount.setProcessdate(number);
    	MultipartHttpServletRequest multipartHttpservletRequest=(MultipartHttpServletRequest) request;	       
    	MultipartFile file = multipartHttpservletRequest.getFile("paper1");
    	String path = request.getSession().getServletContext().getRealPath("files");   
    	businessService.saveFile(file, path);
    	String fileName1=file.getOriginalFilename();       
      //String saveName1=path+"/"+fileName1;//Linux写法
     // String saveName1=path+"\\"+fileName1;
        addmount.setOpfile(fileName1);
        String mountid=request.getParameter("namemm");
		String systemnumber=request.getParameter("namess");
		String[] mountidarr=mountid.split(",");
		String[] systemnumberdarr=systemnumber.split(",");		 	
		businessService.UpdateProcess(addmount,mountidarr); 	  
        businessService.updatedetailprocess(systemnumberdarr);
		 return "redirect:/business/testlist";
	
	}
	@RequiresPermissions("sys:process:view")
	@RequestMapping(value = "/processlist", method = RequestMethod.GET)
	public ModelAndView processlist(Model model) {
		ModelAndView modelAndView = new ModelAndView("business/processlist");	 		
    	SampleMount processlist= new SampleMount();
    	modelAndView.addObject("processlist",processlist);
		return modelAndView;	
	}
	
	@RequiresPermissions("sys:process:view")
	@RequestMapping(value = "/processlist",produces="text/plain;charset=UTF-8", method=RequestMethod.POST)
	public @ResponseBody
	String processlist() {	
		List<SampleMount> sampleresult =businessService.processlist();		
		StringBuffer jsonString = new StringBuffer();
		int len=sampleresult.size();		
	   for(int j=0;j<1;j++){
			jsonString.append("[");
		for(int i=0;i<len;i++){					
			//String lon=sampleresult.get(i).getLonDeg()+"."+sampleresult.get(i).getLonMin();//+sampleresult.get(i).getLonSec();//之前数据加上sec后不对             
			jsonString.append("{");			
    		jsonString.append("\"id\":");
			jsonString.append(i+1);	
			jsonString.append(",\"mountid\":");
			jsonString.append(sampleresult.get(i).getId());			
			jsonString.append(",\"systemid\":");
			jsonString.append("\"");
			jsonString.append(sampleresult.get(i).getRemarka());	
			jsonString.append("\"");	
			jsonString.append(",\"mountname\":");
			jsonString.append("\"");
			jsonString.append(sampleresult.get(i).getMountname());	
			jsonString.append("\"");
	        jsonString.append(",\"testdate\":");
	  	    jsonString.append("\"");
		    jsonString.append(sampleresult.get(i).getTestdate());
		    jsonString.append("\"");
			jsonString.append(",\"op\":");
			jsonString.append("\"");
			jsonString.append(sampleresult.get(i).getOpfile());
			jsonString.append("\"");
			jsonString.append(",\"finishdate\":");
			jsonString.append("\"");
			jsonString.append(sampleresult.get(i).getRemarkc());
			jsonString.append("\"");			
			jsonString.append(",\"process\":");
			jsonString.append("\"");
			jsonString.append(sampleresult.get(i).getRemarkb());
			jsonString.append("\"");
			jsonString.append(",\"processdate\":");
			jsonString.append("\"");
			jsonString.append(sampleresult.get(i).getProcessdate());
			jsonString.append("\"");		
			
			jsonString.append("}");
		if(i<len-1)jsonString.append(",");
		}
		jsonString.append("]");	
	}	
		return jsonString.toString();
	}
	
	
	
	
	@RequestMapping(value = "/resultlist",produces="text/plain;charset=UTF-8", method=RequestMethod.POST)
	public @ResponseBody
	String resultlist() {
		User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");//锟斤拷取锟斤拷前锟斤拷录锟矫伙拷
		Long userid=user.getId();
		List<SampleMount> sampleresult =businessService.resultlist(userid);		
		StringBuffer jsonString = new StringBuffer();
		int len=sampleresult.size();		
		 for(int j=0;j<1;j++){
				jsonString.append("[");
			for(int i=0;i<len;i++){					
				//String lon=sampleresult.get(i).getLonDeg()+"."+sampleresult.get(i).getLonMin();//+sampleresult.get(i).getLonSec();//之前数据加上sec后不对             
				jsonString.append("{");			
	    		jsonString.append("\"id\":");
				jsonString.append(i+1);	
				jsonString.append(",\"mountid\":");
				jsonString.append(sampleresult.get(i).getId());			
				jsonString.append(",\"code\":");
				jsonString.append("\"");
				jsonString.append(sampleresult.get(i).getRemarkf());	
				jsonString.append("\"");	
				jsonString.append(",\"mountname\":");
				jsonString.append("\"");
				jsonString.append(sampleresult.get(i).getMountname());	
				jsonString.append("\"");
		        jsonString.append(",\"testdate\":");
		  	    jsonString.append("\"");
			    jsonString.append(sampleresult.get(i).getTestdate());
			    jsonString.append("\"");
				jsonString.append(",\"op\":");
				jsonString.append("\"");
				jsonString.append(sampleresult.get(i).getOpfile());
				jsonString.append("\"");
				jsonString.append(",\"finishdate\":");
				jsonString.append("\"");
				jsonString.append(sampleresult.get(i).getRemarkc());
				jsonString.append("\"");			
				jsonString.append(",\"process\":");
				jsonString.append("\"");
				jsonString.append(sampleresult.get(i).getRemarkb());
				jsonString.append("\"");
				jsonString.append(",\"processdate\":");
				jsonString.append("\"");
				jsonString.append(sampleresult.get(i).getProcessdate());
				jsonString.append("\"");		
				
				jsonString.append("}");
			if(i<len-1)jsonString.append(",");
			}
			jsonString.append("]");	
		}	
			return jsonString.toString();
	}
	
	}