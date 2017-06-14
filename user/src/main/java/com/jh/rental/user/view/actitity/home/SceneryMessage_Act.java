package com.jh.rental.user.view.actitity.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.jh.rental.user.R;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.view.actitity.BaseActvity;
import com.jh.rental.user.view.fragment.internationnal.CharteredBu1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 骏辉出行 on 2017/6/6.
 */

public class SceneryMessage_Act extends BaseActvity implements View.OnClickListener {
private TabLayout tablayout;
private ViewPager viewpager;
    private List<Fragment> fragmentList;
    int[]  resId1={R.drawable.m_c_aaxxhdpi,R.drawable.m_c_baxxhdpi,R.drawable.m_c_caxxhdpi,R.drawable.m_c_daxxhdpi};
    int[]  resId2={R.drawable.m_c_abxxhdpi,R.drawable.m_c_bbxxhdpi,R.drawable.m_c_cbxxhdpi,R.drawable.m_c_dbxxhdpi};
    String []  values=BaseContext.getResArraysValue(R.array.scenery_message);
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scenerytest_sub);
        fragmentList=new ArrayList<>();
        fragmentList.add(new CharteredBu1());
        fragmentList.add(new CharteredBu1());
        fragmentList.add(new CharteredBu1());
        fragmentList.add(new CharteredBu1());
        tablayout= (TabLayout) findViewById(R.id.scenery_layout);
        viewpager= (ViewPager) findViewById(R.id.scenery_viewpager);
        initUI();
    }

    private void initUI() {

        viewpager.setAdapter(new SceneryAdapter(getSupportFragmentManager(),fragmentList));
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i <tablayout.getTabCount();i++) {
                  if (position==i){
                      tablayout.getTabAt(i).setIcon(resId1[i]).setText(values[i]);
                  }else {
                      tablayout.getTabAt(i).setIcon(resId2[i]).setText(values[i]);
                  }

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        tablayout.setupWithViewPager(viewpager,true);
        for (int i = 0; i <tablayout.getTabCount();i++) {
            if (0==i){
                tablayout.getTabAt(i).setIcon(resId1[i]).setText(values[i]);
            }else {
                tablayout.getTabAt(i).setIcon(resId2[i]).setText(values[i]);
            }

        }

     //   tablayout.addTab(tablayout.newTab().setIcon(resId[0]).setText("我撒"));
       /* tablayout.addTab(tablayout.newTab().setIcon(resId[1]).setText("我撒"));
        tablayout.addTab(tablayout.newTab().setIcon(resId[0]).setText("我撒"));
        tablayout.addTab(tablayout.newTab().setIcon(resId[1]).setText("我撒"));*/
    }

    @Override
    public void onClick(View v) {

    }
   private class SceneryAdapter extends FragmentPagerAdapter {
        List<Fragment> list;

        public SceneryAdapter(FragmentManager fm, List<Fragment> fragments ){
            super(fm);
            this.list=fragments;
        }
        @Override
        public Fragment getItem(int position) {
         /*

            }*/

            return list.get(position);
        }
        @Override
        public int getCount() {
            return list.size();
        }

       @Override
       public CharSequence getPageTitle(int position) {

           return super.getPageTitle(position);
       }
   }

}
