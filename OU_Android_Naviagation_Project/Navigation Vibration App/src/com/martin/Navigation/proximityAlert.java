package com.martin.Navigation;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Vibrator;
import android.widget.Toast;

public class proximityAlert extends BroadcastReceiver
{
	// Variable to be used to store and control use of vibration pattern
		Vibrator vibration;
	 // Variable to be used store value that determines gap between vibration patterns
		int vibrationPattern;
	 // Variable to be used to store vibration pattern
		long[] pattern;
	 // Variable to be used to store turn information
		String turnText;
	 // Variable to be used to store gap information
		String gapText;
		
	    @Override
	    public void onReceive(Context context, Intent intent)
	    {
	     // Variable allocated information on if user entering proximity alert
	    	String key = LocationManager.KEY_PROXIMITY_ENTERING;
	     // Variable that holds boolean value on if the user is entering proximity alert
	    	boolean entering = intent.getBooleanExtra(key, false);
	     // Variable set up and assigned to vibration service
	    	vibration = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
	     // Variable set up and assigned value that determines if user is turning right
	    	boolean isRight = intent.getExtras().getBoolean("isRight");
	     // Variable set up and assigned value that determines gap between vibration patterns
	    	vibrationPattern = intent.getExtras().getInt("vibrationPattern");
	     // If user is entering proximity alert
	    	if (entering)
	    	{
	     // If user is turning right
	    	if (isRight == true)
	    	{
	    	 // Vibration pattern for right turn assigned to variable
	    		pattern = new long[]{0, 250, 250, 250, 500};
	    	 // Text for right turn assigned to variable
	    		turnText = "Right turn";
	    	}
	     // Else user is turning left
	    	else
	    	{
	    	 // Vibration pattern for left turn assigned to variable
	    		pattern = new long[]{0, 250, 250, 250, 250, 250, 250, 250, 500};
	    	 // Text for left turn assigned to variable
	    		turnText = "Left turn";
	    	}
	     // Switch statement to sort gap between vibrations
	    	switch (vibrationPattern)
	    	{
	     // Gap set to half a second
	    	case(1): pattern[pattern.length -1] = 500;
	             // Text for distance to turn assigned to variable
	    			gapText = " next";
	    			break;
	     // Gap set to one second
	    	case(2): pattern[pattern.length -1] = 1000;
	    			gapText = " imminent";
	    			break;
	     // Gap set to two second
	    	case(3): pattern[pattern.length -1] = 2000;
	    			gapText = " coming up";
	    			break;
	    	}
	     // Text for turn information combined and assigned to variable
	    	String finalText = turnText + gapText;
	     // Starts vibration pattern 
	    	vibration.vibrate(pattern, 0);  
	     // Variable that holds information on turn information to be displayed
	    	Toast toast = Toast.makeText(context, finalText, Toast.LENGTH_LONG);
	     // Displays turn information
	    	toast.show();
	    	}
	     // If user exiting proximity alert
	    	else
	    	{
	    	 // Vibration stops
	    		vibration.cancel();
	    	}
	    	
	    }
	}