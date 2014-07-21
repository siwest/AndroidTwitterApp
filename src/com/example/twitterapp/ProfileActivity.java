package com.example.twitterapp;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

public class ProfileActivity extends Activity  {
	final Context context = this;
	public Dialog dialog;
	String addTweetText = "";
	String searchText = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profile_page);
		
		 
        
		
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
			dialog = new Dialog(ProfileActivity.this);
			dialog.setContentView(R.layout.add_tweet_page);
			dialog.setTitle("Search all tweets");
			dialog.setCancelable(true);
			dialog.show();
			
/*			// TO DO: Need method to search tweet database and show keyword matches to tweet activities
			final EditText search = (EditText) dialog.findViewById(R.id.search_text);
			
			
			ImageButton searchButton = (ImageButton) dialog.findViewById(R.id.search_button);	
			searchButton.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					searchText = search.getText().toString();
					dialog.dismiss();
				}
			});
*/
		 }
	 
	 public void goToAddTweet(View view) {
			dialog = new Dialog(ProfileActivity.this);
			dialog.setContentView(R.layout.add_tweet_page);
			dialog.setTitle("Post new tweet");
			dialog.setCancelable(true);
			dialog.show();
			
			// TO DO: Need method to add tweet to database and post to tweet activities
			final EditText tweetText = (EditText) dialog.findViewById(R.id.new_tweet);
			
			
			
			ImageButton addTweetButton = (ImageButton) dialog.findViewById(R.id.add_button);	
			addTweetButton.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					addTweetText = tweetText.getText().toString();
					dialog.dismiss();
				}
			});

		 }

	
}
