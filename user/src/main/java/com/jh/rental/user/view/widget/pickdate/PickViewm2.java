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

public class PickViewm2 extends View {
    private  float h1;/*字体高度*/
    private GestureDetectorCompat gestureDetectorCompat;
    private boolean orun=false;//设置启动
    private String text;
    private Paint  paint,painc;
    private List<Date>  list;
    private int  fontsize=80;//字体大小
    public PickViewm2(Context context) {
        this(context,null);
    }

    public PickViewm2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Gesturelinster gesturelinster=new Gesturelinster();
        gestureDetectorCompat =new GestureDetectorCompat(context,gesturelinster);
        list=new ArrayList<>();
        paint=getPain();
        painc=getPain2();
        h1=paint.descent()-paint.ascent();

    }
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
        for (int i = 0; i <list.size() ; i++) {

        }
        if (!orun){
            return;
        }
        for (int i = 0; i <3 ; i++) {
                if (i==1){
                    canvas.drawLine(0,h1,getWidth(),h1,paint);
                    canvas.drawLine(0,h1*2,getWidth(),h1*2,paint);
                    canvas.drawText(String.format("%1$d月%2$d日"+list.get(i).week,list.get(i).month,list.get(i).day),0,h1+i*h1,painc);
                }else {
                    canvas.drawText(String.format("%1$d月%2$d日"+list.get(i).week,list.get(i).month,list.get(i).day),0,h1+i*h1,paint);
                }
        }
    }

    public Paint  getPain(){
        Paint pa =new Paint();
        pa.setColor(Color.BLACK);
        pa.setTextSize(80);
        pa.setAntiAlias(true);
        return pa;
    }
    public Paint  getPain2(){
        Paint pa =new Paint();
        pa.setColor(Color.BLUE);
        pa.setTextSize(100);
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
    public static void listAddOne(List<Date> list) {  //+1
        if (list==null||list.size()<1){
            return;
        }
        Date a = list.get(0);
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

    public static void listSubOne(List<Date> list) { //-1
        if (list==null||list.size()<1){
            return;
        }
        Date a = list.get(list.size()-1);
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
    public void startUi(String s){  //设置数据类型
        initData(s);
        int  o =DateUtils.getYear();
          int  v=DateUtils.getMonth();
                list.clear();
             int b=DateUtils.getMontyDay();  //本月天数
                int c=DateUtils.getDay();//获取今天

                int  d=b-c;
                if (d>0){
                }
                for (int i = 0; i <d ; i++) {
                    int  e=c+1+i;
                    String monthDay = DateUtils.getMonthDay(o, v, e);
                    list.add(new Date(v,e,monthDay));
                }
                int f=DateUtils.getNextMontyDay(1);
                for (int i = 0; i <f ; i++) {
                    int n=i+1;
                    String monthDay = DateUtils.getMonthDay(o, v+1, n);
                    list.add(new Date(v+1,n,monthDay));
                }
        int ff=DateUtils.getNextMontyDay(2);
        for (int i = 0; i <ff ; i++) {
            int n=i+1;
            String monthDay = DateUtils.getMonthDay(o, v+2, n);
            list.add(new Date(v+2,n,monthDay));
        }
        invalidate();
    }
  public    class Date{
        private  int month;
        private  int day;
        private  String week;

         public Date(int month, int day, String week) {
             this.month = month;
             this.day = day;
             this.week = week;
         }
     }
}
