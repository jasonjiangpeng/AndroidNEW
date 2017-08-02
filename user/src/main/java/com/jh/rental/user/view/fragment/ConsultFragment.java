package com.jh.rental.user.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.hyphenate.helpdesk.easeui.util.IntentBuilder;
import com.jh.rental.user.R;
import com.jh.rental.user.api.ApiConstants;
import com.jh.rental.user.api.ApiGet;
import com.jh.rental.user.bean.OrderDetails;
import com.jh.rental.user.model.HttpVolley;
import com.jh.rental.user.presenter.NetJsonArraySucceed;
import com.jh.rental.user.presenter.huanxin.HxChat;
import com.jh.rental.user.presenter.photo.PhotoUtils;
import com.jh.rental.user.utils.jason.ActivityUtils;
import com.jh.rental.user.utils.jason.Logger;
import com.jh.rental.user.view.BaseApplication;
import com.jh.rental.user.view.actitity.login.Login_Act_;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ConsultFragment extends BaseFragment implements View.OnClickListener {
    public static final String TAG = "ConsultFragment";
    RelativeLayout mNotLogged;

    private CircleImageView imgconstact1,imgconstact2;
    @Override
    public View setView() {
        return LayoutInflater.from(getContext()).inflate(R.layout.fragment_consult,null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
          init();


    }

    @Override
    public void onResume() {
        if (ApiConstants.localCookie == null) {
            mNotLogged.setVisibility(View.VISIBLE);
        }else {
            mNotLogged.setVisibility(View.GONE);
              HxChat.login(getContext());
              getService();
        }
        super.onResume();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
    public void init(){
        mNotLogged = (RelativeLayout) getView().findViewById(R.id.NotLogged);
        LinearLayout service1 = (LinearLayout) getView().findViewById(R.id.service1);
        LinearLayout service2 = (LinearLayout) getView().findViewById(R.id.service2);
        imgconstact1 = (CircleImageView) getView().findViewById(R.id.imgconstact1);
        imgconstact2 = (CircleImageView) getView().findViewById(R.id.imgconstact2);
        service1.setOnClickListener(this);
        service2.setOnClickListener(this);
         Button login = (Button) getView().findViewById(R.id.login);
         login.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.service1:
                HxChat.session(getContext());
                break;
            case R.id.service2:
                HxChat.session(getContext(),2);
                break;
            case R.id.login:
                ActivityUtils.nextActivity(Login_Act_.class);
                break;
        }
    }
    private void getService(){
        HttpVolley.getInstance().getRequestData(ApiGet.getServices,new NetJsonArraySucceed<HxServices>(HxServices.class, new NetJsonArraySucceed.HolderData<HxServices>() {
            @Override
            public void holdData(ArrayList<HxServices> bean) {
                Logger.soutTestMessage(bean.get(0).toString());
                if (bean.size()>1){
                    PhotoUtils.isHasToImg(bean.get(0).getServiceImg(),imgconstact1);
                    PhotoUtils.isHasToImg(bean.get(1).getServiceImg(),imgconstact2);
                }

            }
        }));
    }

    class HxServices {
        private int serviceNum;
        private String serviceName;
        private String serviceJobNum;
        private String serviceImg;
        public int getServiceNum() {
            return serviceNum;
        }
        public void setServiceNum(int serviceNum) {
            this.serviceNum = serviceNum;
        }
        public String getServiceName() {
            return serviceName;
        }
        public void setServiceName(String serviceName) {
            this.serviceName = serviceName;
        }
        public String getServiceJobNum() {
            return serviceJobNum;
        }
        public void setServiceJobNum(String serviceJobNum) {
            this.serviceJobNum = serviceJobNum;
        }
        public String getServiceImg() {
            return serviceImg;
        }
        public void setServiceImg(String serviceImg) {
            this.serviceImg = serviceImg;
        }
    }
}
