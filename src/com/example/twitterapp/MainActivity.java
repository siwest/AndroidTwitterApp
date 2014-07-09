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

public class MainActivity extends Activity  {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
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
