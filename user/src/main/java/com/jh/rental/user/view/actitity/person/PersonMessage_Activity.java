package com.jh.rental.user.view.actitity.person;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.jh.rental.user.R;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.view.BaseApplication;
import com.jh.rental.user.view.actitity.TitelBarAcitvity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by 骏辉出行 on 2017/5/18.
 */
@EActivity(R.layout.personmessage_activity)
public class PersonMessage_Activity extends TitelBarAcitvity{
    @ViewById(R.id.sub_title2)
TextView  sub_titel2;
    @AfterViews
    public void afterviews(){
        sub_titel2.setVisibility(View.VISIBLE);
         sub_titel2.setText(BaseContext.getResValue(R.string.exitlogin));
        setMyTitel(BaseContext.getResValue(R.string.personmessage));
    }
@Click(R.id.sub_title2)
    public void exitsystem(){
   // BaseApplication.exit();
}

}
