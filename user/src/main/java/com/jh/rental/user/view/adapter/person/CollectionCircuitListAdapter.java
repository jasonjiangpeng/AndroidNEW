package com.jh.rental.user.view.adapter.person;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jh.rental.user.R;
import com.zhy.autolayout.utils.AutoUtils;

/**
 * Created by 俊辉出行 on 2017/5/26.
 */

public class CollectionCircuitListAdapter extends RecyclerView.Adapter<CollectionCircuitListAdapter.CollectionCircuitListItemViewHolder> {
    private final Context                mContext;

    public CollectionCircuitListAdapter(Context context) {
        mContext = context;
    }

    @Override
    public CollectionCircuitListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CollectionCircuitListItemViewHolder( LayoutInflater.from(mContext).inflate(R.layout.sub_item_collection_circuit_list, parent, false));
    }

    @Override
    public void onBindViewHolder(CollectionCircuitListItemViewHolder holder, int position) {
        holder.mItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class CollectionCircuitListItemViewHolder
            extends RecyclerView.ViewHolder {

        View mItemView;
        public CollectionCircuitListItemViewHolder(View itemView) {
            super(itemView);
            mItemView = itemView;
            AutoUtils.autoSize(mItemView);
        }
    }
}
