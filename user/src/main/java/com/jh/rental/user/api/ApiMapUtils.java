package com.jh.rental.user.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 骏辉出行 on 2017/6/7.
 */

public class ApiMapUtils {
    public static Map<String,String> getMapRequest(String[] s, String...abc){
         if (abc.length!=s.length){
             return null;
         }
         Map<String,String> stringStringMap=new HashMap<>();
        for (int i = 0; i <s.length ; i++) {
            stringStringMap.put(s[i],abc[i]);
        }
        return stringStringMap;
    }
}
