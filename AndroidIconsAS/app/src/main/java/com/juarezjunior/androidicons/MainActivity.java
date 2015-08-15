package com.juarezjunior.androidicons;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.juarezjunior.androidicons.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private List<Field> myDataSources() {
		
		Field[] fields = android.R.drawable.class.getDeclaredFields();
		List<Field> data = new ArrayList<Field>();
		for (Field field: fields) {
			if (field.getName().startsWith("ic_menu_")) {
				data.add(field);
			}
		}
		return data;
	}

	private class MyListAdapter extends ArrayAdapter<Field> {
		private final Context context;
		private List<Field> dataList;

		public MyListAdapter(Context context, List<Field> data) {
			super(context, R.layout.list_entry, data);
			this.context = context;
			this.dataList = data;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View view = inflater.inflate(R.layout.list_entry, parent, false);
			Field current = dataList.get(position);
			int resourceId = 0;
			try {
				resourceId = current.getInt(new Object());
			} catch (Exception e) {
			}

			ImageView icon = (ImageView)view.findViewById(R.id.myIcon);;
			icon.setImageResource(resourceId);
			TextView title = (TextView)view.findViewById(R.id.textViewAsTitle);
			title.setText(current.getName());
			return view;
		}
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ListView list = (ListView) findViewById(R.id.dataList);
		list.setAdapter(new MyListAdapter(this, myDataSources()));
	}
}