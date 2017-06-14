package com.jh.rental.user.view.actitity.person;

import android.support.v4.app.Fragment;

import com.jh.rental.user.R;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.view.actitity.TabViewPager_Act;
import com.jh.rental.user.view.fragment.person.CollectionCircuitFragment;
import com.jh.rental.user.view.fragment.person.CollectionSceneryFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 骏辉出行 on 2017/5/26.
 */

public class Collection_Activity extends TabViewPager_Act {
    @Override
    public List<Fragment> getfragment() {
        List<Fragment> fragments =new ArrayList<>();
        fragments.add(new CollectionCircuitFragment());
        fragments.add(new CollectionSceneryFragment());
        return fragments;
    }
    @Override
    public String[] getstringArray() {
        return BaseContext.getResArraysValue(R.array.collection_airport);
    }
}
