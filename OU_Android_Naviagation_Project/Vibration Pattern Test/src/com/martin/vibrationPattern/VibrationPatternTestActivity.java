package com.martin.vibrationPattern;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.martin.VibrationPatternGen.R;

public class VibrationPatternTestActivity extends Activity {
    /** Called when the activity is first created. */
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
     // Automatically written when class is created
        super.onCreate(savedInstanceState);
     // Sets layout to main.xml file
        setContentView(R.layout.main);
        
     // variable set up and assigned to vibration service
        final Vibrator vibration = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
     // variable set up and assigned to vibrate button
        Button vibrateButton = (Button) findViewById(R.id.vibrateButton);
     // variable set up and assigned to stop button
        Button stopButton = (Button) findViewById(R.id.stopButton);
     // variable set up and assigned to clear button
        Button clearButton = (Button) findViewById(R.id.clearButton);
     // variable set up and assigned to vibration length text box
        final EditText vibrationText = (EditText) findViewById(R.id.vibrationText);
     // variable set up and assigned to gap between vibrations text box
        final EditText gapText = (EditText) findViewById(R.id.gapText);
     // variable set up and assigned to number of vibrations text box
        final EditText numberText = (EditText) findViewById(R.id.numberText);
     // variable set up and assigned to gap between vibration pattern text box
        final EditText gapBetweenText = (EditText) findViewById(R.id.gapBetweenText);
        
     // Sets up click listener for vibration button
        vibrateButton.setOnClickListener(new OnClickListener() {
        	
            /* 
            * This public method sets up what happens when the
            * 'Vibrate' button is pressed. The values of text boxes
            * dictate the vibration pattern. An array is set up to
            * store vibration pattern. A for loop assigns values to the
            * array. Apart from the first and last value(gap before
            * vibration pattern starts and gap between patterns), the
            * values assigned are dependent on if they are odd
            * (vibration length) or even (gap length). The remainder
            * operation % and nested if statements are used to assign
            * the correct values to the array.
             */
            public void onClick(View v) { 
             // Assigns value for the length of vibration to String
            	String vibrationString = vibrationText.getText().toString();
            // Converts the previous String to a Long 
            	Long vibrateLong = Long.parseLong(vibrationString);
             // Assigns value for the gap between vibrations to String
            	String gapString = gapText.getText().toString();
             // Converts the previous String to a Long 
            	Long gapLong = Long.parseLong(gapString);
             // Assigns value for the length of the gap between vibration patterns to String
            	String gapBetweenString = gapBetweenText.getText().toString();
             // Converts the previous String to a Long
            	Long gapBetweenLong = Long.parseLong(gapBetweenString);
             // Sets up and initialises array
            	long[] pattern = new long [(int) (Long.parseLong(numberText.getText().toString().trim()) * 2 + 1)];
             // Loop that iterates through array
            	for (int i = 0; i < pattern.length; ++i){  
            	 // Separates out first and last values
            		if (i != 0 && i != pattern.length -1){ 
            		 // Checks for even number (has remainder)
            			if (i % 2 != 0){
            			 // Assigns the length of the vibration to i
            				pattern[i] = vibrateLong;
            			}
            			else {
            			 // Assigns the length of the gap between vibrations to i
            				pattern[i] = gapLong;
            			}
            		}
            		else{
            		 // Checks for first element in array
            			if (i == 0){
            			 // Assigns first element value
            				pattern[i] = 0;
            			}
            			else{
            			 // Assigns final element value(gap between vibration pattern)
            				pattern[i] = gapBetweenLong;
            			}
            		}
            	} 
             // Runs vibration pattern(zero makes pattern repeat)
            	vibration.vibrate(pattern, 0);
            }
        });
        
     // Sets up click listener for stop button
        stopButton.setOnClickListener(new OnClickListener() {
            /* 
             * This public method sets up what happens when the 'Stop'
             * button is pressed
             */
            public void onClick(View v) {
             // Stops the vibration patterns
            	vibration.cancel();
            }
        });
        
     // Sets up click listener for clear button
        clearButton.setOnClickListener(new OnClickListener() {
        	 /* 
             * This public method sets up what happens when the 'Clear'
             * button is pressed
             */
            public void onClick(View v) {
             // Clears the vibration length text box
            	vibrationText.setText("");
             // Clears the gap between vibrations text box
            	gapText.setText("");
            // Clears the number of vibrations text box
            	numberText.setText("");
             // Clears the gap between vibration pattern text box
            	gapBetweenText.setText("");
            }
        });
    }
}