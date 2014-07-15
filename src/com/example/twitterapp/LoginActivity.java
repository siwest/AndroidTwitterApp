package com.example.twitterapp;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.example.twitterapp.dto.LoginRequest;
import com.example.twitterapp.dto.LoginResponse;
import com.example.twitterapp.dto.Request;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class LoginActivity extends Activity  {
	
	String username = "";
	String password = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_page);
		
		
		 // To do:  method for isLoggedIn?   ==> If true, go to MainActivity to view tweets, else log in

		
		final TextView usernameTV = (TextView) findViewById(R.id.nameText);		
		final TextView passwordTV = (TextView) findViewById(R.id.passwordText);
		
		username = usernameTV.getText().toString();
		password = passwordTV.getText().toString();
		
		final Button loginButton = (Button) findViewById(R.id.loginButton);
		
		 //This is a test. Move this later.
		 new BackendTestTask().execute();
		 
        
		
	}
	
	 public void goToLogin(View view) {
		 Intent goToNextActivity = new Intent(getApplicationContext(), MainActivity.class);
		 
		 // TO DO: authenticate username and password strings
		 
		 startActivity(goToNextActivity);	
	
	 }

	
}

class BackendTestTask extends AsyncTask<Void, Void, String> {
	@Override
	protected String doInBackground(Void... params) {
		//Log.v("MainActivity", "test......");
		int sessionId = 0;
		try {			
			com.google.gson.Gson gson = new com.google.gson.GsonBuilder().create();
			
			LoginRequest loginRequest = new LoginRequest();
			loginRequest.setRequestType(Request.REQUEST_TYPE_LOGIN);
			loginRequest.setUsername("sanjayrally");
			loginRequest.setPassword("sanjayrallypw");
						
			HttpClient httpclient = new DefaultHttpClient();
			
			HttpPost httpPost = new HttpPost("http://54.186.56.83:8080/twitter/TwitterServlet");
			
			httpPost.setHeader("Content-type", "application/json");
			Log.v("MainActivity", "sending......");
			String jsonStr = gson.toJson(loginRequest);
			Log.v("MainActivity", "jsonStr: " + jsonStr);
			httpPost.setEntity(new StringEntity(gson.toJson(loginRequest)));    			    		
			HttpResponse response = httpclient.execute(httpPost);
			Log.v("MainActivity", "sent......");
			
			StatusLine statusLine = response.getStatusLine();
			int statusCode = statusLine.getStatusCode();
			if (statusCode == 200) {				
				HttpEntity entity = response.getEntity();
				InputStream content = entity.getContent();
				Reader reader = new InputStreamReader(content);
				LoginResponse loginResponse = gson.fromJson(reader, LoginResponse.class);
				Log.v("MainActivity", "sessionId: " + loginResponse.getSessionId());
				sessionId = loginResponse.getSessionId();
			} else {
				Log.e("MainActivity", "Error getting repsonse. StatusCode: " + statusCode);
			}
		} catch(Exception e) {
			Log.e("MainActivity", "exception: " + e.getMessage());
		}
		
		return "SessionId: " + sessionId ;    		
	}
	
	@Override
	protected void onPreExecute() {
		super.onPreExecute();
	}

	@Override
	protected void onPostExecute(final String message) {
		super.onPostExecute(message);
	}
	
}



//
