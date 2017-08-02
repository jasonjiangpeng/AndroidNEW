package com.jh.rental.user.view.adapter.person;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.bean.jason.CouponBean;

/**
 * Created by 俊辉出行 on 2017/6/1.
 */

public class CouponsAdapter extends BaseAdapter {
    Context context;
    CouponBean couponBean;
    public CouponsAdapter(Context context,CouponBean couponBean) {
        this.context=context;
        this.couponBean=couponBean;

    }

    @Override
    public int getCount() {
        if (couponBean.getList()!=null){
             if (couponBean.getList()!=null){
                 return Math.min(couponBean.getSize(),couponBean.getList().size());
             }
            return couponBean.getSize();
        }
        return 0;
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
        CouponsHolder couponsHolder=null;
        if (convertView == null){
            couponsHolder=new CouponsHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.sub_item_coupons,null);
            couponsHolder.couTv1 = (TextView) convertView.findViewById(R.id.couTv1);
            couponsHolder.couTv2 = (TextView) convertView.findViewById(R.id.couTv2);
            couponsHolder.couTv3 = (TextView) convertView.findViewById(R.id.couTv3);
            couponsHolder.couTv4 = (TextView) convertView.findViewById(R.id.couTv4);
            couponsHolder.couTv5 = (TextView) convertView.findViewById(R.id.couTv5);
            convertView.setTag(couponsHolder);
        }
        couponsHolder = (CouponsHolder)convertView.getTag();
        couponsHolder.couTv1.setText(couponBean.getList().get(position).getName());
   //     couponsHolder.couTv2.setText(couponBean.getList().get(position).getName());
        String[] start = couponBean.getList().get(position).getStartDate().split(" ");
        String[] end = couponBean.getList().get(position).getEndDate().split(" ");
        couponsHolder.couTv3.setText("有效日期:"+start[0]+"-"+end[0]);
        couponsHolder.couTv4.setText(couponBean.getList().get(position).getMoney());
        if (!"0.0".equals(couponBean.getList().get(position).getLimitMinMoney())){
            couponsHolder.couTv5.setText("满"+couponBean.getList().get(position).getLimitMinMoney()+"使用");
        }




        return convertView;
    }

    class CouponsHolder {

        TextView couTv5,couTv4,couTv3,couTv2,couTv1;
    }
}
