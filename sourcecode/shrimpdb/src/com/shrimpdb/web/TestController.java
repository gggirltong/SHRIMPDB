package com.shrimpdb.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shrimpdb.entity.QueryResult;
import com.shrimpdb.entity.Sample_detail;
import com.shrimpdb.services.QueryService;



@Controller
@RequestMapping("/Test")
public class TestController {

	@Autowired
	QueryService queryService;	
	@RequestMapping(value = "/testTable", method = RequestMethod.GET)
	public ModelAndView testTable(Model model) {
		ModelAndView modelAndView = new ModelAndView("Test/testTable");	
	
		return modelAndView;
	}
	
	@RequestMapping(value = "/testmaptools", method = RequestMethod.GET)
	public ModelAndView testmaptools(Model model) {
		ModelAndView modelAndView = new ModelAndView("Test/testmaptools");	
	
		return modelAndView;
	}
	
	@RequestMapping(value = "/testbutton", method = RequestMethod.GET)
	public ModelAndView testbutton(Model model) {
		ModelAndView modelAndView = new ModelAndView("Test/testbutton");	
	
		return modelAndView;
	}
	
	@RequestMapping(value = "/changedata", method = RequestMethod.GET)
	public void changedata(Model model) {
		List<Sample_detail> sampleresult=queryService.homeresult();
		List<String> rem=new ArrayList<String>();
		List<Integer> ag=new ArrayList<Integer>();
		int count=sampleresult.size();		
		for(int i=0;i<count;i++)
		{		
			Long id=sampleresult.get(i).getId();
			String ids=id.toString();
			int sampid=Integer.parseInt(ids);
			String title="样品id";
			String remark=title+ids;
			rem.add(i, remark);
			ag.add(i, sampid);			
			queryService.changedata(rem,ag);
			
			
		}
	
		
	}
	@RequestMapping(value = "/testnewbutton", method = RequestMethod.GET)
	public ModelAndView testnewbutton(Model model) {
		ModelAndView modelAndView = new ModelAndView("Test/testnewbutton");	
	
		return modelAndView;
	}
	@RequestMapping(value = "/testTable",produces="text/plain;charset=UTF-8", method=RequestMethod.POST)
	
	public @ResponseBody
	String testTable() {		
		List<Sample_detail> sampleresult=queryService.sampleresult();
		StringBuffer jsonString = new StringBuffer();
		int len=sampleresult.size();		
		   for(int j=0;j<1;j++){
				jsonString.append("[");
			for(int i=0;i<len;i++){					
				String lon=sampleresult.get(i).getLonDeg()+"."+sampleresult.get(i).getLonMin();//+sampleresult.get(i).getLonSec();//之前数据加上sec后不对
		    	String lat=sampleresult.get(i).getLatDeg()+"."+sampleresult.get(i).getLatMin();//+sampleresult.get(i).getLatSec();    	
		        String code=sampleresult.get(i).getCode();
		    //	String lon=sampleresult.get(i).getLonEW();
			//	String lat=sampleresult.get(i).getLatNS();
				jsonString.append("{");					
				jsonString.append("\"lng\":");
				jsonString.append(lon.toString());			
		    	jsonString.append(",\"lat\":");
				jsonString.append(lat.toString());
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
	@RequestMapping(value = "/testsearch", method = RequestMethod.GET)
	public ModelAndView testsearch(Model model) {
		ModelAndView modelAndView = new ModelAndView("Test/testsearch");	
	
		return modelAndView;
	}
	
	@RequestMapping(value = "/jsonage", produces="text/plain;charset=UTF-8", method=RequestMethod.POST)	
	public @ResponseBody
		//String jsonage(HttpServletRequest request, HttpServletResponse response) {
	String jsonage(@RequestBody String sidz) {	
			String[]	strr=sidz.split("&");
			List <Integer> numTable = new ArrayList<Integer>();
			List <Integer> samplearr = new ArrayList<Integer>();
			for(String ito:strr){
				Integer num = Integer.valueOf(ito.trim().substring(5));
				numTable.add(num);
			}
			int numb=numTable.size();
		
			for(int k=0;k<numb;k++){  
				Integer  sampleid=numTable.get(k);			 
				List<QueryResult> sampleresult=queryService.jsonage(sampleid);	
				int count=sampleresult.size();
				if(count>0) samplearr.add(sampleid);		 				
			}
			int countsample=samplearr.size();
			StringBuffer jsonString = new StringBuffer();
			for(int j=0;j<1;j++){
				jsonString.append("[");
				for(int sai=0;sai<countsample;sai++){
					Integer  sampleid=samplearr.get(sai);
					List<QueryResult> samplelist=queryService.jsonage(sampleid);	
					int len=samplelist.size();	
					for(int i=0;i<len;i++){					
						String mountname=samplelist.get(i).getMountname();
						String spotname=samplelist.get(i).getSpotname();  	
	       // Long age204=sampleresult.get(i).getAge204();
	    //	String lon=sampleresult.get(i).getLonEW();
		//	String lat=sampleresult.get(i).getLatNS();
						jsonString.append("{");	
						jsonString.append("\"id\":");
						jsonString.append(samplelist.get(i).getId());				    
						jsonString.append(",\"mountname\":");
						jsonString.append("\"");
						jsonString.append(mountname);
						jsonString.append("\"");
						jsonString.append(",\"spotname\":");
						jsonString.append("\"");
						jsonString.append(spotname);
						jsonString.append("\"");
						jsonString.append(",\"age204\":");
						jsonString.append(samplelist.get(i).getAge204().toString());			
						jsonString.append(",\"err204\":");
						jsonString.append(samplelist.get(i).getErr204().toString());
						jsonString.append(",\"sampleid\":");
						jsonString.append("\"");
						jsonString.append(samplelist.get(i).getSample_id());
						jsonString.append("\"");			
						jsonString.append("}");
						if(sai+1<countsample||i<len-1)			 
							jsonString.append(",");			
		    
	                 	}
					}
				jsonString.append("]");	
         }	
		return jsonString.toString();
	}	
}