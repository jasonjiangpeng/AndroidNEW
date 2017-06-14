package com.jh.rental.user.model;


import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;

import com.android.volley.toolbox.ImageLoader;

import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.jh.rental.user.api.ApiConstants;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.utils.jason.Logger;

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
   public void  postMapRequest(String url, final Map<String,String> map, Response.Listener<String> listener,Response.ErrorListener errorListener){
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
               //    Logger.soutMessage("====================");
                   ApiConstants.localCookie = rawCookies.substring(0, rawCookies.indexOf(";"));
               }

               return super.parseNetworkResponse(response);
           }
           @Override
           public Map<String, String> getHeaders() throws AuthFailureError {
               return super.getHeaders();
           }
       };
       getRequestQueue().add(stringRequest);
   }
     public void  getRequestData(String url,Response.Listener<String> listener,Response.ErrorListener errorListener){
            this.getRequestParamData(url,null,listener,errorListener);
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
     public <T> void addToRequestQueue(Request<T> request, String tag) {
        request.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(request);
    }

    public <T> void addToRequestQueue(Request<T> request) {
        request.setTag(TAG);
        getRequestQueue().add(request);
    }
    public void cancelPendingRequests() {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(TAG);
        }
    }
}
