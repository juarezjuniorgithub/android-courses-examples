package com.juarezjunior.asynctask;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.juarezjunior.asynctask.R;

public class ListRowAdapter extends BaseAdapter {

	private ArrayList<News> newsList;
	private LayoutInflater layoutInflater;

	public ListRowAdapter(Context context, ArrayList<News> listData) {
		this.newsList = listData;
		layoutInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return newsList.size();
	}

	@Override
	public Object getItem(int position) {
		return newsList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = layoutInflater.inflate(R.layout.list_row_layout, null);
			holder = new ViewHolder();
			holder.headline = (TextView) convertView.findViewById(R.id.title);
			holder.reporter = (TextView) convertView.findViewById(R.id.reporter);
			holder.date = (TextView) convertView.findViewById(R.id.date);
			holder.imageView = (ImageView) convertView.findViewById(R.id.thumbImage);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		News news = (News) newsList.get(position);

		holder.headline.setText(news.getHeadline());
		holder.reporter.setText("Reporter: " + news.getReporterName());
		holder.date.setText(news.getDate());

		if (holder.imageView != null) {
			new ImageDownloaderAsyncTask(holder.imageView).execute(news.getUrl());
		}

		return convertView;
	}

	private static class ViewHolder {
		TextView headline;
		TextView reporter;
		TextView date;
		ImageView imageView;
	}
}
