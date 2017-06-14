package com.jh.rental.user.view.adapter.person;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.jh.rental.user.R;

/**
 * Created by 俊辉出行 on 2017/6/1.
 */

public class CouponsAdapter extends BaseAdapter {
    Context context;
    public CouponsAdapter(Context context) {
        this.context=context;
    }

    @Override
    public int getCount() {
        return 20;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CouponsHolder couponsHolder;
        if (convertView == null){
            convertView= LayoutInflater.from(context).inflate(R.layout.sub_item_coupons,null);
            couponsHolder = new CouponsHolder();
            convertView.setTag(couponsHolder);
        }else{
            couponsHolder = (CouponsHolder)convertView.getTag();
        }
//        couponsHolder.mTvTitle1 = (TextView) convertView.findViewById(R.id.tv_title1);
//        couponsHolder.mTvTitle2 = (TextView) convertView.findViewById(R.id.tv_title2);
//        couponsHolder.mTvValidtime = (TextView) convertView.findViewById(R.id.tv_validtime);
//        couponsHolder.mTvMoney = (TextView) convertView.findViewById(R.id.tv_money);
//        couponsHolder.mTvUse = (TextView) convertView.findViewById(R.id.tv_use);
        couponsHolder.mCoupons = (ImageView) convertView.findViewById(R.id.coupons);
        return convertView;
    }

    class CouponsHolder {
        ImageView mCoupons;
//        TextView mTvTitle1;
//        TextView mTvTitle2;
//        TextView mTvValidtime;
//        TextView mTvMoney;
//        TextView mTvUse;

    }
}
