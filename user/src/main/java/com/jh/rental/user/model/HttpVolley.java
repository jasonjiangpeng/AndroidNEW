package com.jh.rental.user.model;


import android.text.TextUtils;
import android.widget.ImageView;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.jh.rental.user.api.ApiConstants;
import com.jh.rental.user.presenter.net.NetError;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.utils.jason.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by 骏辉出行 on 2017/5/25.
 */

public class HttpVolley {
    public static final String TAG = HttpVolley.class.getSimpleName();
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;
    private static HttpVolley mInstance;
    public static synchronized HttpVolley getInstance() {
        if (mInstance==null){
            mInstance=new HttpVolley();
        }

     //   LoadDialog.show(BaseApplication.currentActivity(),"加载中");

        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            synchronized (HttpVolley.class){
                if (mRequestQueue == null){
                    mRequestQueue = Volley.newRequestQueue(BaseContext.context) ;
                }
            }

        }
        mRequestQueue.addRequestFinishedListener(new RequestQueue.RequestFinishedListener<Object>() {
            @Override
            public void onRequestFinished(Request<Object> request) {
          //      LoadDialog.dismiss(BaseApplication.currentActivity());
            }
        });
        return mRequestQueue;
    }

    public ImageLoader getImageLoader() {
        if (mImageLoader == null) {
            mImageLoader = new ImageLoader(getRequestQueue(), new LruBitmapCache());
        }

        return mImageLoader;
    }
    public void loadImageView(String url,final ImageView imageView){
        ImageLoader.ImageListener listener = ImageLoader.getImageListener(imageView, 0, 0);
        ImageLoader imageLoader =getImageLoader();
        imageLoader.get(url,listener,800,600);
    }
    /*http  网络地址,map请求参数，响应数据,错误数据*/
    public void  postMapRequest(String url, final Map<String,String> map, Response.Listener<String> listener){
        this.postMapRequest(url,map,listener,null);
    }

    public void  postMapRequest(String url, final Map<String,String> map, Response.Listener<String> listener,Response.ErrorListener errorListener){
        if (errorListener==null){
            errorListener=new NetError();
        }
        StringRequest  stringRequest =new StringRequest(Request.Method.POST, url,listener,errorListener){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                if (map!=null){
                    return map;
                }
                return super.getParams();
            }

            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                if (ApiConstants.loginStatus){
                    ApiConstants.loginStatus=false;
                    Map<String, String> responseHeaders = response.headers;
                    String rawCookies = responseHeaders.get("Set-Cookie");
                    if (rawCookies!=null){
                        ApiConstants.localCookie = rawCookies.substring(0, rawCookies.indexOf(";"));
                    }

                }
                return super.parseNetworkResponse(response);
            }
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                if (ApiConstants.localCookie != null && ApiConstants.localCookie.length() > 0) {
                    HashMap<String, String> headers = new HashMap<String, String>();
                    headers.put("cookie", ApiConstants.localCookie);
                    return headers;
                }else {
                    return super.getHeaders();
                }
            }
        };
        getRequestQueue().add(stringRequest);
    }
    public void  getRequestData(String url,Response.Listener<String> listener){
        this.getRequestParamData(url,null,listener,null);
    }
    public void  getRequestData(String url,Response.Listener<String> listener,Response.ErrorListener errorListener){
        this.getRequestParamData(url,null,listener,null);
    }
    /*网站get参数加*/
    private String stringUrlholder(LinkedHashMap<String,String> map){
        if (map!=null){
            Set<String> strings = map.keySet();
            String urladdre ="?";
            boolean  irun =true;
            for (String key: strings) {
                if (irun){
                    irun=false;
                    urladdre+=key+"="+map.get(key);
                }else {
                    urladdre+="&"+key+"="+map.get(key);
                }
            }
            return urladdre;
        }
        return "";
    }
    /*带Get参数请求*/
    public void  getRequestParamData(String url, LinkedHashMap<String,String> map, Response.Listener<String> listener, Response.ErrorListener errorListener){
        String value=url+stringUrlholder(map);
        Logger.netSoutMessage(value);
        if (errorListener==null){
            errorListener=new NetError();
        }
        StringRequest  stringRequest =new StringRequest(Request.Method.GET, value,listener,errorListener){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                if (ApiConstants.localCookie != null && ApiConstants.localCookie.length() > 0) {
                    HashMap<String, String> headers = new HashMap<String, String>();
                    headers.put("cookie", ApiConstants.localCookie);
                    return headers;
                }else {
                    return super.getHeaders();
                }
            }
        };
        getRequestQueue().add(stringRequest);
    }

    public void  getRequestIdData(String url, String value, Response.Listener<String> listener, Response.ErrorListener errorListener){
        String values=url+"/"+value;
        if (errorListener==null){
            errorListener=new NetError();
        }

        StringRequest  stringRequest =new StringRequest(Request.Method.GET, values,listener,errorListener){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                if (ApiConstants.localCookie != null && ApiConstants.localCookie.length() > 0) {
                    HashMap<String, String> headers = new HashMap<String, String>();
                    headers.put("cookie", ApiConstants.localCookie);
                    return headers;
                }else {
                    return super.getHeaders();
                }
            }
        };
        getRequestQueue().add(stringRequest);
    }

    public <T> void addToRequestQueue(Request<T> request, String tag) {
        request.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(request);
    }

    public <T> void addToRequestQueue(Request<T> request) {
        getRequestQueue().add(request);
    }
    public void cancelPendingRequests() {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(TAG);
        }
    }
    public void

    postJson(String  url, String body, final CallBack callBacks ){
        JsonObjectRequest   jsonObjectRequest =new JsonObjectRequest(Request.Method.POST, url,body, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Logger.soutMessage("response"+response.toString());
                try {
                    int code = response.getInt("code");
                    if (code==10000){
                        callBacks.callback(response);
                    }else {
                        callBacks.failCallback(response);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

        },new NetError()){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                if (ApiConstants.localCookie != null && ApiConstants.localCookie.length() > 0) {
                    HashMap<String, String> headers = new HashMap<String, String>();
                    headers.put("cookie", ApiConstants.localCookie);
                    return headers;
                }else {
                    return super.getHeaders();
                }
            }
        };
        getRequestQueue().add(jsonObjectRequest);
    }
    public void postJsonB(String  url, String body, final NetResponData<JSONArray> jsonArrayNetResponData){
        JsonArrayRequest   jsonObjectRequest =new JsonArrayRequest(Request.Method.POST, url, body, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                       if (jsonArrayNetResponData!=null){
                           jsonArrayNetResponData.responeData(response);
                       }
                    }
                }, new NetError());

        getRequestQueue().add(jsonObjectRequest);
    }
    public void postCommonJson(String  url, String body, final CallBack callBacks ){
        JsonObjectRequest   jsonObjectRequest =new JsonObjectRequest(Request.Method.POST, url,body, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                callBacks.callback(response);
            }
        },new NetError()){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                if (ApiConstants.localCookie != null && ApiConstants.localCookie.length() > 0) {
                    HashMap<String, String> headers = new HashMap<String, String>();
                    headers.put("cookie", ApiConstants.localCookie);
                    return headers;
                }else {
                    return super.getHeaders();
                }
            }
        };
        getRequestQueue().add(jsonObjectRequest);
    }

    public CallBack getCallBack() {
        return callBack;
    }

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }

    private   CallBack callBack;
    public    interface CallBack{
        public        void callback(JSONObject response);
        void failCallback(JSONObject response);
    }
}
