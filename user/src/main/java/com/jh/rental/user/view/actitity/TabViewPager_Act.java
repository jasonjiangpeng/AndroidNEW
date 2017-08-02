package com.jh.rental.user.view.actitity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.jh.rental.user.R;
import com.jh.rental.user.bean.OrderDetails;
import com.jh.rental.user.exception.ArrayException;
import com.jh.rental.user.utils.jason.BaseContext;

import java.util.List;

import static com.jh.rental.user.R.id.charterdbus_edt1;

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
        setMyTitel(getHeadName());
        viewPager.setAdapter(new PickupAdapter(getSupportFragmentManager(), getfragment(), getstringArray()));
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @NonNull
    protected String getHeadName() {
        return BaseContext.getResValue(R.string.pickupairport);
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
