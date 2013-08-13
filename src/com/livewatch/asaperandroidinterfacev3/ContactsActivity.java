package com.livewatch.asaperandroidinterfacev3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;

public class ContactsActivity extends SherlockActivity {
	@Override
    public void onCreate(Bundle savedInstanceState) {
         
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacts_layout);
        
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM); 
		getSupportActionBar().setCustomView(R.layout.contacts_menu);
		
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
          Intent homeIntent = new Intent(this, Messages.class);
          homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
          startActivity(homeIntent);
        }
      return (super.onOptionsItemSelected(menuItem));

    }
    
    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	if(item.getItemId() == R.id.buttonDone){
    		 
            Intent prefIntent = new Intent(CreateProfileActivity.this,
                    Messages.class);

            CreateProfileActivity.this.startActivity(prefIntent);
        	}
       return true;
    }*/
    
    /*public void clickButtonHome(View view) {
	    Intent intent = new Intent(this, Messages.class);
	    startActivity(intent);
	}*/
 
}