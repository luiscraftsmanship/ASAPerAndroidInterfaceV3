package com.livewatch.asaperandroidinterfacev3;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
//import com.livewatch.asaperhomelistview.BlastActivity;
//import com.livewatch.asaperhomelistview.NewBlastActivity;
//import com.livewatch.asaperhomelistview.R;
//import com.livewatch.asaperhomelistview.Weather;
//import com.livewatch.asaperhomelistview.WeatherAdapter;
//import com.livewatch.asapersherlockactionbar.R;
 
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.support.v4.view.GravityCompat;
import android.text.Html;
 
public class BlastActivity extends SherlockFragmentActivity {
	
	private ListView listView1;
 
    // Declare Variable
    DrawerLayout mDrawerLayout;
    ListView mDrawerList;
    ActionBarDrawerToggle mDrawerToggle;
    MenuListAdapterBlast mMenuAdapter;
    String[] title;
    int[] icon;
    Fragment award_blast = new AwardBlast();
    Fragment add_recipient = new AddRecipient();
    Fragment delete_recipient = new DeleteRecipient();
    Fragment cancel_blast = new CancelBlast();
    
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blast_layout);
        
        Weather weather_data[] = new Weather[]
                {
                    new Weather(R.drawable.profileimagedefault, "Dan Aykroyd"),
                    new Weather(R.drawable.profileimagedefault, "Harold Ramis"),
                    new Weather(R.drawable.profileimagedefault, "Tim Noon"),
                    new Weather(R.drawable.profileimagedefault, "John Ferguson"),
                    new Weather(R.drawable.profileimagedefault, "Todd Frische")
                };
               
                WeatherAdapter adapter = new WeatherAdapter(this,
                        R.layout.listview_item_row, weather_data);
               
               
                listView1 = (ListView)findViewById(R.id.listView1);
                
                //View header = (View)getLayoutInflater().inflate(R.layout.listview_header_row, null);
                //listView1.addHeaderView(header);
               
                listView1.setAdapter(adapter);
 
        // Generate title
        title = new String[] { "Award Blast", 
        		"Add Recipient",
                "Delete Recipient",
                "Cancel Blast" };
 
    
        // Generate icon
        icon = new int[] { R.drawable.award_blast, 
        		R.drawable.add_group_icon,
                R.drawable.remove_contacts,
                R.drawable.cancel_blast };
 
        // Locate DrawerLayout in drawer_main.xml
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
 
        // Locate ListView in drawer_main.xml
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
 
        // Set a custom shadow that overlays the main content when the drawer
        // opens
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
                GravityCompat.START);
 
        // Pass results to MenuListAdapter Class
        mMenuAdapter = new MenuListAdapterBlast(this, title, 
        		//subtitle, 
        		icon);
 
        // Set the MenuListAdapter to the ListView
        mDrawerList.setAdapter(mMenuAdapter);
 
        // Capture button clicks on side menu
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
 
  
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM); 
		getSupportActionBar().setCustomView(R.layout.blast_menu);
		
		getSupportActionBar().setIcon(R.drawable.back_blue_arrow2x);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
  
        // ActionBarDrawerToggle ties together the the proper interactions
        // between the sliding drawer and the action bar app icon
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.drawable.ic_drawer, R.string.drawer_open,
                R.string.drawer_close) {
 
            public void onDrawerClosed(View view) {
                // TODO Auto-generated method stub
                super.onDrawerClosed(view);
            }
 
            public void onDrawerOpened(View drawerView) {
                // TODO Auto-generated method stub
                super.onDrawerOpened(drawerView);
            }
        };
 
        mDrawerLayout.setDrawerListener(mDrawerToggle);
 
        if (savedInstanceState == null) {
            selectItem(0);
        }
    }
 
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater().inflate(R.menu.blast_menu, menu);
        return true;
    }
    
 
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
 
        if (item.getItemId() == R.id.blue_manage_blast_button) {
 
            if (mDrawerLayout.isDrawerOpen(mDrawerList)) {
                mDrawerLayout.closeDrawer(mDrawerList);
            } else {
                mDrawerLayout.openDrawer(mDrawerList);
            }
        }
 
        return super.onOptionsItemSelected(item);
    }
 
    // The click listener for ListView in the navigation drawer
    private class DrawerItemClickListener implements
            ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                long id) {
            selectItem(position);
        }
    }
 
    private void selectItem(int position) {
 
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        // Locate Position
        switch (position) {
        case 0:
            ft.replace(R.id.content_frame, award_blast);
            break;
        case 1:
        	Intent prefIntent = new Intent(BlastActivity.this,
                    NewBlastActivity.class);

            BlastActivity.this.startActivity(prefIntent);
            break;
        case 2:
            ft.replace(R.id.content_frame, delete_recipient);
            break;
        case 3:
            ft.replace(R.id.content_frame, cancel_blast);
            break;
        
        }
        ft.commit();
        mDrawerList.setItemChecked(position, true);
        // Close drawer
        mDrawerLayout.closeDrawer(mDrawerList);
    }
 
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }
 
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        mDrawerToggle.onConfigurationChanged(newConfig);
    }
}