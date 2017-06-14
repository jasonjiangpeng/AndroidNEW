package com.jh.rental.user.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import com.jh.rental.user.R;


public class CitySceneryListItemView
        extends RelativeLayout {
    private static final String TAG = "HomeListItemView";

    public CitySceneryListItemView(Context context) {
        this(context, null);
    }

    public CitySceneryListItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.sub_item_cityscenery_list, this);
    }
}
