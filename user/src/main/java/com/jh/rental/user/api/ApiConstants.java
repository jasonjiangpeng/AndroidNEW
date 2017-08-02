package com.jh.rental.user.api;

/**
 * Created by 骏辉出行 on 2017/6/7.
 */

public class ApiConstants {
    public static final int SucceedCode=10000;
    //sessionid--sessid=5ba6ce2f-aa63-4779-8f1b-af82ce1351d3
    public static volatile String localCookie = null;
    /*订单类型  0代表接机，1送机，2专车,3包车市内，4跨城*/
    public static int OrderlTpye =0;
    /*登陆状态*/
    public static volatile boolean loginStatus = false;
    /*用户端版本*/
    public static  final  String clientVersion="1";
    /*用户端类型*/
    public static  final  String  clientType="1";
    /*优惠券*/
    public static double   coupow=0;
    /*优惠券最大限额*/
    public static double   limitUseMax=0;
    /*1"搜索下个界面,2返回"*/
    public static int searchChoose=1;
    public static String  getSystemVersion(){
        return "1.0";
    }
    /*包车天数*/
    public static int Day=1;
    /*包车日期*/
    public static String Date="";
    public static  boolean isFistBoot=true;
    public static  String queryCity="";
    public static  String orderId="";
    public static final String APP_CACAHE_DIRNAME = "/data/data/com.jh.rental.user/cache/webviewCache";
}
