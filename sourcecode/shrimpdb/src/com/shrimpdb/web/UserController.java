package com.shrimpdb.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shrimpdb.entity.User;
import com.shrimpdb.entity.AnalyticalValue;
import com.shrimpdb.entity.Project;
import com.shrimpdb.entity.Sample_detail;
import com.shrimpdb.entity.Uploadcontents;
import com.shrimpdb.services.UploadService;
import com.shrimpdb.services.UserService;
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	@RequiresPermissions("sys:user:list")
	@RequestMapping(value = "/userlist", method = RequestMethod.GET)
	public ModelAndView openlist(Model model) {
		ModelAndView modelAndView = new ModelAndView("user/userlist");	
		return modelAndView;
	}
	@RequiresPermissions("sys:user:add")
	@RequestMapping(value = "/adduser", method = RequestMethod.GET)
	public ModelAndView adduser(Model model) {
		User user=new User();
		ModelAndView modelAndView = new ModelAndView("user/adduser");
		modelAndView.addObject("user", user);		
		return modelAndView;
	}
	@RequiresPermissions("sys:user:add")
	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public String adduserpost(@Valid User user,Model model) {
		Date date =new Date(); 
		 String i="0";
		 user.setDel_flag(Long.parseLong(i));
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String number = df.format(date);    
    	user.setCreate_date(number);
    	String name=user.getUsername();
    	if(userService.checkLoginName(name)){
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
        	User user1=userService.findByLoginName(name);
		    userService.insertRole(user1);   
		        return "login";
        }  
	}
	@RequestMapping(value="/userlist", produces="text/plain;charset=UTF-8")
	public @ResponseBody String userlist(User user) {	
		User curruser = (User) SecurityUtils.getSubject().getSession().getAttribute("user");//鑾峰彇褰撳墠鐧诲綍鐢ㄦ埛
		if(curruser.getType().equals("4")){			
		}
		String jsonString =userService.jsonString(user);
		return jsonString;
	    }
	@RequestMapping(value = "/qualified",produces="text/plain;charset=UTF-8", method=RequestMethod.POST)
	public @ResponseBody
	String qualified(@Valid String id) {
	String result=userService.UpdateRole(id); 	
		  StringBuffer jsonString = new StringBuffer();
		  jsonString.append("{");	
		  jsonString.append(",\"flag\":");
			jsonString.append("\"");
			jsonString.append(result);
			jsonString.append("\"");
		    jsonString.append(",\"msg\":");
			jsonString.append("\"");
			jsonString.append("success");
			jsonString.append("\"");
			jsonString.append("}");
			return jsonString.toString();}	
}
