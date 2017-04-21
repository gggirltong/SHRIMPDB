package com.shrimpdb.web;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shrimpdb.entity.AnalyticalValue;
import com.shrimpdb.entity.QueryResult;
import com.shrimpdb.entity.Sample_detail;
import com.shrimpdb.entity.User;
import com.shrimpdb.entity.UserRole;
import com.shrimpdb.services.QueryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@RequestMapping("/query")
public class QueryController{
	@Autowired
	QueryService queryService;
	@RequiresPermissions("sys:query:table")
	@RequestMapping(value = "/samplequery", method = RequestMethod.GET)
	public ModelAndView testnewbutton(Model model) {
		ModelAndView modelAndView = new ModelAndView("query/samplequery");	
		return modelAndView;
	}
	@RequestMapping(value = "/book", method = RequestMethod.GET)
	public ModelAndView book(Model model) {
		ModelAndView modelAndView = new ModelAndView("query/book");	
		return modelAndView;
	}
	@RequestMapping(value = "/maptools", method = RequestMethod.GET)
	public ModelAndView testmaptools(Model model) {
		ModelAndView modelAndView = new ModelAndView("query/maptools");	
		return modelAndView;
	}
	
	@RequestMapping(value = "/queryperson", method = RequestMethod.GET)
	public ModelAndView queryperson(Model model) {
		ModelAndView modelAndView = new ModelAndView("query/queryperson");	
		return modelAndView;
	}
	@RequestMapping(value = "/openlist", method = RequestMethod.GET)
	public ModelAndView openlist(Model model) {
		ModelAndView modelAndView = new ModelAndView("query/openlist");	
		return modelAndView;
	}
	
	@RequestMapping(value = "/booklist",produces="text/plain;charset=UTF-8", method=RequestMethod.POST)
	public @ResponseBody
	String booklist() {	
		User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");//获取当前登录用户		
		List<Sample_detail> sampleresult=queryService.booklist(user.getId());
		StringBuffer jsonString = new StringBuffer();
		int len=sampleresult.size();		
		   for(int j=0;j<1;j++){
				jsonString.append("[");
			for(int i=0;i<len;i++){						
			    String code=sampleresult.get(i).getCode();
		        jsonString.append("{");					
			    jsonString.append("\"id\":");
			    jsonString.append(i+1);			
		        jsonString.append(",\"code\":");
		        jsonString.append("\"");
				jsonString.append(code);
				jsonString.append("\"");
				jsonString.append(",\"createdate\":");
				jsonString.append("\"");
				jsonString.append(sampleresult.get(i).getOperate_time());
				jsonString.append("\"");
				jsonString.append(",\"samplename\":");
				jsonString.append("\"");
				jsonString.append(sampleresult.get(i).getLithologic());
				jsonString.append("\"");
				jsonString.append(",\"position\":");
				jsonString.append("\"");
				jsonString.append(sampleresult.get(i).getPostion());
				jsonString.append("\"");	
				jsonString.append(",\"dateid\":");
				jsonString.append(sampleresult.get(i).getDataid().toString());
				jsonString.append("}");
			if(i<len-1)jsonString.append(",");
			}
			jsonString.append("]");	
		}	
		return jsonString.toString();
	}
	
