package com.livewatch.asaperandroidinterfacev3;

import java.util.ArrayList;
import java.util.Random;

import android.app.ListActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

/**
 * MessageActivity is a main Activity to show a ListView containing Message items
 * 
 * @author Adil Soomro
 *
 */
public class MessageChatActivity extends ListActivity {
	/** Called when the activity is first created. */

	ArrayList<MessageChat> messages;
	AwesomeAdapterChat adapter;
	EditText text;
	static Random rand = new Random();	
	static String sender;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chat_layout);
		
		text = (EditText) this.findViewById(R.id.text);
		
		sender = UtilityChat.sender[rand.nextInt( UtilityChat.sender.length-1)];
		this.setTitle(sender);
		messages = new ArrayList<MessageChat>();

		messages.add(new MessageChat("Hello", false));
		messages.add(new MessageChat("Hi!", true));
		messages.add(new MessageChat("Wassup??", false));
		messages.add(new MessageChat("nothing much, working on speech bubbles.", true));
		messages.add(new MessageChat("you say!", true));
		messages.add(new MessageChat("oh thats great. how are you showing them", false));
		

		adapter = new AwesomeAdapterChat(this, messages);
		setListAdapter(adapter);
		addNewMessage(new MessageChat("mmm, well, using 9 patches png to show them.", true));
	}
	public void sendMessage(View v)
	{
		String newMessage = text.getText().toString().trim(); 
		if(newMessage.length() > 0)
		{
			text.setText("");
			addNewMessage(new MessageChat(newMessage, true));
			new SendMessage().execute();
		}
	}
	private class SendMessage extends AsyncTask<Void, String, String>
	{
		@Override
		protected String doInBackground(Void... params) {
			try {
				Thread.sleep(2000); //simulate a network call
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			this.publishProgress(String.format("%s started writing", sender));
			try {
				Thread.sleep(2000); //simulate a network call
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.publishProgress(String.format("%s has entered text", sender));
			try {
				Thread.sleep(3000);//simulate a network call
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
			return UtilityChat.messages[rand.nextInt(UtilityChat.messages.length-1)];
			
			
		}
		@Override
		public void onProgressUpdate(String... v) {
			
			if(messages.get(messages.size()-1).isStatusMessage)//check wether we have already added a status message
			{
				messages.get(messages.size()-1).setMessage(v[0]); //update the status for that
				adapter.notifyDataSetChanged(); 
				getListView().setSelection(messages.size()-1);
			}
			else{
				addNewMessage(new MessageChat(true,v[0])); //add new message, if there is no existing status message
			}
		}
		@Override
		protected void onPostExecute(String text) {
			if(messages.get(messages.size()-1).isStatusMessage)//check if there is any status message, now remove it.
			{
				messages.remove(messages.size()-1);
			}
			
			addNewMessage(new MessageChat(text, false)); // add the orignal message from server.
		}
		

	}
	void addNewMessage(MessageChat m)
	{
		messages.add(m);
		adapter.notifyDataSetChanged();
		getListView().setSelection(messages.size()-1);
	}
	
	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.blast_menu, menu);
		return true;
	}*/
}