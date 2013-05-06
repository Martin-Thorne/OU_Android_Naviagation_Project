package com.martin.Navigation;

import java.util.List;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.os.Bundle;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;
import com.martin.Navigation.R;

public class NavigationMain extends MapActivity {
	// String that forms part of intent (Shows that intent is part of a proximity alert)
		private static final String PROXIMITY_INTENT_ACTION = new String("com.martin.Navigation.PROXIMITY_ALERT");
	 // Variable to be used in intent
		private IntentFilter intentFilter;
	 // Variable to be used to show phones location on map
	    private MyLocationOverlay myLocationOverlay;
	 // Variable to be used to show map
	    private MapView mapView;
	 // Two dimensional array variable to be used to store details for proximity alerts
	    double[][] positions;
	 // Variable to be used to store proximity alerts latitude
	    double latitude;
	 // Variable to be used to store proximity alerts longitude
	    double longitude;
	 // Variable used in store request code for proximity alert 
	    int i = 0;
	 // Variable used to store value that determines if turn is right or left
	    boolean isRight;
	 // Variable used to store value that determines gap between vibration patterns
	    int vibrationPattern;

		/** Called when the activity is first created. */
		@Override
		public void onCreate(Bundle savedInstanceState) {
	     // Automatically written when class is created
		    super.onCreate(savedInstanceState);
		 // Sets layout to main.xml file
		    setContentView(R.layout.main); 
		 // Assigns value to variable. Parameter is for type of action
		    intentFilter = new IntentFilter(PROXIMITY_INTENT_ACTION);
		    
		    
		 // Assigns value to variable. Used to show map
			mapView = (MapView) findViewById(R.id.mapView);
		 // Allows zoom controls to be used on map
			mapView.setBuiltInZoomControls(true);

		 // Assigns value to variable. Creates an overlay to show phones current location
			 myLocationOverlay = new MyLocationOverlay(this, mapView);

		 // Adds the newly created overlay to the list of overlays
			mapView.getOverlays().add(myLocationOverlay);
		 // Used to re-draw the map
			mapView.postInvalidate();
		 // Enables phone location and registers for updates so that map is updated with phones current location
			myLocationOverlay.enableMyLocation();
			
		 // Assigns variable to two dimensional array
		    positions = new double[12][4];
		 // Adds latitude to array
		    positions[0][0] = 51.533748;
		 // Adds longtitude to array
		    positions[0][1] = -2.571910;
		 // Adds turn direction to array
		    positions[0][2] = 2;
		 // Adds distance to turn information
		    positions[0][3] = 1;
		    
		    positions[1][0] = 51.533650;
		    positions[1][1] = -2.571764;
		    positions[1][2] = 2;
		    positions[1][3] = 2;    
		    
		    positions[2][0] = 51.532383;
		    positions[2][1] = -2.576946;
		    positions[2][2] = 2;
		    positions[2][3] = 1;
		    
		    positions[3][0] = 51.532438;
		    positions[3][1] = -2.576745;
		    positions[3][2] = 2;
		    positions[3][3] = 2;
		    
		    positions[4][0] = 51.532494;
		    positions[4][1] = -2.576548;
		    positions[4][2] = 2;
		    positions[4][3] = 3;
		    
		    
		    positions[5][0] = 51.531776;
		    positions[5][1] = -2.576630;
		    positions[5][2] = 2;
		    positions[5][3] = 1;
		  
		    positions[6][0] = 51.531900;
		    positions[6][1] = -2.576716;
		    positions[6][2] = 2;
		    positions[6][3] = 2;

		   	    
		    positions[7][0] = 51.533180;
		    positions[7][1] = -2.571192;
		    positions[7][2] = 2;
		    positions[7][3] = 1;
		    
		    positions[8][0] = 51.533122;
		    positions[8][1] = -2.571389;
		    positions[8][2] = 2;
		    positions[8][3] = 2;
		    
		    positions[9][0] = 51.533069;
		    positions[9][1] = -2.571588;
		    positions[9][2] = 2;
		    positions[9][3] = 3;
		    
		    
		    positions[10][0] = 51.533479;
		    positions[10][1] = -2.571347;
		    positions[10][2] = 1;
		    positions[10][3] = 1;
		    
		    positions[11][0] = 51.533376;
		    positions[11][1] = -2.571207;
		    positions[11][2] = 1;
		    positions[11][3] = 2;
		    
		 // Sets up for loop to go through each row in array
		    for (int row = 0; row < 12; row++)
		    {
		     // Sets up for loop to go through each column in array
		    	for (int col = 0; col < 4; col++)
		    	{
		    	 // Switch statement for columns
		    		switch (col)
		    		{
		    	 // Variable set to latitude
		    		case 0: latitude = positions[row][col];
		    			 // Terminates switch statement
		    				break;
		    	 // Variable set for longitude
		    		case 1: longitude = positions[row][col];
		    				break;
		    	 // If turn direction value is 1
		    		case 2: if (positions[row][col] == 1)
		    					{
		    					 // Variable is set to true
		    						isRight = true;
		    					}
		    					else
		    					{
		    					 // Else it is set to false
		    						isRight = false;
		    					}
		    					
		    					break;
		    	 // Variable set for vibration pattern. Array double value cast as int
		    		case 3: vibrationPattern = (int) positions[row][col];
		    				break;
		    		}    				    			
		    		} 
		     // Calls addProximity method
		    	addProximity(latitude, longitude, i, isRight, vibrationPattern);
		     // Increments variable by 1. Used for request code
				i++;
				
			 // Calls addOverlay method
				addOverlay(latitude, longitude);	    	
		    	}
		    }	
		
		
		/**
		 * @param latitude
		 * @param longitude
		 * Method for setting up map overlays
		 */
		private void addOverlay(double latitude, double longitude)
		{
		 // Variable that holds the current list of overlays
			List<Overlay> mapOverlays = mapView.getOverlays();
		 // Variable that holds the image file of the overlay
			Drawable drawable = this.getResources().getDrawable(R.drawable.reddot);
		 // Variable that holds information on overlay
			overlays itemizedoverlay = new overlays(drawable, this);
		 // Variable that holds the latitude and longitude of the proximity alert in
		 // microdegrees, calculated by multiplying latitude/longitude by 1E6. Array double cast as int
			GeoPoint point = new GeoPoint((int) (latitude * 1E6), (int) (longitude * 1E6));
		 // Variable that holds information on the position, plus any associated text, of an overlay item
			OverlayItem overlayitem = new OverlayItem(point,"","");
		 // Overlay item information added
			itemizedoverlay.addOverlay(overlayitem);
		 // Overlay item added to map
			mapOverlays.add(itemizedoverlay);
		}
		
		
		/**
		 * @param latitude
		 * @param longitude
		 * @param requestCode
		 * @param isRight
		 * @param vibrationPattern
		 * Method for setting up proximity alerts
		 */
		private void addProximity(double latitude, double longitude, int requestCode, boolean isRight, int vibrationPattern)
		{		
		 // Variable for radius of proximity alert in meters
	    	float radius = 5f;    	
	     // Variable for length of time proximity alert lasts. -1 means no expiry
	    	long expiration = -1;
	     // Variable for obtaining location services
	    	LocationManager locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);   
	     // Variable for intent. Parameter is for type of action
	    	Intent intent = new Intent(PROXIMITY_INTENT_ACTION);
	     // Turn direction information added to intent
	    	intent.putExtra("isRight", isRight);
	     // Vibration pattern information added to intent
	    	intent.putExtra("vibrationPattern", vibrationPattern);
	     // Variable that holds information on type of intent and action to perform
	    	PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), requestCode, intent, PendingIntent.FLAG_CANCEL_CURRENT);
	     // Proximity alert is added to location manager
	    	locManager.addProximityAlert(latitude, longitude, radius, expiration, pendingIntent);
		}
		
		
		   /*
		 * Method for when app resumes focus
		 */
		@Override
		   protected void onResume() {
		   	super.onResume();
		 // When activity resumes register for location updates
		   	registerReceiver(new proximityAlert(), intentFilter);
		  	myLocationOverlay.enableMyLocation();
		   }

		   /*
		 * Method for when app has lost focus
		 */
		@Override
		   protected void onPause() {
		   	super.onPause();
		 // When activity pauses remove listening for location updates
		   	myLocationOverlay.disableMyLocation();
		   }

		/*
		 * Automatically generated method to check if a route is displayed on map
		 */
		@Override
		protected boolean isRouteDisplayed() {
			// TODO Auto-generated method stub
			return false;
		}
	}