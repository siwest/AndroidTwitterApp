package com.example.twitterapp.dto;

public class Request {
	public static final String REQUEST_TYPE_LOGIN = "login";
	public static final String REQUEST_TYPE_GET_TWEETS = "getTweets";
	
	protected String requestType; 

	public String getRequestType() {return requestType;}
	public void setRequestType(String requestType) {this.requestType = requestType;} 	
}
