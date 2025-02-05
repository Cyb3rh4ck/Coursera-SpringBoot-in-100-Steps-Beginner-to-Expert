package com.codigojava.springboot.myfirstwebapp.login.services;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

	public boolean authenticate(String username, String password) {
		  
		boolean isValidUsernName = username.equalsIgnoreCase("CodigoJava");
		boolean isValidPassword =  password.equalsIgnoreCase("dummy");
		
		return isValidUsernName && isValidPassword;
	}
}
