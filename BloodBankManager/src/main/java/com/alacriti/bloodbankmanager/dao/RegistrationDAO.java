package com.alacriti.bloodbankmanager.dao;

import com.alacriti.bloodbankmanager.request.RegistrationRequest;

public interface RegistrationDAO {
	
	public boolean register(RegistrationRequest request);
}
