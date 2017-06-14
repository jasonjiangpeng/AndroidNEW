package com.jh.rental.user.utils.jason;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by 骏辉出行 on 2017/5/22.
 */

public class SharePerenceUtils {
    public static void saveDate(String name,String keyname){
        SharedPreferences sharedPreferences = BaseContext.context.getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
           edit.putBoolean(keyname, false);
         edit.commit();
    }
   public static <T>void saveDataType(String name,String saveKey,T t){
        SharedPreferences sharedPreferences = BaseContext.context.getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        if (t instanceof Boolean){
            edit.putBoolean(saveKey,(Boolean)t);
        }else if (t instanceof Integer){
            edit.putInt(saveKey,(Integer)t);
        }else if (t instanceof String){
            edit.putString(saveKey, (String) t);
        }
        edit.commit();
   }
    public static String getDataString(String name,String saveKey){
        SharedPreferences sharedPreferences = BaseContext.context.getSharedPreferences(name, Context.MODE_PRIVATE);
        String value = sharedPreferences.getString(saveKey, "nothing");

        return  value;
    }
    public static int getDataInt(String name,String saveKey){
        SharedPreferences sharedPreferences = BaseContext.context.getSharedPreferences(name, Context.MODE_PRIVATE);
        int value = sharedPreferences.getInt(saveKey, 0);

        return  value;
    }
    public static Boolean getDataBool(String name,String saveKey){
        SharedPreferences sharedPreferences = BaseContext.context.getSharedPreferences(name, Context.MODE_PRIVATE);
        Boolean value = sharedPreferences.getBoolean(saveKey, false);
        return  value;
    }


}
