package com.jh.rental.user.view.widget.pickdate;

import java.util.Calendar;

/**
 * Created by 骏辉出行 on 2017/6/10.
 */

public class DateUtils {

    public static int  getMonthDay(int year,int month) {  //获取一个多少天
        Calendar calendar=Calendar.getInstance();
        int a=month-1;
        calendar.set(year, a, 1);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
    public static String  getMonthDay(int year,int month,int day) {  // 获取年月日的星期几
        Calendar calendar=Calendar.getInstance();
        int a=month-1;
        if (a>11){
         a=a-11;
            year++;
        }
        calendar.set(year, a, day);
        return getWeek(calendar);
    }
    public static int  getYear() {  //获取那年
        Calendar calendar=Calendar.getInstance();
        return calendar.get(Calendar.YEAR);
    }
    public static int  getMonth() {  //获取月
        Calendar calendar=Calendar.getInstance();
        return calendar.get(Calendar.MONTH)+1;
    }
    public static int  getDay() {  //获取那天
        Calendar calendar=Calendar.getInstance();
        return calendar.get(Calendar.DAY_OF_MONTH);
    }
    public static String  getWeek(Calendar calendar) {  //获取周几

        switch (calendar.get(Calendar.DAY_OF_WEEK)-1){
            case 0:
                return "周日";
            case 1:
                return "周一";
            case 2:
                return "周二";
            case 3:
                return "周三";

            case 4:
                return "周四";

            case 5:
                return "周五";

            case 6:
                return "周六";
        }
       return null;
    }
    public static int  getMontyDay(){ //获取本月天数
        return getMonthDay(getYear(),getMonth());
    }
    public static int  getNextMontyDay(int v){ //获取下个月天数
        int a=getMonth();
        int b=getYear();
         if (getMonth()+v>12){
             a=getMonth()+v-12;
             b=b+1;
         }
        return getMonthDay(b,a+v);
    }
}
