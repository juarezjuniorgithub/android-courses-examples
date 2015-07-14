package com.juarezjunior.anotherbasicfragment;

import com.juarezjunior.anotherbasicfragment.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MenuFragment extends Fragment {	
	private IOnItemClicked callBack;	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {		
		View view = inflater.inflate(R.layout.menu, container, false);		
		((Button) view.findViewById(R.id.menu1)).setOnClickListener(new OnClickMenuItemListener());;
		((Button) view.findViewById(R.id.menu2)).setOnClickListener(new OnClickMenuItemListener());;
		((Button) view.findViewById(R.id.menu3)).setOnClickListener(new OnClickMenuItemListener());;
		((Button) view.findViewById(R.id.menu4)).setOnClickListener(new OnClickMenuItemListener());;		
		return view;
	}	
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);		
		try {
			callBack = (IOnItemClicked) activity;
		} catch (ClassCastException e) {
			Log.e("The Menu Fragment", activity.toString() + " must implement IOnItemClicked!");
		}
	}
	
	
	protected class OnClickMenuItemListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {			
			callBack.onItemClicked(v.getId());
		}
	}

}
