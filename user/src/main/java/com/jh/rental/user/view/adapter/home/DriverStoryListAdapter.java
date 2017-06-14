package com.jh.rental.user.view.adapter.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jh.rental.user.R;
import com.zhy.autolayout.utils.AutoUtils;


/**
 * Created by 俊辉出行 on 2017/5/22.
 */

public class DriverStoryListAdapter extends RecyclerView.Adapter<DriverStoryListAdapter.DriverStoryListItemViewHolder> {
    private final Context                mContext;
    public DriverStoryListAdapter(Context context) {
        mContext = context;
    }

    @Override
    public DriverStoryListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DriverStoryListItemViewHolder( LayoutInflater.from(mContext).inflate(R.layout.sub_item_driver_story_list,parent, false));
    }

    @Override
    public void onBindViewHolder(DriverStoryListItemViewHolder holder, int position) {
        holder.mItemView.setOnClickListener(new View.OnClickListener() {
            //点击条目跳转页面
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class DriverStoryListItemViewHolder
            extends RecyclerView.ViewHolder {

        View mItemView;
        public DriverStoryListItemViewHolder(View itemView) {
            super(itemView);
            mItemView = itemView;
            AutoUtils.autoSize(mItemView);
        }
    }
}
