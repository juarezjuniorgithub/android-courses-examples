package com.juarezjunior.implictintent;



import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.juarezjunior.implictintent.R;

public class InvokeImplicitIntent extends Activity {
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);        
        viewContacts();        
    }
    
    private void viewContacts() {
        try {
            Button viewContacts = (Button)findViewById(R.id.viewContactsUsingImplicitIntent);
            
            viewContacts.setOnClickListener(new OnClickListener() {
            	
            	public void onClick(View v) {
            		Intent contacts = new Intent();
            		contacts.setAction(android.content.Intent.ACTION_VIEW);
            		contacts.setData(ContactsContract.Contacts.CONTENT_URI);
            		startActivity(contacts);
            	}
            });
            }catch (ActivityNotFoundException anfe) {
            	Log.e("ViewContacts","Viewing of Contacts failed", anfe);
            }    	
    } 
}