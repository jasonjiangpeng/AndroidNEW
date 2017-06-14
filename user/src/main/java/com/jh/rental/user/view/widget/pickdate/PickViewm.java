package com.jh.rental.user.view.widget.pickdate;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v4.view.GestureDetectorCompat;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 骏辉出行 on 2017/6/10.
 */

public class PickViewm extends View {
    private  float h1;/*字体高度*/
    private GestureDetectorCompat gestureDetectorCompat;
    private boolean orun=false;//设置启动
    private String text;
    private Paint  paint;
    private List<Integer>  list;
    private int  fontsize=80;//字体大小
    public PickViewm(Context context) {
        this(context,null);
    }

    public PickViewm(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Gesturelinster gesturelinster=new Gesturelinster();
        gestureDetectorCompat =new GestureDetectorCompat(context,gesturelinster);
        list=new ArrayList<>();
        paint=getPain();
        h1=paint.descent()-paint.ascent();

    }
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
        if (!orun){
            return;
        }
        if (list.size()==0){
            canvas.drawLine(0,h1,getWidth(),h1,paint);
            canvas.drawLine(0,h1*2,getWidth(),h1*2,paint);
            canvas.drawText(text,0,h1+h1,paint);
        }else if (list.size()==2) {
            for (int i = 0; i <list.size() ; i++) {
                if (i==1){
                    canvas.drawLine(0,h1,getWidth(),h1,paint);
                    canvas.drawLine(0,h1*2,getWidth(),h1*2,paint);
                }
                canvas.drawText(list.get(i)+text,0,h1+i*h1,paint);
            }
        }else if (list.size()>2){
            for (int i = 0; i <3 ; i++) {
                if (i==1){
                    canvas.drawLine(0,h1,getWidth(),h1,paint);
                    canvas.drawLine(0,h1*2,getWidth(),h1*2,paint);
                }
                canvas.drawText(list.get(i)+text,0,h1+i*h1,paint);
            }
        }
    }

    public Paint  getPain(){
        Paint pa =new Paint();
        pa.setColor(Color.BLACK);
        pa.setTextSize(fontsize);
        pa.setAntiAlias(true);
        return pa;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetectorCompat.onTouchEvent(event);
        return true;
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

    @Override
    protected void onDetachedFromWindow() {
        if (list!=null){
            list.clear();
        }
        super.onDetachedFromWindow();
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
    public void initData(String s){
        text=s;
        orun=true;
    }
    public void startUi(Type type,String s){  //设置数据类型
        initData(s);
        //  List<Integer> lv=new ArrayList<>();
        switch (type){
            case Year:
                int a=DateUtils.getYear();
                for (int i = 0; i <2 ; i++) {
                    list.add(a+i);
                }
                break;
            case MONDEY:
                for (int i = 0; i <12 ; i++) {
                    list.add(i+1);
                }
                break;
            case Day:
                for (int i = 0; i <30 ; i++) {
                    list.add(i+1);
                }
                break;
            case WEEK:

                break;
            case HOUR:
                for (int i = 0; i <24 ; i++) {
                    list.add(i+1);
                }
                break;
            case TIME:
                for (int i = 0; i <12 ; i++) {
                    list.add(i*5);
                }
                break;
            case MONDAYWEEK:
                break;
        }
        invalidate();
    }

}
