package com.jh.rental.user.view.fragment.internationnal;

import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jh.rental.user.view.adapter.internationnal.CitySceneryListAdapter;
import com.jh.rental.user.view.adapter.internationnal.OtherSceneryListAdapter;
import com.jh.rental.user.view.fragment.BaseListFragment;

/**
 * Created by 俊辉出行 on 2017/5/31.
 */

public class OtherSceneryFragment extends BaseListFragment {
    @Override
    public RecyclerView.Adapter getAdapter() {
        return new OtherSceneryListAdapter(getContext());
    }

    @NonNull
    @Override
    public LinearLayoutManager getLayout() {
        return new GridLayoutManager(getContext(), 3);
    }
}
