package com.jh.rental.user.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.jh.rental.user.R;

/**
 * Created by 骏辉出行 on 2017/5/27.
 */

public class MyTextView extends View {
    Bitmap bitmap;
    private  int price;
    private   int color;
    private  int textsize;
    public MyTextView(Context context) {
        this(context,null);
    }
  Paint paint;
    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.mytextview);
         int  a=array.getResourceId(R.styleable.mytextview_lefticon,R.drawable.badgexxhdpi);
        price=array.getInteger(R.styleable.mytextview_pricevalue,1000);
        textsize=array.getInteger(R.styleable.mytextview_textsize,10);
        color=array.getColor(R.styleable.mytextview_textcolor, Color.BLUE);
        bitmap= BitmapFactory.decodeResource(getResources(),a);
        paint=getPaint(textsize,color);

    }

    protected Paint  getPaint(){
        Paint  paint=new Paint();
        paint.setAntiAlias(true);
        paint.setTextSize(25);
        paint.setColor(getResources().getColor(R.color.normal_day));
        return paint;
    }
    @Override
    protected void onDraw(Canvas canvas) {
     //      canvas.drawBitmap(bitmap,0,0,null);
        int  w=getWidth();
        int h=getHeight();
        float  a1=paint.measureText("￥");
        float  b1=paint.measureText(String.valueOf(String.valueOf(price)));
        float  c1=getPaint().measureText("/天");
        canvas.drawText("￥",w/2+a1+b1/2,h/2,paint);
    }
    protected Paint  getPaint(int size,int color){
        Paint  paint=new Paint();
        paint.setAntiAlias(true);
        paint.setTextSize(size);
        paint.setColor(color);
        return paint;
    }

    @Override
    protected void onDetachedFromWindow() {

        super.onDetachedFromWindow();
    }
}
