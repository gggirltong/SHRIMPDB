package com.shrimpdb.web;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shrimpdb.entity.User;
import com.shrimpdb.entity.AnalyticalValue;
import com.shrimpdb.entity.Project;
import com.shrimpdb.entity.Sample_detail;
import com.shrimpdb.entity.Uploadcontents;
import com.shrimpdb.services.UploadService;

@Controller
@RequestMapping("/upload")
public class UploadController {
	@Autowired
	UploadService uploadService;
	//锟斤拷锟斤拷预约锟斤拷锟矫�
	
	@RequestMapping(value ="/metauploadbook", method = RequestMethod.GET)
	public ModelAndView cmetaloadaccu(Model model) {
		ModelAndView modelAndView = new ModelAndView("upload/metauploadbook");		
		Uploadcontents uploadcontents=new Uploadcontents();			
		modelAndView.addObject("uploadcontents", uploadcontents);  		
		return modelAndView;
	}
	//锟矫伙拷锟斤拷锟斤拷预约锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟轿�
	@RequestMapping(value = "/metauploadbook", method = RequestMethod.POST)
	public String insertdetailaccu(Uploadcontents uploadcontents,BindingResult result,RedirectAttributes redirectAttrs) {			
		Date date =new Date();
		Long dataid=(long) 0;
		Long testid=(long) 1;
		User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");//锟斤拷取锟斤拷前锟斤拷录锟矫伙拷
		Long userid=user.getId();
		uploadcontents.setUserid(userid);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String number = df.format(date);
    	uploadcontents.setOperate_time(number);
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssSSS");
    	String number2 = sdf.format(date);
    	uploadcontents.setSystemid(number2);  
    	uploadcontents.setMain(number2);
    	uploadcontents.setDataid(dataid);
    	uploadcontents.setTestid(testid);
    	// gps锟斤拷锟斤拷锟劫度撅拷纬锟斤拷锟斤拷锟阶拷锟�
    	String deg=uploadcontents.getLonDeg();
    	String min=uploadcontents.getLonMin();
    	String sec=uploadcontents.getLonSec();
    	double longetitude=(Double.parseDouble(deg))+(Double.parseDouble(min))/60+(Double.parseDouble(sec))/3600;
    	uploadcontents.setLonlat(longetitude);
    	String ldeg=uploadcontents.getLatDeg();
    	String lmin=uploadcontents.getLatMin();
    	String lsec=uploadcontents.getLatSec();
    	double latitude=(Double.parseDouble(ldeg))+(Double.parseDouble(lmin))/60+(Double.parseDouble(lsec))/3600;
    	uploadcontents.setLatitude(latitude);
		uploadService.insertProject(uploadcontents);
		uploadService.insertData(uploadcontents);			
    	return "redirect:/query/book";            
       }
	
	
	//锟斤拷锟斤拷预约锟斤拷锟矫�
		@RequestMapping(value ="/metaupload", method = RequestMethod.GET)
		public ModelAndView cmetaload(Model model) {
			ModelAndView modelAndView = new ModelAndView("upload/metaupload");		
			Uploadcontents uploadcontents=new Uploadcontents();			
			modelAndView.addObject("uploadcontents", uploadcontents);  		
			return modelAndView;
		}
		//锟矫伙拷锟斤拷锟斤拷预约锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟轿�
		@RequestMapping(value = "/metaupload", method = RequestMethod.POST)
		public String insertdetail(Uploadcontents uploadcontents,BindingResult result,RedirectAttributes redirectAttrs) {			
			Date date =new Date();
			Long dataid=(long) 1;
			Long testid=(long) 0;
			User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");//锟斤拷取锟斤拷前锟斤拷录锟矫伙拷
			Long userid=user.getId();
			uploadcontents.setUserid(userid);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    	String number = df.format(date);
	    	uploadcontents.setOperate_time(number);
	    	
	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssSSS");
	    	String number2 = sdf.format(date);
	    	uploadcontents.setSystemid(number2);  
	    	uploadcontents.setMain(number2);
	    	uploadcontents.setDataid(dataid);
	    	uploadcontents.setTestid(testid);
	    	// gps锟斤拷锟斤拷锟劫度撅拷纬锟斤拷锟斤拷锟阶拷锟�
	    	String deg=uploadcontents.getLonDeg();
	    	String min=uploadcontents.getLonMin();
	    	String sec=uploadcontents.getLonSec();
	    	double longetitude=(Double.parseDouble(deg))+(Double.parseDouble(min))/60+(Double.parseDouble(sec))/3600;
	    	uploadcontents.setLonlat(longetitude);
	    	String ldeg=uploadcontents.getLatDeg();
	    	String lmin=uploadcontents.getLatMin();
	    	String lsec=uploadcontents.getLatSec();
	    	double latitude=(Double.parseDouble(ldeg))+(Double.parseDouble(lmin))/60+(Double.parseDouble(lsec))/3600;
	    	uploadcontents.setLatitude(latitude);
			uploadService.insertProject(uploadcontents);
			uploadService.insertData(uploadcontents);			
	    	return "redirect:/upload/valueupload?number="+number2;            
	       }
	@RequestMapping(value = "/testresult", method = RequestMethod.GET)
	public ModelAndView insertresult(Model model, HttpServletRequest request) {				
		String number = request.getParameter("number");
		ModelAndView modelAndView = new ModelAndView("upload/testresult");		
		Project project=uploadService.selectProject(number);	
	    Sample_detail sample_detail=uploadService.selectsampledetail(number); 
		modelAndView.addObject("project", project);  
		modelAndView.addObject("sample_detail", sample_detail);  
		Uploadcontents uploadcontents=new Uploadcontents();			
		AnalyticalValue testvalue=new AnalyticalValue();
		modelAndView.addObject("testvalue", testvalue); 
		modelAndView.addObject("uploadcontents", uploadcontents); 
		return modelAndView;     
       }
	
