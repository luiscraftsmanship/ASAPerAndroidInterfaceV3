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


import java.util.ArrayList;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.text.Html;
//import android.view.ContextMenu;
//import android.view.LayoutInflater;
//import android.view.Menu;
//import android.view.MenuItem;
import android.view.View;
//import android.view.ContextMenu.ContextMenuInfo;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
import android.widget.AdapterView;
//import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class Messages extends SherlockFragmentActivity {
	ListView msgList;
	ArrayList<MessageDetails> details;
	AdapterView.AdapterContextMenuInfo info;
	

	// Declare Variable
			DrawerLayout mDrawerLayout;
			ListView mDrawerList;
			ActionBarDrawerToggle mDrawerToggle;
			MenuListAdapterHome mMenuAdapter;
			String[] title;
			int[] icon;
			Fragment fragment1 = new Fragment1();
			Fragment fragment2 = new Fragment2();
			Fragment fragment3 = new Fragment3();

		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView(R.layout.home_layout);
			
			// Generate title
						title = new String[] { "Settings",
								"Chat", 
								"Community",
								"Contacts", 
								"Convert to Club"};


						// Generate icon
						icon = new int[] { R.drawable.settings_icon2x,
								R.drawable.blasts_menu_icon2x, 
								R.drawable.blue_communities2x,
								R.drawable.blue_contacts2x,
								R.drawable.blue_clubs2x };

						// Locate DrawerLayout in drawer_main.xml
						mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

						// Locate ListView in drawer_main.xml
						mDrawerList = (ListView) findViewById(R.id.left_drawer);

						// Set a custom shadow that overlays the main content when the drawer
						// opens
						mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
								GravityCompat.START);

						// Pass results to MenuListAdapter Class
						mMenuAdapter = new MenuListAdapterHome(this, title, icon);

						// Set the MenuListAdapter to the ListView
						mDrawerList.setAdapter(mMenuAdapter);

						// Capture button clicks on side menu
						mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

						getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM); 
						getSupportActionBar().setCustomView(R.layout.home_menu);
						
						getSupportActionBar().setIcon(R.drawable.blue_lists2x );
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
						
			msgList = (ListView) findViewById(R.id.MessageList);
						
						details = new ArrayList<MessageDetails>();
						    
						MessageDetails Detail;
						Detail = new MessageDetails();
						Detail.setIcon(R.drawable.profileimagedefault);
						Detail.setName("Bill Murray");
						Detail.setSub("Dinner");
						Detail.setDesc("Got 2 tix to the Broncos for Sat! Row G, 34 and 35. Asking for face value: $180. I throw in VIP parking for free");
						Detail.setTime("12/12/2012 12:12");
						details.add(Detail);
						
						Detail = new MessageDetails();
						Detail.setIcon(R.drawable.profileimagedefault);
						Detail.setName("Bill Murray");
						Detail.setSub("Party");
						Detail.setDesc("Are you available to house sit little Johnny on Saturday from 2pm to 8pm?");
						Detail.setTime("13/12/2012 10:12");
						details.add(Detail);
						
						Detail = new MessageDetails();
						Detail.setIcon(R.drawable.profileimagedefault);
						Detail.setName("Bill Murray");
						Detail.setSub("Mail");
						Detail.setDesc("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
						Detail.setTime("13/12/2012 02:12");
						details.add(Detail);		
						
						msgList.setAdapter(new CustomAdapter(details , this));

						registerForContextMenu(msgList);
						
						msgList.setOnItemClickListener(new OnItemClickListener() {
							   public void onItemClick(AdapterView<?> a, View v, int position, long id) {
								   System.out.println("Name: "+details.get(position).getName());
								   String s =(String) ((TextView) v.findViewById(R.id.From)).getText();
								   Toast.makeText(Messages.this, s, Toast.LENGTH_LONG).show();  
							   }
					   });	

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
		protected void onResume() {
			// TODO Auto-generated method stub
			super.onResume();			
	}
		
		public void clickButtonBlast(View view) {
		    //Intent intent = new Intent(this, BlastActivity.class);
		    //startActivity(intent);
		}
		
		//public void sendMessage(View view) {
		    //Intent intent = new Intent(this, MessageChatActivity.class);
		    //startActivity(intent);
		//}
		
		@Override
		public boolean onOptionsItemSelected(MenuItem item) {

			if (item.getItemId() == android.R.id.home) {

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
			switch (position) {
			//case 0:
				
				//break;
			case 1:
				Intent prefIntent = new Intent(Messages.this,
	                    MessageChatActivity.class);
	            Messages.this.startActivity(prefIntent);
				break;
			case 2:
				Intent prefIntent2 = new Intent(Messages.this,
	                    CommunityActivity.class);

	            Messages.this.startActivity(prefIntent2);

				break;
			case 3:
				//ft.replace(R.id.content_frame, fragment3);
				/*Intent prefIntent3 = new Intent(Messages.this,
	                    ContactsActivity.class);

	            Messages.this.startActivity(prefIntent3);*/

				break;
			case 4:
				//ft.replace(R.id.content_frame, fragment3);
				/*Intent prefIntent4 = new Intent(Messages.this,
	                    ConvertListActivity.class);

	            Messages.this.startActivity(prefIntent4);*/

				break;
			}
			//ft.commit();
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
