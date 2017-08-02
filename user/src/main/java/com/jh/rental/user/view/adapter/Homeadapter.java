package com.jh.rental.user.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jh.rental.user.R;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.view.fragment.home.DriverStoryFragment;
import com.jh.rental.user.view.fragment.home.HotDestinationsFragment;
import com.jh.rental.user.view.fragment.home.HotRouteFragment;
import com.jh.rental.user.view.fragment.home.UserVoiceFragment;

import java.util.ArrayList;
import java.util.List;

public class Homeadapter extends FragmentPagerAdapter {

    List<Fragment> fragmentList = new ArrayList<>();
    // 标题数组
    String[] titles = {BaseContext.getResValue(R.string.HotDestinations), BaseContext.getResValue(R.string.HotRoute),BaseContext.getResValue(R.string.DriverStory),BaseContext.getResValue(R.string.UserVoice)};

    public Homeadapter(FragmentManager fm) {
        super(fm);
        fragmentList.add(new HotDestinationsFragment());
        fragmentList.add(new HotRouteFragment());
        fragmentList.add(new DriverStoryFragment());
        fragmentList.add(new UserVoiceFragment());
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}


