package com.jh.rental.user.utils.tom;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesUtil {

    private static SharedPreferences getsp(Context context) {
        return context.getSharedPreferences("context", 0);
    }

    public static void putBoolean(Context context , String key , boolean val) {
        getsp(context).edit().putBoolean(key , val).commit();
    }

    public static boolean getBoolean(Context context , String key) {
        return getsp(context).getBoolean(key ,false);
    }

    public static boolean getBoolean(Context context , String key ,boolean val) {
        return getsp(context).getBoolean(key ,val);
    }

    //===============================================================================
    public static void putString(Context context ,String key,String val) {
        getsp(context).edit().putString(key,val).commit();
    }

    public static String getString(Context context ,String key) {
        return getsp(context).getString(key,"");
    }

    public static String getString(Context context ,String key,String val) {
        return getsp(context).getString(key,val);
    }

    //===============================================================================
    public static void putInt(Context context ,String key,int val) {
        getsp(context).edit().putInt(key,val).commit();
    }

    public static int getInt(Context context ,String key) {
        return getsp(context).getInt(key,0);
    }

    public static int getInt(Context context ,String key,int val) {
        return getsp(context).getInt(key,val);
    }
}
