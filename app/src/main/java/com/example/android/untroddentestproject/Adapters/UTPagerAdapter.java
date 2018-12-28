package com.example.android.untroddentestproject.Adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.android.untroddentestproject.Fragment.ContactMainFragment;
import com.example.android.untroddentestproject.Fragment.OTPDetailFragment;

/**
 * Created by Avjeet on 28-12-2018.
 */
public class UTPagerAdapter extends FragmentPagerAdapter {
    public UTPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0: return new ContactMainFragment();

            case 1: return new OTPDetailFragment();

            default: return new ContactMainFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0: return "Contacts";

            case 1: return "OTP History";

            default: return "Contacts";
        }
    }
}
