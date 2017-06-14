package com.jh.rental.user.utils.jason;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;

/**
 * Created by 骏辉出行 on 2017/6/5.
 */

public class PermissionUtils {
    public static void goPermissionSetting(Context context) {
        // Intent i = new Intent("miui.intent.action.APP_PERM_EDITOR");
        Intent localIntent = new Intent();
        localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        localIntent.setData(Uri.fromParts("package",context.getPackageName(), null));
        context.startActivity(localIntent);
    }
    public static boolean checkPermission(Context context,String persionname){
        /*READ_PHONE_STATE*/
        if (ActivityCompat.checkSelfPermission(context, persionname)!=0) {
           /// Toast.makeText(context, "没有权限", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
