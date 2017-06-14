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

public class CollectionSceneryListAdapter extends RecyclerView.Adapter<CollectionSceneryListAdapter.CollectionSceneryItemViewHolder> {
    private final Context                mContext;

    public CollectionSceneryListAdapter(Context context) {
        mContext = context;
    }

    @Override
    public CollectionSceneryItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return  new CollectionSceneryItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.sub_item_collection_scenery_list,parent, false));

    }

    @Override
    public void onBindViewHolder(CollectionSceneryItemViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class CollectionSceneryItemViewHolder extends RecyclerView.ViewHolder {

        public CollectionSceneryItemViewHolder(View itemView) {
            super(itemView);
            AutoUtils.autoSize(itemView);
        }
    }
}
