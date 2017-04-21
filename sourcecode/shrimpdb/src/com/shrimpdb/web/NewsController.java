package com.shrimpdb.web;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shrimpdb.entity.News;
import com.shrimpdb.services.NewsService;

@Controller  
@RequestMapping("/news")
public class NewsController {

	@Autowired  
	public NewsService newsService;  

	@RequestMapping("/shownews")
	public ModelAndView deviceList() {	

		return new ModelAndView("news/shownews");
	}
	@RequestMapping(value="/newscc", produces="text/plain;charset=UTF-8")
	public @ResponseBody String newscc(News news) {	
		String jsonString =newsService.jsonString(news);
		return jsonString;
	}
	@RequestMapping("/ptgk")
	public ModelAndView ptgk() {	
		News ptgk_news = newsService.ptgklist();		
		return new ModelAndView("news/ptgk", "ptgk_news", ptgk_news);
	}
	
	@RequestMapping("/sybz")
	public ModelAndView sybz() {	
		News sybz = newsService.sybz();		
		return new ModelAndView("news/sybz", "sybz", sybz);
	}
	
	@RequestMapping("/sfbz")
	public ModelAndView sfbz() {	
		News sfbz = newsService.sfbz();		
		return new ModelAndView("news/sfbz", "sfbz", sfbz);
	}
	@RequestMapping("/news_one")
	public ModelAndView viewdevone(Long id) {	
       News onenews = newsService.News_one(id);	
	   return new ModelAndView("news/news_one", "onenews", onenews);
	}
	
	@RequestMapping("/editnews")
     public ModelAndView editnews(Long id,Model model) {			
	  News	news = newsService.News_one(id);	
      return new ModelAndView("/news/editnews", "news", news);
			}
	
	
	@RequiresPermissions("sys:news:add")
	@RequestMapping("/addnews")
	public ModelAndView addnews(Model model) {
	
		ModelAndView modelAndView = new ModelAndView("news/addnews");
		
		News news = new News();
		modelAndView.addObject("news", news);
		return new ModelAndView("news/addnews", "news", news);
	}
	@RequiresPermissions("sys:news:add")
	@RequestMapping(value = "addnews", method = RequestMethod.POST )
	public String adddevice(News news,BindingResult result) {
		     newsService.insertData(news); 		    
    		 return "redirect:/news/shownews";            
       }

	@RequestMapping(value = "updatenews", method = RequestMethod.POST )
	public String updateData(@ModelAttribute News news,Long id) {
		newsService.updateData(news);
		return "redirect:/news/news_one?id="+news.getId();
	}
	@RequiresPermissions("sys:news:del")
	@RequestMapping("/deleteNews")
	    public String deletedevprice(Long id) {
		newsService.deleteData(id);
		 return "redirect:/news/shownews";       
	}
	
	
	
	}