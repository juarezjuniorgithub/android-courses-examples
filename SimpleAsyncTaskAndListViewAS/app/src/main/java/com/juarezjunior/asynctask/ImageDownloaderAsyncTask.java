package com.juarezjunior.asynctask;

import java.io.InputStream;
import java.lang.ref.WeakReference;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;

import com.juarezjunior.asynctask.R;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

class ImageDownloaderAsyncTask extends AsyncTask<String, Void, Bitmap> {

	private final WeakReference<ImageView> imgView;
	private static final String TAG = "ImageDownloaderAsyncTask";

	public ImageDownloaderAsyncTask(ImageView imageView) {
		imgView = new WeakReference<ImageView>(imageView);
	}

	@Override
	protected Bitmap doInBackground(String... params) {
		return downloadBitmapFromUrl(params[0]);
	}

	@Override
	protected void onPostExecute(Bitmap bitmap) {
		if (isCancelled()) {
			bitmap = null;
		}
		if (imgView != null) {
			ImageView imageView = imgView.get();

			if (imageView != null) {

				if (bitmap != null) {
					imageView.setImageBitmap(bitmap);
				} else {
					imageView.setImageDrawable(imageView.getContext()
							.getResources()
							.getDrawable(R.drawable.list_placeholder));
				}
			}
		}
	}

	private static Bitmap downloadBitmapFromUrl(String url) {
		final AndroidHttpClient client = AndroidHttpClient
				.newInstance("AndroidHttpClient");
		final HttpGet getRequest = new HttpGet(url);
		try {
			HttpResponse response = client.execute(getRequest);
			final int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != HttpStatus.SC_OK) {
				Log.w(TAG, new StringBuilder(
						statusCode).append(
								" while downloading bitmap from ").
								append(url).toString());
				return null;
			}
			final HttpEntity entity = response.getEntity();
			if (entity != null) {
				InputStream inputStream = null;
				try {
					inputStream = entity.getContent();
					final Bitmap bitmap = BitmapFactory
							.decodeStream(inputStream);
					return bitmap;
				} finally {
					if (inputStream != null) {
						inputStream.close();
					}
					entity.consumeContent();
				}
			}
		} catch (Exception e) {
			getRequest.abort();
			Log.w(TAG, "Error while retrieving bitmap from "
					+ url);
		} finally {
			if (client != null) {
				client.close();
			}
		}
		return null;
	}

}