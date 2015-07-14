package com.juarezjunior.basicfragment;

import com.juarezjunior.basicfragment.R;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ArticleFragment extends Fragment {

	final static String POSITION = "position";
	int mCurrentPosition = -1;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		if (savedInstanceState != null) {
			mCurrentPosition = savedInstanceState.getInt(POSITION);
		}

		return inflater.inflate(R.layout.article_view, container, false);
	}

	@Override
	public void onStart() {
		super.onStart();

		Bundle args = getArguments();
		if (args != null) {

			updateArticleView(args.getInt(POSITION));
		} else if (mCurrentPosition != -1) {

			updateArticleView(mCurrentPosition);
		}
	}

	public void updateArticleView(int position) {
		TextView article = (TextView) getActivity().findViewById(R.id.article);
		article.setText(TodaysNews.Articles[position]);
		mCurrentPosition = position;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);

		outState.putInt(POSITION, mCurrentPosition);
	}
}