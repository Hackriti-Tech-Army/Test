package com.alacriti.bloodbankmanager.impl.service;

import org.apache.log4j.Logger;

/**
 * 
 * @author digvijaykumars
 *
 */
import com.alacriti.bloodbankmanager.dao.LoginDAO;
import com.alacriti.bloodbankmanager.impl.dao.LoginDAOImpl;
import com.alacriti.bloodbankmanager.request.LoginRequest;
import com.alacriti.bloodbankmanager.service.LoginService;
import com.alacriti.bloodmanager.dao.exception.BloodManagerDAOException;

public class LoginServiceImpl implements LoginService {
	final static Logger log = Logger.getLogger(LoginServiceImpl.class);

	@Override
	public Boolean validateUser(LoginRequest loginRequest) {
		System.out.println("LoginService.validateUser()");
		LoginDAO loginDao = null;
		loginDao = new LoginDAOImpl();
		Boolean result = false;

		try {
			result = loginDao.validateUser(loginRequest);
		} catch (BloodManagerDAOException e) {
			log.error(e.getMessage());
		}
		return result;
	}
}
