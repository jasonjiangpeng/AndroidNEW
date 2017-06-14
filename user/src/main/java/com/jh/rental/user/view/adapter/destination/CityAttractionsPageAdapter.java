package com.jh.rental.user.view.adapter.destination;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jh.rental.user.view.fragment.destination.OtherInstructionsFragment;
import com.jh.rental.user.view.fragment.destination.TripArrangeFragment;
import com.jh.rental.user.view.fragment.destination.TripFeaturesFragment;
import com.jh.rental.user.view.fragment.destination.UserEvaluationFragment;

/**
 * Created by 俊辉出行 on 2017/5/22.
 */

public class CityAttractionsPageAdapter extends FragmentPagerAdapter {

    public CityAttractionsPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new TripArrangeFragment();
            case 1:
                return new TripFeaturesFragment();
            case 2:
                return new OtherInstructionsFragment();
            case 3:
                return new UserEvaluationFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
