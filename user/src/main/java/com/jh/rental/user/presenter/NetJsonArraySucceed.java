package com.jh.rental.user.presenter;

import com.android.volley.Response;
import com.jh.rental.user.presenter.gson.GsonUtlis;

import java.util.ArrayList;

/**
 * Created by 骏辉出行 on 2017/6/7.
 */
/*放回没有头的数组的数组*/
public class NetJsonArraySucceed<T> implements Response.Listener<String> {

    private Class<T> tClass;
    private HolderData<T> holderData;
    public NetJsonArraySucceed(Class<T> tClass, HolderData<T> holderData) {
      this.tClass=tClass;
      this.holderData=holderData;
    }
    @Override
    public void onResponse(String response) {
        if (response==null){
            return;
        }
   /*     Gson gson =new Gson();
        JsonParser jsonParser=new JsonParser();
        JsonArray jsonArray=jsonParser.parse(response).getAsJsonArray();
        ArrayList<T> bannerArrays =new ArrayList();
        for (JsonElement jsonElement:jsonArray){
            Object o = gson.fromJson(jsonElement,  (Type)tClass);
            T effectiveBanner=Primitives.wrap(tClass).cast(o);
            bannerArrays.add(effectiveBanner);
        }*/
       if (GsonUtlis.getJsonArray(response,tClass)!=null){

           holderData.holdData(GsonUtlis.getJsonArray(response,tClass));
       }

    }
  public   interface HolderData<T>{
        void holdData(ArrayList<T> bean);
    }

}
