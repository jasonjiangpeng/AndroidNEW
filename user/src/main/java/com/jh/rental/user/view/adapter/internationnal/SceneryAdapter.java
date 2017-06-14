package com.jh.rental.user.view.adapter.internationnal;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jh.rental.user.R;
import com.jh.rental.user.utils.jason.ActivityUtils;
import com.jh.rental.user.view.actitity.home.SceneryMessage_Act;
import com.zhy.autolayout.utils.AutoUtils;

/**
 * Created by 俊辉出行 on 2017/5/27.
 */

public class SceneryAdapter extends RecyclerView.Adapter<SceneryAdapter.SceneryListItemViewHolder> {

    private final Context mContext;

    public SceneryAdapter(Context context) {
        mContext = context;
    }
    @Override
    public SceneryListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SceneryListItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.sub_item_scenery_list, parent, false));
    }

    @Override
    public void onBindViewHolder(SceneryListItemViewHolder holder, int position) {
        holder.mItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtils.nextActivity(SceneryMessage_Act.class);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class SceneryListItemViewHolder
            extends RecyclerView.ViewHolder {

        View mItemView;
        public SceneryListItemViewHolder(View itemView) {
            super(itemView);
            mItemView = itemView;
            AutoUtils.autoSize(mItemView);
        }
    }
}
