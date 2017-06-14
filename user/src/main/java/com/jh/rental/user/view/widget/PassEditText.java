package com.jh.rental.user.view.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by 骏辉出行 on 2017/6/2.
 */

public class PassEditText extends android.support.v7.widget.AppCompatEditText {
    public PassEditText(Context context) {
        this(context,null);
    }

    public PassEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTransformationMethod(PasswordTransformationMethod.getInstance());

    }

    @Override
    public void setCompoundDrawables(@Nullable Drawable left, @Nullable Drawable top, @Nullable Drawable right, @Nullable Drawable bottom) {
        super.setCompoundDrawables(left, top, right, bottom);

    }
  boolean  isCheckeds=true;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction()==MotionEvent.ACTION_UP){
            Drawable   dra=getCompoundDrawables()[2];
            if (dra != null && event.getRawX() >= (getRight() - dra.getBounds().width())) {
                if(isCheckeds){
                    //如果选中，显示密码
                    setTransformationMethod(HideReturnsTransformationMethod.getInstance());

                    isCheckeds=false;
                  setSelected(true);
                }else{
                    //否则隐藏密码
                    setTransformationMethod(PasswordTransformationMethod.getInstance());
                    isCheckeds =true;
                    setSelected(false);
                }
                return true;
            }
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();

    }

}
