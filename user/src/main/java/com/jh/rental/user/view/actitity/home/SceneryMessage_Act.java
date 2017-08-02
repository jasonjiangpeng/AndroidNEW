package com.jh.rental.user.view.actitity.home;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.api.ApiConstants;
import com.jh.rental.user.api.ApiGet;
import com.jh.rental.user.bean.CarPriceSend;
import com.jh.rental.user.bean.OrderDetails;
import com.jh.rental.user.bean.ShareCirle;
import com.jh.rental.user.bean.circutmodule.QueryHotCircuitById;
import com.jh.rental.user.model.HttpVolley;
import com.jh.rental.user.model.NetResponData;
import com.jh.rental.user.model.circutmomudle.HotCircuitById;
import com.jh.rental.user.presenter.huanxin.HxChat;
import com.jh.rental.user.presenter.net.NetError;
import com.jh.rental.user.presenter.net.NetSucceed;
import com.jh.rental.user.presenter.share.PopShareCirleView;
import com.jh.rental.user.utils.jason.ActivityUtils;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.utils.jason.SnakebarUtils;
import com.jh.rental.user.view.BaseApplication;
import com.jh.rental.user.view.actitity.BaseActvity;
import com.jh.rental.user.view.actitity.destination.StartEndDesActivity;
import com.jh.rental.user.view.fragment.scenery.CommentFragment;
import com.jh.rental.user.view.fragment.scenery.OtherFragment;
import com.jh.rental.user.view.fragment.scenery.WebFragment2;
import com.jh.rental.user.view.other.TextShow;
import com.jh.rental.user.view.popview.PopwindowUtils;
import com.jh.rental.user.view.widget.Entity;
import com.jh.rental.user.view.widget.NoScrollViewPager;
import com.jh.rental.user.view.widget.RecyclerBanner;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by 骏辉出行 on 2017/6/6.
 */

public class SceneryMessage_Act extends BaseActvity implements View.OnClickListener {
    private TextView subTitle, imgcall, imgconstact;
    private TabLayout tablayout;
    private NoScrollViewPager viewpager;
    private RelativeLayout mHead;

    private List<Fragment> fragmentList;
    private ImageView subGoback, share;
    private Button journeyreserve;
    private String destinationid, lineId;
    private TextShow textViewshow;
   private    int[] resId1 = {R.drawable.m_c_aaxxhdpi, R.drawable.m_c_caxxhdpi, R.drawable.m_c_daxxhdpi};
    private   int[] resId2 = {R.drawable.m_c_abxxhdpi, R.drawable.m_c_cbxxhdpi, R.drawable.m_c_dbxxhdpi};
    String[] values = BaseContext.getResArraysValue(R.array.scenery_message);
    private String[] collection = {"type", "scId"};
    private List<RecyclerBanner.BannerEntity> Effective;
    private RecyclerBanner rbHead;

