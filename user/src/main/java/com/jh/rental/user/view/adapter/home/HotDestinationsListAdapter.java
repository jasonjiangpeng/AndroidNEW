package com.jh.rental.user.view.adapter.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.jh.rental.user.view.widget.HotDestinationListItemView;


/*
 *  @项目名：  AndroidApp
 *  @包名：    com.jh.rental.user.view.adapter
 *  @文件名:   HotDestinationsListAdapter
 *  @创建者:   ThinkPad
 *  @创建时间:  2017/5/21 22:55
 *  @描述：    TODO
 */
public class HotDestinationsListAdapter
        extends RecyclerView.Adapter<HotDestinationsListAdapter.PopularDestinationsListItemViewHolder> {

    private static final String TAG = "HotDestinationsListAdapter";
    private final Context                mContext;

    public HotDestinationsListAdapter(Context context) {
        mContext = context;
    }

    @Override
    public PopularDestinationsListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PopularDestinationsListItemViewHolder(new HotDestinationListItemView(mContext));
    }

    @Override
    public void onBindViewHolder(PopularDestinationsListItemViewHolder holder, int position) {
        holder.mHotDestinationListItemView.setOnClickListener(new View.OnClickListener() {
            //点击条目跳转页面
            @Override
            public void onClick(View v) {

            }
        });
    }


    @Override
    public int getItemCount() {
        return 9;
    }

    public class PopularDestinationsListItemViewHolder
            extends RecyclerView.ViewHolder
    {

        private HotDestinationListItemView mHotDestinationListItemView;

        public PopularDestinationsListItemViewHolder(HotDestinationListItemView itemView) {
            super(itemView);
            mHotDestinationListItemView = itemView;
        }
    }
}
