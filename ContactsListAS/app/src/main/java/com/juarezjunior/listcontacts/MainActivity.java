package com.juarezjunior.listcontacts;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.app.ListActivity;
import android.database.Cursor;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends ListActivity {
	
	private ListAdapter adaptador;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Uri uri = ContactsContract.Contacts.CONTENT_URI;
		Cursor contactsQuery = getContentResolver().query(uri, null, null, null, null);
		String [] columnsToShow = new String[] {
			ContactsContract.Contacts._ID,
			ContactsContract.Contacts.DISPLAY_NAME_ALTERNATIVE
			};
		startManagingCursor(contactsQuery);
		int [] fieldsToShow = new int[] { 
			android.R.id.text1,
			android.R.id.text2};
		adaptador = new SimpleCursorAdapter(
				this, android.R.layout.simple_list_item_2, contactsQuery, 
				columnsToShow, fieldsToShow);
		setListAdapter(adaptador);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int p, long id) {
		super.onListItemClick(l, v, p, id);
		Cursor myLine = (Cursor)adaptador.getItem(p);
		String myColumn = ContactsContract.Contacts.DISPLAY_NAME;
		String myName = myLine.getString(myLine.getColumnIndexOrThrow(myColumn));
		Toast.makeText(this,  myName, Toast.LENGTH_SHORT).show();
	}

}
