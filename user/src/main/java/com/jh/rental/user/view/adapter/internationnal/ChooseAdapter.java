package com.jh.rental.user.view.adapter.internationnal;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jh.rental.user.R;
import com.zhy.autolayout.utils.AutoUtils;

/**
 * Created by 俊辉出行 on 2017/6/9.
 */

public class ChooseAdapter extends RecyclerView.Adapter<ChooseAdapter.ChooseListItemViewHolder> {
    private final Context mContext;
    public ChooseAdapter(Context context) {
        mContext = context;
    }
    @Override
    public ChooseListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ChooseListItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.sub_item_choose_list, parent, false));
    }
    @Override
    public void onBindViewHolder(ChooseListItemViewHolder holder, int position) {
        holder.mItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ActivityUtils.nextActivity(SceneryMessage_Act.class);
            }
        });
    }
    @Override
    public int getItemCount() {
        return 5;
    }

    public class ChooseListItemViewHolder extends RecyclerView.ViewHolder {
        View mItemView;
        public ChooseListItemViewHolder(View itemView) {
            super(itemView);
            mItemView = itemView;
            AutoUtils.autoSize(mItemView);
        }
    }
}
