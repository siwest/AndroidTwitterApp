package com.example.twitterapp;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class AddTweetActivity extends Activity  {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_tweet_page);
		
		 
		//code to add tweets here
		
		
		
	}
	

	 public void goToProfile(View view) {
		 Intent goToNextActivity = new Intent(getApplicationContext(), AddTweetActivity.class);
		 startActivity(goToNextActivity);	
	 }
	 public void goToAllTweets(View view) {
		 Intent goToNextActivity = new Intent(getApplicationContext(), MainActivity.class);
		 startActivity(goToNextActivity);	
	 }
	 public void goToSearch(View view) {
		 Intent goToNextActivity = new Intent(getApplicationContext(), SearchActivity.class);
		 startActivity(goToNextActivity);	
	 }
	 public void goToAddTweet(View view) {
		 Intent goToNextActivity = new Intent(getApplicationContext(), AddTweetActivity.class);
		 startActivity(goToNextActivity);	
	 }

	
}
