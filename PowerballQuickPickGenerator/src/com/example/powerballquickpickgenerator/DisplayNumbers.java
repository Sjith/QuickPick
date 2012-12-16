package com.example.powerballquickpickgenerator;

import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;

public class DisplayNumbers extends Activity {
	
	public String numbers = "" + MainActivity.getListOfNumbers() + " " + MainActivity.power();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_numbers);

		// Create the TextView
		TextView textView = new TextView(this);
		textView.setTextSize(25);
	    textView.setText(numbers);

	    // Set the text view as the activity layout
	    setContentView(textView);
	}

}