package com.example.twitterapp.dto;

public class AddTweetRequest extends Request {
	private int userId;
	private String tweetData;
	
	public AddTweetRequest() {
		super(Request.REQUEST_TYPE_ADD_TWEET);
	}
	
	public int getUserId() {return userId;}
	public void setUserId(int userId) {this.userId = userId;}
	public String getTweetData() {return tweetData;}
	public void setTweetData(String tweetData) {this.tweetData = tweetData;}	
	
	public String toString(){
		return new StringBuffer()
			.append("AddTweetRequest[")				
			.append("requestType: " + requestType + "; ")
			.append("userId: " + userId + "; ")
			.append("tweetData: " + tweetData + "; ")
			.append("]")
			.toString(); 
	}
}



























