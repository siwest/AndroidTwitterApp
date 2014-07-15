package com.example.twitterapp;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

public class MainActivity extends Activity  {
	public Dialog dialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		final AlertDialog.Builder builder = new AlertDialog.Builder(this);
	    // Get the layout inflater
	    final LayoutInflater inflater = this.getLayoutInflater();
		
		
		ImageButton addTweetButton = (ImageButton) findViewById(R.id.newtweet);
		addTweetButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				

			    // Inflate and set the layout for the dialog
			    // Pass null as the parent view because its going in the dialog layout
			    builder.setView(inflater.inflate(R.layout.add_tweet_page, null))
			    // Add action buttons
			           .setPositiveButton("Post", new DialogInterface.OnClickListener() {
			               @Override
			               public void onClick(DialogInterface dialog, int id) {
			                   // sign in the user ...
			               }
			           });      
			    builder.create();
				
			}
		});
		
		
		
		
		
		
		
		
	/*	 final ListView listview = (ListView) findViewById(R.id.tweet);
		 
		  

		 final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
			        android.R.layout.simple_list_item_1, list);
			    listview.setAdapter(adapter);
			    
			    
			    
			    // Define a new Adapter
	            // First parameter - Context
	            // Second parameter - Layout for the row
	            // Third parameter - ID of the TextView to which the data is written
	            // Forth - the Array of data
	    
	            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
	              android.R.layout.simple_list_item_1, android.R.id.text1, values);
	    
	    
	            // Assign adapter to ListView
	            listView.setAdapter(adapter); 
	            */	    
		
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
			dialog = new Dialog(MainActivity.this);
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
