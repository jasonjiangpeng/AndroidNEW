package com.jh.rental.user.view.adapter.internationnal;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.zhy.autolayout.utils.AutoUtils;

/**
 * Created by 俊辉出行 on 2017/6/10.
 */

public class ItineraryAdapter extends RecyclerView.Adapter {
    private Context mContext;
    public static final int TYPEL_HEAD = 0;
    public static final int TYPEL_TITLE = 1;
    public static final int TYPEL_ORDINARY = 2;
    public static final int TYPEL_DETERMINE = 3;

    public ItineraryAdapter(Context context) {
        mContext = context;
    }

    int GROUP_SIZE = 20;
    @Override
    public int getItemCount() {
        return GROUP_SIZE;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0){
            return TYPEL_HEAD;
        }else if(position == GROUP_SIZE-1) {
            return TYPEL_DETERMINE;
        }else if(position %5 == 1) {
            return TYPEL_TITLE;
        }else {
            return TYPEL_ORDINARY;
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
        switch (viewType) {
            case TYPEL_HEAD:
                itemView = LayoutInflater.from(mContext).inflate(R.layout.sub_item_itinerary1_list, parent, false);
                return new ItineraryHolder1(itemView);
            case TYPEL_TITLE:
                itemView = LayoutInflater.from(mContext).inflate(R.layout.sub_item_itinerary2_list, parent, false);
                return new ItineraryHolder2(itemView);
            case TYPEL_ORDINARY:
                itemView = LayoutInflater.from(mContext).inflate(R.layout.sub_item_itinerary3_list, parent, false);
                return new ItineraryHolder3(itemView);
            case TYPEL_DETERMINE:
                itemView = LayoutInflater.from(mContext).inflate(R.layout.sub_item_itinerary4_list, parent, false);
                return new ItineraryHolder4(itemView);
            default:
                return null;
        }
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        switch (viewType) {
            case TYPEL_HEAD:
                break;
            case TYPEL_TITLE:
                break;
            case TYPEL_ORDINARY:
                ItineraryHolder3 ordinaryHolder = (ItineraryHolder3) holder;
                if (position %5 == 0) {
                    ordinaryHolder.mIvLine.setVisibility(View.GONE);
                }else if (position == 2){
                    ordinaryHolder.mLlJourneyTime.setVisibility(View.GONE);
                    ordinaryHolder.mTvtime.setVisibility(View.VISIBLE);
                } else if (position == GROUP_SIZE-2){
                    ordinaryHolder.mLlJourneyTime.setVisibility(View.GONE);
                    ordinaryHolder.mTvtime.setVisibility(View.VISIBLE);
                    ordinaryHolder.mTvtime.setBackgroundResource(R.color.userGreen);
                    ordinaryHolder.mTvtime.setText("19:30结束");
                } else {
                    ordinaryHolder.mIvLine.setVisibility(View.VISIBLE);
                    ordinaryHolder.mLlJourneyTime.setVisibility(View.VISIBLE);
                    ordinaryHolder.mTvtime.setVisibility(View.GONE);
                }
                break;
            case TYPEL_DETERMINE:
                break;
        }
    }

    class ItineraryHolder1 extends RecyclerView.ViewHolder {
        View mItemView;
        public ItineraryHolder1(View itemView) {
            super(itemView);
            mItemView = itemView;
            AutoUtils.autoSize(itemView);
        }
    }

    class ItineraryHolder2 extends RecyclerView.ViewHolder {
        View mItemView;
        public ItineraryHolder2(View itemView) {
            super(itemView);
            mItemView = itemView;
            AutoUtils.autoSize(itemView);
        }
    }

    class ItineraryHolder3 extends RecyclerView.ViewHolder {
        View mItemView;
        TextView mTvtime;
        ImageView mIvLine;
        LinearLayout mLlJourneyTime;
        public ItineraryHolder3(View itemView) {
            super(itemView);
            mItemView = itemView;
            mTvtime = (TextView) itemView.findViewById(R.id.tv_time);
            mIvLine = (ImageView) itemView.findViewById(R.id.iv_line);
            mLlJourneyTime = (LinearLayout) itemView.findViewById(R.id.ll_JourneyTime);
            AutoUtils.autoSize(itemView);
        }
    }
    class ItineraryHolder4 extends RecyclerView.ViewHolder {
        View mItemView;
        public ItineraryHolder4(View itemView) {
            super(itemView);
            mItemView = itemView;
            AutoUtils.autoSize(itemView);
        }
    }
}
