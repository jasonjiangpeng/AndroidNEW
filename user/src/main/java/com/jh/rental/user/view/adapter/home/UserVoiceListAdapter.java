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

public class UserVoiceListAdapter extends RecyclerView.Adapter<UserVoiceListAdapter.UserVoiceListItemViewHolder> {
    private final Context                mContext;
    private List<StorySBean.ListBean> storySBean;
    public UserVoiceListAdapter(Context context, List<StorySBean.ListBean> storySBean) {
        mContext = context;
        this.storySBean = storySBean;
    }

    public List<StorySBean.ListBean> getStorySBean() {
        return storySBean;
    }

    public void setStorySBean(List<StorySBean.ListBean> storySBean) {
        this.storySBean = storySBean;
    }

    @Override
    public UserVoiceListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new UserVoiceListItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.sub_item_user_voice_list,parent, false));
    }

    @Override
    public void onBindViewHolder(UserVoiceListItemViewHolder holder, final int position) {
//        Glide.with(mContext).load(storySBean.get(position).getImg()).listener(getRequestListener( holder.img)).into(holder.img);
        PhotoUtils.isHasToImg(storySBean.get(position).getImg(),holder.img);
        holder.name.setText(storySBean.get(position).getTitle());
        holder.context.setText(storySBean.get(position).getContent());
        holder.mItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                SnakebarUtils.showToast(storySBean.get(position).getDetailUrl());
                ActivityUtils.nextActivity(Story_Activity_.class,"UserVoice","客户心声","detail",storySBean.get(position).getDetailUrl());
            }
        });
    }

    @Override
    public int getItemCount() {
        if (storySBean!=null){
            return storySBean.size();
        }
        return 0;
    }

    public class UserVoiceListItemViewHolder
            extends RecyclerView.ViewHolder {
private ImageView img;
        private TextView  name,context;

        View mItemView;
        public UserVoiceListItemViewHolder(View itemView) {
            super(itemView);
            mItemView = itemView;
            img= (ImageView) mItemView.findViewById(R.id.iv_img);
            name= (TextView) mItemView.findViewById(R.id.textView);
            context= (TextView) mItemView.findViewById(R.id.context1);
            AutoUtils.autoSize(mItemView);
        }
    }
}
