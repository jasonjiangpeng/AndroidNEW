package com.jh.rental.user.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.jh.rental.user.R;


public class CollectionCircuitListItemView
        extends LinearLayout
{
    private static final String TAG = "HomeListItemView";

    public CollectionCircuitListItemView(Context context) {
        this(context, null);
    }

    public CollectionCircuitListItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.sub_item_collection_circuit_list, this);
    }

}
