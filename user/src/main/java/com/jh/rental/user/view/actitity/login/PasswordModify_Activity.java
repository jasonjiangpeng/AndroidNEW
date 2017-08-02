package com.jh.rental.user.view.actitity.login;

import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.api.ApiConstants;
import com.jh.rental.user.api.ApiPost;
import com.jh.rental.user.bean.login.SmsBean;
import com.jh.rental.user.model.HttpVolley;
import com.jh.rental.user.presenter.net.NetError;
import com.jh.rental.user.presenter.net.NetSucceed;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.utils.jason.KeyboardUtils;
import com.jh.rental.user.utils.jason.Logger;
import com.jh.rental.user.utils.jason.SnakebarUtils;
import com.jh.rental.user.utils.tom.RegexpUtils;
import com.jh.rental.user.view.actitity.TitelBarAcitvity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by 骏辉出行 on 2017/5/18.
 */
@EActivity(R.layout.passwordmodify_a_activity)
public class PasswordModify_Activity extends TitelBarAcitvity{
    @ViewById(R.id.login_number)
    EditText loginNumber;
    @ViewById(R.id.et_verify)
    EditText  etVerify;
    @ViewById(R.id.et_cipher1)
    EditText  etCipher1;
    @ViewById(R.id.et_cipher2)
    EditText  etCipher2;
    @ViewById(R.id.tv_verify)
    TextView tvVerify;
    @ViewById(R.id.cipher1)
    ImageView mCipher1;
    @ViewById(R.id.cipher2)
    ImageView mCipher2;
    @ViewById(R.id.login_img)
    ImageView img;
    String cipherRegex,telRegex,Phone,verify,cipher1,cipher2;
    private Map<String, String> map;
    private  int time=60;
    private Timer  timer ;
    int tab1,tab2 = 0;
    @AfterViews
    public void afterview(){
        setMyTitel(BaseContext.getResValue(R.string.passwordmodefy));
//        telRegex = "[1][3578]\\d{9}";
//        cipherRegex = "^[a-zA-Z0-9]{6,16}$";
        map=new HashMap<>();
        loginNumber.addTextChangedListener(new TextWatcher() {
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

    @Click({R.id.tv_verify,R.id.present,R.id.ll_cipher1,R.id.ll_cipher2,R.id.login_img})
    public void myclick(View view){
        Phone = loginNumber.getText().toString();
        cipher1 = etCipher1.getText().toString();
        switch (view.getId()){
            case R.id.login_img:
                loginNumber.setText("");
                img.setVisibility(View.GONE);
                break;
            case R.id.tv_verify:
                if (RegexpUtils.isMobileExact(Phone)){
                    if (time==60){
                        sendSms();
                    }else {
                        tvVerify.setEnabled(false);
                        SnakebarUtils.showToast(BaseContext.getResValue(R.string.Sent));
                    }
                }else {
                    SnakebarUtils.showToast(BaseContext.getResValue(R.string.PhoneNumError));
                }
                break;
            case R.id.present:
                cipher2 = etCipher2.getText().toString();
                if (!RegexpUtils.isMobileExact(Phone)){
                    SnakebarUtils.showToast(BaseContext.getResValue(R.string.PhoneNumError));
                    break;
                }
                if (RegexpUtils.isCipher(cipher1)) {
                    if (!cipher1.equals(cipher2)) {
                        SnakebarUtils.showToast(BaseContext.getResValue(R.string.PasswordNotTconsistent));
//                        SnakebarUtils.showToast(cipher1+"========="+cipher2);
                        break;
                    }
                }else {
                    Logger.showMessage(cipher1+"====="+cipherRegex);
                    SnakebarUtils.showToast(BaseContext.getResValue(R.string.CipherRegex));
                    break;
                }
                modify();
                break;
            case R.id.ll_cipher1:
                if (tab1==0){
                    etCipher1.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    mCipher1.setImageResource(R.drawable.cxxhdpi);
                    tab1=1;
                }else {
                    etCipher1.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    mCipher1.setImageResource(R.drawable.axxhdpi);
                    tab1=0;
                }
                break;
            case R.id.ll_cipher2:
                if (tab2==0){
                    etCipher2.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    mCipher2.setImageResource(R.drawable.cxxhdpi);
                    tab2=1;
                }else {
                    etCipher2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    mCipher2.setImageResource(R.drawable.axxhdpi);
                    tab2=0;
                }
                break;
        }
    }

    private void modify() {
        KeyboardUtils.hideSoftInput(PasswordModify_Activity.this);
        mapegister(loginNumber.getText().toString(),etCipher1.getText().toString(),etVerify.getText().toString());
        HttpVolley.getInstance().postMapRequest(ApiPost.setPassword,map,new NetSucceed<>(SmsBean.class, new NetSucceed.HolderData<SmsBean>() {
            @Override
            public void holdData(SmsBean bean) {
                if (Integer.parseInt(bean.getCode())==ApiConstants.SucceedCode){
                    SnakebarUtils.showToast(BaseContext.getResValue(R.string.ModifySuccess));
                    finish();
                }else {
                    SnakebarUtils.showToast(BaseContext.getResValue(R.string.ModifyFailure));
                }
            }
        }),new NetError(PasswordModify_Activity.this));
    }

    public void sendSms(){
        mapsms(loginNumber.getText().toString());
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
                                        tvVerify.setEnabled(true);
                                        tvVerify.setText(BaseContext.getResValue(R.string.GetVerificationCode));
                                    }else if (time>57){
                                        tvVerify.setText(BaseContext.getResValue(R.string.Sent));
                                    }else {
                                        tvVerify.setText(String.format("(%d)"+BaseContext.getResValue(R.string.retry),time));
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
        }),new NetError(PasswordModify_Activity.this));
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
        map.put("newPass",ab[1]);
        map.put("verification",ab[2]);
    }


}
