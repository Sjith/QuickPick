package com.example.powerballquickpickgenerator;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DisplayNumbers extends Activity {
	
	//public String numbers = "" + MainActivity.getListOfNumbers() + " " + MainActivity.power();
	ArrayList<String> tickets = new ArrayList<String>();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_numbers);
		
		// Get the number of tickets that the user wants
		Intent intent = getIntent();
		String getNum = intent.getStringExtra(MainActivity.EXTRA_NUMBER);
		int batchNum = Integer.parseInt(getNum);

		// populate array with the tickets
		for (int i = 0; i < batchNum; i++) {
			int fixTicketNum = i + 1;
			tickets.add("Ticket #" + fixTicketNum + "  " + MainActivity.getListOfNumbers() + " " + MainActivity.power());
		}

		// Create ListView
		ListView listView = (ListView) findViewById(R.id.mylist);
		
		// Create Adapter
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tickets);

		// Assign adapter to ListView
		listView.setAdapter(adapter); 
	}

}