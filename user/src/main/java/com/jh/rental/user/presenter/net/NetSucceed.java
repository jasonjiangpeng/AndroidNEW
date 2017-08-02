package com.jh.rental.user.presenter.net;

import com.android.volley.Response;
import com.jh.rental.user.api.ApiConstants;
import com.jh.rental.user.bean.LoginBean;
import com.jh.rental.user.presenter.gson.GsonUtlis;
import com.jh.rental.user.utils.jason.Logger;
import com.jh.rental.user.utils.jason.SnakebarUtils;
import com.jh.rental.user.view.BaseApplication;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by 骏辉出行 on 2017/6/7.
 */

public class NetSucceed<T> implements Response.Listener<String> {

    private Class<T> tClass;
    private HolderData<T> holderData;
    private boolean isJudge = false;

    public NetSucceed(Class<T> tClass, HolderData<T> holderData) {
        this(tClass, holderData, false);
    }

    public NetSucceed(Class<T> tClass, HolderData<T> holderData, boolean isJudge) {
        this.tClass = tClass;
        this.holderData = holderData;
        this.isJudge = isJudge;
    }


    @Override
    public void onResponse(String response) {
        Logger.soutMessage(response);
        if (response == null) {
            return;
        }
        LoginBean smsBean = null;
        if (isJudge) {
            smsBean = GsonUtlis.getJson(response, LoginBean.class);
            if (smsBean.getCode() != null && smsBean.getMsg() != null) {
                holderData.holdData(null);
            } else {
                if (GsonUtlis.getJson(response, tClass) != null) {
                    holderData.holdData(GsonUtlis.getJson(response, tClass));
                }
            }
        } else {
            if (response.startsWith("{")) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getString("msg") != null) {
//                        SnakebarUtils.showToast(jsonObject.getString("msg").toString(), BaseApplication.currentActivity());
                        if ("请先登录".equals(jsonObject.getString("msg"))) {
                            ApiConstants.localCookie = null;
                        }
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            holderData.holdData(GsonUtlis.getJson(response, tClass));
        }

    }

    public interface HolderData<T> {
        void holdData(T bean);
    }
}
