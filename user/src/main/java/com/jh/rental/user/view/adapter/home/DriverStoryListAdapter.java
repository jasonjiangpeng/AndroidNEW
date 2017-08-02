package com.jh.rental.user.view.adapter.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.bean.login.StorySBean;
import com.jh.rental.user.presenter.photo.PhotoUtils;
import com.jh.rental.user.utils.jason.ActivityUtils;
import com.jh.rental.user.utils.jason.SnakebarUtils;
import com.jh.rental.user.view.actitity.home.Story_Activity_;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;


/**
 * Created by 俊辉出行 on 2017/5/22.
 */

public class DriverStoryListAdapter extends RecyclerView.Adapter<DriverStoryListAdapter.DriverStoryListItemViewHolder> {
    private final Context mContext;

    private List<StorySBean.ListBean> listBean;

    public List<StorySBean.ListBean> getListBean() {
        return listBean;
    }

    public void setListBean(List<StorySBean.ListBean> listBean) {
        this.listBean = listBean;
    }

    public DriverStoryListAdapter(Context context, List<StorySBean.ListBean> listBean) {
        this.mContext = context;
        this.listBean = listBean;
    }

    @Override
    public DriverStoryListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DriverStoryListItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.sub_item_driver_story_list, parent, false));
    }

    @Override
    public void onBindViewHolder(DriverStoryListItemViewHolder holder, final int position) {
//        Glide.with(mContext).load(listBean.get(position).getImg()).listener(getRequestListener(holder.img)).into(holder.img);
        PhotoUtils.isHasToImg(listBean.get(position).getImg(), holder.img);
        holder.tv.setText(listBean.get(position).getContent());
        holder.mItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                SnakebarUtils.showToast(listBean.get(position).getDetailUrl());
                ActivityUtils.nextActivity(Story_Activity_.class,"UserVoice","司导故事","detail",listBean.get(position).getDetailUrl());
            }
        });
    }

    @Override
    public int getItemCount() {
        if (listBean != null) {
            return listBean.size();
        }
        return 0;
    }

    public class DriverStoryListItemViewHolder
            extends RecyclerView.ViewHolder {

        View mItemView;
        private ImageView img;
        private TextView tv;

        public DriverStoryListItemViewHolder(View itemView) {
            super(itemView);
            mItemView = itemView;
            img = (ImageView) mItemView.findViewById(R.id.iv_img);
            tv = (TextView) mItemView.findViewById(R.id.textView);
            AutoUtils.autoSize(mItemView);
        }
    }
}
