package com.alacriti.bloodbankmanager.impl.service;

import org.apache.log4j.Logger;

/**
 * 
 * @author digvijaykumars
 *
 */
import com.alacriti.bloodbankmanager.dao.RegistrationDAO;
import com.alacriti.bloodbankmanager.impl.dao.RegistrationDAOImpl;
import com.alacriti.bloodbankmanager.request.RegisterCustomerRequest;
import com.alacriti.bloodbankmanager.request.RegisterPartnerRequest;
import com.alacriti.bloodbankmanager.service.RegistrationService;
import com.alacriti.bloodmanager.dao.exception.BloodManagerDAOException;

public class RegistrationServiceImpl implements RegistrationService {
	final static Logger log = Logger.getLogger(RegistrationServiceImpl.class);

	@Override
	public boolean registerCustomer(RegisterCustomerRequest request) {
		System.out.println("RegistrationServiceImpl.register()");
		RegistrationDAO dao = null;
		Boolean result = false;
		dao = new RegistrationDAOImpl();

		try {
			result = dao.registerCustomer(request);
		} catch (BloodManagerDAOException e) {
			log.error(e.getMessage());
		}
		return result;
	}

	@Override
	public boolean registerPartner(RegisterPartnerRequest request) {
		// TODO Auto-generated method stub
		return false;
	}

}
