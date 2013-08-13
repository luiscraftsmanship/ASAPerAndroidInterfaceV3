package com.livewatch.asaperandroidinterfacev3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;

public class ConvertListActivity extends SherlockActivity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
         
        super.onCreate(savedInstanceState);
        setContentView(R.layout.convertlist_layout);
        
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM); 
		getSupportActionBar().setCustomView(R.layout.convertlist_menu);

    }
 
    // note that these are actionbarsherlock.view.Menu objects that are
    // created in this method.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	
    	MenuInflater inflater = getSupportMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
 
   
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