package com.amazonaws.lambda.service;

import com.amazonaws.lambda.dao.LoginDAO;
import com.amazonaws.lambda.demo.LoginRequest;

public class LoginService {

	public Boolean validateUser(LoginRequest loginRequest){
		System.out.println("LoginService.validateUser()");
		LoginDAO loginDao=new LoginDAO();
		
		return loginDao.validateUser(loginRequest);
		
	}
}
