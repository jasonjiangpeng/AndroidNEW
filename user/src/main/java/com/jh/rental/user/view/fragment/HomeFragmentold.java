package com.jh.rental.user.view.fragment;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.jh.rental.user.R;
import com.jh.rental.user.api.ApiPost;
import com.jh.rental.user.bean.home.GetEffectiveBanner;
import com.jh.rental.user.model.HttpVolley;
import com.jh.rental.user.presenter.NetJsonArraySucceed;
import com.jh.rental.user.utils.jason.ActivityUtils;
import com.jh.rental.user.utils.jason.Logger;
import com.jh.rental.user.view.actitity.home.CharteredBus2_Act;
import com.jh.rental.user.view.actitity.home.DifineBusNew_Act;
import com.jh.rental.user.view.actitity.home.PickUpAirport_Act;
import com.jh.rental.user.view.adapter.Homeadapter;
import com.jh.rental.user.view.fragment.home.SearchDesNew_Act;
import com.jh.rental.user.view.widget.Entity;
import com.jh.rental.user.view.widget.RecyclerBanner;

import java.util.ArrayList;
import java.util.List;

public class HomeFragmentold extends BaseFragment implements View.OnClickListener {
    private Homeadapter mHomeadapter;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ImageView searchDes;
    private CollapsingToolbarLayout ctlHead;
    private LinearLayout llCharteredbus, llAirport, llTailoredCar, llCarpooling;
    private List<RecyclerBanner.BannerEntity> Effective;
    private RecyclerBanner rbHead;

    @Override
    public View setView() {
        Logger.showMessage("===========Star========");
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_home, null);
        init(view);

        return view;
    }

    protected void init(View view) {
        Effective = new ArrayList<>();
        llCharteredbus = (LinearLayout) view.findViewById(R.id.ll_charteredbus);
        searchDes = (ImageView) view.findViewById(R.id.imageView2);
        searchDes.setOnClickListener(this);
        llAirport = (LinearLayout) view.findViewById(R.id.ll_airport);
        llTailoredCar = (LinearLayout) view.findViewById(R.id.ll_tailoredCar);
        llCarpooling = (LinearLayout) view.findViewById(R.id.ll_carpooling);
        llCharteredbus.setOnClickListener(this);
        llAirport.setOnClickListener(this);
        llTailoredCar.setOnClickListener(this);
        mTabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) view.findViewById(R.id.view_pager);
        rbHead = (RecyclerBanner) view.findViewById(R.id.rb_head);
        ctlHead = (CollapsingToolbarLayout) view.findViewById(R.id.ctl_head);
        llCarpooling.setVisibility(View.GONE);//结伴隐藏


//        llCarpooling.setOnClickListener(this);
        mHomeadapter = new Homeadapter(getChildFragmentManager());
        mViewPager.setAdapter(mHomeadapter);
        mTabLayout.setupWithViewPager(mViewPager);
        formatHead();
        postRequestData();
    }

    private void formatHead() {
        int width = getActivity().getWindowManager().getDefaultDisplay().getWidth();
        ViewGroup.LayoutParams params1 = ctlHead.getLayoutParams();
        params1.height = (int) (width * 0.98);
        ctlHead.setLayoutParams(params1);
    }

    private String[] ba = {"type"};

    private void postRequestData() {
        HttpVolley.getInstance().postMapRequest(ApiPost.getEffectiveBanner, getBaseMap(ba, "0"), new NetJsonArraySucceed<>(GetEffectiveBanner.class, new NetJsonArraySucceed.HolderData<GetEffectiveBanner>() {
            @Override
            public void holdData(ArrayList<GetEffectiveBanner> bean) {
                if (bean.size() > 0) {
                    for (int i = 0; i < bean.size(); i++) {
                        Effective.add(new Entity(bean.get(i).getImg()));
                    }
                    rbHead.setDatas(Effective);
                } else {
                    return;
                }
            }
        }), null);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_charteredbus:
//                SnakebarUtils.showToast("功能正在开发中");
                //   ActivityUtils.nextActivity(CharteredBus_Act.class);
                ActivityUtils.nextActivity(CharteredBus2_Act.class,"tab","1");
                break;
            case R.id.ll_airport:
                ActivityUtils.nextActivity(PickUpAirport_Act.class);
                break;
            case R.id.ll_tailoredCar:
                ActivityUtils.nextActivity(DifineBusNew_Act.class);
                break;
           /* case R.id.ll_carpooling:
                SnakebarUtils.showToast("功能正在开发中");
                ActivityUtils.nextActivity(Carpooling_Act.class);
                break;*/
            case R.id.imageView2:
             //  ApiConstants.searchChoose = 1;
                ActivityUtils.nextActivity(SearchDesNew_Act.class);
                break;
        }
    }
}
