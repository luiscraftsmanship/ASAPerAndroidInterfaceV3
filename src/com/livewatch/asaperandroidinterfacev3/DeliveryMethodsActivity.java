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


public class DeliveryMethodsActivity extends SherlockActivity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
         
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delivery_methods_layout);
        
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM); 
		getSupportActionBar().setCustomView(R.layout.delivery_methods_menu);
        
    }
 
    // note that these are actionbarsherlock.view.Menu objects that are
    // created in this method.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	
    	MenuInflater inflater = getSupportMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
 
    }
    
    
    public void clickButtonNext(View view) {
//	    Intent intent = new Intent(this, PreviewActivity.class);
	//    startActivity(intent);
	}

}
