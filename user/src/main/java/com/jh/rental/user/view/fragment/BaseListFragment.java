package com.jh.rental.user.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jh.rental.user.R;

/**
 * Created by 俊辉出行 on 2017/5/22.
 */

public abstract class BaseListFragment extends Fragment{

    private View mView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_base_list, null);
        init();
        return mView;
    }

    protected void init() {
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.recycler_view);

        initRecyclerView();
    }
    private void initRecyclerView() {
        mAdapter = getAdapter();
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(getLayout());
        mRecyclerView.setAdapter(mAdapter);

    }

    @NonNull
    public LinearLayoutManager getLayout() {
        return new GridLayoutManager(getContext(), 1);
    }

    public abstract RecyclerView.Adapter getAdapter();


}
