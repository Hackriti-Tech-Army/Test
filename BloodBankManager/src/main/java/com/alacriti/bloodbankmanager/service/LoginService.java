package com.alacriti.bloodbankmanager.service;

import com.alacriti.bloodbankmanager.request.LoginRequest;

public interface LoginService {
	public Boolean validateUser(LoginRequest loginRequest);
}
