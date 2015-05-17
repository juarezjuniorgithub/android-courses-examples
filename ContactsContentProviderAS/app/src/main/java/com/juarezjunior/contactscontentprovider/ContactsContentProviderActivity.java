package com.juarezjunior.contactscontentprovider;

import java.util.ArrayList;

import com.juarezjunior.contactscontentprovider.R;

import android.app.Activity;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.os.Bundle;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.CommonDataKinds.StructuredName;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ContactsContentProviderActivity extends Activity {

	EditText nameEdt, phoneEdt;
	TextView contactTxtView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.main);

		Button view = (Button) findViewById(R.id.viewButton);
		Button create = (Button) findViewById(R.id.createButton);
		Button update = (Button) findViewById(R.id.updateButton);
		Button delete = (Button) findViewById(R.id.deleteButton);

		nameEdt = (EditText) findViewById(R.id.etName);
		phoneEdt = (EditText) findViewById(R.id.etPhoneNO);

		contactTxtView = (TextView) findViewById(R.id.tvContactsText);

		view.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				viewContacts();
			}
		});

		create.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				String name = nameEdt.getText().toString();
				String phone = phoneEdt.getText().toString();

				if (name.equals("") && phone.equals("")) {
					Toast.makeText(getApplicationContext(),
							"Contact fields are empty!", Toast.LENGTH_SHORT)
							.show();
					return;
				}

				createContact(name, phone);
			}
		});

		update.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				String name = nameEdt.getText().toString();
				String phone = phoneEdt.getText().toString();

				if (name.equals("") && phone.equals("")) {
					Toast.makeText(getApplicationContext(), "Fields are empty",
							Toast.LENGTH_SHORT).show();
					return;
				}

				updateContact(name, phone);
				
			}
		});

		delete.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				String name = nameEdt.getText().toString();

				if (name.equals("")) {
					Toast.makeText(getApplicationContext(),
							"Name Field is empty", Toast.LENGTH_SHORT).show();
					return;
				}

				deleteContact(name);
				
			}
		});
	}

	private void viewContacts() {
		
		ContentResolver contentresolver = getContentResolver();		
		Cursor cursor = contentresolver.query(
				ContactsContract.Contacts.CONTENT_URI, null, null, null, null);

		int count = cursor.getCount();

		if (count > 0) {
			String contactDetails = "";

			while (cursor.moveToNext()) {

				String columnId = ContactsContract.Contacts._ID;
				int cursorIndex = cursor.getColumnIndex(columnId);

				String id = cursor.getString(cursorIndex);

				String name = cursor
						.getString(cursor
								.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

				int numCount = Integer
						.parseInt(cursor.getString(cursor
								.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)));

				if (numCount > 0) {
					Cursor phoneCursor = contentresolver.query(
							ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
							null,
							ContactsContract.CommonDataKinds.Phone.CONTACT_ID
									+ " = ?", new String[] { id }, null);

					while (phoneCursor.moveToNext()) {
						String phoneNo = phoneCursor
								.getString(phoneCursor
										.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

						contactDetails += "Name: " + name + ", Phone No: "
								+ phoneNo + "\n";

					}

					phoneCursor.close();
				}
			}
			contactTxtView.setText(contactDetails);
		}
	}

	private void createContact(String name, String phone) {

		Cursor cursor = getContentResolver().query(
				ContactsContract.Contacts.CONTENT_URI, null, null, null, null);

		int count = cursor.getCount();

		if (count > 0) {
			while (cursor.moveToNext()) {

				String display_name = ContactsContract.Contacts.DISPLAY_NAME;
				int colIndex = cursor.getColumnIndex(display_name);
				String existName = cursor.getString(colIndex);

				if (existName.equals(name)) {
					Toast.makeText(ContactsContentProviderActivity.this,
							"The contact " + name + " already exists!",
							Toast.LENGTH_SHORT).show();
					return;
				}
			}
		}

		ArrayList<ContentProviderOperation> ops = new ArrayList<ContentProviderOperation>();
		int rawContactInsertIndex = ops.size();

		ops.add(ContentProviderOperation.newInsert(RawContacts.CONTENT_URI)
				.withValue(RawContacts.ACCOUNT_TYPE, null)
				.withValue(RawContacts.ACCOUNT_NAME, null).build());
		ops.add(ContentProviderOperation
				.newInsert(Data.CONTENT_URI)
				.withValueBackReference(Data.RAW_CONTACT_ID,
						rawContactInsertIndex)
				.withValue(Data.MIMETYPE, StructuredName.CONTENT_ITEM_TYPE)
				.withValue(StructuredName.DISPLAY_NAME, name).build());
		ops.add(ContentProviderOperation
				.newInsert(Data.CONTENT_URI)
				.withValueBackReference(Data.RAW_CONTACT_ID,
						rawContactInsertIndex)
				.withValue(Data.MIMETYPE, Phone.CONTENT_ITEM_TYPE)
				.withValue(Phone.NUMBER, phone)
				.withValue(Phone.TYPE, Phone.TYPE_MOBILE).build());

		try {
			getContentResolver().applyBatch(ContactsContract.AUTHORITY, ops);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (OperationApplicationException e) {
			e.printStackTrace();
		}

		Toast.makeText(
				ContactsContentProviderActivity.this,
				"Created a new contact: " + name + ",phone #: "
						+ phone, Toast.LENGTH_SHORT).show();

	}

	private void updateContact(String name, String phone) {

		ContentResolver cr = getContentResolver();

		String where = ContactsContract.Data.DISPLAY_NAME + " = ? ";
		String[] params = new String[] { name };

		ArrayList<ContentProviderOperation> ops = new ArrayList<ContentProviderOperation>();

		ops.add(ContentProviderOperation
				.newUpdate(ContactsContract.Data.CONTENT_URI)
				.withSelection(where, params)
				.withValue(ContactsContract.CommonDataKinds.Phone.NUMBER, phone)
				.build());

		try {
			cr.applyBatch(ContactsContract.AUTHORITY, ops);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (OperationApplicationException e) {
			e.printStackTrace();
		}

		Toast.makeText(ContactsContentProviderActivity.this,
				"Updated the phone number of " + name + " to: " + phone,
				Toast.LENGTH_SHORT).show();
	}

	private void deleteContact(String name) {

		ContentResolver cr = getContentResolver();
		String where = ContactsContract.Data.DISPLAY_NAME + " = ? ";
		String[] params = new String[] { name };

		ArrayList<ContentProviderOperation> ops = new ArrayList<ContentProviderOperation>();
		ops.add(ContentProviderOperation
				.newDelete(ContactsContract.RawContacts.CONTENT_URI)
				.withSelection(where, params).build());
		try {
			cr.applyBatch(ContactsContract.AUTHORITY, ops);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (OperationApplicationException e) {
			e.printStackTrace();
		}

		Toast.makeText(ContactsContentProviderActivity.this,
				"Deleted the contact " + name + "!",
				Toast.LENGTH_SHORT).show();

	}
}
