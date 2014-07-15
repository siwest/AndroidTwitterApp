package com.example.twitterapp;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;

public class SearchActivity extends Activity  {
	public Dialog dialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_page);
		
		
		
		Spinner trendSpinner = (Spinner) findViewById(R.id.trends);
		Spinner peopleSpinner = (Spinner) findViewById(R.id.people);

		
		
		//trendSpinner.setOnItemSelectedListener(this);
	
	}
	
	
	public void goToProfile(View view) {
		 Intent goToNextActivity = new Intent(getApplicationContext(), ProfileActivity.class);
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
			dialog = new Dialog(SearchActivity.this);
			dialog.setContentView(R.layout.add_tweet_page);
			dialog.setTitle("Post new tweet");
			dialog.setCancelable(true);
			dialog.show();
			
			// TO DO: Need method to add tweet to database and post to tweet activities
			//EditText tweetText = (EditText) findViewById(R.id.new_Tweet);
			//String addTweetText = tweetText.getText().toString();
			
			/*
			ImageButton addTweetButton = (ImageButton) findViewById(R.id.addButton);	
			addTweetButton.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					dialog.dismiss();
				}
			});*/

		 }
	
}
