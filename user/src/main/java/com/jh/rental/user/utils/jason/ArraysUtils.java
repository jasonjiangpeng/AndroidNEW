package com.jh.rental.user.utils.jason;

/**
 * Created by 骏辉出行 on 2017/5/18.
 */

public class ArraysUtils {
    public static void cleanArrays(String[] v){
        for (int i = 0; i <v.length ; i++) {
            v[i]=null;
        }
    }
    public static void cleanArrays(Object...abc){
        for (int i = 0; i <abc.length; i++) {
            abc[i]=null;
        }

    }
}
