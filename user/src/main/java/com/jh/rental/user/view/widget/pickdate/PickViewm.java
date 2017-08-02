package com.jh.rental.user.view.widget.pickdate;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
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
    private  float fontheight1,fontheight2;/*字体高度*/
    private GestureDetectorCompat gestureDetectorCompat;
    private boolean orun=false;//设置启动
    private String text;
    private Paint  paint;
    private List<Integer>  list;

    public PickViewm(Context context) {
        this(context,null);
    }

    public PickViewm(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Gesturelinster gesturelinster=new Gesturelinster();
        gestureDetectorCompat =new GestureDetectorCompat(context,gesturelinster);
        list=new ArrayList<>();
        paintline=getPaintLine();

    }
    private int height;
    private int weight;

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
        if (!orun){
            return;
        }
        if (weight==0){
            weight=getWidth();
            height=getHeight()/3;
            float a=height/2;
            float b=(height*2)/5;
            paintc=getPain2(a);
            paint=getPain(b);
            fontheight1=paintc.descent()-paintc.ascent();
            fontheight2=paint.descent()-paint.ascent();
            fontheight1=(height-fontheight1)/2;
            fontheight2=(height-fontheight2)/2;
        }
        RectF rect =new RectF(0,height,getWidth(),2*height);
        canvas.drawRect(rect,paintline);
            for (int i = 0; i <3 ; i++) {
                if (i==1){
                    String value=list.get(i)+text;
                    float v = paintc.measureText(value);
                    float  c= (weight-v)/2;
                    canvas.drawText(value,c,height+height*i-fontheight1,paintc);
                }else {
                    String value=list.get(i)+text;
                    float v = paint.measureText(value);
                    float  c= (weight-v)/2;
                    canvas.drawText(value,c,height+height*i-fontheight2,paint);
                }
              //  canvas.drawText(String.valueOf(list.get(i)),weight/2,height+height*i-fontheight2,paint);
            }

    }

    private Paint  paintline;
    private Paint  paintc;
    public Paint  getPaintLine(){
        Paint pa =new Paint();
        pa.setStyle(Paint.Style.FILL);
        pa.setColor(Color.parseColor("#eef7ff"));
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
   public int  getTime(){
       return list.get(1);
   }
    public Paint  getPain(float size){
        Paint pa =new Paint();
        pa.setColor(Color.parseColor("#9A9A9A"));
        pa.setTextSize(size);
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
            if (distanceY>20){
                postDelayed(rundown,0);
            }
            if (distanceY<-20){
                postDelayed(runup,0);
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
