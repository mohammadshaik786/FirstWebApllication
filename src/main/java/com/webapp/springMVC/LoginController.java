package com.webapp.springMVC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.webapp.UserValidationService;

@Controller
public class LoginController {
	
	@Autowired
	UserValidationService service;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String showLoginPage(){
		return "loginform";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String handleLoginPage(@RequestParam String name,
			@RequestParam String password ,ModelMap model){
		if(service.isValidUser(name,password)){

			model.put("name", name);
			model.put("pwd", password);
			return "welcome";
		}
		else{
			
			return "loginform";
		}
	}
	
}
