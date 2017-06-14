package com.jh.rental.user.view.actitity.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.jh.rental.user.R;
import com.jh.rental.user.exception.ArrayException;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.view.actitity.TitelBarAcitvity;
import java.util.List;

/**
 * Created by 骏辉出行 on 2017/5/26.
 */
public abstract class TabViewPager_Act extends TitelBarAcitvity {
     TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pickupaireport_activity);
        tabLayout= (TabLayout) findViewById(R.id.pickupaireport_tablayout);
        viewPager= (ViewPager) findViewById(R.id.pickupaireport_viewpage);
        afterviews();
    }
    public void afterviews() {
        setMyTitel(BaseContext.getResValue(R.string.pickupairport));
        //   tabLayout.addTab();
    /*    List<Fragment> fragments = new ArrayList<>();
        fragments.add(new PickUpAirport_());
        fragments.add(new PickUpAirport_());
        String[] strings = BaseContext.getResArraysValue(R.array.pickup_airport);*/

        viewPager.setAdapter(new PickupAdapter(getSupportFragmentManager(), getfragment(), getstringArray()));
        tabLayout.setupWithViewPager(viewPager);
    }
  public abstract List<Fragment> getfragment();
  public abstract String[] getstringArray();

    class PickupAdapter extends FragmentPagerAdapter {
        List<Fragment> list;
        String[] strings;
        public PickupAdapter(FragmentManager fm, List<Fragment> fragments, String[] strings) {
              super(fm);
            this.list=fragments;
            this.strings=strings;
            if (strings.length!=list.size()){
                throw   new ArrayException("数组不相等");
            }
        }
        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }
        @Override
        public int getCount() {
            return list.size();
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return strings[position%list.size()];
        }
    }
}
