package com.jh.rental.user;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.jh.rental.user.presenter.login.UpdataFile;
import com.jh.rental.user.view.BaseApplication;
import com.jh.rental.user.view.actitity.BaseActvity;
import com.jh.rental.user.view.fragment.ConsultFragment;
import com.jh.rental.user.view.fragment.DestinationFragment;
import com.jh.rental.user.view.fragment.HomeFragment;
import com.jh.rental.user.view.fragment.JourneyFragment;
import com.jh.rental.user.view.fragment.MyFragment;

import org.androidannotations.api.UiThreadExecutor;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActvity {
   // private FragmentManager mFragmentManager;
    private Toast toast;
    private long exitTime = 0;
    private String account,password;
    private LinearLayout mBaseNav;
    private List<Fragment> mFragmentList = null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         new UpdataFile().reqNet();
        setContentView(R.layout.activity_main);

//        map=new HashMap<>();
        initView();

    }

    @Override
    public void handleManage(int value) {

    }

    private void initView() {
        if (mFragmentList== null){
            mFragmentList = new ArrayList<>();
        }
//        account = PreferencesUtil.getString(MainActivity.this, Constant.ACCOUNT);
//        password = PreferencesUtil.getString(MainActivity.this, Constant.PASSWORD);
        mBaseNav = (LinearLayout) findViewById(R.id.baseNav);
      //  mFragmentManager = getSupportFragmentManager();
//        if (account!=""&password!=""){
//            login();
//        }
        initFragment();
        initBottom();
        changeUi(0);
    }

    /*private void login() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mapconfig(account,password);
                ApiConstants.loginStatus=true;
                HttpVolley.getInstance().postMapRequest(ApiPost.login,map,new NetSucceed<>(SmsBean.class,new NetSucceed.HolderData<SmsBean>() {
                    @Override
                    public void holdData(SmsBean bean) {
                        PreferencesUtil.putString(MainActivity.this, Constant.REGISTER, ApiConstants.localCookie);
                        requestNet();
                    }
                }),new NetError());
            }
        });
    }*/

    private void initFragment() {
      //  mFragmentList.add(new HomeFragmentold());
        mFragmentList.add(new HomeFragment());
        mFragmentList.add(new DestinationFragment());
        mFragmentList.add(new ConsultFragment());
        mFragmentList.add(new JourneyFragment());
        mFragmentList.add(new MyFragment());
    }
    int tap;
    private void initBottom() {
        int count  = mBaseNav.getChildCount();
        for(int i=0;i<count;i++){
            final View child = mBaseNav.getChildAt(i);
            child.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int index = mBaseNav.indexOfChild(child);
                    changeUi(index);
                    tap = index;
                }
            });
        }
    }

    private void changeUi(int index) {
        int count  = mBaseNav.getChildCount();
        for(int i=0;i<count;i++) {
            final View child = mBaseNav.getChildAt(i);
            if(i==index){
                child.setEnabled(false);
            }else{
                child.setEnabled(true);
            }
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,mFragmentList.get(index)).commit();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
      //  BaseApplication.exit();
    }

    public void upUi() {
        UiThreadExecutor.runTask("", new Runnable() {
                    @Override
                    public void run() {
                       /* FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        FragmentFactory.getInstance().setIsupdata(true);
                        fragmentTransaction.replace(R.id.fragment_container, FragmentFactory.getInstance().getFragment(FragmentFactory.getInstance().getTabid()));
                        fragmentTransaction.commit();*/
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,mFragmentList.get(tap)).commit();
                    }
                }
                , 500L);
    }
    public void jump1() {
        changeUi(0);
    }
    public void jump2() {
        changeUi(2);
    }

    /*private Map<String ,String> map;
    public void mapconfig(String... ab){
        if (ab.length<1){
            return;
        }
        map.clear();
        map.put("mobile",ab[0]);
        map.put("password",ab[1]);
    }*/

   /* public void requestNet(){
        HttpVolley.getInstance().getRequestData(ApiGet.getUserInfo, new NetSucceed<>(GetUserInfo.class, new NetSucceed.HolderData<GetUserInfo>() {
            @Override
            public void holdData(GetUserInfo bean) {
                if (bean.getMobile()!=null){
//                    SnakebarUtils.showToast(bean.getMobile()+"==="+bean.getNickName()+"==="+bean.getSex());
                    Constant.PHONE = bean.getMobile();
                    Constant.NAME = bean.getNickName();
                    Constant.SEX = bean.getSex();
                }
            }
        }));
    }*/

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void exit() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
           exitTime = System.currentTimeMillis();
             if (toast == null) {
                toast = Toast.makeText(MainActivity.this, "再按一次退出程序！", Toast.LENGTH_SHORT);
            } else {
                toast.cancel();
                toast = Toast.makeText(MainActivity.this, "再按一次退出程序！", Toast.LENGTH_SHORT);
            }
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
//            SnakebarUtils.showToast("再按一次退出程序");
        } else {
          toast.cancel();
          BaseApplication.exit();
//            System.exit(0);
        }
    }

}