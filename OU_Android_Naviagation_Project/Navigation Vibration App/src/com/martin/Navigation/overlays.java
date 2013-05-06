package com.martin.Navigation;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;

import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;

public class overlays extends ItemizedOverlay {
	// Array that stores all overlays
		private ArrayList<OverlayItem> mOverlays = new ArrayList<OverlayItem>();
	 // Variable to be used for context
		Context mContext;
		
	 // Constructor for class
		public overlays(Drawable defaultMarker) {
		 // Sets overlay position
			super(boundCenterBottom(defaultMarker));
		}
		
	 // Alternative constructor for class
		public overlays(Drawable defaultMarker, Context context) {
		  // Sets overlay position 
			  super(boundCenterBottom(defaultMarker));
		  // Variable assigned value. Used to handle touch events
			  mContext = context;
			}

		/* 
		 * Method used to return number of overlays
		 */
		@Override
		protected OverlayItem createItem(int i) {
		 // Returns overlay item at position i
			return mOverlays.get(i);
		}

		/* 
		 * Method used to return number of overlays
		 */
		@Override
		public int size() {
		 // Returns number of overlays
			return mOverlays.size();
		}
		
//		@Override
//		protected boolean onTap(int index) {
//		  OverlayItem item = mOverlays.get(index);
//		  AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
//		  dialog.setTitle(item.getTitle());
//		  dialog.setMessage(item.getSnippet());
//		  dialog.show();
//		  return true;
//		}
		
		/**
		 * @param overlay
		 * Method used to add an overlay 
		 */
		public void addOverlay(OverlayItem overlay) {
		 // Adds overlay
		    mOverlays.add(overlay);
		 // Takes each overlay and prepares them to be drawn
		    populate();
		}

	}

