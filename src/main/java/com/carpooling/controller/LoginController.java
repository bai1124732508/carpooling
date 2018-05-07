package com.carpooling.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@EnableAutoConfiguration
public class LoginController {
	
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String index(Model model){
		
		return "login/index";
	}
	
	
	@RequestMapping(value = "/adminLogin",method = RequestMethod.GET)
	public String adminLogin(Model model){
		
		return "login/adminLogin";
	}
}
