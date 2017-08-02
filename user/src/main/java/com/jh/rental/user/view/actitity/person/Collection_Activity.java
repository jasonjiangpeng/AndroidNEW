package com.jh.rental.user.view.actitity.person;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import com.jh.rental.user.R;
import com.jh.rental.user.model.order.AddOrderDayMsg;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.view.actitity.TitelBarAcitvity;
import com.jh.rental.user.view.adapter.person.CollectionAdapter;
import com.jh.rental.user.view.fragment.person.CollectionCircuitFragment;
import com.jh.rental.user.view.fragment.person.CollectionSceneryFragment;
import com.jh.rental.user.view.widget.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 骏辉出行 on 2017/5/26.
 */

public class Collection_Activity extends TitelBarAcitvity {
    TabLayout tabLayout;
    NoScrollViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collection_activity);
        new AddOrderDayMsg().reqNet();
        tabLayout= (TabLayout) findViewById(R.id.tablayout);
        viewPager= (NoScrollViewPager) findViewById(R.id.viewpage);
        afterviews();
    }
    public void afterviews() {
        setMyTitel(BaseContext.getResValue(R.string.collect));
        List<Fragment> fragments = getFragments();
        viewPager.setAdapter(new CollectionAdapter(getSupportFragmentManager(),fragments,BaseContext.getResArraysValue(R.array.collection_airport)));
        tabLayout.setupWithViewPager(viewPager);
    }

    @NonNull
    private List<Fragment> getFragments() {
        List<Fragment> fragments =new ArrayList<>();
        fragments.add(new CollectionCircuitFragment());
        fragments.add(new CollectionSceneryFragment());
        return fragments;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
