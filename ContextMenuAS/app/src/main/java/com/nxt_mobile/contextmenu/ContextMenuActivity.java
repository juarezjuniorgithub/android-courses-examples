package com.nxt_mobile.contextmenu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.nxt_mobile.contextmenu.R;
import android.os.Bundle;
import android.app.ListActivity;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.AdapterContextMenuInfo;

public class ContextMenuActivity extends ListActivity {

	private String[] items;
	private List<String> list;
	private ArrayAdapter<String> adapter;
	private int position;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getListData();
		registerForContextMenu(getListView());
	}

	private void getListData() {
		items = new String[] { "Java", "Python", "C++", "C",
				"C#", "Ruby", "R" };
		list = new ArrayList<String>();
		Collections.addAll(list, items);
		adapter = new ArrayAdapter<String>(this, R.layout.row, R.id.r_text,
				list);
		setListAdapter(adapter);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {

		super.onCreateContextMenu(menu, v, menuInfo);
		MenuInflater m = getMenuInflater();
		m.inflate(R.menu.context_menu, menu);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.delete_item:
			AdapterContextMenuInfo info = (AdapterContextMenuInfo) item
					.getMenuInfo();
			position = (int) info.id;
			list.remove(position);
			this.adapter.notifyDataSetChanged();
			return true;
		}
		return super.onContextItemSelected(item);
	}
}