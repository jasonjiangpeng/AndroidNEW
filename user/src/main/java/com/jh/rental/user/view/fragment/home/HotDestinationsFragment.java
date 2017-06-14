package com.jh.rental.user.view.fragment.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.jh.rental.user.R;
import com.jh.rental.user.view.adapter.home.DriverStoryListAdapter;
import com.jh.rental.user.view.adapter.home.HotDestinationsListAdapter2;
import com.jh.rental.user.view.fragment.BaseFragment;
import com.jh.rental.user.view.fragment.BaseListFragment;


public class HotDestinationsFragment extends BaseListFragment {

    private GridLayoutManager mGridManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public RecyclerView.Adapter getAdapter() {
        return new HotDestinationsListAdapter2(getContext());

    }



}
