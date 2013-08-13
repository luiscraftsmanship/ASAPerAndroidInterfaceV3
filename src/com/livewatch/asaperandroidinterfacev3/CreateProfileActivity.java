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
		
		getSupportActionBar().setIcon(R.drawable.back_blue_arrow2x );
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
		
    }
 
    // note that these are actionbarsherlock.view.Menu objects that are
    // created in this method.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	
    	MenuInflater inflater = getSupportMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
  
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
        case android.R.id.home:
          Intent homeIntent = new Intent(this, MainActivity.class);
          homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
          startActivity(homeIntent);
        }
      return (super.onOptionsItemSelected(menuItem));

    }
        
    public void clickButtonHome(View view) {
	    Intent intent = new Intent(this, Messages.class);
	    startActivity(intent);
	}
 
}
