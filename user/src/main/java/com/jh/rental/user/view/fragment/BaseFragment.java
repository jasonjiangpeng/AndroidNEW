package com.jh.rental.user.view.fragment;

import android.app.Activity;
import android.content.Context;
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
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jh.rental.user.MainActivity;
import com.jh.rental.user.R;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.utils.jason.NetUtils;
import com.jh.rental.user.view.BaseApplication;
import com.jh.rental.user.view.widget.SearchView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 骏辉出行 on 2017/5/23.
 */

public abstract class BaseFragment extends Fragment {
    public Handler handler=new Handler(Looper.myLooper()){

        @Override
        public void handleMessage(Message msg) {
          myHanlder(msg.what);
        }
    };
    public void myHanlder(int value){
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        initParamer();
        new Thread(){
            @Override
            public void run() {
                netRequest();
            }
        }.start();
    }

    public void initParamer() {
    }


    public void netRequest(){

     }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

      /*  if (isNetUsed()){
            if (!NetUtils.isConnected(getContext())){

                ViewGroup  viewGroup = (ViewGroup) BaseApplication.currentActivity().getWindow().getDecorView();
                View view1=inflater.inflate(R.layout.nonet,null);
                Button  button= (Button) view1.findViewById(R.id.netupdata);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MainActivity mainActivity = (MainActivity) getActivity();
                        mainActivity.upUi();
                    }
                });
                viewGroup.addView(view1);
              //  return view1;
            }
        }*/
        View view =setView();
//        int width = getActivity().getWindowManager().getDefaultDisplay().getWidth();
//        Logger.showMessage(width+"-----------------------------");
        return view;
    }
    public     abstract View setView();
    protected    void init(){

    }
    protected    void init(View view){

    }
    public Map<String ,String> getBaseMap(String[] strings, String... ab){
        if (ab.length<1&&strings.length!=ab.length){
            return null;
        }
        Map<String ,String> baseMap =new HashMap<>();
        for (int i = 0; i <strings.length ; i++) {
            baseMap.put(strings[i],ab[i]);
        }
        return baseMap;
    }

    public boolean isNetUsed(){
        return  true;
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
            ActivityCompat.requestPermissions(BaseApplication.currentActivity(), needPermissions.toArray(new String[needPermissions.size()]), REQUEST_CODE_PERMISSION);
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
            if (ContextCompat.checkSelfPermission(BaseApplication.currentActivity(), permission) !=
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
            if (ContextCompat.checkSelfPermission(this.getContext(), permission) !=
                    PackageManager.PERMISSION_GRANTED ||
                    ActivityCompat.shouldShowRequestPermissionRationale(BaseApplication.currentActivity(), permission)) {
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
        new AlertDialog.Builder(this.getContext())
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
        intent.setData(Uri.parse("package:" + this.getContext().getPackageName()));
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
