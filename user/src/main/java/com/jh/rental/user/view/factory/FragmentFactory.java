package com.jh.rental.user.view.factory;

import android.support.v4.app.Fragment;

import com.jh.rental.user.R;
import com.jh.rental.user.view.fragment.DestinationFragment;
import com.jh.rental.user.view.fragment.HomeFragment;
import com.jh.rental.user.view.fragment.HomeFragmentold;
import com.jh.rental.user.view.fragment.JourneyFragment;
import com.jh.rental.user.view.fragment.ConsultFragment;
import com.jh.rental.user.view.fragment.MyFragment;

/**
 * 创建首页Fragment的工厂类
 */
public class FragmentFactory {
    private static final String TAG = "FragmentFactory";

    public static FragmentFactory mFragmentFactory;
    private       Fragment        mHomeFragment;
    private       Fragment        mDestinationFragment;
    private       Fragment        mConsultFragment;
    private       Fragment        mJourneyFragment;
    private       Fragment        mMyFragment;
    private FragmentFactory() {}
    public static FragmentFactory getInstance() {

            synchronized (FragmentFactory.class) {
                if (mFragmentFactory == null) {
                    mFragmentFactory = new FragmentFactory();
                }
            }
        return mFragmentFactory;
    }
  private   int  tabid;
    public Fragment getFragment(int tabId) {
        this.tabid=tabId;
        switch (tabId) {
            case R.id.tab_home:
                return getHomeFragment();
            case R.id.tab_destination:
                return getDestinationFragment();
            case R.id.tab_consult:
                return getConsultFragment();
            case R.id.tab_journey:
                return getJourneyFragment();
            case R.id.tab_my:
                return getMyFragment();
        }
        return null;
    }
    public int getTabid(){
        return tabid;
    }
    private   boolean  isupdata=false;

    public boolean isupdata() {
        return isupdata;
    }

    public void setIsupdata(boolean isupdata) {
        this.isupdata = isupdata;
    }

    public Fragment getHomeFragment() {
      if (mHomeFragment == null||isupdata) {
            isupdata=false;
       //     mHomeFragment = new HomeFragmentold();
            mHomeFragment = new HomeFragment();

        }
        return mHomeFragment;
    }

    public Fragment getDestinationFragment() {
        if (mDestinationFragment == null||isupdata) {
            isupdata=false;
            mDestinationFragment = new DestinationFragment();

        }
        return mDestinationFragment;
    }

    public Fragment getConsultFragment() {
        if (mConsultFragment == null||isupdata) {
            isupdata=false;
            mConsultFragment = new ConsultFragment();
        }
        return mConsultFragment;
    }

    public Fragment getJourneyFragment() {
        if (mJourneyFragment == null||isupdata) {
            isupdata=false;
            mJourneyFragment = new JourneyFragment();
        }
        return mJourneyFragment;
    }

    public Fragment getMyFragment() {
        if (mMyFragment == null||isupdata) {
            isupdata=false;
            mMyFragment = new MyFragment();
        }
        return mMyFragment;
    }
}
