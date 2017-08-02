package com.jh.rental.user.api;

/**
 * Created by 骏辉出行 on 2017/6/5.
 */

public class ApiGet {
    public final static String url = "http://app.haiguizuche.com/jh-inter-web";
//    public final static String url = "http://wx.yoyochuxing.com/test-inter-web";

    /*热门城市*/
    public final static String getPoiCityList = url + "/unauth/address/getHotCityList";
    public final static String register_url = url + "/unauth/user/register";
    public final static String getInterAreaAddressList = url + "/unauth/address/getInterAreaAddressList";
    /*查询行帮*/
    public final static String queryFlightMsg = url + "/unauth/flightMsg/queryFlightMsg";
    public final static String queryFlightMsgNew = "http://app.haiguizuche.com/jh-third-web/unauth/third/getFlight";
    /*获取广东地址包括香港*/
    public final static String getGDAddressList = url + "/unauth/address/getGDAddressList";
    public final static String queryHotCircuitById = url + "/unauth/hotCircuit/queryHotCircuitById";
    public final static String queryCoupon = url + "/userCoupon/queryCoupon";
    /*查询订单*/
    public final static String findOrders = url + "/order/findOrders";
    /*单个订单*/
//    public final static  String  findOrderDetail=url+"/order/findOrderDetail/findOrderDetail";
    public final static String findOrderDetail = url + "/order/findOrderDetail";
    /*退出登录*/
    public final static String logout = url + "/user/logout";
    /*获取用户信息*/
    public final static String getUserInfo = url + "/user/getUserInfo";
    /*环信用户信息*/
    public final static String getUser = url + "/huanxin/getUser";
    //    public final static  String  getUser="http://wx.yoyochuxing.com/test-inter-web/huanxin/getUser";
//    public final static  String  getUser="http://39.108.78.123/huanxin/getUser";
    /*获取7牛token*/
    public final static String getToken = url + "/qiniu/getToken";
    /*获取支付数据*/
    public final static String getPayData = url + "/pay/getPayData";
    /*司导故事*/
    public final static String storys = url + "/unauth/story/storys";
    /*获取国家城市*/
    public final static String getGroupLetterCountListByCityId = url + "/unauth/address/getGroupLetterCountListByCityId";
    public final static String getAddressByCityName = url + "/unauth/address/getAddressByCityName";
    /*获取主题*/
    public final static String getThemess = url + "/unauth/hotCircuit/getThemess";
    public final static String getHotCircuitsDays = url + "/unauth/hotCircuit/getHotCircuitsDays";
    /**/
    public final static String getHotCircuitUrl = url + "/unauth/hotCircuit/getHotCircuitUrl?type=";
    public final static String getCircuitModelList = url + "/unauth/hotCircuit/getCircuitModelList";
    public final static String getAddressByCityId = url + "/unauth/address/getAddressByCityId";
    /* 取消订单*/
    public final static String cancelOrder = url + "/order/cancelOrder";
    /*收藏*/
    public final static String saveUserCollection = url + "/user/saveUserCollection";
    /*取消收藏*/
    public final static String deleteUserCollection = url + "/user/deleteUserCollection";
    /*收藏列表*/
    public final static String getUserCollectionList = url + "/user/getUserCollectionList";
    /*删除订单*/
    public final static String deleteOrder = url + "/order/deleteOrder";
    /*查询城市*/
    public final static String getGooglePointByAdr = "http://wx.yoyochuxing.com/jh-third-web/unauth/map/getGooglePointByAdr?query=";
    public final static String checkCityIdIsDomestic = url + "/unauth/address/checkCityIdIsDomestic?cityName=";
    public final static String wxShareCodePage = url + "/activity/wxShareCodePage";
    public final static String sendShare = url + "/unauth/activity/sendShare";
    public final static String shareBack = url + "/unauth/activity/shareBack?id=";
    public final static String getCircuitDayCity = url + "/unauth/hotCircuit/getCircuitDayCity";
    public final static String getServices = url + "/huanxin/getServices";
    public final static String queryUserExist = url + "/unauth/user/queryUserExist";
    public final static String queryCircuitPlanListByCircuitId = url + "/unauth/hotCircuit/queryCircuitPlanListByCircuitId?hotCircuitId=";
    public final static String getScenicById = url + "/unauth/scenic/getScenicById?scenicId=";

}