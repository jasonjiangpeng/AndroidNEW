package com.jh.rental.user.view.fragment.person;

import android.support.v7.widget.RecyclerView;

import com.jh.rental.user.view.adapter.person.CollectionSceneryListAdapter;
import com.jh.rental.user.view.fragment.BaseListFragment;


public class CollectionSceneryFragment
        extends BaseListFragment {
    private static final String TAG = "CollectionSceneryFragment";

    @Override
    public RecyclerView.Adapter getAdapter() {
        return new CollectionSceneryListAdapter(getContext());
    }

    @Override
    public void dataCallBack() {

    }
}
