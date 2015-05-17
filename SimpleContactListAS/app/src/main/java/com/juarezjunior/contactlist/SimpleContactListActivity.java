package com.juarezjunior.contactlist;

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

public class SimpleContactListActivity extends ListActivity {

	private ListAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Uri uri = ContactsContract.Contacts.CONTENT_URI;
		Cursor contactsQuery = getContentResolver().query(uri, null, null,
				null, null);
		String[] attributes = new String[] { ContactsContract.Contacts.DISPLAY_NAME_PRIMARY };
		startManagingCursor(contactsQuery);
		int[] fields = new int[] { android.R.id.text1 };
		adapter = new SimpleCursorAdapter(this,
				android.R.layout.simple_list_item_2, contactsQuery, attributes,
				fields);
		setListAdapter(adapter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int p, long id) {
		super.onListItemClick(l, v, p, id);
		Cursor row = (Cursor) adapter.getItem(p);
		String columnName = ContactsContract.Contacts.DISPLAY_NAME;
		String name = row.getString(row.getColumnIndexOrThrow(columnName));
		Toast.makeText(this, name, Toast.LENGTH_LONG).show();
	}

}
