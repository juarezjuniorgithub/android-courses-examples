package com.juarezjunior.asynctask;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.juarezjunior.asynctask.R;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		ArrayList<News> bitmapDetails = getListData();
		final ListView lv1 = (ListView) findViewById(R.id.list);
		lv1.setAdapter(new ListRowAdapter(this, bitmapDetails));
		lv1.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> a, View v, int position, long id) {
				Object o = lv1.getItemAtPosition(position);
				News newsData = (News) o;
				Toast.makeText(MainActivity.this, "News item selected :" + " " + newsData,
						Toast.LENGTH_SHORT).show();
			}

		});

	}

	private ArrayList<News> getListData() {
		ArrayList<News> results = new ArrayList<News>();
		News newsData = new News();
		newsData.setHeadline("Battle for Tripoli");
		newsData.setReporterName("BBC Scott Rymes");
		newsData.setDate("August 08, 2014, 11:11");
		newsData.setUrl("http://up.metropol247.co.uk/woah/Simulcast%205.jpg");
		results.add(newsData);
		newsData = new News();
		newsData.setHeadline("Engineering Prize");
		newsData.setReporterName("BBC Kent Scott");
		newsData.setDate("June 13, 2013, 13:11");
		newsData.setUrl("http://i51.photobucket.com/albums/f363/TheAxG/BBCNewsBreaking.png");
		results.add(newsData);
		return results;
	}
}
