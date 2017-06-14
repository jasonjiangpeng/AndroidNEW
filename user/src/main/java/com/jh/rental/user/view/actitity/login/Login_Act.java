package com.jh.rental.user.view.actitity.login;

import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;

import com.jh.rental.user.MainActivity_;
import com.jh.rental.user.R;
import com.jh.rental.user.api.ApiConstants;
import com.jh.rental.user.api.ApiPost;
import com.jh.rental.user.bean.login.SmsBean;
import com.jh.rental.user.model.HttpVolley;
import com.jh.rental.user.presenter.login.ImLoginData;
import com.jh.rental.user.presenter.net.NetError;
import com.jh.rental.user.presenter.net.NetSucceed;
import com.jh.rental.user.utils.jason.ActivityUtils;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.utils.jason.KeyboardUtils;
import com.jh.rental.user.utils.jason.SimCardUtils;
import com.jh.rental.user.utils.jason.SnakebarUtils;
import com.jh.rental.user.view.actitity.TitelBarAcitvity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 骏辉出行 on 2017/6/2.
 */
@EActivity(R.layout.login_view)
public class Login_Act extends TitelBarAcitvity implements ImLoginData {
    @ViewById(R.id.login_swith)
    CheckBox checkBox;
    @ViewById(R.id.login_password)
    EditText loginpassword;
    @ViewById(R.id.login_number)
    EditText loginnumber;
    ImLoginData  imloginData=null;
    @ViewById(R.id.login_img)
    ImageView img;
    @AfterViews
    public void afterview(){
        map=new HashMap<>();
        imloginData=this;
        sendTheard();
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    loginpassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                }else {
                    loginpassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
        });
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

    @Click({R.id.login_register,R.id.login_forgetpass,R.id.login_login,R.id.login_img})
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
                handler.sendEmptyMessage(10);
                break;
            case R.id.login_img:
                loginnumber.setText("");
                img.setVisibility(View.GONE);
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
              //  mapconfig(loginnumber.getText().toString(),loginpassword.getText().toString());
                mapconfig("18680800808","123456");
                ApiConstants.loginStatus=true;
                HttpVolley.getInstance().postMapRequest(ApiPost.login,map,new NetSucceed<SmsBean>(SmsBean.class,new NetSucceed.HolderData<SmsBean>() {
                    @Override
                    public void holdData(SmsBean bean) {
                        if (bean.getCode()==10000){
                            ActivityUtils.nextActivity(MainActivity_.class);
                        }else {
                            SnakebarUtils.showToast("账号或者密码错误");
                        }

                    }
                }),new NetError(Login_Act.this));

            }

        }
    };
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