    //    int tab=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OrderDetails.creOredeDetails();
        CarPriceSend.createInit();
        ApiConstants.OrderlTpye = 4;
        setContentView(R.layout.scenerytest_sub);
        textViewshow = new TextShow();
        Effective = new ArrayList<>();
        textViewshow.showText(this);
        loading();
    }

    private void loading() {
        if (getIntent().getStringExtra("destinationid") != null) {
            destinationid = getIntent().getStringExtra("destinationid");
            OrderDetails.getOrderDetails().setScenId(destinationid);
            new HotCircuitById().reqNet(destinationid, new NetResponData<QueryHotCircuitById>() {
                @Override
                public void responeData(final QueryHotCircuitById object) {
                    ShareCirle.getShacirl().setFistUrl(object.getFirstImg());
                    ShareCirle.getShacirl().setContextName(object.getName());
                    ShareCirle.getShacirl().setShareUrl(object.getCircuitShareUrl());
                    OrderDetails.getOrderDetails().setDestinationID(object.getDestinationid());
                    OrderDetails.getOrderDetails().setCircleId(object.getId());
                    initFragment();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            textViewshow.setText(object);
                            lineId = object.getId();
                            if (object.getImgs().size() > 0) {
                                for (int i = 0; i < object.getImgs().size(); i++) {
                                    Effective.add(new Entity(object.getImgs().get(i)));
                                }
                                rbHead.setDatas(Effective);
                            } else {
                                return;
                            }
                        }
                    }, 10);
                }
            });
        }
    }

    private void initFragment(){
       fragmentList = new ArrayList<>();
       fragmentList.add(new WebFragment2());
     //  fragmentList.add(new JourneyFragment());
       fragmentList.add(new OtherFragment());
       fragmentList.add(new CommentFragment());
       initView();
   }
    @Override
    protected void onDestroy() {
        for (int i = 0; i < values.length; i++) {
            values[i] = null;
        }
        PopwindowUtils.closePopWin();
        super.onDestroy();
    }

    private void initView() {
        imgcall = (TextView) findViewById(R.id.imgcall);
        imgcall.setOnClickListener(this);
        imgconstact = (TextView) findViewById(R.id.imgconstact);
        imgconstact.setOnClickListener(this);


        mHead = (RelativeLayout) findViewById(R.id.head);
        tablayout = (TabLayout) findViewById(R.id.scenery_layout);
        viewpager = (NoScrollViewPager) findViewById(R.id.scenery_viewpager);
//        mCollect = (LinearLayout) findViewById(R.id.collect);
        subGoback = (ImageView) findViewById(R.id.sub_goback);
//        ivCollect = (ImageView) findViewById(R.id.iv_collect);
        share = (ImageView) findViewById(R.id.share);
        share.setOnClickListener(this);
        journeyreserve = (Button) findViewById(R.id.journeyreserve);
        journeyreserve.setOnClickListener(this);
        subTitle = (TextView) findViewById(R.id.sub_title);
        rbHead = (RecyclerBanner) findViewById(R.id.rb_head);
        subTitle.setText(BaseContext.getResValue(R.string.LineDetails));
        subGoback.setOnClickListener(this);

//        mCollect.setOnClickListener(this);

        initUI();
    }

    private void initUI() {
        Point point = new Point();
        this.getWindowManager().getDefaultDisplay().getSize(point);
        int width = point.x;
        //  int width = this.getWindowManager().getDefaultDisplay().getSize();
        ViewGroup.LayoutParams params = mHead.getLayoutParams();
        params.height = (int) (width * 0.128);
        mHead.setLayoutParams(params);
        viewpager.setAdapter(new SceneryAdapter(getSupportFragmentManager(), fragmentList));
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < tablayout.getTabCount(); i++) {
                    if (position == i) {
                        tablayout.getTabAt(i).setIcon(resId1[i]).setText(values[i]);
                    } else {
                        tablayout.getTabAt(i).setIcon(resId2[i]).setText(values[i]);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        tablayout.setupWithViewPager(viewpager, true);
        for (int i = 0; i < tablayout.getTabCount(); i++) {
            if (0 == i) {
                tablayout.getTabAt(i).setIcon(resId1[i]).setText(values[i]);
            } else {
                tablayout.getTabAt(i).setIcon(resId2[i]).setText(values[i]);
            }

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sub_goback:
                BaseApplication.finishActivity();
                break;
            case R.id.share:
                PopwindowUtils.getPopwindowUtils().show(new PopShareCirleView(this),v,SceneryMessage_Act.this);
//                SnakebarUtils.showToast("再按一次退出程序");
                break;
            case R.id.journeyreserve:
                //       AppUtils.isLogin(this);
                ActivityUtils.nextActivity(StartEndDesActivity.class);
                break;
            case R.id.imgcall:
                requestPermission(new String[]{Manifest.permission.CALL_PHONE}, 888);

                break;
            case R.id.imgconstact:
                if (ApiConstants.localCookie != null) {
                    HxChat.session(this);
                } else {
                    SnakebarUtils.showToast("请先注册登录");
                }
                break;
        }
    }

    @Override
    public void permissionSuccess(int requestCode) {
        super.permissionSuccess(requestCode);
        switch (requestCode) {
            case 888:
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:0755-89328932"));
                if (ActivityCompat.checkSelfPermission(BaseApplication.currentActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(intent);
                break;

        }
    }

    private void saveUserCollection() {
        HttpVolley.getInstance().getRequestParamData(ApiGet.saveUserCollection, getLinkdHashHap(collection, "1", lineId), new NetSucceed<>(String.class, new NetSucceed.HolderData<String>() {
            @Override
            public void holdData(String bean) {}
        }), new NetError());
    }

    private void deleteUserCollection() {
        HttpVolley.getInstance().getRequestParamData(ApiGet.deleteUserCollection, getLinkdHashHap(collection, "1", lineId), new NetSucceed<>(String.class, new NetSucceed.HolderData<String>() {
            @Override
            public void holdData(String bean) {}
        }), new NetError());
    }

    public LinkedHashMap<String, String> getLinkdHashHap(String[] efg, String... abc) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        for (int i = 0; i < efg.length; i++) {
            linkedHashMap.put(efg[i], abc[i]);
        }
        return linkedHashMap;
    }


    private class SceneryAdapter extends FragmentPagerAdapter {
        List<Fragment> list;

        public SceneryAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            this.list = fragments;
        }

        @Override
        public Fragment getItem(int position) {

            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {



            return super.getPageTitle(position);
        }
    }

}
