package com.shrimpdb.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.shrimpdb.entity.AnalyticalValue;
import com.shrimpdb.entity.News;
import com.shrimpdb.entity.SampleMount;
import com.shrimpdb.entity.Sample_detail;
import com.shrimpdb.entity.User;
import com.shrimpdb.services.NewsService;
import com.shrimpdb.services.QueryService;
import com.shrimpdb.services.UploadService;
import com.shrimpdb.services.UserService;




@Controller
public class HomePageController {

	@Autowired
	UserService userService;
	@Autowired
	QueryService queryService;
	@Autowired
	UploadService uploadService;
	@Autowired
	NewsService newsService;
	
	/**
	 * 显示登录页面
	 * 
	 * @return "Login"
	 */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request) {
		if (SecurityUtils.getSubject().isAuthenticated()) {
			SecurityUtils.getSubject().logout();
		}
		return "login";
	}
	/**
	 * 用户登录
	 * 
	 * @param username
	 * @param request
	 * @param model
	 * @return login
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM) String username, HttpServletRequest request, Model model) {
		String error = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
		if (error != null) {
			model.addAttribute("error", "用户名或密码错误");
			return null;
		}		
		model.addAttribute("username", username);
		return "redirect:/home";  
	}
	/**
	 *用户登录
	 * 
	 * @param username
	 * @param request
	 * @param model
	 * @return login
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String welcome(Model model) {		
		List<News> newsList = newsService.NewsList();	
		model.addAttribute("newsList", newsList);
		List<Sample_detail> list=queryService.sampleresult();
		model.addAttribute("list", list);
		return "home";
	}
	@RequestMapping(value = "/processdata", method = RequestMethod.GET)
	public String dataprocess() {		
		List<AnalyticalValue> value=queryService.pickav();
		int count=value.size();
		List<AnalyticalValue> anvalue=new ArrayList<AnalyticalValue>(count);
		AnalyticalValue aaa=new AnalyticalValue();
		for(int i=0;i<count;i++)
		{
			String spotname=value.get(i).getSpotname();		
			long id=value.get(i).getId();
			aaa.setId(id);			
			if(spotname!= null)
			{			
			boolean ddd=spotname.contains("-");
			if(ddd==true)
			 {
				String[] a=spotname.split("-");	
			    aaa.setTestdate(a[0]);
			  }
			else
			{
				String a=spotname;
			    aaa.setTestdate(a);
			}
	}	
			
			else 
				{continue;}
			uploadService.insertremark(aaa);	
		}
		
		//model.addAttribute("newsList", newsList);
		//List<Sample_detail> list=queryService.sampleresult();
		//model.addAttribute("list", list);
		return "home";
	}
//进行前期数据背景信息与测试数据关联时，编写的程序，将analytical_value 里面spotname一项取出来，然后取出“-”线前的一部分，再存入数据库中。
	
	@RequestMapping(value = "/home", produces="text/plain;charset=UTF-8", method=RequestMethod.POST)	
	public @ResponseBody
	String querymap() {		
		List<Sample_detail> sampleresult=queryService.homeresult();
		StringBuffer jsonString = new StringBuffer();
		int len=sampleresult.size();		
	   for(int j=0;j<1;j++){
			jsonString.append("[");
		for(int i=0;i<len;i++){					
			//String lon=sampleresult.get(i).getLonDeg()+"."+sampleresult.get(i).getLonMin();//+sampleresult.get(i).getLonSec();//之前数据加上sec后不对
	    	double lon=sampleresult.get(i).getLonlat();
			//String lat=sampleresult.get(i).getLatDeg()+"."+sampleresult.get(i).getLatMin();//+sampleresult.get(i).getLatSec();    	
	        double lat=sampleresult.get(i).getLatitude();
	    	String code=sampleresult.get(i).getCode();	  
			jsonString.append("{");			
			jsonString.append("\"lng\":");
			jsonString.append(lon);			
	    	jsonString.append(",\"lat\":");
			jsonString.append(lat);
			jsonString.append(",\"sampleid\":");
			jsonString.append("\"");
			jsonString.append(code);
			jsonString.append("\"");
			jsonString.append(",\"lithologic\":");
			jsonString.append("\"");
			jsonString.append(sampleresult.get(i).getLithologic());
			jsonString.append("\"");
			jsonString.append(",\"position\":");
			jsonString.append("\"");
			jsonString.append(sampleresult.get(i).getPostion());
			jsonString.append("\"");	
			jsonString.append(",\"ssid\":");
			jsonString.append(sampleresult.get(i).getId().toString());
			jsonString.append("}");
		if(i<len-1)jsonString.append(",");
		}
		jsonString.append("]");	
	}	
		return jsonString.toString();
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(Model model) {
		// User user = (User)
		// SecurityUtils.getSubject().getSession().getAttribute("user");//��ȡ��ǰ��¼�û�
		return "test";
	}

	@RequestMapping(value ="/reg", method = RequestMethod.GET)
	public ModelAndView index(Model model) {
		ModelAndView modelAndView = new ModelAndView("reg");
		
	//	List<User> teacher=userService.getTeacherList();
		//model.addAttribute("teacher", teacher);
		
		User user = new User();
		modelAndView.addObject("user", user);
		return modelAndView;
	}

	 @RequestMapping(value = "/reg", method = RequestMethod.POST)
		public String reg(@Valid User user,BindingResult result,Model model,HttpServletRequest request) {
	        String i="0";
	        String j="8";
	    	user.setDel_flag(Long.parseLong(i));
	    	user.setPassword("e10adc3949ba59abbe56e057f20f883e");
	    	user.setRemarks("普通未确认用户");
	    	user.setType(Long.parseLong(j));
	    	Date date =new Date(); 	
	    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    	String number = df.format(date);    
	    	user.setCreate_date(number);
	    	MultipartHttpServletRequest multipartHttpservletRequest=(MultipartHttpServletRequest) request;
	       //第一篇论文
	    	MultipartFile file1 = multipartHttpservletRequest.getFile("paper1");
	        String fileName1=file1.getOriginalFilename();       
	       //第2篇论文
	        MultipartFile file2 = multipartHttpservletRequest.getFile("paper2");
	        String fileName2=file2.getOriginalFilename();
	        // 第3篇论文
	        MultipartFile file3 = multipartHttpservletRequest.getFile("paper3");
	        String fileName3=file3.getOriginalFilename();
	        //肖像
	        MultipartFile imag=multipartHttpservletRequest.getFile("imag");
	        String path = request.getSession().getServletContext().getRealPath("files");   
	      //String saveName1=path+"/"+fileName1;//Linux写法
	      //String saveName2=path+"/"+fileName2;//Linux写法
	      //String saveName3=path+"/"+fileName3;//Linux写法
	        //windows 写法，这样写以后json传数据时格式会有问题
	        //   String saveName1=path+"\\"+fileName1;
	        //   String saveName2=path+"\\"+fileName2;
	        //   String saveName3=path+"\\"+fileName3;
	        String saveName1=fileName1;
	        String saveName2=fileName2;
	        String saveName3=fileName3;
	        String imgName=imag.getOriginalFilename();
	        user.setImag(imgName);
	        user.setPapera(saveName1);
	        user.setPaperb(saveName2);
	        user.setPaperc(saveName3);
	        if (!file1.isEmpty()) {
	         uploadService.saveFile(file1, path);}
	        if (!file2.isEmpty()) {
	       	 uploadService.saveFile(file2, path);}
	        if (!file1.isEmpty()) {
	       	 uploadService.saveFile(file3, path);}
	        if (!imag.isEmpty()) {
	       	 uploadService.saveFile(imag, path);}       
	    	if(userService.checkLoginName(user.getUsername())){
	            	String loginname = "用户名已存在 ";
	            	model.addAttribute("loginname", loginname);           	
	            }
	            if(userService.checkEmail(user.getEmail())){
	            	String email = "该邮箱已注册 ";
	            	model.addAttribute("email", email);
	            	return null;
	            }
	            else{
	            	userService.insertData(user);
	            	User user1=userService.findByLoginName(user.getUsername());
	    		    userService.insertRole(user1);   
	  		        return "login";
	            }         
	       }	
	@RequestMapping(value = "/test",produces="text/plain;charset=UTF-8", method=RequestMethod.POST)
	public @ResponseBody
	String test() {		
		List<Sample_detail> sampleresult=queryService.sampleresult();
		StringBuffer jsonString = new StringBuffer();
		int len=sampleresult.size();		
		   for(int j=0;j<1;j++){
				jsonString.append("[");
			for(int i=0;i<len;i++){					
				double lon=sampleresult.get(i).getLonlat();//+sampleresult.get(i).getLonSec();//之前数据加上sec后不对
		    	double lat=sampleresult.get(i).getLatitude();//+sampleresult.get(i).getLatSec();    	
		        String code=sampleresult.get(i).getCode();
		        String testdate=sampleresult.get(i).getOperate_time();
		    //	String lon=sampleresult.get(i).getLonEW();
			//	String lat=sampleresult.get(i).getLatNS();
		        jsonString.append("{");	
			    jsonString.append("\"code\":");
				jsonString.append("\"");
				jsonString.append(code);
				jsonString.append("\"");			    
				jsonString.append(",\"lithologic\":");
				jsonString.append("\"");
				jsonString.append(sampleresult.get(i).getLithologic());
				jsonString.append("\"");
				jsonString.append(",\"position\":");
				jsonString.append("\"");
				jsonString.append(sampleresult.get(i).getPostion());
				jsonString.append("\"");	
			    jsonString.append(",\"lng\":");
			    jsonString.append(lon);			
			    jsonString.append(",\"lat\":");
			    jsonString.append(lat);
				jsonString.append(",\"testdate\":");
				jsonString.append("\"");
				jsonString.append(testdate);
				jsonString.append("\"");			    
				jsonString.append(",\"ssid\":");
				jsonString.append(sampleresult.get(i).getId().toString());
				jsonString.append("}");
			if(i<len-1)jsonString.append(",");
			}
			jsonString.append("]");	
		}	
		return jsonString.toString();
	}
	//将存好的数据关联一下
	
	
}