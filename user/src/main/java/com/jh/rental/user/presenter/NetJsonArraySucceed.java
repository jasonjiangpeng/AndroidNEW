package com.jh.rental.user.presenter;

import com.android.volley.Response;
import com.jh.rental.user.api.ApiConstants;
import com.jh.rental.user.presenter.gson.GsonUtlis;
import com.jh.rental.user.utils.jason.Logger;
import com.jh.rental.user.utils.jason.SnakebarUtils;
import com.jh.rental.user.view.BaseApplication;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by 骏辉出行 on 2017/6/7.
 */
/*放回没有头的数组的数组*/
public class NetJsonArraySucceed<T> implements Response.Listener<String> {
    private Class<T> tClass;
    private HolderData<T> holderData;
    private boolean isfis=true;
    public NetJsonArraySucceed(Class<T> tClass, HolderData<T> holderData) {
      this.tClass=tClass;
      this.holderData=holderData;
    }
    public NetJsonArraySucceed(Class<T> tClass, HolderData<T> holderData,boolean isFist) {
        this.tClass=tClass;
        this.isfis=isFist;
        this.holderData=holderData;
    }
    @Override
    public void onResponse(String response) {
    //    Logger.soutMessage(response);
        if (isfis&&response.startsWith("{")){
            try {
                JSONObject jsonObject=new JSONObject(response);
                if (jsonObject.getString("msg")!=null){
                    SnakebarUtils.showToast(jsonObject.getString("msg"), BaseApplication.currentActivity());
                    if ("请先登录".equals(jsonObject.getString("msg"))) {
                        ApiConstants.localCookie = null;
                    }
                    return;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        if (GsonUtlis.getJsonArray(response,tClass)==null){
            return;
        }
        holderData.holdData(GsonUtlis.getJsonArray(response,tClass));
    }
  public   interface HolderData<T>{
        void holdData(ArrayList<T> bean);
    }

}
