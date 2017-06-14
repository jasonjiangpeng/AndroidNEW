package com.jh.rental.user.view.adapter.internationnal;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.utils.jason.ActivityUtils;
import com.jh.rental.user.view.actitity.home.Carpooling_Act;
import com.jh.rental.user.view.actitity.home.CharteredBus_Act;
import com.jh.rental.user.view.actitity.home.DifineBus_Act;
import com.jh.rental.user.view.actitity.home.PickUpAirport_Act;
import com.zhy.autolayout.utils.AutoUtils;

/**
 * Created by 俊辉出行 on 2017/5/27.
 */

public class LandscapeAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private PopupWindow mPopupWindow;
    public static final int TYPEL_HEAD = 0;
    public static final int TYPEL_ORDINARY = 1;

    public LandscapeAdapter(Context context) {
        mContext = context;
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
                itemView = LayoutInflater.from(mContext).inflate(R.layout.sub_item_scenery_head, parent, false);
                return new SceneryHolder1(itemView);
            case TYPEL_ORDINARY:
                itemView = LayoutInflater.from(mContext).inflate(R.layout.sub_item_scenery_list, parent, false);
                return new SceneryHolder2(itemView);
            default:
                return null;
        }
    }
    int flag1 = 0;
    int flag2 = 0;
    int flag3 = 0;
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        switch (viewType) {
            case TYPEL_HEAD:
                final SceneryHolder1 sceneryHolder = (SceneryHolder1) holder;
                sceneryHolder.llCharteredbus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ActivityUtils.nextActivity(CharteredBus_Act.class);
                    }
                });
                sceneryHolder.llAirport.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ActivityUtils.nextActivity(PickUpAirport_Act.class);
                    }
                });
                sceneryHolder.llTailoredCar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ActivityUtils.nextActivity(DifineBus_Act.class);
                    }
                });
                sceneryHolder.llCarpooling.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ActivityUtils.nextActivity(Carpooling_Act.class);
                    }
                });
                sceneryHolder.mRlArea.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (flag1 == 0) {
                            sceneryHolder.mIvArea.setBackgroundResource(R.drawable.j_jxxhdpi);
                            sceneryHolder.mIvDay.setBackgroundResource(R.drawable.w_g_pxxhdpi);
                            sceneryHolder.mIvTheme.setBackgroundResource(R.drawable.w_g_pxxhdpi);
                            sceneryHolder.mTvArea.setTextColor(android.graphics.Color.parseColor("#50B4FD"));
                            sceneryHolder.mTvDay.setTextColor(android.graphics.Color.parseColor("#424242"));
                            sceneryHolder.mTvTheme.setTextColor(android.graphics.Color.parseColor("#424242"));
                            flag1 = 1;
                            flag2 = 0;
                            flag3 = 0;
                        } else {
                            sceneryHolder.mIvArea.setBackgroundResource(R.drawable.w_g_pxxhdpi);
                            sceneryHolder. mTvArea.setTextColor(android.graphics.Color.parseColor("#424242"));
                            flag1 = 0;
                        }
                    }


                });
                sceneryHolder.mRlDay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (flag2 == 0) {
                            sceneryHolder.mIvDay.setBackgroundResource(R.drawable.j_jxxhdpi);
                            sceneryHolder.mIvArea.setBackgroundResource(R.drawable.w_g_pxxhdpi);
                            sceneryHolder.mIvTheme.setBackgroundResource(R.drawable.w_g_pxxhdpi);
                            sceneryHolder.mTvArea.setTextColor(android.graphics.Color.parseColor("#424242"));
                            sceneryHolder.mTvDay.setTextColor(android.graphics.Color.parseColor("#50B4FD"));
                            sceneryHolder.mTvTheme.setTextColor(android.graphics.Color.parseColor("#424242"));
                            flag1 = 0;
                            flag2 = 1;
                            flag3 = 0;
                        } else {
                            sceneryHolder.mIvDay.setBackgroundResource(R.drawable.w_g_pxxhdpi);
                            sceneryHolder.mTvDay.setTextColor(android.graphics.Color.parseColor("#424242"));
                            flag2 = 0;
                        }
                    }
                });
                sceneryHolder.mRlTheme.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (flag3 == 0) {
                            sceneryHolder.mIvTheme.setBackgroundResource(R.drawable.j_jxxhdpi);
                            sceneryHolder.mIvArea.setBackgroundResource(R.drawable.w_g_pxxhdpi);
                            sceneryHolder.mIvDay.setBackgroundResource(R.drawable.w_g_pxxhdpi);
                            sceneryHolder.mTvArea.setTextColor(android.graphics.Color.parseColor("#424242"));
                            sceneryHolder.mTvDay.setTextColor(android.graphics.Color.parseColor("#424242"));
                            sceneryHolder.mTvTheme.setTextColor(android.graphics.Color.parseColor("#50B4FD"));
                            flag1 = 0;
                            flag2 = 0;
                            flag3 = 1;
                        } else {
                            sceneryHolder.mIvTheme.setBackgroundResource(R.drawable.w_g_pxxhdpi);
                            sceneryHolder.mTvTheme.setTextColor(android.graphics.Color.parseColor("#424242"));
                            flag3 = 0;
                        }
                    }
                });
                break;
            case TYPEL_ORDINARY:
                break;
        }
    }


    @Override
    public int getItemCount() {
        return 10;
    }

    class SceneryHolder1
            extends RecyclerView.ViewHolder {

        RelativeLayout mRlArea;
        RelativeLayout mRlDay;
        RelativeLayout mRlTheme;
        LinearLayout llCharteredbus;
        LinearLayout llAirport;
        LinearLayout llTailoredCar;
        LinearLayout llCarpooling;
        TextView mTvArea;
        TextView mTvDay;
        TextView mTvTheme;
        ImageView mIvArea;
        ImageView mIvDay;
        ImageView mIvTheme;
        View mItemView;

        public SceneryHolder1(View itemView) {
            super(itemView);
            mItemView = itemView;
            AutoUtils.autoSize(itemView);
            llCharteredbus = (LinearLayout) mItemView.findViewById(R.id.ll_charteredbus);
            llAirport = (LinearLayout) mItemView.findViewById(R.id.ll_airport);
            llTailoredCar = (LinearLayout) mItemView.findViewById(R.id.ll_tailoredCar);
            llCarpooling = (LinearLayout) mItemView.findViewById(R.id.ll_carpooling);
            mRlArea = (RelativeLayout) mItemView.findViewById(R.id.rl_area);
            mRlDay = (RelativeLayout) mItemView.findViewById(R.id.rl_day);
            mRlTheme = (RelativeLayout) mItemView.findViewById(R.id.rl_theme);
            mTvArea = (TextView) mItemView.findViewById(R.id.tv_area);
            mTvDay = (TextView) mItemView.findViewById(R.id.tv_day);
            mTvTheme = (TextView) mItemView.findViewById(R.id.tv_theme);
            mIvArea = (ImageView) mItemView.findViewById(R.id.iv_area);
            mIvDay = (ImageView) mItemView.findViewById(R.id.iv_day);
            mIvTheme = (ImageView) mItemView.findViewById(R.id.iv_theme);
        }
    }

    class SceneryHolder2
            extends RecyclerView.ViewHolder {

        View mItemView;

        public SceneryHolder2(View itemView) {
            super(itemView);
            mItemView = itemView;
            AutoUtils.autoSize(mItemView);
        }
    }

}