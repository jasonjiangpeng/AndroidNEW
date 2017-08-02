package com.jh.rental.user.view.adapter.internationnal;

import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.api.ApiConstants;
import com.jh.rental.user.bean.OrderDetails;
import com.jh.rental.user.bean.home.HotCircuits;
import com.jh.rental.user.bean.home.Themess;
import com.jh.rental.user.constants.Constant;
import com.jh.rental.user.model.NetResponArrayData;
import com.jh.rental.user.model.homemodel.GetThemess;
import com.jh.rental.user.model.homemodel.HotDay;
import com.jh.rental.user.presenter.photo.PhotoUtils;
import com.jh.rental.user.utils.jason.ActivityUtils;
import com.jh.rental.user.utils.jason.Logger;
import com.jh.rental.user.utils.jason.SnakebarUtils;
import com.jh.rental.user.view.actitity.destination.Destination_Activity;
import com.jh.rental.user.view.actitity.home.Carpooling_Act;
import com.jh.rental.user.view.actitity.home.CharteredBus2_Act;
import com.jh.rental.user.view.actitity.home.DifineBusNew_Act;
import com.jh.rental.user.view.actitity.home.PickUpAirport_Act;
import com.jh.rental.user.view.actitity.home.SceneryMessage3_Act;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 俊辉出行 on 2017/5/27.
 */

public class LandscapeAdapter extends RecyclerView.Adapter {
    private Destination_Activity mContext;
    private static final int TYPEL_HEAD = 0;
    private static final int TYPEL_ORDINARY = 1;
    private int TAB = 1;
    private HotCircuits hot;

    List<HotCircuits.ListBean> hotCircuits;
    List<HotCircuits.ListBean> list2;
    List<HotCircuits.ListBean> list3;
    String mCityName;

