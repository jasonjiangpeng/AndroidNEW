package com.jh.rental.user.view.actitity.person;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Response;
import com.jh.rental.user.R;
import com.jh.rental.user.api.ApiConstants;
import com.jh.rental.user.api.ApiPost;
import com.jh.rental.user.bean.login.SmsBean;
import com.jh.rental.user.model.HttpVolley;
import com.jh.rental.user.presenter.gson.GsonUtlis;
import com.jh.rental.user.utils.jason.ArraysUtils;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.utils.jason.KeyboardUtils;
import com.jh.rental.user.utils.jason.SnakebarUtils;
import com.jh.rental.user.view.actitity.TitelBarAcitvity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 骏辉出行 on 2017/5/18.
 */

public class IdeaCallBack_Activity extends TitelBarAcitvity{

    EditText editText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.idea_callback);
        setMyTitel(BaseContext.getResValue(R.string.ideoback));
        editText= (EditText) findViewById(R.id.ideot1);
    }

   public void onClickgo(View v){
       KeyboardUtils.hideSoftInput(this);
       if (editText.getText().toString()!=null&&editText.getText().toString().length()>0){
               send();
       }else {
           SnakebarUtils.showView("输入信息太短");

        //   SnakebarUtils.showToast("输入信息太短");
       }
   }
    public void send()  {
        HttpVolley.getInstance().postMapRequest(ApiPost.submitOpinion, getmap(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                SmsBean smsBean = GsonUtlis.getIntance().fromJson(response, SmsBean.class);
                 if (Integer.parseInt(smsBean.getCode())==10000){
                      SnakebarUtils.showView("已发送成功");

                 }
            }
        });
          }

    @Override
    protected void onStop() {

        super.onStop();

    }

    @Override
    protected void onDestroy() {
     //   ArraysUtils.cleanArrays(strings);

        super.onDestroy();
    }
    public Map<String,String>  getmap(){
        String s=    editText.getText().toString();
        Map<String,String> map=new HashMap<>();
        map.put("clientVersion",ApiConstants.clientVersion);
        map.put("systemVersion",ApiConstants.getSystemVersion());
        map.put("clientType","1");
        map.put("content",s);
        return map;
    }

  //  private String[]  strings={"clientVersion","systemVersion","clientType","content"};


}