	@RequestMapping(value = "/queryperson",produces="text/plain;charset=UTF-8", method=RequestMethod.POST)
	public @ResponseBody
	String test() {	
		User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");//获取当前登录用户	
	
		List<Sample_detail> sampleresult=queryService.personresult(user.getId());
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
	
	@RequestMapping(value = "/openprocess",produces="text/plain;charset=UTF-8", method=RequestMethod.POST)
	public @ResponseBody
	String openprocess() {	
		User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");//获取当前登录用户		
		List<Sample_detail> sampleresult=queryService.openlist(user.getId());
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
	
	@RequestMapping(value = "/personage", produces="text/plain;charset=UTF-8", method=RequestMethod.POST)	
	public @ResponseBody
		//String jsonage(HttpServletRequest request, HttpServletResponse response) {
	String personage(@RequestBody String sidz) {	
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
						jsonString.append(",\"spotname\":");
						jsonString.append("\"");
						jsonString.append(spotname);
						jsonString.append("\"");			    
						jsonString.append(",\"age204\":");
						jsonString.append(samplelist.get(i).getAge204().toString());			
						jsonString.append(",\"err204\":");
						jsonString.append(samplelist.get(i).getErr204().toString());
					//	jsonString.append(",\"age208\":");
					//	jsonString.append(samplelist.get(i).getAge208().toString());
					//	jsonString.append(",\"err208\":");
					//	jsonString.append(samplelist.get(i).getErr204().toString());
						jsonString.append(",\"U\":");
						jsonString.append(samplelist.get(i).getU().toString());
						jsonString.append(",\"Th\":");
						jsonString.append(samplelist.get(i).getTh().toString());
						jsonString.append(",\"ThU\":");
						jsonString.append(samplelist.get(i).getUTh().toString());
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
	
	
	@RequestMapping(value = "/chageopen", produces="text/plain;charset=UTF-8", method=RequestMethod.POST)	
	public @ResponseBody
		//String jsonage(HttpServletRequest request, HttpServletResponse response) {
	String chageopen(@RequestBody String sidz) {	
			String[]	strr=sidz.split("&");
			List <Integer> numTable = new ArrayList<Integer>();
			List <Integer> samplearr = new ArrayList<Integer>();
			for(String ito:strr){
				Integer num = Integer.valueOf(ito.trim().substring(5));
				numTable.add(num);
			}
			int numb=numTable.size();
		 List<Integer>  listint= queryService.updataopen(numTable);	 
		 listint.add(numb);
		    StringBuffer jsonString = new StringBuffer();
		    jsonString.append("{");	
		    jsonString.append("\"id\":");		    
		    jsonString.append(numb);		    
		    jsonString.append(",\"type\":");
		    jsonString.append(listint.get(0));
		    jsonString.append(",\"number\":");
		    jsonString.append(listint.get(1));
		    jsonString.append(",\"open\":");
		    jsonString.append(listint.get(2));
		    jsonString.append("}");
		return jsonString.toString();
	}		
	@RequestMapping(value = "/changegps", method = RequestMethod.GET)
	public ModelAndView changegps(Model model) {
		ModelAndView modelAndView = new ModelAndView("query/changegps");	
		List<Sample_detail> sampleresult=queryService.sampleresult();
	//	List<Sample_detail> sampleresult1=new ArrayList<Sample_detail>();
	//samplereslt1		
		for(int i=0;i<sampleresult.size();i++)
		{
			String deg=sampleresult.get(i).getLonDeg();
			String min=sampleresult.get(i).getLonMin();
			String sec=sampleresult.get(i).getLonSec();
			double d=Double.parseDouble(deg);
			double m=Double.parseDouble(min);
			double s=Double.parseDouble(sec);
			double lonlat=d+m/60+s/3600;
			sampleresult.get(i).setLonlat(lonlat);			
			String ldeg=sampleresult.get(i).getLatDeg();
			String lmin=sampleresult.get(i).getLatMin();
			String lsec=sampleresult.get(i).getLatSec();
			double ld=Double.parseDouble(ldeg);
			double lm=Double.parseDouble(lmin);
			double ls=Double.parseDouble(lsec);
			double llat=ld+lm/60+ls/3600;
			sampleresult.get(i).setLatitude(llat);		
		}
		 queryService.update(sampleresult);		
    	 return modelAndView;
	}
	
	@RequestMapping(value = "/querymap", method = RequestMethod.GET)
	public ModelAndView querymap(Model model) {
		ModelAndView modelAndView = new ModelAndView("query/querymap");	
		return modelAndView;
	}	
	
	
	@RequestMapping(value = "/querymap", produces="text/plain;charset=UTF-8", method=RequestMethod.POST)	
	public @ResponseBody
	String querymap() {		
		List<Sample_detail> sampleresult=queryService.sampleresult();
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
	
	@RequestMapping(value = "/mapperson", method = RequestMethod.GET)
	public ModelAndView mapperson(Model model) {
		ModelAndView modelAndView = new ModelAndView("query/mapperson");	
		return modelAndView;
	}
	@RequestMapping(value = "/mapperson", produces="text/plain;charset=UTF-8", method=RequestMethod.POST)	
	public @ResponseBody
	String mapperson() {	
		User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");//获取当前登录用户		
		List<Sample_detail> sampleresult=queryService.personresult(user.getId());
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
	@RequestMapping(value = "/queryage", produces="text/plain;charset=UTF-8", method=RequestMethod.POST)	
	public @ResponseBody
	String queryage(Long id) {		
		List<AnalyticalValue> sampleresult=queryService.analyticalValue(id);
		StringBuffer jsonString = new StringBuffer();
		int len=sampleresult.size();		
	    for(int j=0;j<1;j++){
			jsonString.append("[");
		for(int i=0;i<len;i++){					
			String mountname=sampleresult.get(i).getMountname();
	    	String spotname=sampleresult.get(i).getSpotname();  	
	       // Long age204=sampleresult.get(i).getAge204();
	    //	String lon=sampleresult.get(i).getLonEW();
		//	String lat=sampleresult.get(i).getLatNS();
			jsonString.append("{");	
			jsonString.append("\"id\":");
			jsonString.append(sampleresult.get(i).getId());				    
			jsonString.append(",\"mountname\":");
			jsonString.append("\"");
			jsonString.append(mountname);
			jsonString.append("\"");
			jsonString.append(",\"spotname\":");
			jsonString.append("\"");
			jsonString.append(spotname);
			jsonString.append("\"");
         	jsonString.append(",\"age204\":");
			jsonString.append(sampleresult.get(i).getAge204());			
	    	jsonString.append(",\"err204\":");
			jsonString.append(sampleresult.get(i).getErr204());
			jsonString.append(",\"sampleid\":");
			jsonString.append("\"");
			jsonString.append(sampleresult.get(i).getSample_id());
			jsonString.append("\"");			
			jsonString.append("}");
		if(i<len-1)jsonString.append(",");
		}
		jsonString.append("]");	
	}	
		return jsonString.toString();
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
	/*		for(int k=0;k<numb;k++){  
				Integer  sampleid=numTable.get(k);			 
				List<QueryResult> sampleresult=queryService.jsonage(sampleid);	
				int count=sampleresult.size();
				if(count>0) samplearr.add(sampleid);		 				
			}*/
			List<QueryResult> samplelist=queryService.jsonagearray(numTable);	
			
			
			int countsample=samplelist.size();
			StringBuffer jsonString = new StringBuffer();
			for(int j=0;j<1;j++){
				jsonString.append("[");
			
				
					
					int len=samplelist.size();	
					for(int i=0;i<len;i++){					
						//String mountname=samplelist.get(i).getMountname();
						String spotname=samplelist.get(i).getSpotname();  	
	       // Long age204=sampleresult.get(i).getAge204();
	    //	String lon=sampleresult.get(i).getLonEW();
		//	String lat=sampleresult.get(i).getLatNS();
						jsonString.append("{");	
						jsonString.append("\"spotname\":");
						jsonString.append("\"");
						jsonString.append(spotname);
						jsonString.append("\"");			    
						jsonString.append(",\"age204\":");
						jsonString.append(samplelist.get(i).getAge204().toString());			
						jsonString.append(",\"err204\":");
						jsonString.append(samplelist.get(i).getErr204().toString());
					//	jsonString.append(",\"age208\":");
					//	jsonString.append(samplelist.get(i).getAge208().toString());
					//	jsonString.append(",\"err208\":");
					//	jsonString.append(samplelist.get(i).getErr204().toString());
						jsonString.append(",\"U\":");
						jsonString.append(samplelist.get(i).getU().toString());
						jsonString.append(",\"Th\":");
						jsonString.append(samplelist.get(i).getTh().toString());
						jsonString.append(",\"ThU\":");
						jsonString.append(samplelist.get(i).getUTh().toString());
						jsonString.append(",\"sampleid\":");
						jsonString.append("\"");
						jsonString.append(samplelist.get(i).getSample_id());
						jsonString.append("\"");			
						jsonString.append("}");
						if(i<len-1)			 
							jsonString.append(",");			
		    
	                 	}
					}
				jsonString.append("]");	
         
		return jsonString.toString();
	}	
	
	
}