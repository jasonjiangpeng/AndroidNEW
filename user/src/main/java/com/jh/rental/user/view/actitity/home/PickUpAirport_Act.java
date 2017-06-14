package com.jh.rental.user.view.actitity.home;

import android.support.v4.app.Fragment;

import com.jh.rental.user.R;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.view.actitity.TabViewPager_Act;
import com.jh.rental.user.view.fragment.internationnal.PickUpAirport;
import com.jh.rental.user.view.fragment.internationnal.PickUpAirport2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 骏辉出行 on 2017/5/26.
 * 接送机
 */

public class PickUpAirport_Act extends TabViewPager_Act {
    @Override
    public List<Fragment> getfragment() {
        List<Fragment> fragments =new ArrayList<>();
        fragments.add(new PickUpAirport());
        fragments.add(new PickUpAirport2());
         return fragments;
    }
    @Override
    public String[] getstringArray() {
        return BaseContext.getResArraysValue(R.array.pickup_airport);
    }

}
