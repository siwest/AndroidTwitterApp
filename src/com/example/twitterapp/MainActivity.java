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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity  {
	String addTweetText = "";
	String searchText = "";
	public Dialog dialog;
	ListView lv;
    String[] planets = new String[] { "Tweet1 tweet1 tweet1", "Tweet2 tweet2 tweet2", "Tweet3 tweet3 tweet3", "Tweet4 tweet4 tweet4" };   
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		lv=(ListView) findViewById(R.id.list_view);
		
		
	    ListAdapter mylist;
	    
	    ArrayAdapter adapter = new ArrayAdapter(this, R.layout.tweet_list_item, R.id.tweet, planets);
	    
	    lv.setAdapter(adapter);
	    
        lv.setOnItemClickListener(new OnItemClickListener() {

          @Override
          public void onItemClick(AdapterView<?> arg0, View arg1,
                  int position, long arg3) {
        	  
        	  // To do: Toggle star on/off for each list item when clicked (Currently set only the first one on)
        	  ImageView starButton = (ImageView) findViewById(R.id.star);
        	  starButton.setBackgroundResource(android.R.drawable.star_big_on);
        	 
               int itemPosition     = position;
               

                 // ListView Clicked item value
                 String  itemValue    = (String) lv.getItemAtPosition(position);

                  // Show Alert - for testing
                  Toast.makeText(getApplicationContext(),
                    "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
                    .show();
                  
                  
          }
      });

	    
		
		
		
	
		
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
			dialog = new Dialog(MainActivity.this);
			dialog.setContentView(R.layout.add_tweet_page);
			dialog.setTitle("Search all tweets");
			dialog.setCancelable(true);
			dialog.show();
			
			// TO DO: Need method to search tweet database and show keyword matches to tweet activities
	/*		final EditText search = (EditText) dialog.findViewById(R.id.search_text);
			
			
			ImageButton searchButton = (ImageButton) dialog.findViewById(R.id.search_button);	
			searchButton.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					searchText = search.getText().toString();
					dialog.dismiss();
				}
			});*/

		 }
	 
	 public void goToAddTweet(View view) {
			dialog = new Dialog(MainActivity.this);
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
