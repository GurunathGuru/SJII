package com.integro.sjii.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.integro.sjii.fragments.HomeFragment;
import com.integro.sjii.fragments.NewsFragment;
import com.integro.sjii.fragments.NotificationsFragment;
import com.integro.sjii.fragments.WebFragment;

public class SlideAdapter extends FragmentPagerAdapter {

    public SlideAdapter(FragmentManager supportFragmentManager) {
        super(supportFragmentManager);
    }

    @NonNull
    @Override
    public Fragment getItem(int i) {
        Fragment fragment = null;
        if (i == 0) {
            fragment = new HomeFragment();
        }
        if (i == 1) {
            fragment = new NewsFragment();
        }
        if (i == 2) {
            fragment = new NotificationsFragment();
        }
        if (i == 3) {
            fragment = new WebFragment();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
