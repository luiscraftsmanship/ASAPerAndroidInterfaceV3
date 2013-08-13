package com.livewatch.asaperandroidinterfacev3;


import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
 
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
 
// Derive from SherlockActivity
public class CreateProfileActivity extends SherlockActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
         
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_profile_layout);
        
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM); 
		getSupportActionBar().setCustomView(R.layout.create_profile_menu);
		

    }
 
    // note that these are actionbarsherlock.view.Menu objects that are
    // created in this method.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	
    	MenuInflater inflater = getSupportMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
 
   
    }
    
        
    public void clickButtonHome(View view) {
	    //Intent intent = new Intent(this, Messages.class);
	    //startActivity(intent);
	}
 
}
