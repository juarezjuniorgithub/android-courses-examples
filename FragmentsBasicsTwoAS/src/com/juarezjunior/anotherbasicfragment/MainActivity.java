package com.juarezjunior.anotherbasicfragment;

import com.juarezjunior.anotherbasicfragment.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

public class MainActivity extends FragmentActivity implements IOnItemClicked {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);		
		MenuFragment menuFrag = new MenuFragment();		
		if (findViewById(R.id.main) != null) {			
			getSupportFragmentManager().beginTransaction().add(R.id.main, menuFrag).commit();
			
		} else if (findViewById(R.id.content) != null) {			
			FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
			transaction.add(R.id.menu, menuFrag); 
			transaction.add(R.id.content, new ContentFragment());			
			transaction.commit();
		}
	}

	@Override
	public void onItemClicked(int menuItem) {
		Fragment newFragment = null;
		switch (menuItem) {
		case R.id.menu1:			
			newFragment = getNewFragment(1); 
			break;
		case R.id.menu2:			
			newFragment = getNewFragment(2); 
			break;
		case R.id.menu3:			
			newFragment = getNewFragment(3); 
			break;			
		case R.id.menu4:			
			newFragment = getNewFragment(4); 
			break;
		}
		
		if (newFragment != null) {			
			FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();			
			if (findViewById(R.id.main) != null) {				
				transaction.replace(R.id.main, newFragment); 				
				transaction.addToBackStack(null);
				
			} else if (findViewById(R.id.content) != null) {				
				transaction.replace(R.id.content, newFragment); 
			}		
			transaction.commit();
		}
	}

	
	private Fragment getNewFragment(int menu) {		
		ContentFragment fragment = new ContentFragment();		
		Bundle args = new Bundle();
		args.putInt("menu", menu);
		fragment.setArguments(args);		
		return fragment;
	}
}
