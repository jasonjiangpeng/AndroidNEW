package com.jh.rental.user.view.adapter.hongkong;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.jh.rental.user.R;
import com.zhy.autolayout.utils.AutoUtils;

/**
 * Created by 俊辉出行 on 2017/6/10.
 */

public class VisaCollectionAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private PopupWindow mPopupWindow;
    public static final int TYPEL_BOTTOM = 0;
    public static final int TYPEL_ORDINARY = 1;

    public VisaCollectionAdapter(Context context) {
        mContext=context;
    }
    @Override
    public int getItemViewType(int position) {
        if (position == length) {
            return TYPEL_BOTTOM;
        } else {
            return TYPEL_ORDINARY;
        }
    }

    @Override
    public  RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
        switch (viewType) {
            case TYPEL_BOTTOM:
                itemView = LayoutInflater.from(mContext).inflate(R.layout.sub_item_bottom, parent, false);
                return new VisaCollectionHolder2(itemView);
            case TYPEL_ORDINARY:
                itemView = LayoutInflater.from(mContext).inflate(R.layout.sub_item_visacollection_list, parent, false);
                return new VisaCollectionHolder(itemView);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {}

    int length = 6;
    @Override
    public int getItemCount() {
        return length+1;
    }

    public class VisaCollectionHolder extends RecyclerView.ViewHolder {
        View mItemView;
        public VisaCollectionHolder(View itemView) {
            super(itemView);
            mItemView = itemView;
            AutoUtils.autoSize(mItemView);
        }
    }
    public class VisaCollectionHolder2 extends RecyclerView.ViewHolder {
        View mItemView2;
        public VisaCollectionHolder2(View itemView) {
            super(itemView);
            mItemView2 = itemView;
            AutoUtils.autoSize(mItemView2);
        }
    }
}
