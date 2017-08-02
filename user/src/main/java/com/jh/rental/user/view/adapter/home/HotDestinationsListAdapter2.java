/*
package com.jh.rental.user.view.adapter.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.jh.rental.user.R;
import com.jh.rental.user.bean.ordermessage.GetAreaAddressList;
import com.jh.rental.user.utils.jason.Logger;
import com.jh.rental.user.view.widget.ImageViewFont;

import java.util.ArrayList;
import java.util.List;


*/
/*
 *  @项目名：  AndroidApp
 *  @包名：    com.jh.rental.user.view.adapter
 *  @文件名:   HotDestinationsListAdapter
 *
 *  @创建者:   ThinkPad
 *  @创建时间:  2017/5/21 22:55
 *  @描述：    TODO
 *//*

public class HotDestinationsListAdapter2 extends RecyclerView.Adapter<HotDestinationsListAdapter2.PopularDestinationsListItemViewHolder2> {

    private static final String TAG = "HotDestinationsListAdapter";
    private  Context  mContext;
    private ArrayList<GetAreaAddressList> getAreaAddressList;
    public HotDestinationsListAdapter2(Context context,ArrayList<GetAreaAddressList> getAreaAddressList) {
        this.mContext = context;
        this.getAreaAddressList=getAreaAddressList;
    }

    @Override
    public PopularDestinationsListItemViewHolder2 onCreateViewHolder(ViewGroup parent, int viewType) {
        View  view= LayoutInflater.from(mContext).inflate(R.layout.sub_item_hot_destination,parent,false);

        return new PopularDestinationsListItemViewHolder2(view);
    }

    @Override
    public void onBindViewHolder(PopularDestinationsListItemViewHolder2 holder, int position) {
        Logger.soutMessage("onBindViewHolder");
        List<GetAreaAddressList.AddressListBean> addressList = getAreaAddressList.get(position).getAddressList();
           if (position==0){
               holder.linearLayout2.setVisibility(View.GONE);
               for (int i = 0; i <addressList.size(); i++) {
                   if (i==0){
                       Glide.with(mContext).load(addressList.get(i).getImgUrl()).into(holder.img1);
                       holder.img1.setText(addressList.get(i).getName());
                   }else if (i==1){
                       Glide.with(mContext).load(addressList.get(i).getImgUrl()).into(holder.img2);
                       holder.img2.setText(addressList.get(i).getName());
                   }else if (i==2){
                       Glide.with(mContext).load(addressList.get(i).getImgUrl()).into(holder.img3);
                       holder.img3.setText(addressList.get(i).getName());
                   }else if (i==3){
                       Glide.with(mContext).load(addressList.get(i).getImgUrl()).into(holder.img4);
                       holder.img4.setText(addressList.get(i).getName());
                   }else if (i==4){
                       Glide.with(mContext).load(addressList.get(i).getImgUrl()).into(holder.img5);
                       holder.img5.setText(addressList.get(i).getName());
                   }else if (i>4) {
                       break;
                   }
               }
           }else {
               holder.linearLayout1.setVisibility(View.GONE);
              holder.city.setText(getAreaAddressList.get(position).getAreaName());
               for (int i = 0; i <addressList.size(); i++) {
                   if (i==0){
                       Glide.with(mContext).load(addressList.get(i).getImgUrl()).into(holder.ig1);
                       holder.hott1.setText(addressList.get(i).getName());
                   }else if (i==1){
                       Glide.with(mContext).load(addressList.get(i).getImgUrl()).into(holder.ig2);
                       holder.hott2.setText(addressList.get(i).getName());
                   }else if (i==2){
                       Glide.with(mContext).load(addressList.get(i).getImgUrl()).into(holder.ig3);
                       holder.hott3.setText(addressList.get(i).getName());
                   }else {
                       break;
                   }
               }
           }
    }


    @Override
    public int getItemCount() {
        return getAreaAddressList.size();
    }

    public class PopularDestinationsListItemViewHolder2 extends RecyclerView.ViewHolder {
     private    LinearLayout  linearLayout1,linearLayout2;
        private    ImageViewFont  img1,img2,img3,img4,img5;

        private   ImageView ig1,ig2,ig3;
        private   TextView   city,hott1,hott2,hott3;

        public PopularDestinationsListItemViewHolder2(View itemView) {
            super(itemView);
            linearLayout1= (LinearLayout) itemView.findViewById(R.id.hotlayout1);
            linearLayout2= (LinearLayout) itemView.findViewById(R.id.hotlayout2);
            img1= (ImageViewFont) itemView.findViewById(R.id.hotdes1);
            img2= (ImageViewFont) itemView.findViewById(R.id.hotdes2);
            img3= (ImageViewFont) itemView.findViewById(R.id.hotdes3);
            img4= (ImageViewFont) itemView.findViewById(R.id.hotdes4);
            img5= (ImageViewFont) itemView.findViewById(R.id.hotdes5);
            hott1= (TextView) itemView.findViewById(R.id.citytv1);
            hott2= (TextView) itemView.findViewById(R.id.citytv2);
            city= (TextView) itemView.findViewById(R.id.city);
            hott3= (TextView) itemView.findViewById(R.id.citytv3);
            ig1= (ImageView) itemView.findViewById(R.id.cityimg1);
            ig2= (ImageView) itemView.findViewById(R.id.cityimg2);
            ig3= (ImageView) itemView.findViewById(R.id.cityimg3);
            }
    }
}
*/
