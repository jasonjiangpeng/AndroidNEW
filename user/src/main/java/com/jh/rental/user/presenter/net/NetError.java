package com.jh.rental.user.presenter.net;

import android.app.Activity;
import android.content.Context;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.jh.rental.user.utils.jason.Logger;
import com.jh.rental.user.utils.jason.SnakebarUtils;

/**
 * Created by 骏辉出行 on 2017/6/7.
 */

public class NetError implements Response.ErrorListener {
    private Activity context;
    public NetError(Activity context) {
        this.context=context;
    }

    public NetError() {
    }

    @Override
    public void onErrorResponse(VolleyError error) {
       // Logger.netSoutMessage("onErrorResponse"+error.networkResponse.statusCode);
        SnakebarUtils.show(context.getWindow().getDecorView(),"网络错误，请检查网络");
    }

}
