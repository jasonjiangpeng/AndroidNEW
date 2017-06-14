package com.jh.rental.user.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jh.rental.user.R;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.view.fragment.ConsultFragment;
import com.jh.rental.user.view.fragment.DestinationFragment;
import com.jh.rental.user.view.fragment.HomeFragment;
import com.jh.rental.user.view.fragment.JourneyFragment;
import com.jh.rental.user.view.fragment.MyFragment;

public class MainAdapter extends FragmentPagerAdapter {


    private String[] mTitles = new String[]{BaseContext.getResValue(R.string.home),
            BaseContext.getResValue(R.string.destination),
            BaseContext.getResValue(R.string.consult),
            BaseContext.getResValue(R.string.journey),
            BaseContext.getResValue(R.string.my)};

    public MainAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 1) {
            return new DestinationFragment();
        } else if (position == 2) {
            return new ConsultFragment();
        }else if (position==3){
            return new JourneyFragment();
        }else if (position==4){
            return new MyFragment();
        }
        return new HomeFragment();
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

}


