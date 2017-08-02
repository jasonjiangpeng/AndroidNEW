package com.jh.rental.user.view.actitity.person;

import android.view.View;
import android.widget.TextView;

import com.android.volley.Response;
import com.jh.rental.user.R;
import com.jh.rental.user.api.ApiGet;
import com.jh.rental.user.api.ApiPost;
import com.jh.rental.user.bean.login.GetUserInfo;
import com.jh.rental.user.bean.login.SmsBean;
import com.jh.rental.user.bean.login.UpdateUser;
import com.jh.rental.user.model.HttpVolley;
import com.jh.rental.user.presenter.gson.GsonUtlis;
import com.jh.rental.user.presenter.huanxin.HxChat;
import com.jh.rental.user.presenter.net.NetSucceed;
import com.jh.rental.user.utils.jason.AppUtils;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.utils.jason.Logger;
import com.jh.rental.user.utils.jason.SnakebarUtils;
import com.jh.rental.user.view.BaseApplication;
import com.jh.rental.user.view.actitity.TitelBarAcitvity;
import com.jh.rental.user.view.dialog.MyDialog;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by 骏辉出行 on 2017/5/18.
 */
@EActivity(R.layout.personmessage_activity)
public class PersonMessage_Activity extends TitelBarAcitvity{
    @ViewById(R.id.sub_title2)
TextView  sub_titel2;
    @AfterViews
    public void afterviews(){
       /*  sub_titel2.setVisibility(View.VISIBLE);
         sub_titel2.setText(BaseContext.getResValue(R.string.exitlogin));*/
        setMyTitel(BaseContext.getResValue(R.string.personmessage));
        requestNet();
    }
    @Click(R.id.out_login)
    public void outlogin(){
        HttpVolley.getInstance().getRequestData(ApiGet.logout, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                SmsBean smsBean = GsonUtlis.getIntance().fromJson(response, SmsBean.class);
                if (Integer.parseInt(smsBean.getCode())==10000){
                    BaseApplication.getLoginActivity();
                 //   HxChat.outLogin(null);
                }
            }
        });
    }
    public void requestNet(){
        HttpVolley.getInstance().getRequestData(ApiGet.getUserInfo, new NetSucceed<>(GetUserInfo.class, new NetSucceed.HolderData<GetUserInfo>() {
            @Override
            public void holdData(GetUserInfo bean) {
                uiupdata(bean);
            }
        }));
    }
    @ViewById(R.id.usetv1)
    TextView name;
    @ViewById(R.id.usetv2)
    TextView sex;
    @ViewById(R.id.usetv3)
    TextView phone;
    @UiThread
    public void uiupdata(GetUserInfo bean){
         if (bean.getSexStr()!=null){
              sex.setText(bean.getSexStr());
         }
        if (bean.getNickName()!=null){
            name.setText(bean.getNickName());
        }
        if (bean.getMobile()!=null){
            phone.setText(bean.getMobile());
        }
        if (bean.getImgurl().length()>2){

        }
    }

@Background
    public void upData(String va){
    UpdateUser  updateUser =new UpdateUser(va,"1","xxxx");
    String  body=GsonUtlis.getIntance().toJson(updateUser,UpdateUser.class);
    Logger.soutMessage(body);
   HttpVolley.getInstance().postJson(ApiPost.updateUser, body, new HttpVolley.CallBack() {
       @Override
       public void callback(JSONObject response) {
           requestNet();
       }

       @Override
       public void failCallback(JSONObject response) {
           try {
               if (response.getString("msg")!=null){
                   SnakebarUtils.showToast(response.getString("msg"));
               }

           } catch (JSONException e) {
               e.printStackTrace();
           }

       }

   });
   }
   @Click(R.id.layoutname)
   public void nameModify(){
       final MyDialog  myDialog =new MyDialog(this);
       myDialog.setEdtHint("请填写你的昵称");
       myDialog.getWindow().setLayout(AppUtils.getScreenWH(0)*2/3,AppUtils.getScreenWH(1)/5);
       myDialog.setTitel("填写昵称");
       myDialog.setOnNegativeListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               myDialog.dismiss();
           }
       });
       myDialog.setOnPositiveListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (myDialog.getDialogedt().getText().toString().length()>1){
                   myDialog.dismiss();
                   upData(myDialog.getDialogedt().getText().toString());
               }else {
                   SnakebarUtils.showToast("请输入昵称，谢谢!");
               }
           }
       });
       myDialog.show();
   }


}
