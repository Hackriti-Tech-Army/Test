package com.alacriti.bloodbankmanager.dao;

import com.alacriti.bloodbankmanager.request.RegistrationRequest;
import com.alacriti.bloodmanager.dao.exception.BloodManagerDAOException;

public interface RegistrationDAO {
	
	public boolean register(RegistrationRequest request)  throws BloodManagerDAOException;
}
