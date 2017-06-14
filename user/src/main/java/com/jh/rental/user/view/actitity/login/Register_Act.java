package com.jh.rental.user.view.actitity.login;

import android.os.Handler;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.jh.rental.user.MainActivity_;
import com.jh.rental.user.R;
import com.jh.rental.user.api.ApiConstants;
import com.jh.rental.user.api.ApiPost;
import com.jh.rental.user.bean.login.SmsBean;
import com.jh.rental.user.model.HttpVolley;
import com.jh.rental.user.other.apputilss.utilcode.utils.ToastUtils;
import com.jh.rental.user.presenter.login.ImRegisterData;
import com.jh.rental.user.presenter.net.NetError;
import com.jh.rental.user.presenter.net.NetSucceed;
import com.jh.rental.user.utils.jason.ActivityUtils;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.utils.jason.KeyboardUtils;
import com.jh.rental.user.utils.jason.Logger;
import com.jh.rental.user.utils.jason.SimCardUtils;
import com.jh.rental.user.utils.jason.SnakebarUtils;
import com.jh.rental.user.view.BaseApplication;
import com.jh.rental.user.view.actitity.TitelBarAcitvity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.sql.Time;
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
    CheckBox wregisteri9;
    @AfterViews
    public void afterview() {

        imregister=this;
        timer=new Timer();
        sendThread();
        map=new HashMap<>();
        wregisteri9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    registerpassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                }else {
                    registerpassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
        });
        setMyTitel(BaseContext.getResValue(R.string.register));

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
        super.onDestroy();
    }
    @Click({R.id.register_autocodetv,R.id.register_oldnumber,R.id.register_login})
    public void gets(View view){
        switch (view.getId()){
            case R.id.register_autocodetv:
                if (time!=0&&time!=60){
                    SnakebarUtils.showToast("已发送");
                    return;
                }
               mapsms(register_number.getText().toString());
                HttpVolley.getInstance().postMapRequest(ApiPost.sendSms,map,new NetSucceed<>(SmsBean.class, new NetSucceed.HolderData<SmsBean>() {
                    @Override
                    public void holdData(SmsBean bean) {
                        if (bean.getCode()==ApiConstants.SucceedCode){
                            SnakebarUtils.showToast("已发2送");
                            timer.schedule(new TimerTask() {
                                @Override
                                public void run() {
                               runOnUiThread(new Runnable() {
                                   @Override
                                   public void run() {
                                       if (time<=0){
                                           time=60;
                                       }
                                       aotucode.setText(String.format("(%d)获取验证码",time));
                                   }
                               });
                                    time--;
                                }
                            },100,1000);
                        }else {
                            SnakebarUtils.showToast(bean.getMessage()+"操作异常");
                        }
                    }
                }),new NetError(Register_Act.this));
                break;
            case R.id.register_oldnumber:
               onBackPressed();
                break;

            case R.id.register_login:
                KeyboardUtils.hideSoftInput(Register_Act.this);
                mapegister(register_number.getText().toString(),registerautocade.getText().toString(),registerpassword.getText().toString(),"1");
                HttpVolley.getInstance().postMapRequest(ApiPost.register,map,new NetSucceed<>(SmsBean.class, new NetSucceed.HolderData<SmsBean>() {
                    @Override
                    public void holdData(SmsBean bean) {
                        if (bean.getCode()==ApiConstants.SucceedCode){
                            SnakebarUtils.showToast("注册成功");
                        }else {
                            SnakebarUtils.showToast("注册失败"+bean.getMessage());
                        }
                    }
                }),new NetError(Register_Act.this));
                break;
        }
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
  Timer  timer ;
}
