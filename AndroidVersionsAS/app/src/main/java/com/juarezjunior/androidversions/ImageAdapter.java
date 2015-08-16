package com.juarezjunior.androidversions;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {

	private Context ctx;
	private final int[] img;
	private final LayoutParams params;

	public ImageAdapter(Context ctx, int[] img, LayoutParams params) {
		this.ctx = ctx;
		this.img = img;
		this.params = params;
	}

	@Override
	public int getCount() {
		return img.length;
	}

	@Override
	public Object getItem(int pos) {
		return img[pos];
	}

	@Override
	public long getItemId(int pos) {
		return img[pos];
	}

	@Override
	public View getView(int pos, View convView, ViewGroup pai) {
		ImageView v = new ImageView(ctx);
		v.setImageResource(img[pos]);
		v.setAdjustViewBounds(true);
		v.setLayoutParams(params);
		return v;
	}

}
