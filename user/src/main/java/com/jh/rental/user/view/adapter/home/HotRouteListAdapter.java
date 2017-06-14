package com.jh.rental.user.view.adapter.home;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.zhy.autolayout.utils.AutoUtils;


/*
 *  @项目名：  AndroidApp
 *  @包名：    com.jh.rental.user.view.adapter
 *  @文件名:   HotRouteListAdapter
 *  @创建者:   ThinkPad
 *  @创建时间:  2017/5/21 23:38
 *  @描述：    TODO
 */
public class HotRouteListAdapter
        extends RecyclerView.Adapter<HotRouteListAdapter.HotRouteListItemViewHolder> {

    private static final String TAG = "HotRouteListAdapter";
    private final Context                mContext;

    public HotRouteListAdapter(Context context) {
        mContext = context;
    }

    @Override
    public HotRouteListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.sub_item_hot_line_list, parent, false);
        return  new HotRouteListItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HotRouteListItemViewHolder holder, int position) {
        holder.mTxt.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG|Paint.ANTI_ALIAS_FLAG);
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

    public class HotRouteListItemViewHolder
            extends RecyclerView.ViewHolder {

        View mItemView;
        TextView mTxt;
        public HotRouteListItemViewHolder(View itemView) {
            super(itemView);
            mItemView = itemView;
            mTxt = (TextView) mItemView.findViewById(R.id.tv_original_price);
            AutoUtils.autoSize(mItemView);

        }
    }
}
