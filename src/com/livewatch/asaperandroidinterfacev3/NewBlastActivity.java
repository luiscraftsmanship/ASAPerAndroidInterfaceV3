package com.livewatch.asaperandroidinterfacev3;

//import android.content.Intent;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
//import android.view.View;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
//import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
//import com.livewatch.asapersherlockactionbar.R;
import com.actionbarsherlock.view.MenuItem;
//import com.livewatch.asapersherlockactionbar.LoginActivity;

public class NewBlastActivity extends SherlockActivity {
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
         
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_blast_layout);
        
        //getSupportActionBar().setTitle(Html.fromHtml("New Blast"));
        //getSupportActionBar().setLogo(R.drawable.back_blue_arrow2x);
        //getSupportActionBar().setHomeButtonEnabled(true);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM); 
		getSupportActionBar().setCustomView(R.layout.new_blast_menu);
		
        
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
    	if(item.getItemId() == R.id.blast_button){
    		 
            Intent prefIntent = new Intent(NewBlastActivity.this,
                    ReplyOptionsActivity.class);

            NewBlastActivity.this.startActivity(prefIntent);
        	}
       return true;
    }*/
    
    public void clickButtonNext(View view) {
	    //Intent intent = new Intent(this, ReplyOptionsActivity.class);
	    //startActivity(intent);
	}

}
