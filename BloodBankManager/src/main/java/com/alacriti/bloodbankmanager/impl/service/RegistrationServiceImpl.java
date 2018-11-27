package com.alacriti.bloodbankmanager.impl.service;

import com.alacriti.bloodbankmanager.dao.RegistrationDAO;
import com.alacriti.bloodbankmanager.impl.dao.RegistrationDAOImpl;
import com.alacriti.bloodbankmanager.request.RegistrationRequest;
import com.alacriti.bloodbankmanager.service.RegistrationService;

public class RegistrationServiceImpl implements RegistrationService {

	@Override
	public boolean register(RegistrationRequest request) {
		System.out.println("RegistrationServiceImpl.register()");
		RegistrationDAO dao = null;
		dao = new RegistrationDAOImpl();
		
		return dao.register(request);
	}

}
