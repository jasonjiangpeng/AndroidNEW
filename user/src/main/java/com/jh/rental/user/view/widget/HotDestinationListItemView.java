package com.jh.rental.user.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import com.jh.rental.user.R;


public class HotDestinationListItemView
        extends RelativeLayout
{
    private static final String TAG = "HotDestinationListItemView";

    public HotDestinationListItemView(Context context) {
        this(context, null);
    }

    public HotDestinationListItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.sub_item_hot_destination_list, this);
    }

}
