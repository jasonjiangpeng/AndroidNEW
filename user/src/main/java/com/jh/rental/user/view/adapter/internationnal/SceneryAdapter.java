package com.jh.rental.user.view.adapter.internationnal;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.api.ApiConstants;
import com.jh.rental.user.bean.home.HotCircuits;
import com.jh.rental.user.presenter.photo.PhotoUtils;
import com.jh.rental.user.utils.jason.ActivityUtils;
import com.jh.rental.user.view.actitity.home.SceneryMessage3_Act;
import com.jh.rental.user.view.actitity.home.SceneryMessage_Act;
import com.zhy.autolayout.utils.AutoUtils;

/**
 * Created by 俊辉出行 on 2017/5/27.
 */

public class SceneryAdapter extends RecyclerView.Adapter<SceneryAdapter.SceneryListItemViewHolder> {

    private final Context mContext;
    private HotCircuits mHotCircuits;
    public SceneryAdapter(Context context, HotCircuits hotCircuits) {
        mContext = context;
        mHotCircuits = hotCircuits;
    }



    @Override
    public SceneryListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SceneryListItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.sub_item_scenery_list, parent, false));
    }

    @Override
    public void onBindViewHolder(SceneryListItemViewHolder holder, final int position) {
        String img1 = mHotCircuits.getList().get(position).getImg();
        if (img1.indexOf(",") != -1) {
            String img2 = img1.substring(0,img1.indexOf(","));
//            Glide.with(mContext).load(img2).listener(getRequestListener( holder.iv_img)).into(holder.iv_img);
            PhotoUtils.isHasToImg(img2, holder.iv_img);
        }else {
//            Glide.with(mContext).load(img1).listener(getRequestListener( holder.iv_img)).into(holder.iv_img);
            PhotoUtils.isHasToImg(img1, holder.iv_img);
        }
//        holder.themeName.setText(mHotCircuits.getList().get(position).getThemeNames());
        holder.hidden.setVisibility(View.GONE);
        holder.textView.setText(mHotCircuits.getList().get(position).getName());
        holder.priceSet.setText("￥" + mHotCircuits.getList().get(position).getSetPrice());
        if (mHotCircuits.getList().get(position).getBuyNum()==""){
            holder.tv_original_price.setText("0人购买");
        }else {
            holder.tv_original_price.setText(mHotCircuits.getList().get(position).getBuyNum() + "人购买");
        }
        holder.mItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiConstants.queryCity = mHotCircuits.getList().get(position).getCityName();
                ActivityUtils.nextActivity(SceneryMessage3_Act.class,"destinationid", mHotCircuits.getList().get(position).getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mHotCircuits == null || mHotCircuits.getList() == null) {
            return 0;
        }
        return mHotCircuits.getList().size();
    }

    public class SceneryListItemViewHolder
            extends RecyclerView.ViewHolder {

        View mItemView;
        private ImageView iv_img;
        LinearLayout hidden;
        private TextView themeName, tv_original_price, priceSet,textView;
        public SceneryListItemViewHolder(View itemView) {
            super(itemView);
            mItemView = itemView;
            iv_img = (ImageView) mItemView.findViewById(R.id.iv_img);
//            themeName = (TextView) mItemView.findViewById(R.id.themeName);
            hidden = (LinearLayout) mItemView.findViewById(R.id.hidden);
            textView = (TextView) mItemView.findViewById(R.id.textView);
            priceSet = (TextView) mItemView.findViewById(R.id.priceSet);
            tv_original_price = (TextView) mItemView.findViewById(R.id.tv_original_price);
            AutoUtils.autoSize(mItemView);
        }
    }
}
