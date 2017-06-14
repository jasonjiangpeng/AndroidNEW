package com.jh.rental.user.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jh.rental.user.R;

public class TripItemView extends LinearLayout {
    private static final String TAG = "HomeListItemView";

    public TripItemView(Context context) {
        this(context, null);
    }

    public TripItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.sub_item_trip, this);
        ImageView mIvTrip = (ImageView) findViewById(R.id.iv_trip);
        TextView tvTrip1 = (TextView) findViewById(R.id.tv_trip1);
        TextView tvTrip2 = (TextView) findViewById(R.id.tv_trip2);
    }

}
