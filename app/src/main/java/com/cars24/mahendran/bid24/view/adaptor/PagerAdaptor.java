package com.cars24.mahendran.bid24.view.adaptor;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.cars24.mahendran.bid24.view.fragment.CarsListFragment;
import com.cars24.mahendran.bid24.view.fragment.UserProfileFragment;

public class PagerAdaptor extends FragmentStatePagerAdapter {
    private int mNumOfTabs;
    private CarsListFragment carsListFragment;
    private UserProfileFragment userProfileFragment;
    public PagerAdaptor(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                if(carsListFragment == null) {
                    carsListFragment = new CarsListFragment();
                }
                return carsListFragment;
            case 1:
                if(userProfileFragment == null) {
                    userProfileFragment = new UserProfileFragment();
                }
                return userProfileFragment;
            default:
                if(carsListFragment == null) {
                    carsListFragment = new CarsListFragment();
                }
                return carsListFragment;
        }
    }


    @Override
    public int getCount() {
        return mNumOfTabs;
    }

    public String getFragmentTag(int viewPagerId, int fragmentPosition) {
        return "android:switcher:" + viewPagerId + ":" + fragmentPosition;
    }
}

