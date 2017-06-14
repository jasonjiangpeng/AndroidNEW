package com.jh.rental.user.view.fragment.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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

    @Override
    public RecyclerView.Adapter getAdapter() {
        return new DriverStoryListAdapter(getContext());
    }

}
