package com.jh.rental.user.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.jh.rental.user.R;
import com.jh.rental.user.api.ApiPost;
import com.jh.rental.user.bean.home.GetEffectiveBanner;
import com.jh.rental.user.model.HttpVolley;
import com.jh.rental.user.presenter.NetJsonArraySucceed;
import com.jh.rental.user.utils.jason.ActivityUtils;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.utils.jason.Logger;
import com.jh.rental.user.utils.jason.SnakebarUtils;
import com.jh.rental.user.view.actitity.home.Carpooling_Act;
import com.jh.rental.user.view.actitity.home.CharteredBus_Act;
import com.jh.rental.user.view.actitity.home.DifineBus_Act;
import com.jh.rental.user.view.actitity.home.PickUpAirport_Act;
import com.jh.rental.user.view.adapter.Homeadapter;
import com.jh.rental.user.view.adapter.hongkong.HomeMainAdapter;
import com.jh.rental.user.view.fragment.home.DriverStoryFragment;
import com.jh.rental.user.view.fragment.home.HotDestinationsFragment;
import com.jh.rental.user.view.fragment.home.HotRouteFragment;
import com.jh.rental.user.view.fragment.home.UserVoiceFragment;
import com.jh.rental.user.view.widget.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeFragment extends BaseFragment implements View.OnClickListener {
    private View view;
    private RecyclerView  recyclerView;
    @Override
    public View setView() {
    /*    if (view==null){
            view=LayoutInflater.from(getContext()).inflate(R.layout.jhcx_home,null);
        }
        init(view);*/
        return null;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=LayoutInflater.from(getContext()).inflate(R.layout.jhcx_home,container,false);
        init(view);
        return view;
    }

    protected void init(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                Logger.newTestMessage(isSlideToBottom(recyclerView));
                if (isSlideToBottom(recyclerView)){
                    if (homeMainAdapter!=null){
                   homeMainAdapter.getDataCallBack().dataCallBack();
                    }


                }
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        postRequestData();
    }
    DataCallBack dataCallBack;
 public  interface  DataCallBack{
          void dataCallBack();
  }


    public static boolean isSlideToBottom(RecyclerView recyclerView) {
        if (recyclerView == null) return false;
        if (recyclerView.computeVerticalScrollExtent() + recyclerView.computeVerticalScrollOffset()
                >= recyclerView.computeVerticalScrollRange())
            return true;
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
        }
    }
    private HomeMainAdapter  homeMainAdapter;
    /*获取图片*/
    private void postRequestData() {
        HttpVolley.getInstance().postMapRequest(ApiPost.getEffectiveBanner, getBaseMap(), new NetJsonArraySucceed<>(GetEffectiveBanner.class, new NetJsonArraySucceed.HolderData<GetEffectiveBanner>() {
            @Override
            public void holdData(ArrayList<GetEffectiveBanner> bean) {
                homeMainAdapter=new HomeMainAdapter(getChildFragmentManager(),bean);
                recyclerView.setAdapter(homeMainAdapter);
            }
        }), null);
    }
    public Map<String ,String> getBaseMap(){
        Map<String ,String> baseMap =new HashMap<>();
        baseMap.put("type","0");
        return baseMap;
    }

}
