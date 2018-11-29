package com.alacriti.bloodbankmanager.dao;

import com.alacriti.bloodbankmanager.request.RegisterCustomerRequest;
import com.alacriti.bloodmanager.bo.PartnerBO;
import com.alacriti.bloodmanager.dao.exception.BloodManagerDAOException;

public interface RegistrationDAO {
	
	public boolean registerCustomer(RegisterCustomerRequest request)  throws BloodManagerDAOException;
	public boolean registerPartner(PartnerBO partnerBo)  throws BloodManagerDAOException;
}
