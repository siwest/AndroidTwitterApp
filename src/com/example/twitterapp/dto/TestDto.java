package com.example.twitterapp.dto;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import android.util.Log;

public class TestDto {

	private static final String SERVER_URL = "http://54.186.56.83:8080/twitter/TwitterServlet";
	
	
	public void testLogin(String username, String password) {		
		LoginRequest loginRequest = new LoginRequest();
		loginRequest.setUsername(username);
		loginRequest.setPassword(password);
	
		com.google.gson.Gson gson = new com.google.gson.GsonBuilder().create();
		
		HttpClient httpclient = new DefaultHttpClient();		
		HttpPost httpPost = new HttpPost(SERVER_URL);
		httpPost.setHeader("Content-type", "application/json");
		httpPost.setEntity(new StringEntity(gson.toJson(loginRequest)));  
		HttpResponse response = httpclient.execute(httpPost);
		
		StatusLine statusLine = response.getStatusLine();
		int statusCode = statusLine.getStatusCode();
		if (statusCode == 200) {				
			HttpEntity entity = response.getEntity();
			InputStream content = entity.getContent();
			Reader reader = new InputStreamReader(content);
			LoginResponse loginResponse = gson.fromJson(reader, LoginResponse.class);
			
			if(loginResponse.isSuccess()) {
				// Store this user id in session to be used by other apps
				int userId = loginResponse.getUserId();
			} else {
				// Show error message in the app
				loginResponse.getErrorMessage();
			}
		} else {
			Log.e("TestDto", "Error getting repsonse. StatusCode: " + statusCode);
		}		
	}
	
	public void testAddTweet(int userId, String tweet) {		
		AddTweetRequest addTweetRequest = new AddTweetRequest();
		addTweetRequest.setUserId(userId);
		addTweetRequest.setTweetData(tweet);
	
		com.google.gson.Gson gson = new com.google.gson.GsonBuilder().create();
		
		HttpClient httpclient = new DefaultHttpClient();		
		HttpPost httpPost = new HttpPost(SERVER_URL);
		httpPost.setHeader("Content-type", "application/json");
		httpPost.setEntity(new StringEntity(gson.toJson(addTweetRequest)));  
		HttpResponse httpResponse = httpclient.execute(httpPost);
		
		StatusLine statusLine = httpResponse.getStatusLine();
		int statusCode = statusLine.getStatusCode();
		if (statusCode == 200) {				
			HttpEntity entity = httpResponse.getEntity();
			InputStream content = entity.getContent();
			Reader reader = new InputStreamReader(content);
			Response addTweetResponse = gson.fromJson(reader, Response.class);
			if(addTweetResponse.isSuccess()) {
				// Show message that tweet was successfully added.
			} else {
				// Show error message in the app
				addTweetResponse.getErrorMessage();
			}
		} else {
			Log.e("TestDto", "Error getting repsonse. StatusCode: " + statusCode);
		}		
	}
	
	public void testGetTrendingTweets() {		
		GetTrendingTweetsRequest getTrendingTweetsRequest = new GetTrendingTweetsRequest();
	
		com.google.gson.Gson gson = new com.google.gson.GsonBuilder().create();
		
		HttpClient httpclient = new DefaultHttpClient();		
		HttpPost httpPost = new HttpPost(SERVER_URL);
		httpPost.setHeader("Content-type", "application/json");
		httpPost.setEntity(new StringEntity(gson.toJson(getTrendingTweetsRequest)));  
		HttpResponse response = httpclient.execute(httpPost);
		
		StatusLine statusLine = response.getStatusLine();
		int statusCode = statusLine.getStatusCode();
		if (statusCode == 200) {				
			HttpEntity entity = response.getEntity();
			InputStream content = entity.getContent();
			Reader reader = new InputStreamReader(content);
			GetTrendingTweetsResponse getTrendingTweetsResponse = gson.fromJson(reader, GetTrendingTweetsResponse.class);
			if(getTrendingTweetsResponse.isSuccess()) {
				// Display following tweet list in the app
				List<Tweet> tweetList = getTrendingTweetsResponse.getTweetList();
			} else {
				// Show error message in the app
				getTrendingTweetsResponse.getErrorMessage();
			}
		} else {
			Log.e("TestDto", "Error getting repsonse. StatusCode: " + statusCode);
		}		
	}
	
