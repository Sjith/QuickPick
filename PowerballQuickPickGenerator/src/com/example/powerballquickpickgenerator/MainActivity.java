package com.example.powerballquickpickgenerator;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends Activity {

	private static final boolean False = false;
	static final String EXTRA_NUMBER = "com.example.PowerBallQuickPickGenerator.NUMBER";


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}
 	
 	public void getNumbers(View view) {
 		Intent intent = new Intent(this, DisplayNumbers.class);
 		EditText editText = (EditText) findViewById(R.id.numTickets);
 		String tickets = editText.getText().toString();
		intent.putExtra(EXTRA_NUMBER, tickets);
		startActivity(intent);
 	}

  	// Generates a random number
	public static int getRandomNumber(int min, int max) {
		Random random = new Random();
		int randomNumber = random.nextInt(max - min) + min;
		return randomNumber;
	}

	// Generate the list of random numbers (five random numbers between 1 and 59 inclusive)
	public static String getListOfNumbers() {
		List<Integer> numbers = new ArrayList<Integer>();

		while (numbers.size() != 5) {
			int randNum = getRandomNumber(1,60);

			if (numbers.contains(randNum) == False) {
				numbers.add(randNum);
			} 
			else {
				continue;
			}
		}
		sort(numbers);
		return numbers.toString();
	}

	public static String power() {
		// Generate the Powerball number (random number between 1 and 35 inclusive
		return "" + getRandomNumber(1,36);
	}

	public static List<Integer> sort(List<Integer> list) {
		Collections.sort(list);
		return list;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}