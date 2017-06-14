package com.jh.rental.user.view.widget;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jh.rental.user.R;


public class HotLineListItemView
        extends LinearLayout
{
    private static final String TAG = "HomeListItemView";

    public HotLineListItemView(Context context) {
        this(context, null);
    }

    public HotLineListItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.sub_item_hot_line_list, this);
        TextView tvOriginalPrice = (TextView) findViewById(R.id.tv_original_price);
        tvOriginalPrice.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG|Paint.ANTI_ALIAS_FLAG);
    }

}
