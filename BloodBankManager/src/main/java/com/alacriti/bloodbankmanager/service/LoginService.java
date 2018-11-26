package com.alacriti.bloodbankmanager.service;

import com.alacriti.bloodbankmanager.dao.LoginDAO;
import com.alacriti.bloodbankmanager.request.LoginRequest;

public class LoginService {

	public Boolean validateUser(LoginRequest loginRequest){
		System.out.println("LoginService.validateUser()");
		LoginDAO loginDao=new LoginDAO();
		
		return loginDao.validateUser(loginRequest);
		
	}
}