	@RequestMapping(value = "/valueupload", method = RequestMethod.GET)
	public ModelAndView valueupload(Model model, HttpServletRequest request) {				
		String number = request.getParameter("number");
		ModelAndView modelAndView = new ModelAndView("upload/valueupload");		
		Project project=uploadService.selectProject(number);	
	    Sample_detail sample_detail=uploadService.selectsampledetail(number); 
		modelAndView.addObject("project", project);  
		modelAndView.addObject("sample_detail", sample_detail);  
		Uploadcontents uploadcontents=new Uploadcontents();			
		AnalyticalValue testvalue=new AnalyticalValue();
		modelAndView.addObject("testvalue", testvalue); 
		modelAndView.addObject("uploadcontents", uploadcontents); 
		return modelAndView;     
       }
	
	/*@RequestMapping(value = "/uploadfiles", method = RequestMethod.POST)
	public ModelAndView uploadfiles(Model model, HttpServletRequest request) throws IOException 
	{
		MultipartHttpServletRequest multipartHttpservletRequest=(MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartHttpservletRequest.getFile("input44[]");		     
        InputStream multipartFile2 = multipartHttpservletRequest.getFile("input44[]").getInputStream();	    
		return null;		
	}*/
	@RequestMapping(value ="/uploadfiles")	
	public @ResponseBody
	 String uploadfiles(HttpServletRequest request,HttpServletResponse response) {		
        MultipartHttpServletRequest multipartHttpservletRequest=(MultipartHttpServletRequest) request;
        MultipartFile file = multipartHttpservletRequest.getFile("kartik-input-700[]");
        String id=request.getParameter("sampleid");
        StringBuffer jsonString = new StringBuffer();
        String path = request.getSession().getServletContext().getRealPath("files");
      
       String fileName = file.getOriginalFilename();
        if (!file.isEmpty()) {
        	 uploadService.saveFile(file, path);
             jsonString.append("{");	
         	 jsonString.append("}");
        if (!fileName.isEmpty()) {
        	String saveName=path+"\\"+fileName;//windows下与linux下路径不一样，此路经为weindows写法
        	//String saveName=path+"/"+fileName;//Linux写法
         	 uploadService.CreateTestvalue(saveName,id);
    		}
		}
        return jsonString.toString();        
    }	   
	@RequestMapping(value = "/insertaccu", method = RequestMethod.GET)
	public ModelAndView insertaccu(Model model, HttpServletRequest request) {				
		ModelAndView modelAndView = new ModelAndView("upload/insertaccu");			
		Uploadcontents uploadcontents=new Uploadcontents();			
		AnalyticalValue testvalue=new AnalyticalValue();
		modelAndView.addObject("testvalue", testvalue); 
		modelAndView.addObject("uploadcontents", uploadcontents); 
		return modelAndView;     
       }
	@RequestMapping(value ="/uploadaccu")	
	public @ResponseBody
	    String uploadaccu(HttpServletRequest request,HttpServletResponse response) {		
        MultipartHttpServletRequest multipartHttpservletRequest=(MultipartHttpServletRequest) request;
        MultipartFile file = multipartHttpservletRequest.getFile("kartik-input-700[]");
        String id=request.getParameter("mountname");
        StringBuffer jsonString = new StringBuffer();
        String path = request.getSession().getServletContext().getRealPath("files");   
        String fileName = file.getOriginalFilename();
        if (!file.isEmpty()) {
        	 uploadService.saveFile(file, path);
             jsonString.append("{");	
         	 jsonString.append("}");
        if (!fileName.isEmpty()) {
        	String saveName=path+"\\"+fileName;
         	 uploadService.insertaccu(saveName,id);
    		}
		}
        return jsonString.toString();        
    }	  
	
	@RequestMapping(value ="/processfile", method = RequestMethod.GET)
	public ModelAndView processfile(Model model) {
		ModelAndView modelAndView = new ModelAndView("upload/processfile");		
 		
		return modelAndView;
	}	
	
	@RequestMapping(value ="/uploadprocess", method = RequestMethod.POST)	
	public @ResponseBody
	    String uploadprocess(HttpServletRequest request,HttpServletResponse response) {				
		MultipartHttpServletRequest multipartHttpservletRequest=(MultipartHttpServletRequest) request;
        MultipartFile file = multipartHttpservletRequest.getFile("paper1");    
        StringBuffer jsonString = new StringBuffer();
        String path = request.getSession().getServletContext().getRealPath("files");   
        String fileName = file.getOriginalFilename();
        if (!file.isEmpty()) {
        	 uploadService.saveFile(file, path);
             jsonString.append("{");	
         	 jsonString.append("}");
        if (!fileName.isEmpty()) {      
        	File fileexcel=new File(path+"\\"+fileName);
         	 uploadService.readExcel(fileexcel);
    		}
		}
        return jsonString.toString();        
    }	 
	
}