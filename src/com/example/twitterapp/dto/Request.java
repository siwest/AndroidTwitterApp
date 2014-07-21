package com.example.twitterapp.dto;

public class Request {
	public static final String REQUEST_TYPE_LOGIN = "login";
	public static final String REQUEST_TYPE_ADD_TWEET = "addTweet";
	public static final String REQUEST_TYPE_GET_TRENDING_TWEETS = "getTrendingTweets";
	public static final String REQUEST_TYPE_GET_TWEETS_BY_USER_ID = "getTweetsByUserId";
	public static final String REQUEST_TYPE_GET_USER_PROFILE = "getUserProfile";
	public static final String REQUEST_TYPE_SEARCH_TWEET = "searchTweet";
	
	protected String requestType; 
		
	public Request() {}
	
	public Request(String requestType) {
		this.requestType = requestType;
	}
	
	public String getRequestType() {return requestType;}
	public void setRequestType(String requestType) {this.requestType = requestType;} 	
	
}
