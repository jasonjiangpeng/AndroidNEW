package com.jh.rental.user.utils.jason;

import android.content.Context;
import android.telephony.TelephonyManager;

import static android.Manifest.permission.READ_PHONE_STATE;

/**
 * Created by 骏辉出行 on 2017/6/5.
 */

public class SimCardUtils {
    public  static boolean readSIMCard(Context context) {
             if (PermissionUtils.checkPermission(context,READ_PHONE_STATE)){
                 TelephonyManager manager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);// 取得相关系统服务
                 String imsi = manager.getLine1Number(); // 取出IMSI
                 System.out.println(manager.getSimSerialNumber());
                 System.out.println(manager.getNetworkOperator());
                 System.out.println("取出IMSI" + imsi);
                 if (imsi == null || imsi.length() <= 0) {
                     return false;
                 } else {
                     return true;
                 }
             }
             return false;
    }
    public static String readSimNumber(Context context){
        if (PermissionUtils.checkPermission(context,READ_PHONE_STATE)) {
            TelephonyManager manager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
             String as=manager.getLine1Number();
            if (as!=null&&as.contains("+86")){
              return as.replace("+86","");
            }
            return as;
        }
        return null;
    }
}
