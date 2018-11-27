package com.alacriti.bloodbankmanager.dao;

import com.alacriti.bloodbankmanager.request.LoginRequest;

public interface LoginDAO {

	public Boolean validateUser(LoginRequest loginRequest); 
}
