package com.jh.rental.user.view.adapter.person;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.bean.user.UserCollection;
import com.jh.rental.user.presenter.photo.PhotoUtils;
import com.jh.rental.user.utils.jason.ActivityUtils;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.view.actitity.home.SceneryMessage3_Act;
import com.jh.rental.user.view.actitity.home.SceneryMessage_Act;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * Created by 俊辉出行 on 2017/5/26.
 */

public class CollectionCircuitListAdapter extends RecyclerView.Adapter<CollectionCircuitListAdapter.CollectionCircuitListItemViewHolder> {
    private Context mContext;
    private List<UserCollection.ListBean> mList;
    public CollectionCircuitListAdapter(Context context, List<UserCollection.ListBean> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public CollectionCircuitListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CollectionCircuitListItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.sub_item_collection_circuit_list, parent, false));
    }

    @Override
    public void onBindViewHolder(CollectionCircuitListItemViewHolder holder, final int position) {
        String img1 = mList.get(position).getImgUrl();
        if (img1.indexOf(",") != -1) {
            String img2 = img1.substring(0,img1.indexOf(","));
            PhotoUtils.isHasToImg(img2, holder.ivImg);
        }else {
            PhotoUtils.isHasToImg(img1, holder.ivImg);
        }
        holder.textView1.setText(mList.get(position).getName());
        if ("0".equals(mList.get(position).getBuyNum())){
            holder.textView2.setText("0"+ BaseContext.getResValue(R.string.buy));
        }else {
            holder.textView2.setText(mList.get(position).getBuyNum()+ BaseContext.getResValue(R.string.buy));
        }
        if ("0".equals(mList.get(position).getPrintPrice())){
            holder.textView3.setText("￥0");
        }else {
            holder.textView3.setText("￥"+mList.get(position).getPrintPrice());
        }
        holder.textView3.setText(mList.get(position).getPrintPrice());

        holder.mItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtils.nextActivity(SceneryMessage3_Act.class,"destinationid",mList.get(position).getScId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class CollectionCircuitListItemViewHolder
            extends RecyclerView.ViewHolder {

        View mItemView;
        ImageView ivImg;
        TextView textView1,textView2,textView3;
        public CollectionCircuitListItemViewHolder(View view) {
            super(view);
            mItemView = view;
            ivImg = (ImageView) view.findViewById(R.id.iv_img);
            textView1 = (TextView) view.findViewById(R.id.textView1);
            textView2 = (TextView) view.findViewById(R.id.textView2);
            textView3 = (TextView) view.findViewById(R.id.textView3);
            AutoUtils.autoSize(mItemView);
        }
    }
}
