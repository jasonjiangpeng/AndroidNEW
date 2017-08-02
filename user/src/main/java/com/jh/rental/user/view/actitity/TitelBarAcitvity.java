package com.jh.rental.user.view.actitity;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.api.ConstantsNet;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.view.BaseApplication;

/**
 * Created by 骏辉出行 on 2017/5/18.
 */

public   class TitelBarAcitvity extends BaseActvity   {
    private   TextView  textView=null;
    private   TextView  textView2=null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) throws Resources.NotFoundException {
        super.setContentView(layoutResID);
        textView = (TextView) findViewById(R.id.sub_title);
        textView2 = (TextView) findViewById(R.id.sub_title2);
        if (textView!=null){
            if (getIntent()!=null){
                textView.setText(getIntent().getStringExtra(ConstantsNet.test_Value));
            }else textView.setText(BaseContext.getResValue(R.string.app_name));
        }
        if (textView2!=null){
            textView2.setVisibility(View.VISIBLE);
        }

    }
    public void setMyTitel(String titel){
        textView.setText(titel);
    }
    public void setMyTite2(String tite2){
        textView2.setText(tite2);
    }
    public void settv2Onclick(){
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               tv2Onclick();
            }
        });
    }
    public void tv2Onclick(){

    }
    public void ImgBack_M(View view){
        BaseApplication.finishActivity();
    }
}
