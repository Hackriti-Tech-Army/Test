package com.amazonaws.lambda.demo;

import java.util.UUID;

import com.amazonaws.lambda.service.LoginService;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LoginLambdaHandler implements RequestHandler<LoginRequest, LoginResponse> {
	 
    @Override
    public LoginResponse handleRequest(LoginRequest loginRequest, Context context) {
        context.getLogger().log("Input: " + loginRequest);
        LoginResponse loginResponse = new LoginResponse();
        LoginService loginService=new LoginService();
        
        try {
        	Boolean isValid=loginService.validateUser(loginRequest);
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