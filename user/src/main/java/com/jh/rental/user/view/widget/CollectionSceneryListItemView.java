package com.jh.rental.user.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.jh.rental.user.R;


public class CollectionSceneryListItemView
        extends LinearLayout
{
    private static final String TAG = "HomeListItemView";

    public CollectionSceneryListItemView(Context context) {
        this(context, null);
    }

    public CollectionSceneryListItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.sub_item_collection_scenery_list, this);
    }

}
