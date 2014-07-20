package com.example.twitterapp.dto;

public class GetUserProfileRequest extends Request {
	private int userId;
	
	public GetUserProfileRequest() {
		super(Request.REQUEST_TYPE_GET_USER_PROFILE);
	}
	
	public int getUserId() {return userId;}
	public void setUserId(int userId) {this.userId = userId;}

	public String toString(){
		return new StringBuffer()
			.append("GetUserProfileRequest[")
			.append("requestType: " + requestType + "; ")
			.append("userId: " + userId + "; ")
			.append("]")
			.toString(); 
	}
}
