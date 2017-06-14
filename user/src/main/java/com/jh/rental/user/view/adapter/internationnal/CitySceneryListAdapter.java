package com.jh.rental.user.view.adapter.internationnal;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jh.rental.user.R;
import com.zhy.autolayout.utils.AutoUtils;

/**
 * Created by 俊辉出行 on 2017/5/31.
 */

public class CitySceneryListAdapter extends RecyclerView.Adapter<CitySceneryListAdapter.CitySceneryHolder> {

    private final Context                mContext;

    public CitySceneryListAdapter(Context context) {
        mContext = context;
    }

    @Override
    public CitySceneryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CitySceneryHolder(LayoutInflater.from(mContext).inflate(R.layout.sub_item_cityscenery_list, parent, false));
    }

    @Override
    public void onBindViewHolder(final CitySceneryHolder holder, int position) {
        holder.mItemView.setOnClickListener(new View.OnClickListener() {
            int tag = 0;
            @Override
            public void onClick(View v) {
                if (tag == 0) {
                    holder.mSelect.setVisibility(View.VISIBLE);
                    tag = 1;
                }else {
                    holder.mSelect.setVisibility(View.GONE);
                    tag = 0;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class CitySceneryHolder extends RecyclerView.ViewHolder {

        View mItemView;
        private ImageView mSelect;

        public CitySceneryHolder(View itemView) {
            super(itemView);
            mItemView = itemView;
            mSelect = (ImageView) mItemView.findViewById(R.id.select);
            AutoUtils.autoSize(mItemView);
        }
    }
}
