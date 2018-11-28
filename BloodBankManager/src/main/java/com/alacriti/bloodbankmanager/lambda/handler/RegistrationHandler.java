package com.alacriti.bloodbankmanager.lambda.handler;
/**
 * 
 * @author digvijaykumars
 *
 */
import com.alacriti.bloodbankmanager.impl.service.RegistrationServiceImpl;
import com.alacriti.bloodbankmanager.request.RegistrationRequest;
import com.alacriti.bloodbankmanager.service.RegistrationService;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class RegistrationHandler implements RequestHandler<RegistrationRequest, String> {

	@Override
	public String handleRequest(RegistrationRequest request, Context context) {
		RegistrationService service = null;
		service = new RegistrationServiceImpl();
		if (service.register(request))
			return "Registration Success";
		else
			return "Registration Failed";
	}

}
