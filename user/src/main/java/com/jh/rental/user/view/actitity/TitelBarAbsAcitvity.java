package com.jh.rental.user.view.actitity;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.view.BaseApplication;

/**
 * Created by 骏辉出行 on 2017/5/18.
 */

public abstract   class TitelBarAbsAcitvity extends BaseActvity   {
  private   TextView  textView=null;
    private ImageView imageView=null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(resId());
        initUI();
    }
   public abstract int resId();
   public abstract void initUI();
   public abstract String  resTitel();
    @Override
    public void setContentView(@LayoutRes int layoutResID) throws Resources.NotFoundException {
        super.setContentView(layoutResID);
        textView = (TextView) findViewById(R.id.sub_title);
        textView.setText(resTitel());
    }


    public void ImgBack_M(View view){
        BaseApplication.finishActivity();
    }
}
