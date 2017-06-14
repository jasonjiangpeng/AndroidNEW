package com.jh.rental.user.view.actitity.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.widget.CompoundButton;

import com.jh.rental.user.R;
import com.jh.rental.user.utils.jason.BaseContext;
import com.jh.rental.user.view.actitity.TitelBarAcitvity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

/**
 * Created by 骏辉出行 on 2017/5/18.
 */
@EActivity(R.layout.passwordmodify_a_activity)
public class PasswordModify_Activity extends TitelBarAcitvity{

    @AfterViews
    public void afterview(){
        setMyTitel(BaseContext.getResValue(R.string.passwordmodefy));
    }

}
