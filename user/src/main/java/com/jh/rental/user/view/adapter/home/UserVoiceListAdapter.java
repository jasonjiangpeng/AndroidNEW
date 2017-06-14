package com.jh.rental.user.view.adapter.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jh.rental.user.R;
import com.zhy.autolayout.utils.AutoUtils;


/**
 * Created by 俊辉出行 on 2017/5/22.
 */

public class UserVoiceListAdapter extends RecyclerView.Adapter<UserVoiceListAdapter.UserVoiceListItemViewHolder> {
    private final Context                mContext;
    public UserVoiceListAdapter(Context context) {
        mContext = context;
    }

    @Override
    public UserVoiceListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new UserVoiceListItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.sub_item_user_voice_list,parent, false));
    }

    @Override
    public void onBindViewHolder(UserVoiceListItemViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class UserVoiceListItemViewHolder
            extends RecyclerView.ViewHolder {

        View mItemView;
        public UserVoiceListItemViewHolder(View itemView) {
            super(itemView);
            mItemView = itemView;
            AutoUtils.autoSize(mItemView);
        }
    }
}
