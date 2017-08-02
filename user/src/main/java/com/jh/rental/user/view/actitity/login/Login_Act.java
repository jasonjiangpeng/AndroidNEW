package com.jh.rental.user.view.actitity.login;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.android.volley.Response;
import com.jh.rental.user.R;
import com.jh.rental.user.api.ApiConstants;
import com.jh.rental.user.api.ApiGet;
import com.jh.rental.user.api.ApiPost;
import com.jh.rental.user.bean.login.GetUserInfo;
import com.jh.rental.user.constants.Constant;
import com.jh.rental.user.model.HttpVolley;
import com.jh.rental.user.presenter.login.ImLoginData;
import com.jh.rental.user.presenter.net.NetSucceed;
import com.jh.rental.user.receive.MyBroadCast;
import com.jh.rental.user.utils.jason.ActivityUtils;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.utils.jason.KeyboardUtils;
import com.jh.rental.user.utils.jason.Logger;
import com.jh.rental.user.utils.jason.SimCardUtils;
import com.jh.rental.user.utils.jason.SnakebarUtils;
import com.jh.rental.user.utils.tom.PreferencesUtil;
import com.jh.rental.user.view.BaseApplication;
import com.jh.rental.user.view.actitity.TitelBarAcitvity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 骏辉出行 on 2017/6/2.
 */
@EActivity(R.layout.login_view)
public class Login_Act extends TitelBarAcitvity implements ImLoginData {
    @ViewById(R.id.login_swith)
    ImageView imageView;
    @ViewById(R.id.login_password)
    EditText loginpassword;
    @ViewById(R.id.login_number)
    EditText loginnumber;
    ImLoginData  imloginData=null;
    @ViewById(R.id.login_img)
    ImageView img;
    @ViewById(R.id.login_login)
    Button button;

    int tab=0;
    @AfterViews
    public void afterview(){
        map=new HashMap<>();
        imloginData=this;
        sendTheard();
        loginnumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length()>2){
                    img.setVisibility(View.VISIBLE);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        setMyTitel(BaseContext.getResValue(R.string.login));

    }

    private void sendTheard() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (SimCardUtils.readSimNumber(Login_Act.this)!=null){
                    if (SimCardUtils.readSimNumber(Login_Act.this)==null){
                        return;
                    }
                    String value=SimCardUtils.readSimNumber(Login_Act.this);
                    imloginData.setData(value);
                }
            }
        }).start();
    }

    @Click({R.id.login_register,R.id.login_forgetpass,R.id.login_login,R.id.login_img,R.id.cipher})
    public void gets(View view){
        switch (view.getId()){
            case R.id.login_register:
                ActivityUtils.nextActivity(Register_Act_.class);
                break;
            case R.id.login_forgetpass:
                ActivityUtils.nextActivity(PasswordModify_Activity_.class);
                break;
            case R.id.login_login:
                KeyboardUtils.hideSoftInput(Login_Act.this);
           //     button.setEnabled(false);
                handler.sendEmptyMessage(10);
                break;
            case R.id.login_img:
                loginnumber.setText("");
                img.setVisibility(View.GONE);
                break;
            case R.id.cipher:
                if (tab==0){
                    loginpassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    imageView.setImageResource(R.drawable.cxxhdpi);
                    tab=1;
                }else {
                    loginpassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    imageView.setImageResource(R.drawable.axxhdpi);
                    tab=0;
                }
                break;

        }
    }
    private Map<String ,String> map;
    public void mapconfig(String... ab){
        if (ab.length<1){
            return;
        }
        map.clear();
        map.put("mobile",ab[0]);
        map.put("password",ab[1]);
    }
    private Handler  handler =new Handler(){
        @Override
        public void handleMessage(Message msg) {
         /*登陆*/
            if (msg.what==10){
                final String number = loginnumber.getText().toString();
                String password = loginpassword.getText().toString();
                mapconfig(number,password);
//                mapconfig("18680800806","123456");
                PreferencesUtil.putString(Login_Act.this, Constant.ACCOUNT,number);
                PreferencesUtil.putString(Login_Act.this, Constant.PASSWORD,password);
                ApiConstants.loginStatus=true;
             //   LoadDialog.show(BaseApplication.currentActivity(),"登录中...");
             /*   HttpVolley.getInstance().postMapRequest(ApiPost.login,map,new NetSucceed<>(SmsBean.class,new NetSucceed.HolderData<SmsBean>() {
                    @Override
                    public void holdData(SmsBean bean) {
                        PreferencesUtil.putString(Login_Act.this, Constant.REGISTER,ApiConstants.localCookie);
                        SnakebarUtils.showToast(ApiConstants.localCookie);
                        if (Integer.parseInt(bean.getCode())==10000){
                            BaseApplication.finishActivity();
                            requestNet();
                        }else {
                            SnakebarUtils.showToast("账号或者密码错误");
                        }
                    }
                }),new NetError());*/

                HttpVolley.getInstance().postMapRequest(ApiPost.login, map, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject  jsonObject =new JSONObject(response);
                            if (jsonObject.getInt("code")==10000){
                                PreferencesUtil.putString(Login_Act.this, Constant.REGISTER,ApiConstants.localCookie);
                                sendBroadcast(new Intent(MyBroadCast.loginSucceed));
                                BaseApplication.finishActivity();
                                requestNet();
                            }else {
                                Logger.soutTestMessage(jsonObject.getString("msg").toString());
                                SnakebarUtils.showToast(jsonObject.getString("msg").toString());
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
//                            SnakebarUtils.showToast(e.toString());
                        }

                     //   JsonObject  jsonObject =new JsonObject(response);
                    }
                });
            }
        }
    };

    public void requestNet(){
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
    }

    /*检查账号*/
    public void chechAccount(){
        if (!TextUtils.isEmpty(loginnumber.getText().toString())&&!TextUtils.isEmpty(loginpassword.getText().toString())){

        }

    }

    @Override
    public void setData(String value) {
        loginnumber.setText(value);
    }

    @Override
    protected void onDestroy() {
        if (map!=null){
            map.clear();
        }
        if (handler!=null){
            handler.removeCallbacksAndMessages(null);
        }
        super.onDestroy();
    }
}
