package com.jh.rental.user.view.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.jh.rental.user.R;
import com.jh.rental.user.utils.jason.ActivityUtils;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.utils.jason.Logger;
import com.jh.rental.user.view.actitity.home.Carpooling_Act;
import com.jh.rental.user.view.actitity.home.CharteredBus_Act;
import com.jh.rental.user.view.actitity.home.DifineBus_Act;
import com.jh.rental.user.view.actitity.home.PickUpAirport_Act;
import com.jh.rental.user.view.adapter.Homeadapter;
import com.jh.rental.user.view.fragment.home.DriverStoryFragment;
import com.jh.rental.user.view.fragment.home.HotDestinationsFragment;
import com.jh.rental.user.view.fragment.home.HotRouteFragment;
import com.jh.rental.user.view.fragment.home.UserVoiceFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFragment implements View.OnClickListener {
    //public static final String TAG = "HomeFragment";

    private Homeadapter mHomeadapter;
    private List<Fragment> list_fragment;
    private List<String> list_title;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    public View setView() {
        Logger.showMessage("===========Star========");
        View  view=LayoutInflater.from(getContext()).inflate(R.layout.fragment_home,null);
        init(view);
        return view;
    }

    protected void init(View view) {
        LinearLayout llCharteredbus = (LinearLayout) view.findViewById(R.id.ll_charteredbus);
        LinearLayout llAirport      = (LinearLayout) view.findViewById(R.id.ll_airport);
        LinearLayout llTailoredCar  = (LinearLayout) view.findViewById(R.id.ll_tailoredCar);
        LinearLayout llCarpooling   = (LinearLayout) view.findViewById(R.id.ll_carpooling);
        llCharteredbus.setOnClickListener(this);
        llAirport.setOnClickListener(this);
        llTailoredCar.setOnClickListener(this);
        llCarpooling.setOnClickListener(this);
        initTab(view);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_charteredbus:
                ActivityUtils.nextActivity(CharteredBus_Act.class);
                break;
            case R.id.ll_airport:
                ActivityUtils.nextActivity(PickUpAirport_Act.class);
                break;
            case R.id.ll_tailoredCar:
                ActivityUtils.nextActivity(DifineBus_Act.class);
                break;
            case R.id.ll_carpooling:
               ActivityUtils.nextActivity(Carpooling_Act.class);
                break;
        }
    }
    HotDestinationsFragment hotDestinationsFragment;
    HotRouteFragment hotRouteFragment;
    DriverStoryFragment driverStoryFragment;
    UserVoiceFragment userVoiceFragment;
    private void initTab(View view) {

        if (mTabLayout==null)      mTabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        if (mViewPager==null)       mViewPager  = (ViewPager) view.findViewById(R.id.view_pager);
    /*    if (hotRouteFragment==null)hotRouteFragment = new HotRouteFragment();
        if (hotDestinationsFragment==null) hotDestinationsFragment = new HotDestinationsFragment();
        if (userVoiceFragment==null) userVoiceFragment = new UserVoiceFragment();
        if (driverStoryFragment==null) driverStoryFragment = new DriverStoryFragment();*/
        if (list_fragment==null){
            list_fragment = new ArrayList<>();
            list_fragment.add(new HotRouteFragment());
            list_fragment.add(new HotDestinationsFragment());
            list_fragment.add(new DriverStoryFragment());
            list_fragment.add(new UserVoiceFragment());

        }
        if (list_title==null){
            list_title = new ArrayList<>();
            list_title.add(BaseContext.getResValue(R.string.HotDestinations));
            list_title.add(BaseContext.getResValue(R.string.HotRoute));
            list_title.add(BaseContext.getResValue(R.string.DriverStory));
            list_title.add(BaseContext.getResValue(R.string.UserVoice));
        }
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        for (int i = 0;i < list_fragment.size();i++){
            mTabLayout.addTab(mTabLayout.newTab().setText(list_title.get(i)));
        }
        mHomeadapter = new Homeadapter(this.getChildFragmentManager(),list_fragment,list_title);
        mViewPager.setAdapter(mHomeadapter);
        mTabLayout.setupWithViewPager(mViewPager);

    }

}
