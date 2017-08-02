package com.jh.rental.user.view.adapter.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.bean.OrderDetails;
import com.jh.rental.user.bean.jason.HomeImg;
import com.jh.rental.user.bean.ordermessage.GetAreaAddressList;
import com.jh.rental.user.presenter.photo.PhotoUtils;
import com.jh.rental.user.utils.jason.ActivityUtils;
import com.jh.rental.user.view.actitity.destination.Destination_Activity;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;


/*
 *  @项目名：  AndroidApp
 *  @包名：    com.jh.rental.user.view.adapter
 *  @文件名:   HotDestinationsListAdapter
 *  @创建者:   ThinkPad
 *  @创建时间:  2017/5/21 22:55
 *  @描述：    TODO
 */
public class HotDestinationsListAdapter
        extends RecyclerView.Adapter {
    private Context mContext;
    private static final int TYPEL_HEAD = 0;
    private static final int TYPEL_ORDINARY = 1;
    private List<GetAreaAddressList> getAreaAddressList;

    public HotDestinationsListAdapter(Context context, List<GetAreaAddressList> getAreaAddressList) {
        mContext = context;

        this.getAreaAddressList = getAreaAddressList;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPEL_HEAD;
        } else {
            return TYPEL_ORDINARY;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
        switch (viewType) {
            case TYPEL_HEAD:
                itemView = LayoutInflater.from(mContext).inflate(R.layout.sub_item_hot_destination_head, parent, false);
                return new HotDestinationsHolder1(itemView);
            case TYPEL_ORDINARY:
                itemView = LayoutInflater.from(mContext).inflate(R.layout.sub_item_hot_destination_ordinary, parent, false);
                return new HotDestinationsHolder2(itemView);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        List<GetAreaAddressList.AddressListBean> addressList = getAreaAddressList.get(position).getAddressList();
        int viewType = getItemViewType(position);
        switch (viewType) {
            case TYPEL_HEAD:
                HotDestinationsHolder1 HotHolder1 = (HotDestinationsHolder1) holder;
                for (int i = 0; i < addressList.size(); i++) {
                    if (i == 0) {
//                        Glide.with(mContext).load(addressList.get(i).getImgUrl()).listener(getRequestListener( HotHolder1.ivImg1)).into(HotHolder1.ivImg1);
                        PhotoUtils.isHasToImg(addressList.get(i).getImgUrl(), HotHolder1.ivImg1);
                        final String name = addressList.get(i).getName();
                        HotHolder1.tvText1.setText(name);
                        HomeImg homeImg = new HomeImg(addressList.get(i).getIndexImgUrl(), addressList.get(i).getId(), name);
                        HotHolder1.ivImg1.setOnClickListener(getCityName(homeImg));
                    } else if (i == 1) {
//                        Glide.with(mContext).load(addressList.get(i).getImgUrl()).listener(getRequestListener( HotHolder1.ivImg2)).into(HotHolder1.ivImg2);
                        PhotoUtils.isHasToImg(addressList.get(i).getImgUrl(), HotHolder1.ivImg2);
                        final String name = addressList.get(i).getName();
                        HotHolder1.tvText2.setText(name);
                        HomeImg homeImg = new HomeImg(addressList.get(i).getIndexImgUrl(), addressList.get(i).getId(), name);
                        HotHolder1.ivImg2.setOnClickListener(getCityName(homeImg));
                    } else if (i == 2) {
//                        Glide.with(mContext).load(addressList.get(i).getImgUrl()).listener(getRequestListener( HotHolder1.ivImg3)).into(HotHolder1.ivImg3);
                        PhotoUtils.isHasToImg(addressList.get(i).getImgUrl(), HotHolder1.ivImg3);
                        final String name = addressList.get(i).getName();
                        HotHolder1.tvText3.setText(name);
                        HomeImg homeImg = new HomeImg(addressList.get(i).getIndexImgUrl(), addressList.get(i).getId(), name);
                        HotHolder1.ivImg3.setOnClickListener(getCityName(homeImg));
                    } else if (i == 3) {
//                        Glide.with(mContext).load(addressList.get(i).getImgUrl()).listener(getRequestListener( HotHolder1.ivImg4)).into(HotHolder1.ivImg4);
                        PhotoUtils.isHasToImg(addressList.get(i).getImgUrl(), HotHolder1.ivImg4);
                        final String name = addressList.get(i).getName();
                        HotHolder1.tvText4.setText(name);
                        HomeImg homeImg = new HomeImg(addressList.get(i).getIndexImgUrl(), addressList.get(i).getId(), name);
                        HotHolder1.ivImg4.setOnClickListener(getCityName(homeImg));
                    } else if (i == 4) {
//                        Glide.with(mContext).load(addressList.get(i).getImgUrl()).listener(getRequestListener( HotHolder1.ivImg5)).into(HotHolder1.ivImg5);
                        PhotoUtils.isHasToImg(addressList.get(i).getImgUrl(), HotHolder1.ivImg5);
                        final String name = addressList.get(i).getName();
                        HotHolder1.tvText5.setText(name);
                        HomeImg homeImg = new HomeImg(addressList.get(i).getIndexImgUrl(), addressList.get(i).getId(), name);
                        HotHolder1.ivImg5.setOnClickListener(getCityName(homeImg));
                    } else if (i > 4) {
                        break;
                    }
                }
                break;
            case TYPEL_ORDINARY:
                HotDestinationsHolder2 HotHolder2 = (HotDestinationsHolder2) holder;
                HotHolder2.tvTitle.setText(getAreaAddressList.get(position).getAreaName());
                for (int i = 0; i < addressList.size(); i++) {
                    if (i == 0) {
//                        Glide.with(mContext).load(addressList.get(i).getImgUrl()).listener(getRequestListener( HotHolder2.ivImg1)).into(HotHolder2.ivImg1);
                        PhotoUtils.isHasToImg(addressList.get(i).getImgUrl(), HotHolder2.ivImg1);
                        final String name = addressList.get(i).getName();
                        HotHolder2.tvText1.setText(name);
                        HomeImg homeImg = new HomeImg(addressList.get(i).getIndexImgUrl(), addressList.get(i).getId(), name);
                        HotHolder2.ivImg1.setOnClickListener(getCityName(homeImg));
                    } else if (i == 1) {
//                        Glide.with(mContext).load(addressList.get(i).getImgUrl()).listener(getRequestListener( HotHolder2.ivImg2)).into(HotHolder2.ivImg2);
                        PhotoUtils.isHasToImg(addressList.get(i).getImgUrl(), HotHolder2.ivImg2);
                        final String name = addressList.get(i).getName();
                        HotHolder2.tvText2.setText(name);
                        HomeImg homeImg = new HomeImg(addressList.get(i).getIndexImgUrl(), addressList.get(i).getId(), name);
                        HotHolder2.ivImg2.setOnClickListener(getCityName(homeImg));
                    } else if (i == 2) {
//                        Glide.with(mContext).load(addressList.get(i).getImgUrl()).listener(getRequestListener( HotHolder2.ivImg3)).into(HotHolder2.ivImg3);
                        PhotoUtils.isHasToImg(addressList.get(i).getImgUrl(), HotHolder2.ivImg3);
                        final String name = addressList.get(i).getName();
                        HotHolder2.tvText3.setText(name);
                        HomeImg homeImg = new HomeImg(addressList.get(i).getIndexImgUrl(), addressList.get(i).getId(), name);
                        HotHolder2.ivImg3.setOnClickListener(getCityName(homeImg));
                    } else if (i == 3) {
//                        Glide.with(mContext).load(addressList.get(i).getImgUrl()).listener(getRequestListener( HotHolder2.ivImg4)).into(HotHolder2.ivImg4);
                        PhotoUtils.isHasToImg(addressList.get(i).getImgUrl(), HotHolder2.ivImg4);
                        final String name = addressList.get(i).getName();
                        HotHolder2.tvText4.setText(name);
                        HomeImg homeImg = new HomeImg(addressList.get(i).getIndexImgUrl(), addressList.get(i).getId(), name);
                        HotHolder2.ivImg4.setOnClickListener(getCityName(homeImg));
                    } else if (i == 4) {
//                        Glide.with(mContext).load(addressList.get(i).getImgUrl()).listener(getRequestListener( HotHolder2.ivImg5)).into(HotHolder2.ivImg5);
                        PhotoUtils.isHasToImg(addressList.get(i).getImgUrl(), HotHolder2.ivImg5);
                        final String name = addressList.get(i).getName();
                        HotHolder2.tvText5.setText(name);
                        HomeImg homeImg = new HomeImg(addressList.get(i).getIndexImgUrl(), addressList.get(i).getId(), name);
                        HotHolder2.ivImg5.setOnClickListener(getCityName(homeImg));
                    } else if (i == 5) {
//                        Glide.with(mContext).load(addressList.get(i).getImgUrl()).listener(getRequestListener( HotHolder2.ivImg6)).into(HotHolder2.ivImg6);
                        PhotoUtils.isHasToImg(addressList.get(i).getImgUrl(), HotHolder2.ivImg6);
                        final String name = addressList.get(i).getName();
                        HotHolder2.tvText6.setText(name);
                        HomeImg homeImg = new HomeImg(addressList.get(i).getIndexImgUrl(), addressList.get(i).getId(), name);
                        HotHolder2.ivImg6.setOnClickListener(getCityName(homeImg));
                    } else {
                        break;
                    }
                }
                break;
        }

    }

    @NonNull
    private View.OnClickListener getCityName(final HomeImg img) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OrderDetails.setValue(img.getCityId(),img.getImgUrl());
                ActivityUtils.nextActivity(Destination_Activity.class, "cityName", img.getCityName());
            }
        };
    }
    @Override
    public int getItemCount() {
        return getAreaAddressList.size();
    }

    class HotDestinationsHolder1 extends RecyclerView.ViewHolder {
        private ImageView ivImg1, ivImg2, ivImg3, ivImg4, ivImg5;
        private TextView tvText1, tvText2, tvText3, tvText4, tvText5;

        public HotDestinationsHolder1(View itemView) {
            super(itemView);
            ivImg1 = (ImageView) itemView.findViewById(R.id.iv_img1);
            ivImg2 = (ImageView) itemView.findViewById(R.id.iv_img2);
            ivImg3 = (ImageView) itemView.findViewById(R.id.iv_img3);
            ivImg4 = (ImageView) itemView.findViewById(R.id.iv_img4);
            ivImg5 = (ImageView) itemView.findViewById(R.id.iv_img5);
            tvText1 = (TextView) itemView.findViewById(R.id.tv_Text1);
            tvText2 = (TextView) itemView.findViewById(R.id.tv_Text2);
            tvText3 = (TextView) itemView.findViewById(R.id.tv_Text3);
            tvText4 = (TextView) itemView.findViewById(R.id.tv_Text4);
            tvText5 = (TextView) itemView.findViewById(R.id.tv_Text5);
            AutoUtils.autoSize(itemView);
        }
    }

    class HotDestinationsHolder2 extends RecyclerView.ViewHolder {
        private ImageView ivImg1, ivImg2, ivImg3, ivImg4, ivImg5, ivImg6;
        private TextView tvTitle, tvText1, tvText2, tvText3, tvText4, tvText5, tvText6;

        public HotDestinationsHolder2(View itemView) {
            super(itemView);
            ivImg1 = (ImageView) itemView.findViewById(R.id.iv_img1);
            ivImg2 = (ImageView) itemView.findViewById(R.id.iv_img2);
            ivImg3 = (ImageView) itemView.findViewById(R.id.iv_img3);
            ivImg4 = (ImageView) itemView.findViewById(R.id.iv_img4);
            ivImg5 = (ImageView) itemView.findViewById(R.id.iv_img5);
            ivImg6 = (ImageView) itemView.findViewById(R.id.iv_img6);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvText1 = (TextView) itemView.findViewById(R.id.tv_text1);
            tvText2 = (TextView) itemView.findViewById(R.id.tv_text2);
            tvText3 = (TextView) itemView.findViewById(R.id.tv_text3);
            tvText4 = (TextView) itemView.findViewById(R.id.tv_text4);
            tvText5 = (TextView) itemView.findViewById(R.id.tv_text5);
            tvText6 = (TextView) itemView.findViewById(R.id.tv_text6);
            AutoUtils.autoSize(itemView);
        }
    }
}
