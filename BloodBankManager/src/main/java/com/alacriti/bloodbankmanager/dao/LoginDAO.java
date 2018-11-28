package com.alacriti.bloodbankmanager.dao;

import com.alacriti.bloodbankmanager.request.LoginRequest;
import com.alacriti.bloodmanager.dao.exception.BloodManagerDAOException;

public interface LoginDAO {

	public Boolean validateUser(LoginRequest loginRequest)  throws BloodManagerDAOException; 
}
