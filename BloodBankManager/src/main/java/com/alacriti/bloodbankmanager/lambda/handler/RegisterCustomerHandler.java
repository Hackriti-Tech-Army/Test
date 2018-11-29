package com.alacriti.bloodbankmanager.lambda.handler;
/**
 * 
 * @author digvijaykumars
 *
 */
import com.alacriti.bloodbankmanager.impl.service.RegistrationServiceImpl;
import com.alacriti.bloodbankmanager.request.RegisterCustomerRequest;
import com.alacriti.bloodbankmanager.service.RegistrationService;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class RegisterCustomerHandler implements RequestHandler<RegisterCustomerRequest, String> {

	@Override
	public String handleRequest(RegisterCustomerRequest request, Context context) {
		RegistrationService service = null;
		service = new RegistrationServiceImpl();
		if (service.registerCustomer(request))
			return "Registration Success";
		else
			return "Registration Failed";
	}

}
