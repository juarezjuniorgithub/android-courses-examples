package com.juarezjunior.anotherbasicfragment;

import com.juarezjunior.anotherbasicfragment.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ContentFragment extends Fragment {

	int clickedMenu = 0;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {		
		View currentView = inflater.inflate(R.layout.content, container, false);		
		if (getArguments() != null) {
			Bundle args = getArguments();
			clickedMenu = args.getInt("menu");
		}		
		TextView txt = (TextView) currentView.findViewById(R.id.content_text);
		txt.setText("Content Page..." + clickedMenu);		
		return currentView;
	}
	
}
