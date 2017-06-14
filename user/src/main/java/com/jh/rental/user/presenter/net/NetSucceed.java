package com.jh.rental.user.presenter.net;

import com.android.volley.Response;
import com.google.gson.Gson;
import com.google.gson.internal.Primitives;
import com.jh.rental.user.presenter.gson.GsonUtlis;
import com.jh.rental.user.utils.jason.Logger;

import java.lang.reflect.Type;

/**
 * Created by 骏辉出行 on 2017/6/7.
 */

public class NetSucceed<T> implements Response.Listener<String> {

    private Class<T> tClass;
    private HolderData<T> holderData;
    public NetSucceed(Class<T> tClass,HolderData<T> holderData) {
      this.tClass=tClass;
      this.holderData=holderData;
    }
    @Override
    public void onResponse(String response) {
        if (response==null){
            return;
        }
        Logger.netSoutMessage(response);
   /*     Logger.soutMessage(response);
        Gson gson =new Gson();
        Object o = gson.fromJson(response,  (Type)tClass);
        holderData.holdData( Primitives.wrap(tClass).cast(o));*/

        if (GsonUtlis.getJson(response,tClass)!=null){
         //   T t=GsonUtlis.getJson(response,tClass);
            holderData.holdData(GsonUtlis.getJson(response,tClass));
        }

    }
  public   interface HolderData<T>{
        void holdData(T bean);
    }
/*    Object object = fromJson(json, (Type) classOfT);
    return Primitives.wrap(classOfT).cast(object);*/
}
