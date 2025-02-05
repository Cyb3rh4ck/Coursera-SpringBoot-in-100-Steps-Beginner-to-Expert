package com.codigojava.springboot.myfirstwebapp.login.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codigojava.springboot.myfirstwebapp.login.services.AuthenticationService;

@Controller
public class LoginController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private AuthenticationService authenticationService;
	
	public LoginController (AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}
	
	@GetMapping("login")
	public String gotologinPage() {
		return "login";
	}
	
	@PostMapping("login")
	public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
		
		if(authenticationService.authenticate(name, password)) {
			model.put("name", name);
			model.put("password", password);
			return "welcome";
		}
		model.put("errorMessage", "Invalid credentials! Please try again");
		return "login";
	}
	


}
