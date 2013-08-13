package com.livewatch.asaperandroidinterfacev3;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;

public class MainActivity extends Activity {
	
	//private float mx, my;
    //private float curX, curY;
	
	private ScrollView vScroll;
    private HorizontalScrollView hScroll;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome_layout);
		
		 //vScroll = (ScrollView) findViewById(R.id.vScroll);
	     //hScroll = (HorizontalScrollView) findViewById(R.id.hScroll);
	        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	/** Called when the user clicks the Send button */
	public void sendViewLogin(View view) {
	    //Intent intent = new Intent(this, LoginActivity.class);
	    //startActivity(intent);
	}
	
	public void sendViewProfile(View view) {
	    //Intent intent = new Intent(this, CreateProfileActivity.class);
	    //startActivity(intent);
	}
	

}
