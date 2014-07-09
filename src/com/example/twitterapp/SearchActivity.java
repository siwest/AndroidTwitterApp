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
import android.widget.Spinner;

public class SearchActivity extends Activity  {

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
		 Intent goToNextActivity = new Intent(getApplicationContext(), SearchActivity.class);
		 startActivity(goToNextActivity);	
	
	 }
	 public void goToSearch(View view) {
		 Intent goToNextActivity = new Intent(getApplicationContext(), SearchActivity.class);
		 startActivity(goToNextActivity);	
	
	 }
	
}
