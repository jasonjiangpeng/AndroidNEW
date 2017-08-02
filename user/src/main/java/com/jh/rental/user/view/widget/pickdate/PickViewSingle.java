package com.jh.rental.user.view.widget.pickdate;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.support.v4.view.GestureDetectorCompat;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.jh.rental.user.utils.jason.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 骏辉出行 on 2017/6/10.
 */

public class PickViewSingle extends View {
    private  float fontheight1,fontheight2;/*字体高度*/
    private GestureDetectorCompat gestureDetectorCompat;
    private boolean orun=false;//设置启动
    private Paint  paint,line,paintc;
    private List<Integer>  list;
    public PickViewSingle(Context context) {
        this(context,null);
    }
    public PickViewSingle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Gesturelinster gesturelinster=new Gesturelinster();
        gestureDetectorCompat =new GestureDetectorCompat(context,gesturelinster);
        list=new ArrayList<>();
        line=getPaintLine();
        orun=false;
    }
    private   int count=3;
    private int weight=0;
    private  float height;
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
        if (!orun){
            return;
        }
        if (weight==0){
            weight=getWidth();
            height=getHeight()/3;
            float a=(height*3)/4;
            float b=height/2;
            paint=getPain(b);
            paintc=getPain2(a);
            fontheight1=paintc.descent()-paintc.ascent();
            fontheight2=paint.descent()-paint.ascent();
            fontheight1=(height-fontheight1)/2;
            fontheight2=(height-fontheight2)/2;
        }
        if (list==null){
            return;
        }
        RectF rect =new RectF(0,height,getWidth(),2*height);
        canvas.drawRect(rect,line);
        if (list.size()>0){
            if (list.size()<count){
                count=list.size();
            }
            if (list.size()==1){
                canvas.drawText(String.valueOf(list.get(0))+value,weight/2,height+height-fontheight1*2,paintc);
                return;
            }
            for (int i = 0; i <count ; i++) {
                if (i==1){
                    canvas.drawText(String.valueOf(list.get(i))+value,weight/2,height+height*i-fontheight1*2,paintc);
                }else {
                    canvas.drawText(String.valueOf(list.get(i))+value,weight/2,height+height*i-fontheight2,paint);
                }
            }
        }
    }
    private String  value="";

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetectorCompat.onTouchEvent(event);
        return true;
    }
    public int getCounts(){
        return list.get(1);
    }
    public class Gesturelinster extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            if (distanceY>25){
                postDelayed(rundown,10);
            }
            if (distanceY<-25){
                postDelayed(runup,10);
            }
            return super.onScroll(e1, e2, distanceX, distanceY);
        }
    }
    public Paint  getPain(float size){
        Paint pa =new Paint();
        pa.setColor(Color.parseColor("#9A9A9A"));
        pa.setTextSize(size);
        pa.setAntiAlias(true);
        return pa;
    }
    public Paint  getPain2(float size){
        Paint pa =new Paint();
        pa.setColor(Color.parseColor("#424242"));
        pa.setTextSize(size);
        pa.setAntiAlias(true);
        return pa;
    }
    public Paint  getPaintLine(){
        Paint pa =new Paint();
        pa.setColor(Color.parseColor("#eef7ff"));
        pa.setStyle(Paint.Style.FILL);
        pa.setStrokeWidth(5f);
          pa.setAntiAlias(true);
        return pa;
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
    private Runnable  rundown =new Runnable() {
        @Override
        public void run() {
            listAddOne(list);
            postInvalidate();
        }
    };
    private     Runnable  runup =new Runnable() {
        @Override
        public void run() {
            listSubOne(list);
            postInvalidate();
        }
    };
    public static void listAddOne(List<Integer> list) {  //+1
        if (list==null||list.size()<1){
            return;
        }
        int a = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                list.set(i, a);
            } else {
                list.set(i, list.get(i + 1));
            }

        }
    }
    public static void listSubOne(List<Integer> list) { //-1
        if (list==null||list.size()<1){
            return;
        }
        int a = list.get(list.size()-1);
        for (int i = list.size()-1; i >=0; i--) {
            if (i==0) {
                list.set(i, a);
            } else {
                list.set(i, list.get(i - 1));
            }
        }
    }

    public void startUi(List l){  //设置数据类型
        orun =true;
        this.list.clear();
          list.addAll(l);
        invalidate();
    }

}
