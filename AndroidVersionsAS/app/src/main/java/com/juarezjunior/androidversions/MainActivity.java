package com.juarezjunior.androidversions;

import com.juarezjunior.androidversions.R;

import android.os.Bundle;
import android.app.Activity;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Toast;
import android.view.View;
import android.widget.Gallery;

public class MainActivity extends Activity {

	private int[] img = { R.drawable.cupcake, R.drawable.donut,
			R.drawable.eclair, R.drawable.froyo, R.drawable.gingerbread,
			R.drawable.honeycomb, R.drawable.icecream, R.drawable.jellybeans,
			R.drawable.kitkat };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Gallery g = (Gallery) findViewById(R.id.galeria);
		g.setAdapter(new ImageAdapter(this, img, new Gallery.LayoutParams(150,
				100)));
		g.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View v, int pos,
					long id) {
				ImageView imgView = new ImageView(MainActivity.this);
				imgView.setImageResource(img[pos]);
				Toast t = new Toast(MainActivity.this);
				t.setView(imgView);
				t.show();
			}
		});
	}

}
