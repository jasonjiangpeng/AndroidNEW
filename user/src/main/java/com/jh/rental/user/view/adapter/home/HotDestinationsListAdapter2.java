package com.jh.rental.user.view.adapter.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.jh.rental.user.R;
import com.jh.rental.user.utils.jason.BaseContext;
import com.zhy.autolayout.utils.AutoUtils;


/*
 *  @项目名：  AndroidApp
 *  @包名：    com.jh.rental.user.view.adapter
 *  @文件名:   HotDestinationsListAdapter
 *
 *  @创建者:   ThinkPad
 *  @创建时间:  2017/5/21 22:55
 *  @描述：    TODO
 */
public class HotDestinationsListAdapter2 extends RecyclerView.Adapter<HotDestinationsListAdapter2.PopularDestinationsListItemViewHolder2> {

    private static final String TAG = "HotDestinationsListAdapter";
    private final Context                mContext;

    public HotDestinationsListAdapter2(Context context) {
        mContext = context;
    }

    @Override
    public PopularDestinationsListItemViewHolder2 onCreateViewHolder(ViewGroup parent, int viewType) {
        View  view= LayoutInflater.from(BaseContext.context).inflate(R.layout.sub_item_hot_destination,parent, false);
        return new PopularDestinationsListItemViewHolder2(view);
    }

    @Override
    public void onBindViewHolder(PopularDestinationsListItemViewHolder2 holder, int position) {
                   if (position==0){
                       holder.linearLayout.setVisibility(View.VISIBLE);
                   }else {
                       holder.linearLayout.setVisibility(View.GONE);
                   }
    }


    @Override
    public int getItemCount() {
        return 9;
    }

    public class PopularDestinationsListItemViewHolder2 extends RecyclerView.ViewHolder {
        LinearLayout  linearLayout;

        public PopularDestinationsListItemViewHolder2(View itemView) {
            super(itemView);
            linearLayout= (LinearLayout) itemView.findViewById(R.id.hot_linear_layout);
            AutoUtils.autoSize(itemView);
        }
    }
}
