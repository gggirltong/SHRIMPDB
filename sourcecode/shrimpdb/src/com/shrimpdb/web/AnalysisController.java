package com.shrimpdb.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/analysis")
public class AnalysisController {
	@RequestMapping(value = "/chart", method = RequestMethod.GET)
	public ModelAndView chart(Model model) {
		ModelAndView modelAndView = new ModelAndView("analysis/chart");	
	
		return modelAndView;
	}
	
	
	}
	
