package com.jh.rental.user;


import android.Manifest;
import android.app.Activity;

import android.app.Activity;

import android.app.PendingIntent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.toolbox.ImageLoader;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.codbking.widget.DatePickDialog;
import com.codbking.widget.bean.DateType;
import com.jh.rental.user.api.ApiGet;
import com.jh.rental.user.bean.order.FindOrdersbean;
import com.jh.rental.user.model.HttpVolley;
import com.jh.rental.user.presenter.NetJsonArraySucceed;
import com.jh.rental.user.presenter.net.NetError;
import com.jh.rental.user.presenter.net.NetSucceed;
import com.jh.rental.user.utils.jason.Logger;
import com.jh.rental.user.utils.jason.SnakebarUtils;


import com.jh.rental.user.view.BaseApplication;
import com.jh.rental.user.view.actitity.BaseActvity;
import com.jh.rental.user.view.popview.PopwindowUtils;
import com.jh.rental.user.view.widget.PopJourneyCounterView;
import com.jh.rental.user.view.widget.PopTimeView;

import java.io.IOException;
import java.lang.reflect.Type;

import java.lang.reflect.Type;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;


/**
 * Created by 骏辉出行 on 2017/5/18.
 */
public class TestActivity extends BaseActvity {
 // String url = "http://47.52.94.158:8090/jh-app-web/unauth/sms/sendSms";
  String[] a = {"type"};
  LinearLayout lv;
  int[] resid = {R.drawable.m_c_oxxhdpi, R.drawable.g_b_fxxhdpi, R.drawable.g_b_fxxhdpi, R.drawable.g_b_fxxhdpi};
  ImageView img1, img2, img3, img4;
  List<ImageView> list = new ArrayList<>();

private  View  views;
  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.calender_activity);
    img1= (ImageView) findViewById(R.id.img);


  }
    private String[] values={"start","size"};
    private void netRequst() {
        HttpVolley.getInstance().getRequestParamData(ApiGet.findOrders,getLinkdHashHap(values,"1","10"),new NetSucceed<>(FindOrdersbean.class, new NetSucceed.HolderData<FindOrdersbean>() {
            @Override
            public void holdData(FindOrdersbean bean) {
                if (bean==null){
                    return;
                }
                if (bean.getList().size()>0){
                    for (int i = 0; i <bean.getList().size() ; i++) {
                        Logger.soutMessage(bean.getList().get(i).getStatusName());
                    }
                }

            }
        }),new NetError());
    }
  public void onClicka(View view) {

     netRequst();
  }


  public void onClickb(View value) {
      Glide.with(this).load(url2).into(img1);
  }
  String url= "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=149" +
          "7423272782&di=95944ffb73a253f5554a257aaf65ed87&imgtype=jpg&src=http%3A%2F%2Fimg3.im" +
          "gtn.bdimg.com%2Fit%2Fu%3D1314796313%2C4036714048%26fm%3D214%26gp%3D0.jpg";
    String url2="https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1985013354,1644267139&fm=58";
}
