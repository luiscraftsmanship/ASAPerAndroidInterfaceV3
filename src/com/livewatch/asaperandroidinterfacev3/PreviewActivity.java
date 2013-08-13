package com.livewatch.asaperandroidinterfacev3;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
//import com.actionbarsherlock.view.Menu;
//import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuInflater;


public class PreviewActivity extends SherlockActivity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
         
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preview_layout);
        
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM); 
		getSupportActionBar().setCustomView(R.layout.preview_menu);
		
		getSupportActionBar().setIcon(R.drawable.back_blue_arrow2x );
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
		
    }
	
	@Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
        case android.R.id.home:
          Intent homeIntent = new Intent(this, NewBlastActivity.class);
          homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
          startActivity(homeIntent);
        }
      return (super.onOptionsItemSelected(menuItem));

    }

 
    // note that these are actionbarsherlock.view.Menu objects that are
    // created in this method.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	
    	MenuInflater inflater = getSupportMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    
    
    public void clickButtonSend(View view) {
	    Intent intent = new Intent(this, Messages.class);
	    startActivity(intent);
	}

}
