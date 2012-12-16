package com.example.powerballquickpickgenerator;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends Activity {

	private static final boolean False = false;
	static final String EXTRA_TICKETS = "com.example.PowerBallQuickPickGenerator.TICKETS";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	}
 	
 	public void getNumbers(View view) {
 		Intent intent = new Intent(this, DisplayNumbers.class);
 		EditText editText = (EditText) findViewById(R.id.numTickets);
 		Bundle b = new Bundle();
 		List tickets = totalTickets(numberOfTickets);
 		b.putStringArray(EXTRA_TICKETS, tickets);
 		intent.putExtras(b);
 		int numberOfTickets = editText.getText().toString();
		startActivity(intent);
 	}

 	private static List totalTickets(int num) {
		int i = 1;
		List tickets = new ArrayList();
		
		// Generate the Powerball tickets
		while (i <= num) {
			tickets.add(getListOfNumbers() + " " + "Powerball: " + power());
			i++;
		}

		return tickets;
	}

  	// Generates a random number
	private static int getRandomNumber(int min, int max) {
		Random random = new Random();
		int randomNumber = random.nextInt(max - min) + min;
		return randomNumber;
	}

	// Generate the list of random numbers (five random numbers between 1 and 59 inclusive)
	private static String getListOfNumbers() {
		List<Integer> numbers = new ArrayList<Integer>();
		
		while (numbers.size() != 5) {
			int randNum = getRandomNumber(1,59);

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

	private static String power() {
		// Generate the Powerball number (random number between 1 and 35 inclusive
		return "" + getRandomNumber(1,35);
	}

	private static List sort(List list) {
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
