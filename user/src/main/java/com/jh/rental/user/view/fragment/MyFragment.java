package com.jh.rental.user.view.fragment;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.api.ApiConstants;
import com.jh.rental.user.api.ApiGet;
import com.jh.rental.user.bean.LoginBean;
import com.jh.rental.user.bean.login.GetUserInfo;
import com.jh.rental.user.constants.Constant;
import com.jh.rental.user.model.HttpVolley;
import com.jh.rental.user.presenter.net.NetSucceed;
import com.jh.rental.user.presenter.photo.PhotoUtils;
import com.jh.rental.user.utils.jason.ActivityUtils;
import com.jh.rental.user.utils.jason.Logger;
import com.jh.rental.user.utils.jason.SnakebarUtils;
import com.jh.rental.user.utils.tom.PreferencesUtil;
import com.jh.rental.user.view.BaseApplication;
import com.jh.rental.user.view.actitity.login.Login_Act_;
import com.jh.rental.user.view.actitity.person.CommonProblems_Activity_;
import com.jh.rental.user.view.actitity.person.Coupons_Activity_;
import com.jh.rental.user.view.actitity.person.IdeaCallBack_Activity;
import com.jh.rental.user.view.actitity.person.PersonMessage_Activity2_;
import com.jh.rental.user.view.actitity.person.ShareGift_Activity_;
import com.jh.rental.user.view.actitity.person.UserAgreement_Activity_;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyFragment extends BaseFragment implements View.OnClickListener {
    LoginBean smsBean = null;
    private String str;
    private TextView phone;
    public void requestNet(){
        HttpVolley.getInstance().getRequestData(ApiGet.getUserInfo, new NetSucceed<>(GetUserInfo.class, new NetSucceed.HolderData<GetUserInfo>() {
            @Override
            public void holdData(GetUserInfo bean) {
                updata(bean);
            }
        }));

    }
    public void updata(final GetUserInfo bean){
        PhotoUtils.isHasToImg(bean.getImgurl(),imageView);
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                phone.setText(bean.getNickName());
            }
        });
    }
    @Override
    public View setView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.text_show, null);
        if (smsBean == null) {
        }
        init(view);

        return view;
    }

    CircleImageView imageView;
    protected void init(View view) {
        imageView = (CircleImageView) view.findViewById(R.id.my_personphtone);
//        LinearLayout linearLayout1 = (LinearLayout) view.findViewById(R.id.myfragment1);
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.myfragment2);
//        LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.myfragment3);
        LinearLayout linearLayout4 = (LinearLayout) view.findViewById(R.id.myfragment4);
        LinearLayout linearLayout5 = (LinearLayout) view.findViewById(R.id.myfragment5);
        LinearLayout linearLayout6 = (LinearLayout) view.findViewById(R.id.myfragment6);
        LinearLayout linearLayout7 = (LinearLayout) view.findViewById(R.id.myfragment7);
        LinearLayout callservice = (LinearLayout) view.findViewById(R.id.callservice);
//        LinearLayout soscall = (LinearLayout) view.findViewById(R.id.soscall);
        callservice.setOnClickListener(this);
//        soscall.setOnClickListener(this);
        phone = (TextView) view.findViewById(R.id.phone);
        phone.setOnClickListener(this);
        imageView.setOnClickListener(this);
//        linearLayout1.setOnClickListener(this);
        linearLayout2.setOnClickListener(this);
//        linearLayout3.setOnClickListener(this);
        linearLayout4.setOnClickListener(this);
        linearLayout5.setOnClickListener(this);
        linearLayout6.setOnClickListener(this);
        linearLayout7.setOnClickListener(this);

    }

    /*public void requestNet(){
        HttpVolley.getInstance().getRequestData(ApiGet.getUserInfo, new NetSucceed<>(GetUserInfo.class, new NetSucceed.HolderData<GetUserInfo>() {
            @Override
            public void holdData(GetUserInfo bean) {
                if (bean.getMobile()!=null){
                    Constant.PHONE = bean.getMobile();
                    Constant.NAME = bean.getNickName();
                    Constant.SEX = bean.getSex();
                }
            }
        }));
    }*/



    @Override
    public void onResume() {
        super.onResume();
        if (ApiConstants.localCookie!=null){
            requestNet();
        }else {
            imageView.setImageResource(R.drawable.fxxhdpi);
            phone.setText("请先登录...");
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.phone:
            case R.id.my_personphtone:
                str = PreferencesUtil.getString(getActivity(), Constant.REGISTER);
                Logger.showMessage(str + "========" + ApiConstants.localCookie);
//                SnakebarUtils.showToast(str + "========" + ApiConstants.localCookie);
                if (str.equals(ApiConstants.localCookie)) {
                    ActivityUtils.nextActivity(PersonMessage_Activity2_.class);
                } else {
                    ActivityUtils.nextActivity(Login_Act_.class);
                }
                break;
           /* case R.id.myfragment1:
                ActivityUtils.nextActivity(Collection_Activity.class);
                break;*/
            case R.id.myfragment2:
                ActivityUtils.nextActivity(Coupons_Activity_.class);
                break;
           /* case R.id.myfragment3:
                ActivityUtils.nextActivity(InvoiceService_Activity.class);
                break;*/
            case R.id.myfragment4:
                ActivityUtils.nextActivity(CommonProblems_Activity_.class);
                break;
            case R.id.myfragment5:
                ActivityUtils.nextActivity(ShareGift_Activity_.class);
                break;
            case R.id.myfragment6:
                ActivityUtils.nextActivity(UserAgreement_Activity_.class);
                break;
            case R.id.myfragment7:
                ActivityUtils.nextActivity(IdeaCallBack_Activity.class);
                break;
            case R.id.callservice:
                requestPermission(new String[]{Manifest.permission.CALL_PHONE},888);
                break;
           /* case R.id.soscall:
                requestPermission(new String[]{Manifest.permission.CALL_PHONE},897);
                break;*/
        }
    }

    @Override
    public void permissionFail(int requestCode) {
        super.permissionFail(requestCode);
        switch (requestCode) {
            case 888:
                SnakebarUtils.showToast("请在设置应用打开使用电话权限");
                break;
            /*case 897:
                SnakebarUtils.showToast("请在设置应用打开使用电话权限");
                break;*/
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
           /* case 897:
                Intent intents = new Intent(Intent.ACTION_CALL, Uri.parse("tel:110"));
                if (ActivityCompat.checkSelfPermission(BaseApplication.currentActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(intents);
                break;*/
        }
    }
}
