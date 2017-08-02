package com.jh.rental.user.view.actitity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.MotionEvent;

import com.jh.rental.user.bean.ordermessage.GetAreaAddressList;
import com.jh.rental.user.model.receive.PickupData;
import com.jh.rental.user.presenter.home.LoadingNetData;
import com.jh.rental.user.utils.jason.Logger;
import com.jh.rental.user.view.BaseApplication;
import com.jh.rental.user.view.popview.PopwindowUtils;
import com.zhy.autolayout.AutoLayoutActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 骏辉出行 on 2017/5/12.
 */
public class BaseActvity extends AutoLayoutActivity implements PickupData {
    private LoadingNetData  loadingNetData;
    public Handler  handler=new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(Message msg) {
            handleManage(msg.what);
        }
    };
    public void handleManage(int value){
    }
    public void handleManage(Message msg){
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
              super.onCreate(savedInstanceState);

        loadingNetData=new LoadingNetData(this);
   //     loadingNetData.add();
        Logger.soutMessage(this.getClass().getName());
        new Thread(){
            @Override
            public void run() {
                initParameter();
                sendRequestData();
            }
        }.start();
        BaseApplication.addActivity(this);
    }
    /*初始化参数*/
   public void initParameter(){
   }
    @Override
    protected void onResume() {
        super.onResume();
     //   loadingNetData.clearView();
        Logger.soutMessage("目前activities数量"+BaseApplication.activities.size()+"==");
        System.gc();
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        if (handler!=null){
            handler.removeCallbacksAndMessages(null);
        }
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
       if (PopwindowUtils.getPopwindowUtils().getPopupWindow()!=null&&PopwindowUtils.getPopwindowUtils().getPopupWindow().isShowing()){
            return false;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        BaseApplication.finishActivity();
    }
    /*主要用途网络请求数据*/
    public  Map<String ,String> getBaseMap(String[] strings,String... ab){
        if (ab.length<1&&strings.length!=ab.length){
            return null;
        }
        Map<String ,String> baseMap =new HashMap<>();
        for (int i = 0; i <strings.length ; i++) {
            baseMap.put(strings[i],ab[i]);
        }
             return baseMap;
    }

    @Override
    public void getAreaAddressList(GetAreaAddressList GetAreaAddressList) {

    }
    /*w网络请求*/
    @Override
    public void sendRequestData() {
    }
    public Map<String,String> getMap(String[] key,String[] value){
         if (key.length!=value.length||key==null||value==null){
             return null;
         }
        Map<String,String>  map=new HashMap<>();
        for (int i = 0; i <value.length ; i++) {
              map.put(key[i],value[i]);
        }
        return map;
}
    public Map<String,String> getMap(String[] key,List<String> value){
        if (key.length!=value.size()||key==null||value==null){
            return null;
        }
        Map<String,String>  map=new HashMap<>();
        for (int i = 0; i <value.size() ; i++) {
            map.put(key[i],value.get(i));
        }
        return map;
    }
    /*返回linked数据*/
    public LinkedHashMap<String,String > getLinkdHashHap(String[] efg,String...abc){
        LinkedHashMap<String,String > linkedHashMap=new LinkedHashMap<>();
        for (int i = 0; i <efg.length ; i++) {
            linkedHashMap.put(efg[i],abc[i]);
        }
        return linkedHashMap;
    }
    private final String TAG = "MPermissions";
    private int REQUEST_CODE_PERMISSION = 0x00099;
    /**
     * 请求权限
     *
     * @param permissions 请求的权限
     * @param requestCode 请求权限的请求码
     */
    public void requestPermission(String[] permissions, int requestCode) {
        this.REQUEST_CODE_PERMISSION = requestCode;
        if (checkPermissions(permissions)) {
            permissionSuccess(REQUEST_CODE_PERMISSION);
        } else {
            List<String> needPermissions = getDeniedPermissions(permissions);
            ActivityCompat.requestPermissions(this, needPermissions.toArray(new String[needPermissions.size()]), REQUEST_CODE_PERMISSION);
        }
    }
    /**
     * 检测所有的权限是否都已授权
     *
     * @param permissions
     * @return
     */
    private boolean checkPermissions(String[] permissions) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true;
        }
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) !=
                    PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    /**
     * 获取权限集中需要申请权限的列表
     *
     * @param permissions
     * @return
     */
    private List<String> getDeniedPermissions(String[] permissions) {
        List<String> needRequestPermissionList = new ArrayList<>();
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) !=
                    PackageManager.PERMISSION_GRANTED ||
                    ActivityCompat.shouldShowRequestPermissionRationale(this, permission)) {
                needRequestPermissionList.add(permission);
            }
        }
        return needRequestPermissionList;
    }


    /**
     * 系统请求权限回调
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_PERMISSION) {
            if (verifyPermissions(grantResults)) {
                permissionSuccess(REQUEST_CODE_PERMISSION);
            } else {
                permissionFail(REQUEST_CODE_PERMISSION);
                showTipsDialog();
            }
        }
    }

    /**
     * 确认所有的权限是否都已授权
     *
     * @param grantResults
     * @return
     */
    private boolean verifyPermissions(int[] grantResults) {
        for (int grantResult : grantResults) {
            if (grantResult != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    /**
     * 显示提示对话框
     */
    private void showTipsDialog() {
        new AlertDialog.Builder(this)
                .setTitle("提示信息")
                .setMessage("当前应用缺少必要权限，该功能暂时无法使用。如若需要，请单击【确定】按钮前往设置中心进行权限授权。")
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startAppSettings();
                    }
                }).show();
    }

    /**
     * 启动当前应用设置页面
     */
    private void startAppSettings() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setData(Uri.parse("package:" + getPackageName()));
        startActivity(intent);
    }

    /**
     * 获取权限成功
     *
     * @param requestCode
     */
    public void permissionSuccess(int requestCode) {
        Log.d(TAG, "获取权限成功=" + requestCode);

    }

    /**
     * 权限获取失败
     * @param requestCode
     */
    public void permissionFail(int requestCode) {
        Log.d(TAG, "获取权限失败=" + requestCode);
    }


}
