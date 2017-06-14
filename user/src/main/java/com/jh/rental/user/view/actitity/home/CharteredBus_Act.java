package com.jh.rental.user.view.actitity.home;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.jh.rental.user.R;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.view.actitity.TabViewPager_Act;
import com.jh.rental.user.view.fragment.internationnal.CharteredBu1;
import com.jh.rental.user.view.fragment.internationnal.CharteredBu2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 骏辉出行 on 2017/5/26.
 * 定制包车游
 */

public class CharteredBus_Act extends TabViewPager_Act {

    @Override
    public List<Fragment> getfragment() {
        List<Fragment> fragments =new ArrayList<>();
        fragments.add(new CharteredBu1());
        fragments.add(new CharteredBu2());
        return fragments;
    }
    @Override
    public String[] getstringArray() {
        return BaseContext.getResArraysValue(R.array.chartered_bus);
    }

    @NonNull
    @Override
    protected String getHeadName() {
        return BaseContext.getResValue(R.string.charteredBus);
    }
}
