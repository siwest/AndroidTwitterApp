package com.example.twitterapp.dto;

public class LoginRequest extends Request {
	private String username;
	private String password;
	
	public LoginRequest() {
		super(Request.REQUEST_TYPE_LOGIN);
	}
	
	public String getUsername() {return username;}
	public void setUsername(String username) {this.username = username;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}

	public String toString(){
		return new StringBuffer()
			.append("LoginRequest[")				
			.append("requestType: " + requestType + "; ")
			.append("username: " + username + "; ")
			.append("password: " + password + "; ")
			.append("]")
			.toString(); 
	}
}
