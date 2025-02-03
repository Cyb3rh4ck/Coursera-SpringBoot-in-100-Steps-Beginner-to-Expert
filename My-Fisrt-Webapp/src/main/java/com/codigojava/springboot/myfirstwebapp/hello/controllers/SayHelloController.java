package com.codigojava.springboot.myfirstwebapp.hello.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
	
	@GetMapping("say-hello")
	@ResponseBody
	public String sayHello() {
		return "Hello! What are you learning today?";
	}
	
	
	@GetMapping("say-hello-html")
	@ResponseBody
	public String sayHelloHtml() {
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>My first HTML Page</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("My first HTML with body");
		sb.append("</body>");
		sb.append("</html>");
		
		return sb.toString();
	}
	
	@GetMapping("say-hello-jsp")
	public String sayHelloJsp() {
		return "sayHello";
	}

}
