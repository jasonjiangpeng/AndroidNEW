package com.jh.rental.user.view.actitity.internationnal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.jh.rental.user.R;
import com.jh.rental.user.exception.ArrayException;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.view.actitity.TitelBarAcitvity;
import com.jh.rental.user.view.fragment.internationnal.CitySceneryFragment;
import com.jh.rental.user.view.fragment.internationnal.OtherSceneryFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 骏辉出行 on 2017/5/26.
 */
public class SceneryCity_Activity extends TitelBarAcitvity implements View.OnClickListener {
    TabLayout tabLayout;
    ViewPager viewPager;
    private RelativeLayout mRlShutDown;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scenerycity_activity);
        tabLayout= (TabLayout) findViewById(R.id.pickupaireport_tablayout);
        viewPager= (ViewPager) findViewById(R.id.pickupaireport_viewpage);
        mRlShutDown = (RelativeLayout) findViewById(R.id.rl_ShutDown);
        ImageView ivShutDown = (ImageView) findViewById(R.id.iv_ShutDown);
        ivShutDown.setOnClickListener(this);
        afterviews();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_ShutDown:
                mRlShutDown.setVisibility(View.GONE);
                break;
        }
    }

    public void afterviews() {
        setMyTitel(getHeadName());
        String[] stringArray = BaseContext.getResArraysValue(R.array.scenery_city);
        List<Fragment> fragments =new ArrayList<>();
        fragments.add(new CitySceneryFragment());
        fragments.add(new OtherSceneryFragment());
        viewPager.setAdapter(new SceneryCityAdapter(getSupportFragmentManager(), fragments, stringArray));
        tabLayout.setupWithViewPager(viewPager);
    }
    @NonNull
    protected String getHeadName() {
        return BaseContext.getResValue(R.string.SceneryCity);
    }

    class SceneryCityAdapter extends FragmentPagerAdapter {
        List<Fragment> list;
        String[] strings;
        public SceneryCityAdapter(FragmentManager fm, List<Fragment> fragments, String[] strings) {
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
