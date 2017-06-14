package com.jh.rental.user.api;

/**
 * Created by 骏辉出行 on 2017/6/5.
 */

public class ApiPost {
    /*注册登陆*/
 //   public final static  String register_url="http://47.52.71.216:8090/jh-app-web/unauth/user/register";
    public final static  String register="http://47.52.71.216/jh-app-web/unauth/user/register";
    /*登陆*/
//    public final static  String login_url="http://47.52.71.216:8090/jh-app-web/unauth/user/login";
    public final static  String login="http://47.52.71.216/jh-app-web/unauth/user/login";
    /*发送短信*/
/*    public final static  String sendSms_url="http://47.52.71.216:8090/jh-app-web/unauth/sms/sendSms";*/
    public final static  String sendSms="http://47.52.71.216/jh-app-web/unauth/sms/sendSms";

    public final static  String getEffectiveBanner="http://47.52.71.216/jh-app-web/unauth/banner/getEffectiveBanner";
    /*修改密码*/

    public final static  String setpassword_url="http://47.52.71.216/jh-app-web/user/setPassword";
    /*获取热门地标查询*/
    public final static  String getHotAddressList="http://47.52.71.216/jh-app-web/unauth/hotaddress/getHotAddressList";
    /*获取车辆信息*/
    public final static  String getCarPrice="http://47.52.71.216/jh-app-web/unauth/carprice/getCarPrice";
    /*获取接送机车辆信息*/
    public final static  String getCarPriceTransPort="http://47.52.71.216/jh-app-web/unauth/carprice/getCarPriceTransPort";
    /*订单备注*/
    public final static  String addOrderRemark="http://47.52.71.216/jh-app-web/order/addOrderRemark";


}