    public LandscapeAdapter(Destination_Activity context, String cityName, HotCircuits hot) {
        this.hot = hot;
        this.mContext = context;
        this.mCityName = cityName;
        list2 = new ArrayList<>();
        list3 = new ArrayList<>();
        hotCircuits = new ArrayList<>();
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

    RecyclerView mRecyclerView;
    PopupWindow mP1, mP2, mP3;
    View view;
    ArrayList<String> list;

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if (hot.getList() != null) {
            hotCircuits.clear();
//            if (TAB == 1) {
                hotCircuits.addAll(hot.getList());
//            }
        }
        list2.clear();
        list3.clear();
        int viewType = getItemViewType(position);
        view = LayoutInflater.from(mContext).inflate(R.layout.view_spinner, null);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_spinner_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        final int[] point = {0, 0};
        switch (viewType) {
            case TYPEL_HEAD:
                final SceneryHolder1 sceneryHolder = (SceneryHolder1) holder;
                sceneryHolder.mCity.setText(mCityName);
                Logger.soutTestMessage(sceneryHolder.imgUrl.getLayoutParams().height + sceneryHolder.imgUrl.getLayoutParams().width + "====");
//                Glide.with(mContext).load(OrderDetails.getOrderDetails().getImgUrl()).listener(getRequestListener(sceneryHolder.imgUrl)).into(sceneryHolder.imgUrl);
                PhotoUtils.isHasToImg(OrderDetails.getOrderDetails().getImgUrl(), sceneryHolder.imgUrl);
               /* sceneryHolder.subTitle.setText(BaseContext.getResValue(R.string.destination));
                sceneryHolder.subGoback.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mContext.finish();
                    }
                });*/
//                if ("香港".equals(mCityName) | "澳门".equals(mCityName)) {
                sceneryHolder.llCarpooling.setVisibility(View.GONE);
//                }
                sceneryHolder.llCharteredbus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        SnakebarUtils.showToast("功能正在开发中");
                        ActivityUtils.nextActivity(CharteredBus2_Act.class, "tab", "2");
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
                        ActivityUtils.nextActivity(DifineBusNew_Act.class, "city", mCityName);
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
                        list = new ArrayList<>();
                        list.add("定制包车游");
                        /*list.add("接送机");
                        list.add("单次接送");
                        list.add("结伴拼车");*/
                        mRecyclerView.setAdapter(new SpinnerAdapter(list, sceneryHolder.mIvArea, sceneryHolder.mTvArea, 1));
                        mP1 = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                        mP1.setFocusable(true);
                        mP1.setOutsideTouchable(true);
                        mP1.setBackgroundDrawable(new BitmapDrawable());
                        sceneryHolder.mRlArea.getLocationOnScreen(point);
                        mP1.showAtLocation(view, Gravity.TOP | Gravity.LEFT, point[0] - ViewGroup.LayoutParams.MATCH_PARENT / 2 + sceneryHolder.mRlArea.getWidth() / 2, point[1] + sceneryHolder.mRlArea.getHeight());
                        mP1.setOnDismissListener(new PopupWindow.OnDismissListener() {
                            @Override
                            public void onDismiss() {
                                sceneryHolder.mIvArea.setBackgroundResource(R.drawable.w_g_pxxhdpi);
                                sceneryHolder.mTvArea.setTextColor(android.graphics.Color.parseColor("#424242"));
                                for (int i = 0; i < hot.getList().size(); i++) {
                                    if (hot.getList().get(i).getShowType() != "" & Constant.ROUTECHOICE.indexOf(hot.getList().get(i).getShowType()) != -1) {
                                        list2.add(hot.getList().get(i));
                                    } else {
                                        list3.add(hot.getList().get(i));
                                    }
                                }
                                if (list2.size() != 0) {
                                    TAB = 1;
                                    hot.getList().clear();
                                    hot.getList().addAll(list2);
                                    hot.getList().addAll(list3);
                                } else {
                                    TAB = 2;
//                                    SnakebarUtils.showToast("该路线暂未开通。");
                                }
                                notifyItemRangeChanged(0, hotCircuits.size());
                            }
                        });
                        sceneryHolder.mIvArea.setBackgroundResource(R.drawable.j_jxxhdpi);
                        sceneryHolder.mTvArea.setTextColor(android.graphics.Color.parseColor("#50B4FD"));
                    }


                });
                sceneryHolder.mRlDay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        list = new ArrayList<>();
                        new HotDay().reqNet(new NetResponArrayData<String>() {
                            @Override
                            public void responeData(List<String> values) {
                                list.clear();
                                if (values != null) {
                                    list.addAll(values);
                                }
                                mRecyclerView.getAdapter().notifyDataSetChanged();
                            }
                        });
                        mRecyclerView.setAdapter(new SpinnerAdapter(list, sceneryHolder.mIvArea, sceneryHolder.mTvArea, 2));
                        mP2 = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, 470/*ViewGroup.LayoutParams.WRAP_CONTENT*/);
                        mP2.setFocusable(true);
                        mP2.setOutsideTouchable(true);
                        mP2.setBackgroundDrawable(new BitmapDrawable());
                        sceneryHolder.mRlDay.getLocationOnScreen(point);
                        mP2.showAtLocation(view, Gravity.TOP | Gravity.LEFT, point[0] - ViewGroup.LayoutParams.MATCH_PARENT / 2 + sceneryHolder.mRlArea.getWidth() / 2, point[1] + sceneryHolder.mRlArea.getHeight());
                        mP2.setOnDismissListener(new PopupWindow.OnDismissListener() {
                            @Override
                            public void onDismiss() {
                                sceneryHolder.mIvDay.setBackgroundResource(R.drawable.w_g_pxxhdpi);
                                sceneryHolder.mTvDay.setTextColor(android.graphics.Color.parseColor("#424242"));
                                for (int i = 0; i < hot.getList().size(); i++) {
//                                    if (Constant.ROUTECHOICE.equals(hot.getList().get(i).getDayNum())) {
                                    if (Constant.ROUTECHOICE.indexOf(hot.getList().get(i).getDayNum()) != -1) {
                                        list2.add(hot.getList().get(i));
                                    } else {
                                        list3.add(hot.getList().get(i));
                                    }
                                }
                                if (list2.size() != 0) {
                                    TAB = 1;
                                    hot.getList().clear();
                                    hot.getList().addAll(list2);
                                    hot.getList().addAll(list3);
                                } else {
                                    TAB = 2;
//                                    SnakebarUtils.showToast("该路线暂未开通。");
                                }
                                notifyItemRangeChanged(0, hotCircuits.size());
                            }
                        });
                        sceneryHolder.mIvDay.setBackgroundResource(R.drawable.j_jxxhdpi);
                        sceneryHolder.mTvDay.setTextColor(android.graphics.Color.parseColor("#50B4FD"));
                    }
                });
                sceneryHolder.mRlTheme.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        list = new ArrayList<String>();
                        new GetThemess().reqNet(new NetResponArrayData<Themess>() {
                            @Override
                            public void responeData(List<Themess> values) {
                                list.clear();
                                if (values != null) {
                                    for (int i = 0; i < values.size(); i++) {
                                        Logger.soutTestMessage("list" + values.get(i).getName());
                                        list.add(values.get(i).getName());
                                    }
                                    mRecyclerView.getAdapter().notifyDataSetChanged();
                                }
                            }
                        });
                        mRecyclerView.setAdapter(new SpinnerAdapter(list, sceneryHolder.mIvArea, sceneryHolder.mTvArea, 3));
                        mP3 = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, 470/*ViewGroup.LayoutParams.WRAP_CONTENT*/);
                        mP3.setFocusable(true);
                        mP3.setOutsideTouchable(true);
                        mP3.setBackgroundDrawable(new BitmapDrawable());
                        sceneryHolder.mRlTheme.getLocationOnScreen(point);
                        mP3.showAtLocation(view, Gravity.TOP | Gravity.LEFT, point[0] - ViewGroup.LayoutParams.MATCH_PARENT / 2 + sceneryHolder.mRlArea.getWidth() / 2, point[1] + sceneryHolder.mRlArea.getHeight());
                        mP3.setOnDismissListener(new PopupWindow.OnDismissListener() {
                            @Override
                            public void onDismiss() {
                                sceneryHolder.mIvTheme.setBackgroundResource(R.drawable.w_g_pxxhdpi);
                                sceneryHolder.mTvTheme.setTextColor(android.graphics.Color.parseColor("#424242"));
                                for (int i = 0; i < hot.getList().size(); i++) {
                                    if (hot.getList().get(i).getThemeNames() != "" & hot.getList().get(i).getThemeNames().indexOf(Constant.ROUTECHOICE) != -1) {
                                        list2.add(hot.getList().get(i));
                                    } else {
                                        list3.add(hot.getList().get(i));
                                    }
                                }
                                if (list2.size() != 0) {
                                    TAB = 1;
                                    hot.getList().clear();
                                    hot.getList().addAll(list2);
                                    hot.getList().addAll(list3);
                                } else {
                                    TAB = 2;
//                                    SnakebarUtils.showToast("该路线暂未开通。");
                                }
                                notifyItemRangeChanged(0, hotCircuits.size());
                            }
                        });
                        sceneryHolder.mIvTheme.setBackgroundResource(R.drawable.j_jxxhdpi);
                        sceneryHolder.mTvTheme.setTextColor(android.graphics.Color.parseColor("#50B4FD"));

                    }
                });
                break;
            case TYPEL_ORDINARY:
                SceneryHolder2 sceneryHolder2 = (SceneryHolder2) holder;
                try {
                    sceneryHolder2.entry.setVisibility(View.VISIBLE);
                    sceneryHolder2.mType.setVisibility(View.VISIBLE);
                    if (hotCircuits.get(position - 1).getThemeNames() == "") {
                        sceneryHolder2.mHidden.setVisibility(View.GONE);
                    } else {
                        sceneryHolder2.mHidden.setVisibility(View.VISIBLE);
                    }
                    String img1 = hotCircuits.get(position - 1).getImg();
                    sceneryHolder2.prompt.setVisibility(View.GONE);
                    if (img1.indexOf(",") != -1) {
                        String img2 = img1.substring(0, img1.indexOf(","));
                        PhotoUtils.isHasToImg(img2, sceneryHolder2.iv_img);
                    } else {
                        PhotoUtils.isHasToImg(img1, sceneryHolder2.iv_img);
                    }
                    sceneryHolder2.themeName.setText(hotCircuits.get(position - 1).getThemeNames());
                    sceneryHolder2.textView.setText(hotCircuits.get(position - 1).getName());
                    sceneryHolder2.priceSet.setText("￥" + hotCircuits.get(position - 1).getSetPrice());
                    sceneryHolder2.tv_original_price.setText(hotCircuits.get(position - 1).getBuyNum() + "人购买");
                    sceneryHolder2.mItemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ApiConstants.queryCity = hotCircuits.get(position - 1).getCityName();
                            ActivityUtils.nextActivity(SceneryMessage3_Act.class, "destinationid", hotCircuits.get(position - 1).getId());
                        }
                    });
                    String showType = hotCircuits.get(position - 1).getShowType();
                    String cityName = hotCircuits.get(position - 1).getCityName();
                    int type = Integer.valueOf(hotCircuits.get(position - 1).getServiceType());
                    switch (type) {
                        case 1:
                        case 6:
                            SetType(sceneryHolder2, showType, cityName, R.color.userBlue1);
                            break;
                        case 2:
                            SetType(sceneryHolder2, showType, cityName, R.color.userBlue2);
                            break;
                        case 3:
                            SetType(sceneryHolder2, showType, cityName, R.color.userOrange4);
                            break;
                        case 5:
                            SetType(sceneryHolder2, showType, cityName, R.color.userYellow1);
                            break;
                    }
                } catch (Exception e) {
                    sceneryHolder2.prompt.setVisibility(View.VISIBLE);
                    sceneryHolder2.entry.setVisibility(View.GONE);
                }

                break;
        }
    }

    private void SetType(SceneryHolder2 holder, String Type, String city, int color) {
        holder.textView5.setText(Type);
        holder.textView5.setBackgroundResource(color);
        holder.textView6.setText(city);
        holder.textView6.setTextColor(mContext.getResources().getColor(color));
    }

    @Override
    public int getItemCount() {
        int a = 2;
        if (hotCircuits != null & hotCircuits.size() > 0) {
            a = hotCircuits.size() + 1;
        }
//        SnakebarUtils.showToast("a===" + a);
        return a;
    }


    class SceneryHolder1 extends RecyclerView.ViewHolder {
        RelativeLayout mRlArea, mRlDay, mRlTheme;
        LinearLayout llCharteredbus, llAirport, llTailoredCar, llCarpooling;
        TextView mTvArea, mTvDay, mTvTheme, mCity/*, subGoback, subTitle*/;
        ImageView mIvArea, mIvDay, mIvTheme, imgUrl;
        View mItemView;

        public SceneryHolder1(View itemView) {
            super(itemView);
            mItemView = itemView;
            AutoUtils.autoSize(itemView);
            llCharteredbus = (LinearLayout) itemView.findViewById(R.id.ll_charteredbus);
            llAirport = (LinearLayout) itemView.findViewById(R.id.ll_airport);
            llTailoredCar = (LinearLayout) itemView.findViewById(R.id.ll_tailoredCar);
            llCarpooling = (LinearLayout) itemView.findViewById(R.id.ll_carpooling);
            mRlArea = (RelativeLayout) itemView.findViewById(R.id.rl_area);
            mRlDay = (RelativeLayout) itemView.findViewById(R.id.rl_day);
            mRlTheme = (RelativeLayout) itemView.findViewById(R.id.rl_theme);
            imgUrl = (ImageView) itemView.findViewById(R.id.imageView33);
            mTvArea = (TextView) itemView.findViewById(R.id.tv_area);
            mTvDay = (TextView) itemView.findViewById(R.id.tv_day);
            mTvTheme = (TextView) itemView.findViewById(R.id.tv_theme);
            mCity = (TextView) itemView.findViewById(R.id.city);
            mIvArea = (ImageView) itemView.findViewById(R.id.iv_area);
            mIvDay = (ImageView) itemView.findViewById(R.id.iv_day);
            mIvTheme = (ImageView) itemView.findViewById(R.id.iv_theme);
//            subGoback = (TextView) itemView.findViewById(R.id.sub_goback);
//            subTitle = (TextView) itemView.findViewById(R.id.sub_title);
        }
    }

    class SceneryHolder2 extends RecyclerView.ViewHolder {
        private ImageView iv_img;
        private TextView themeName, tv_original_price, priceSet, textView5, textView6, textView, prompt;
        private View mItemView;
        private LinearLayout mType, mHidden, entry;

        public SceneryHolder2(View itemView) {
            super(itemView);
            mItemView = itemView;
            iv_img = (ImageView) mItemView.findViewById(R.id.iv_img);
            themeName = (TextView) mItemView.findViewById(R.id.themeName);
            tv_original_price = (TextView) mItemView.findViewById(R.id.tv_original_price);
            textView5 = (TextView) mItemView.findViewById(R.id.textView5);
            textView6 = (TextView) mItemView.findViewById(R.id.textView6);
            priceSet = (TextView) mItemView.findViewById(R.id.priceSet);
            textView = (TextView) mItemView.findViewById(R.id.textView);
            prompt = (TextView) mItemView.findViewById(R.id.prompt);
            mType = (LinearLayout) mItemView.findViewById(R.id.type);
            mHidden = (LinearLayout) mItemView.findViewById(R.id.hidden);
            entry = (LinearLayout) mItemView.findViewById(R.id.entry);
            AutoUtils.autoSize(mItemView);
        }
    }

    class SpinnerAdapter extends RecyclerView.Adapter<SpinnerAdapter.MyViewHolder> {
        ArrayList<String> mDatas;
        ImageView mIvArea;
        TextView mTvArea;
        int mIn;

        public SpinnerAdapter(ArrayList<String> list, ImageView ivArea, TextView tvArea, int i) {
            mDatas = list;
            mIvArea = ivArea;
            mTvArea = tvArea;
            mIn = i;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                    mContext).inflate(R.layout.item_test, parent,
                    false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            final int mPosition = position;
            holder.tv.setText(mDatas.get(position));
            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Toast.makeText(mContext, mDatas.get(mPosition), Toast.LENGTH_SHORT).show();
                    mIvArea.setBackgroundResource(R.drawable.w_g_pxxhdpi);
                    mTvArea.setTextColor(android.graphics.Color.parseColor("#424242"));
                    Constant.CHOOSETAG = mIn;
                    Constant.ROUTECHOICE = mDatas.get(mPosition);
                    if (mIn == 1) {
                        mP1.dismiss();
                    } else if (mIn == 2) {
                        mP2.dismiss();
                    } else if (mIn == 3) {
                        mP3.dismiss();
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return mDatas.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            TextView tv;
            View mView;

            public MyViewHolder(View view) {
                super(view);
                tv = (TextView) view.findViewById(R.id.test1);
                mView = view;
                AutoUtils.autoSize(mView);
            }
        }
    }
}