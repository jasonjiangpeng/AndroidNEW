package com.jh.rental.user.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jh.rental.user.view.fragment.home.DriverStoryFragment;
import com.jh.rental.user.view.fragment.home.HotRouteFragment;
import com.jh.rental.user.view.fragment.home.HotDestinationsFragment;
import com.jh.rental.user.view.fragment.home.UserVoiceFragment;

/**
 * 热门目的地、热门路线、司导故事、用户心声
 */
public class HomePageAdapter
        extends FragmentPagerAdapter
{
    public HomePageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HotDestinationsFragment();
            case 1:
                return new HotRouteFragment();
            case 2:
                return new DriverStoryFragment();
            case 3:
                return new UserVoiceFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }

}