	public void testGetTweetsByUserId(int userId) {		
		GetTweetsByUserIdRequest getTweetsByUserIdRequest = new GetTweetsByUserIdRequest();
		getTweetsByUserIdRequest.setUserId(userId);
	
		com.google.gson.Gson gson = new com.google.gson.GsonBuilder().create();
		
		HttpClient httpclient = new DefaultHttpClient();		
		HttpPost httpPost = new HttpPost(SERVER_URL);
		httpPost.setHeader("Content-type", "application/json");
		httpPost.setEntity(new StringEntity(gson.toJson(getTweetsByUserIdRequest)));  
		HttpResponse httpResponse = httpclient.execute(httpPost);
		
		StatusLine statusLine = httpResponse.getStatusLine();
		int statusCode = statusLine.getStatusCode();
		if (statusCode == 200) {				
			HttpEntity entity = httpResponse.getEntity();
			InputStream content = entity.getContent();
			Reader reader = new InputStreamReader(content);
			GetTweetsByUserIdResponse getTweetsByUserIdResponse = gson.fromJson(reader, GetTweetsByUserIdResponse.class);
			if(getTweetsByUserIdResponse.isSuccess()) {
				// Display following tweet list in the app
				List<Tweet> tweetList = getTweetsByUserIdResponse.getTweetList();
			} else {
				// Show error message in the app
				getTweetsByUserIdResponse.getErrorMessage();
			}
		} else {
			Log.e("TestDto", "Error getting repsonse. StatusCode: " + statusCode);
		}		
	} 
	
	public void testUserProfile(int userId) {		
		GetUserProfileRequest getUserProfileRequest = new GetUserProfileRequest();
		getUserProfileRequest.setUserId(userId);
	
		com.google.gson.Gson gson = new com.google.gson.GsonBuilder().create();
		
		HttpClient httpclient = new DefaultHttpClient();		
		HttpPost httpPost = new HttpPost(SERVER_URL);
		httpPost.setHeader("Content-type", "application/json");
		httpPost.setEntity(new StringEntity(gson.toJson(getUserProfileRequest)));  
		HttpResponse httpResponse = httpclient.execute(httpPost);
		
		StatusLine statusLine = httpResponse.getStatusLine();
		int statusCode = statusLine.getStatusCode();
		if (statusCode == 200) {				
			HttpEntity entity = httpResponse.getEntity();
			InputStream content = entity.getContent();
			Reader reader = new InputStreamReader(content);
			GetUserProfileResponse getUserProfileResponse = gson.fromJson(reader, GetUserProfileResponse.class);
			if(getUserProfileResponse.isSuccess()) {
				// Display following user profile data
				getUserProfileResponse.getUserProfile().getUser();
				getUserProfileResponse.getUserProfile().getTweetList();
				getUserProfileResponse.getUserProfile().getFollowingUserList();
				getUserProfileResponse.getUserProfile().getFollowedUserList();
			} else {
				// Show error message in the app
				getUserProfileResponse.getErrorMessage();
			}
		} else {
			Log.e("TestDto", "Error getting repsonse. StatusCode: " + statusCode);
		}		
	}
	
	public void testSearchTweet(String searchString) {		
		SearchTweetRequest searchTweetRequest = new SearchTweetRequest();
		searchTweetRequest.setSearchString(searchString);
	
		com.google.gson.Gson gson = new com.google.gson.GsonBuilder().create();
		
		HttpClient httpclient = new DefaultHttpClient();		
		HttpPost httpPost = new HttpPost(SERVER_URL);
		httpPost.setHeader("Content-type", "application/json");
		httpPost.setEntity(new StringEntity(gson.toJson(searchTweetRequest)));  
		HttpResponse httpResponse = httpclient.execute(httpPost);
		
		StatusLine statusLine = httpResponse.getStatusLine();
		int statusCode = statusLine.getStatusCode();
		if (statusCode == 200) {				
			HttpEntity entity = httpResponse.getEntity();
			InputStream content = entity.getContent();
			Reader reader = new InputStreamReader(content);
			SearchTweetResponse searchTweetResponse = gson.fromJson(reader, SearchTweetResponse.class);
			if(searchTweetResponse.isSuccess()) {
				// Display following tweet list in the app
				List<Tweet> tweetList = searchTweetResponse.getTweetList();
			} else {
				// Show error message in the app
				searchTweetResponse.getErrorMessage();
			}
		} else {
			Log.e("TestDto", "Error getting repsonse. StatusCode: " + statusCode);
		}		
	}
}









