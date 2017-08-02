package com.jh.rental.user.presenter.net;

import android.app.Activity;
import android.view.View;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.jh.rental.user.utils.jason.LoadDialog;
import com.jh.rental.user.utils.jason.Logger;
import com.jh.rental.user.view.BaseApplication;

/**
 * Created by 骏辉出行 on 2017/6/7.
 */

public class NetError implements Response.ErrorListener {
    private Activity context;
    private View btn;
    public NetError(Activity context) {
        this.context=context;
    }
    public NetError() {
    }

    public NetError(View btn) {
        this.btn = btn;
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        LoadDialog.dismiss(BaseApplication.currentActivity());
       if (btn!=null){
           btn.setEnabled(true);
       }
    }

}
