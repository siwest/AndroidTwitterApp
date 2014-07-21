package com.example.twitterapp.dto;

public class GetTweetsByUserIdRequest extends Request {	
	private int userId;
	
	public GetTweetsByUserIdRequest() {
		super(Request.REQUEST_TYPE_GET_TWEETS_BY_USER_ID);
	}
	
	public int getUserId() {return userId;}
	public void setUserId(int userId) {this.userId = userId;}

	public String toString(){
		return new StringBuffer()
			.append("GetTweetsByUserIdRequest[")
			.append("requestType: " + requestType + "; ")
			.append("userId: " + userId + "; ")
			.append("]")
			.toString(); 
	}
	
}
