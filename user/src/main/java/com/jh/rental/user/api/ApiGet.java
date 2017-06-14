package com.jh.rental.user.api;

/**
 * Created by 骏辉出行 on 2017/6/5.
 */

public class ApiGet {
    /*热门城市*/
    public final static  String getPoiCityList="http://47.52.71.216/jh-app-web/unauth/address/getHotCityList";
    public final static  String register_url="http://47.52.71.216/jh-app-web/unauth/user/register";
    public final static  String getAreaAddressList="http://47.52.71.216/jh-app-web/unauth/address/getAreaAddressList";
    /*查询行帮*/
    public final static  String  queryFlightMsg="http://47.52.71.216/jh-app-web/unauth/flightMsg/queryFlightMsg";
    /*获取广东地址包括香港*/
    public final static  String  getGDAddressList="http://47.52.71.216/jh-app-web/unauth/address/getGDAddressList";
    /*查询订单*/
    public final static  String  findOrders="http://47.52.71.216/jh-app-web/order/findOrders";
    /*单个订单*/
    public final static  String  findOrderDetail="http://47.52.71.216/jh-app-web/order/findOrderDetail/findOrderDetail";
}