package com.juarezjunior.tabswipe;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsSwipeablePagerAdapter extends FragmentPagerAdapter {

	public TabsSwipeablePagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int index) {

		switch (index) {
		case 0:
			return new MMAFragment();
		case 1:
			return new SkateFragment();
		case 2:
			return new SurfFragment();
		}
		return null;
	}

	@Override
	public int getCount() {
		return 3;
	}

}
