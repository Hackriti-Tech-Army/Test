package com.alacriti.bloodbankmanager.request;

public class LoginResponse {
	String responseMessage;
    String transactionID;
 
    public String getResponseMessage() {
        return responseMessage;
    }
 
    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
 
    public String getTransactionID() {
        return transactionID;
    }
 
    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }
 
    @Override
    public String toString() {
        return "MyLambdaResponse [responseMessage=" + responseMessage + ",transactionID=" + transactionID + "]";
    }
}