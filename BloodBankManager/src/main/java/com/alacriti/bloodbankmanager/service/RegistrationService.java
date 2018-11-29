package com.alacriti.bloodbankmanager.service;
/**
 * 
 * @author digvijaykumars
 *
 */
import com.alacriti.bloodbankmanager.request.RegisterCustomerRequest;
import com.alacriti.bloodbankmanager.request.RegisterPartnerRequest;

public interface RegistrationService  {

	public boolean registerCustomer(RegisterCustomerRequest request);
	public boolean registerPartner(RegisterPartnerRequest request);
}
