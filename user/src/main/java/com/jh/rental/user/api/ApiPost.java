package com.jh.rental.user.api;

/**
 * Created by 骏辉出行 on 2017/6/5.
 */

public class ApiPost {
    public final static String url = "http://app.haiguizuche.com/jh-inter-web";
//    public final static String url = "http://wx.yoyochuxing.com/test-inter-web";
    /*注册登陆*/
    //   public final static  String register_url="http://47.52.71.216:8090/test-inter-web/unauth/user/register";
    public final static String register = url + "/unauth/user/register";
    /*登陆*/
//    public final static  String login_url="http://47.52.71.216:8090/test-inter-web/unauth/user/login";
//    public final static  String login="http://47.52.71.216/test-inter-web/unauth/user/login";
//    public final static  String login="http://wx.yoyochuxing.com/test-inter-web/unauth/user/login";
    public final static String login = url + "/unauth/user/login";
    /*获取热门路线*/
    public final static String getHotCircuits = url + "/unauth/hotCircuit/getHotCircuits";
    /*发送短信*/
    public final static String sendSms = url + "/unauth/sms/sendSms";
    /*首页轮播图*/

    public final static String getEffectiveBanner = url + "/unauth/banner/getEffectiveBanner";
    public final static String setpassword_url = url + "/user/setPassword";
    /*获取热门地标查询*/
    public final static String getHotAddressList = url + "/unauth/hotaddress/getHotAddressListNew";
    /*获取车辆信息*/
    public final static String getCarPrice = url + "/unauth/carprice/getCarPrice";
    /*获取接送机车辆信息*/
    public final static String getCarPriceTransPort = url + "/unauth/carprice/getCarPriceTransPort";
    /*订单备注*/
    public final static String addOrderRemark = url + "/order/addOrderRemark";
    /*用户意见反馈*/
    public final static String submitOpinion = url + "/opinion/submitOpinion";
    /*包车接口*/
    public final static String getCharteredCarPrice = url + "/unauth/carprice/getCharteredCarPrice";
    /*修改用户信息*/
    public final static String updateUser = url + "/user/updateUser";
    /*下单接口*/
    public final static String placeOrder = url + "/order/placeOrder";
    public final static String placeOrderCircuit = url + "/order/placeOrderCircuit";
    /*高德地址*/
    public final static String getGdPoiList = "http://app.haiguizuche.com/jh-third-web/unauth/map/getGdPoiList";
  //  public final static String getGdPoiList = "http://39.108.78.123/jh-third-web/unauth/map/getGdPoiList";
    /*国家城市接口*/
    public final static String getPoiCityList = url + "/unauth/address/getPoiCityList";
    /*修改密码*/
    public final static String inlandOrderInfo = url + "/order/inlandOrderInfo";
    /*获取优惠券*/
    public final static String getUserCouponList = url + "/user/getUserCouponList";

    public final static String setPassword = url + "/unauth/user/setPassword";

    public final static String queryEvaluateStatis = url + "/unauth/evaluate/queryEvaluateStatis";
    public final static String queryEvaluateView = url + "/unauth/evaluate/queryEvaluateView";
    //    public final  static String queryEvaluateView ="http://39.108.78.123/unauth/evaluate/queryEvaluateView";
    public final static String submitEvaluate = url + "/evaluate/submitEvaluate";
    public final static String queryUserEvaluate = url + "/evaluate/queryUserEvaluate";
    public final static String updateIsExistL = url + "/order/updateIsExistL";
    public final static String getGgPoiPath = "http://app.haiguizuche.com/jh-third-web/unauth/map/getGgPoiPath";
    /*线路每天起终点*/
    public final static String addOrderDayMsg = url + "/order/addOrderDayMsg";
    public final static String addOrderPhotos = url + "/orderphotos/addOrderPhotos";
    public final static String getNewVersion = url + "/unauth/version/getNewVersion";

}
