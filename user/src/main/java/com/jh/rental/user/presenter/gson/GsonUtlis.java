package com.jh.rental.user.presenter.gson;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.Primitives;
import com.jh.rental.user.utils.jason.SnakebarUtils;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by 骏辉出行 on 2017/6/8.
 */

public class GsonUtlis {
    private static Gson  gson;

    public static Gson getIntance() {
       if (gson==null){
           synchronized (GsonUtlis.class){
               return new Gson();
           }

       }
       return gson;
    }
    public static <T>  ArrayList<T> getJsonArray(String value,Class<T> tClass){
        Gson gson =new Gson();
        JsonParser jsonParser= null;
        try {
            jsonParser = new JsonParser();
            if (jsonParser.parse(value).getAsJsonArray()==null){
                return null;
            }
        } catch (JsonSyntaxException e) {
            SnakebarUtils.showToast("网络异常");
            e.printStackTrace();
        }catch (IllegalStateException e){
            SnakebarUtils.showToast("网络错误");
            e.printStackTrace();
            return  null;
        }
        JsonArray jsonArray=jsonParser.parse(value).getAsJsonArray();
        ArrayList<T> bannerArrays =new ArrayList();
        for (JsonElement jsonElement:jsonArray){
            Object o = gson.fromJson(jsonElement,  (Type)tClass);
            T effectiveBanner= Primitives.wrap(tClass).cast(o);
            bannerArrays.add(effectiveBanner);
        }
        return bannerArrays;
    }
    public static <T> T getJson(String value,Class<T> tClass) throws JsonSyntaxException {
        if (value==null){
            return null;
        }
        Object o = getIntance().fromJson(value, (Type)tClass);
        return Primitives.wrap(tClass).cast(o);
    }
}
