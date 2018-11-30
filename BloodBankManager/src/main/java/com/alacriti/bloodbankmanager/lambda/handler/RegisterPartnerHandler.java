package com.alacriti.bloodbankmanager.lambda.handler;

import com.alacriti.bloodbankmanager.impl.service.RegistrationServiceImpl;
import com.alacriti.bloodbankmanager.request.RegisterCustomerRequest;
import com.alacriti.bloodbankmanager.request.RegisterPartnerRequest;
import com.alacriti.bloodbankmanager.service.RegistrationService;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

	public class RegisterPartnerHandler implements RequestHandler<RegisterPartnerRequest, String> {

		@Override
		public String handleRequest(RegisterPartnerRequest request, Context context) {
			RegistrationService service = null;
			service = new RegistrationServiceImpl();
			if (service.registerPartner(request))
				return "Registration Success";
			else
				return "Registration Failed";
		}

	}
