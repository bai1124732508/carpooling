package com.carpooling.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class IndexController {
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String getIndex(Model model,String name)throws Exception{
		
		
		
		return "login/index";
	}
	
}
