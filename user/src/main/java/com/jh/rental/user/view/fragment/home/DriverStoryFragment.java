package com.jh.rental.user.view.fragment.home;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jh.rental.user.bean.login.StorySBean;
import com.jh.rental.user.model.NetResponData;
import com.jh.rental.user.model.homemodel.Storys;
import com.jh.rental.user.utils.jason.LoadDialog;
import com.jh.rental.user.view.adapter.home.DriverStoryListAdapter;
import com.jh.rental.user.view.fragment.BaseListFragment;

/*
 *  @项目名：  AndroidApp 
 *  @包名：    com.jh.rental.user.view.fragment.home
 *  @文件名:   DriverStoryFragment
 *  @创建者:   ThinkPad
 *  @创建时间:  2017/5/21 22:21
 *  @描述：    TODO
 */
public class DriverStoryFragment extends BaseListFragment {
    private static final String TAG = "DriverStoryFragment";


    private int loadValue = 1;
    private StorySBean storySBean;
    private int total;
    private DriverStoryListAdapter hotRouteListAdapter;
    private boolean isLoad = true;

    private void loadData() {
        isLoad = false;
        if (total > loadValue * 8) {
            loadValue++;
            LoadDialog.show(getContext(), "加载数据...");
            new Storys().reqNet(loadValue, new NetResponData<StorySBean>() {
                @Override
                public void responeData(final StorySBean object) {
                    storySBean.getList().addAll(object.getList());
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            LoadDialog.dismiss(getContext());
                            hotRouteListAdapter.notifyDataSetChanged();
                            isLoad = true;
                        }
                    });

                }
            });
        }
    }

    @Override
    protected void init() {
        super.init();

        new Storys().reqNet(loadValue, new NetResponData<StorySBean>() {
            @Override
            public void responeData(final StorySBean object) {
                storySBean = object;
                total = object.getTotal();
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        hotRouteListAdapter = new DriverStoryListAdapter(getContext(), storySBean.getList());
                        initRecyclerView(hotRouteListAdapter);
                    }
                });

            }
        });


    }

    @Override
    public RecyclerView.Adapter getAdapter() {
        return null;
    }

    @Override
    public void dataCallBack() {
        if (isLoad ) {
            loadData();
        }
    }
}
