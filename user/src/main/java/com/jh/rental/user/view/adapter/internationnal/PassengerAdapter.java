package com.jh.rental.user.view.adapter.internationnal;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jh.rental.user.R;
import com.jh.rental.user.utils.jason.BaseContext;
import com.zhy.autolayout.utils.AutoUtils;

/**
 * Created by 俊辉出行 on 2017/6/10.
 */

public class PassengerAdapter extends RecyclerView.Adapter<PassengerAdapter.PassengerHolder> {

    Context mContext;
    public PassengerAdapter(Context context) {
        mContext=context;
    }

    @Override
    public PassengerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(BaseContext.context).inflate(R.layout.sub_item_passenger_list, parent, false);
        return new PassengerHolder(view);
    }

    @Override
    public void onBindViewHolder(PassengerHolder holder, int position) {
        holder.mItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    @Override
    public int getItemCount() {
        return 3;
    }

    public class PassengerHolder extends RecyclerView.ViewHolder {
        View mItemView;
        public PassengerHolder(View itemView) {
            super(itemView);
            mItemView = itemView;
            AutoUtils.autoSize(itemView);
        }
    }
}
