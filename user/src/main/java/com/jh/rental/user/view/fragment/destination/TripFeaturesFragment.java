package com.jh.rental.user.view.fragment.destination;

import android.support.v7.widget.RecyclerView;

import com.jh.rental.user.view.adapter.destination.TripFeaturesListAdapter;
import com.jh.rental.user.view.fragment.BaseListFragment;

/**
 * Created by 俊辉出行 on 2017/5/22.
 */

public class TripFeaturesFragment extends BaseListFragment {

    @Override
    public RecyclerView.Adapter getAdapter() {
        return new TripFeaturesListAdapter(getContext());
    }

    @Override
    public void dataCallBack() {

    }
}
