package com.alacriti.bloodbankmanager.impl.service;

import com.alacriti.bloodbankmanager.dao.LoginDAO;
import com.alacriti.bloodbankmanager.impl.dao.LoginDAOImpl;
import com.alacriti.bloodbankmanager.request.LoginRequest;
import com.alacriti.bloodbankmanager.service.LoginService;

public class LoginServiceImpl implements LoginService {

	@Override
	public Boolean validateUser(LoginRequest loginRequest){
		System.out.println("LoginService.validateUser()");
		LoginDAO loginDao=new LoginDAOImpl();
		
		return loginDao.validateUser(loginRequest);
		
	}
}
