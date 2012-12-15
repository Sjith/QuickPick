package com.example.powerballquickpickgenerator;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.TextView;

public class DisplayNumbers extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_numbers);

		// Get the message from the intent
		Intent intent = getIntent();
		String numbers = intent.getStringExtra(MainActivity.EXTRA_NUMBERS);

		// Create the TextView
		TextView textView = new TextView(this);
		textView.setTextSize(30);
	    textView.setText(numbers);

	    // Set the text view as the activity layout
	    setContentView(textView);
	}

}