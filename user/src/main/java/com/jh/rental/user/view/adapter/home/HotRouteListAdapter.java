package com.jh.rental.user.view.adapter.home;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.api.ApiConstants;
import com.jh.rental.user.bean.home.HotCircuits;
import com.jh.rental.user.presenter.photo.PhotoUtils;
import com.jh.rental.user.utils.jason.ActivityUtils;
import com.jh.rental.user.view.actitity.destination.InLine_Activity;
import com.jh.rental.user.view.actitity.home.SceneryMessage3_Act;
import com.jh.rental.user.view.actitity.home.SceneryMessage_Act;

import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;


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

    private Context mContext;
    private List<HotCircuits.ListBean> list;

    public List<HotCircuits.ListBean> getList() {
        return list;
    }

    public void setList(List<HotCircuits.ListBean> list) {
        this.list = list;
    }

    public HotRouteListAdapter(Context context, List<HotCircuits.ListBean> list) {
        this.mContext = context;
        this.list = list;
    }

    @Override
    public HotRouteListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.sub_item_hot_line_list, parent, false);
        return new HotRouteListItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final HotRouteListItemViewHolder holder, final int position) {
        holder.textView1.setText(list.get(position).getName());
        if ("".equals(list.get(position).getBuyNum())) {
            holder.textView2.setText("0人购买");
        } else {
            holder.textView2.setText(list.get(position).getBuyNum() + "人购买");
        }
        holder.textView3.setText("原价:￥" + list.get(position).getPrintPrice());
        holder.textView3.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
        holder.textView4.setText(list.get(position).getSetPrice() + "");
        //   Glide.with(mContext).load(list.get(position).getImg()).listener(getRequestListener(holder.ivImg)).into(holder.ivImg);
     //   String img1 = list.get(position).getFirstImg();

        PhotoUtils.isHasToImg(list.get(position).getFirstImg(), holder.ivImg);
    /*    if (img1.indexOf(",") != -1) {
            String img2 = img1.substring(0,img1.indexOf(","));
//            Glide.with(mContext).load(img2).listener(getRequestListener( holder.ivImg)).into(holder.ivImg);
            PhotoUtils.isHasToImg(img2, holder.ivImg);
        }else {
//            Glide.with(mContext).load(img1).listener(getRequestListener( holder.ivImg)).into(holder.ivImg);
            PhotoUtils.isHasToImg(img1, holder.ivImg);
        }*/
        String showType = list.get(position).getShowType();
        final String cityName = list.get(position).getCityName();
        final String type = list.get(position).getServiceType();
        switch (type) {
            case "1":
            case "6":
                SetType(holder, showType, cityName, R.color.userBlue1);
                break;
            case "2":
                SetType(holder, showType, cityName, R.color.userBlue2);
                break;
            case "3":
                SetType(holder, showType, cityName, R.color.userOrange4);
                break;
            case "5":
                SetType(holder, showType, cityName, R.color.userYellow1);
                break;
        }
        holder.mItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (list.get(position).getCityName()!=null){
                    ApiConstants.queryCity=list.get(position).getCityName();
                }

                switch (type) {
                    case "1":
                    case "6":
                        ActivityUtils.nextActivity(SceneryMessage3_Act.class,"destinationid",list.get(position).getId());
                    break;
                    case "5":
                        ActivityUtils.nextActivity(InLine_Activity.class, "cityName", cityName ,"destinationid",list.get(position).getDestinationid());
                        break;
                }
            }
        });
    }

    private void SetType(HotRouteListItemViewHolder holder, String Type, String city, int color) {
        holder.textView5.setText(Type);
        holder.textView5.setBackgroundResource(color);
        holder.textView6.setText(city);
        holder.textView6.setTextColor(mContext.getResources().getColor(color));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HotRouteListItemViewHolder extends RecyclerView.ViewHolder {
        private View mItemView;
        private ImageView ivImg;
        private TextView textView1, textView2, textView3, textView4, textView5, textView6;
        public HotRouteListItemViewHolder(View itemView) {
            super(itemView);
            mItemView = itemView;
            textView1 = (TextView) itemView.findViewById(R.id.textView);
            textView2 = (TextView) itemView.findViewById(R.id.textView2);
            textView3 = (TextView) itemView.findViewById(R.id.textView3);
            textView4 = (TextView) itemView.findViewById(R.id.textView4);
            textView5 = (TextView) itemView.findViewById(R.id.textView5);
            textView6 = (TextView) itemView.findViewById(R.id.textView6);
            ivImg = (ImageView) itemView.findViewById(R.id.iv_img);
            AutoUtils.autoSize(mItemView);
        }
    }
}
