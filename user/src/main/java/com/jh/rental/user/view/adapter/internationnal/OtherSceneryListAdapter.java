package com.jh.rental.user.view.adapter.internationnal;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jh.rental.user.R;
import com.zhy.autolayout.utils.AutoUtils;

/**
 * Created by 俊辉出行 on 2017/5/31.
 */

public class OtherSceneryListAdapter extends RecyclerView.Adapter<OtherSceneryListAdapter.OtherSceneryHolder> {
    private final Context                mContext;

    public OtherSceneryListAdapter(Context context) {
        mContext = context;
    }

    @Override
    public OtherSceneryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new OtherSceneryHolder(LayoutInflater.from(mContext).inflate(R.layout.sub_item_otherscenery_list, parent, false));
    }


    @Override
    public void onBindViewHolder(final OtherSceneryHolder holder, int position) {
        holder.mItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return 12;
    }


    public class OtherSceneryHolder extends RecyclerView.ViewHolder {
        View mItemView;
        public OtherSceneryHolder(View itemView) {
            super(itemView);
            mItemView = itemView;
            AutoUtils.autoSize(mItemView);
        }
    }
}
