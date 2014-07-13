package com.example.twitterapp.dto;

public class Response {
	protected boolean success;
	protected String errorMessage;
	
	public boolean isSuccess() {return success;}
	public void setSuccess(boolean success) {this.success = success;}
	public String getErrorMessage() {return errorMessage;}
	public void setErrorMessage(String errorMessage) {this.errorMessage = errorMessage;}	
}

