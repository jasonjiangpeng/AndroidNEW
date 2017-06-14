package com.jh.rental.user.view.fragment.home;

import android.support.v7.widget.RecyclerView;

import com.jh.rental.user.view.adapter.home.HotRouteListAdapter;
import com.jh.rental.user.view.fragment.BaseListFragment;

/*
 *  @项目名：  AndroidApp 
 *  @包名：    com.jh.rental.user.view.fragment.home
 *  @文件名:   HotDestinationsFragment
 *  @创建者:   ThinkPad
 *  @创建时间:  2017/5/21 22:19
 *  @描述：    TODO
 */
public class HotRouteFragment extends BaseListFragment {
    private static final String TAG = "HotRouteFragment";
    @Override
    public RecyclerView.Adapter getAdapter() {
        return new HotRouteListAdapter(getContext());
    }

}
