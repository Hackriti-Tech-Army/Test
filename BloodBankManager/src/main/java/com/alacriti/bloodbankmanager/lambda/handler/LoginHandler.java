package com.alacriti.bloodbankmanager.lambda.handler;

import java.util.UUID;

import org.apache.log4j.Logger;

import com.alacriti.bloodbankmanager.impl.service.LoginServiceImpl;
import com.alacriti.bloodbankmanager.request.LoginRequest;
import com.alacriti.bloodbankmanager.response.LoginResponse;
import com.alacriti.bloodbankmanager.service.LoginService;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LoginHandler implements RequestHandler<LoginRequest, LoginResponse> {
	final static Logger log = Logger.getLogger(LoginHandler.class);
	  @Override
	    public LoginResponse handleRequest(LoginRequest loginRequest, Context context) {
		  log.debug("in LoginHandler.handleRequest() ");
		  LambdaLogger logger= context.getLogger();
	        logger.log("Input: " + loginRequest);
	        LoginResponse loginResponse = new LoginResponse();
	        LoginService service=new LoginServiceImpl();
	        
	        try {
	        	Boolean isValid=service.validateUser(loginRequest);
	        	if(isValid)
	            loginResponse.setResponseMessage("Login Successfull with user " + loginRequest.getUsername());
	        	else
	        		loginResponse.setResponseMessage("Login Failed !! Invalid Username/Password " + loginRequest.getUsername());
	            loginResponse.setTransactionID(UUID.randomUUID().toString());
	        } catch (Exception e) {
	            e.printStackTrace();
	            loginResponse.setResponseMessage(e.getMessage());
	        }
	        context.getLogger().log("Response : " + loginResponse);
	        return loginResponse;
	    }
    }
