package com.codigojava.springboot.myfirstwebapp.login.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class WelcomeController {
	
	//private Logger logger = LoggerFactory.getLogger(getClass());

	@GetMapping("/")
	public String gotoWelcomePage(ModelMap model) {
		model.put("name", "CodigoJava");
		return "welcome";
	}

}
