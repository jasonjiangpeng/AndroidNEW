package com.jh.rental.user.view.fragment.person;

import android.support.v7.widget.RecyclerView;

import com.jh.rental.user.view.adapter.person.CollectionCircuitListAdapter;
import com.jh.rental.user.view.fragment.BaseListFragment;


public class CollectionCircuitFragment
        extends BaseListFragment {
    private static final String TAG = "CollectionCircuitFragment";

    @Override
    public RecyclerView.Adapter getAdapter() {
        return new CollectionCircuitListAdapter(getContext());
    }

}
