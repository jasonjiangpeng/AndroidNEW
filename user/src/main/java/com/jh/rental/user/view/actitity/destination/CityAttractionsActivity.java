package com.jh.rental.user.view.actitity.destination;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;

import com.jh.rental.user.R;
import com.jh.rental.user.view.adapter.destination.CityAttractionsPageAdapter;

/**
 * Created by 俊辉出行 on 2017/5/19.
 */

public class CityAttractionsActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener {

    private View mView;
    private RadioGroup mRgTab;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cityattractions_activity);
        init();
    }

    private void init() {
        mRgTab = (RadioGroup) mView.findViewById(R.id.rg_tab);
        mViewPager = (ViewPager) mView.findViewById(R.id.view_pager);
        mRgTab.check(R.id.trip_arrange);
        mViewPager.setAdapter(new CityAttractionsPageAdapter(getSupportFragmentManager()));
        mViewPager.addOnPageChangeListener(this);
        mRgTab.setOnCheckedChangeListener(this);
        loadAreaData();
    }

    private void loadAreaData() {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                mRgTab.check(R.id.trip_arrange);
                break;
            case 1:
                mRgTab.check(R.id.trip_features);
                break;
            case 2:
                mRgTab.check(R.id.other_instructions);
                break;
            case 3:
                mRgTab.check(R.id.user_evaluation);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.trip_arrange:
                mViewPager.setCurrentItem(0);
                break;
            case R.id.trip_features:
                mViewPager.setCurrentItem(1);
                break;
            case R.id.other_instructions:
                mViewPager.setCurrentItem(2);
                break;
            case R.id.user_evaluation:
                mViewPager.setCurrentItem(3);
                break;
        }
    }
}
