package com.jh.rental.user.view.actitity.login;

import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;
import com.jh.rental.user.R;
import com.jh.rental.user.api.ApiConstants;
import com.jh.rental.user.api.ApiGet;
import com.jh.rental.user.api.ApiPost;
import com.jh.rental.user.bean.login.SmsBean;
import com.jh.rental.user.model.HttpVolley;
import com.jh.rental.user.presenter.login.ImRegisterData;
import com.jh.rental.user.presenter.net.NetError;
import com.jh.rental.user.presenter.net.NetSucceed;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.utils.jason.KeyboardUtils;
import com.jh.rental.user.utils.jason.SimCardUtils;
import com.jh.rental.user.utils.jason.SnakebarUtils;
import com.jh.rental.user.utils.tom.RegexpUtils;
import com.jh.rental.user.view.actitity.TitelBarAcitvity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by 骏辉出行 on 2017/6/2.
 */
@EActivity(R.layout.register_view)
public class Register_Act extends TitelBarAcitvity implements ImRegisterData{
    ImRegisterData imregister=null;
    @ViewById(R.id.register_number)
    EditText  register_number;
    @ViewById(R.id.register_password)
    EditText  registerpassword;
    @ViewById(R.id.register_autocode)
    EditText  registerautocade;
    @ViewById(R.id.register_autocodetv)
    TextView aotucode;
    @ViewById(R.id.registeri9)
    ImageView iv9;
    @ViewById(R.id.login_img)
    ImageView img;
    int tab = 0;
    String cipherRegex,telRegex,Phone,password;
    @AfterViews
    public void afterview() {
        imregister=this;
        sendThread();
        map=new HashMap<>();
        setMyTitel(BaseContext.getResValue(R.string.register));
        register_number.addTextChangedListener(new TextWatcher() {
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
    }
    private void sendThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (SimCardUtils.readSimNumber(Register_Act.this)!=null){
                    String value=SimCardUtils.readSimNumber(Register_Act.this);
                    imregister.setData(value);
                }
            }
        }).start();
    }

    @Override
    public void setData(String value) {
        register_number.setText(value);
    }
    private Map<String, String> map;
    private  int time=60;
    @Override
    protected void onDestroy() {
        if (timer!=null){
            timer.purge();
        }
        super.onDestroy();

    }
    @Click({R.id.register_autocodetv,R.id.cipher,R.id.register_oldnumber,R.id.register_login,R.id.login_img})
    public void gets(View view){
        Phone = register_number.getText().toString();
        password = registerpassword.getText().toString();
        switch (view.getId()){
            case R.id.login_img:
                register_number.setText("");
                img.setVisibility(View.GONE);
                break;
            case R.id.register_autocodetv:
                if (RegexpUtils.isMobileExact(Phone)){
                    if (time==60){
                        sendSms();
                    }else {
                        aotucode.setEnabled(false);
                        SnakebarUtils.showToast(BaseContext.getResValue(R.string.Sent));
                    }
                }else {
                    SnakebarUtils.showToast(BaseContext.getResValue(R.string.PhoneNumError));
                }
                break;
            case R.id.cipher:
               if (tab==0){
                   registerpassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                   iv9.setImageResource(R.drawable.cxxhdpi);
                   tab=1;
               }else {
                   registerpassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                   iv9.setImageResource(R.drawable.axxhdpi);
                   tab=0;
               }
                break;
            case R.id.register_oldnumber:
               onBackPressed();
                break;
            case R.id.register_login:
                if (!RegexpUtils.isMobileExact(Phone)){
                    SnakebarUtils.showToast(BaseContext.getResValue(R.string.PhoneNumError));
                    break;
                }
                if (!RegexpUtils.isCipher(password)) {
                    SnakebarUtils.showToast(BaseContext.getResValue(R.string.CipherRegex));
                    break;
                }
                KeyboardUtils.hideSoftInput(Register_Act.this);
                submit();

                break;
        }
    }

    private void submit() {
        String  url= ApiGet.queryUserExist+"?mobile="+register_number.getText().toString();
        HttpVolley.getInstance().getRequestData(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject =new JSONObject(response);
                    if (jsonObject.getInt("exist") == 0) {
                        registered();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void registered() {
        mapegister(register_number.getText().toString(),registerpassword.getText().toString(),registerautocade.getText().toString(),"1");
        HttpVolley.getInstance().postMapRequest(ApiPost.register,map,new NetSucceed<>(SmsBean.class, new NetSucceed.HolderData<SmsBean>() {
            @Override
            public void holdData(SmsBean bean) {
                if (Integer.parseInt(bean.getCode())== ApiConstants.SucceedCode){
                    SnakebarUtils.showToast("注册成功");
                    finish();
                }else {
                    SnakebarUtils.showToast("注册失败"+bean.getMessage());
                }
            }
        }),new NetError(Register_Act.this));
    }

    public void sendSms(){
        mapsms(register_number.getText().toString());
        HttpVolley.getInstance().postMapRequest(ApiPost.sendSms,map,new NetSucceed<>(SmsBean.class, new NetSucceed.HolderData<SmsBean>() {
            @Override
            public void holdData(SmsBean bean) {
                if (Integer.parseInt(bean.getCode())== ApiConstants.SucceedCode){
                    timer=new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if (time<=0){
                                        time=60;
                                        timer.cancel();
                                        aotucode.setEnabled(true);
                                        aotucode.setText(BaseContext.getResValue(R.string.GetVerificationCode));
                                    }else if (time>57){
                                        aotucode.setText(BaseContext.getResValue(R.string.Sent));
                                    }else {
                                        aotucode.setText(String.format("(%d)"+BaseContext.getResValue(R.string.retry),time));
                                    }
                                }
                            });
                            time--;
                        }
                    },100,1000);
                }else {
                    SnakebarUtils.showToast(bean.getMessage()+BaseContext.getResValue(R.string.AbnormalOperation));
                }
            }
        }),new NetError(Register_Act.this));
    }
    public void mapsms(String... ab){
        if (ab.length<1){
            return;
        }
        map.clear();
        map.put("mobile",ab[0]);
     }
    public void mapegister(String... ab){
        map.clear();
        if (ab.length<1){
            return;
        }
        map.put("mobile",ab[0]);
        map.put("password",ab[1]);
        map.put("verification",ab[2]);
        map.put("type",ab[3]);
    }

 private Timer  timer ;
}
