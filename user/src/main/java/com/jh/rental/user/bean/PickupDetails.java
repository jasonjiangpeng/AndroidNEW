package com.jh.rental.user.bean;

/**
 * Created by 骏辉出行 on 2017/6/9.
 */

public class PickupDetails {
 private  static PickupDetails orderDetails;
    private String  flightNo; //航班号
    private String  date; //到达日期
    private String  arrive; //到达目的地
    private String  arriveTime; //到达时间
    private String  waycity; //途径城市
    private String  departcity; //城市出发地点
    private String  descitys; //城市目的地点
    private String  mancounts; //人数
    private String  child; //小孩人数
    private String  carmessage; //小孩人数
    private String  luggage; //行李
    private String  time; //行李
    private String  city; //


    public String getWaycity() {
        return waycity;
    }

    public void setWaycity(String waycity) {
        this.waycity = waycity;
    }

    public String getDepartcity() {
        return departcity;
    }

    public void setDepartcity(String departcity) {
        this.departcity = departcity;
    }



    public String getMancounts() {
        return mancounts;
    }

    public void setMancounts(String mancounts) {
        this.mancounts = mancounts;
    }

    public String getChild() {
        return child;
    }

    public void setChild(String child) {
        this.child = child;
    }

    public String getCarmessage() {
        return carmessage;
    }

    public void setCarmessage(String carmessage) {
        this.carmessage = carmessage;
    }

    public String getLuggage() {
        return luggage;
    }

    public void setLuggage(String luggage) {
        this.luggage = luggage;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

/*    public String getDesCity() {
        return desCity;
    }

    public void setDesCity(String desCity) {
        this.desCity = desCity;
    }*/



    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getArrive() {
        return arrive;
    }

    public void setArrive(String arrive) {
        this.arrive = arrive;
    }

    public String getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(String arriveTime) {
        this.arriveTime = arriveTime;
    }

    private PickupDetails() {
    }

    public String getDescitys() {
        return descitys;
    }

    public void setDescitys(String descitys) {
        this.descitys = descitys;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public static PickupDetails getOrderDetails(){
        if (orderDetails==null){
            synchronized (PickupDetails.class){
                if (orderDetails==null){
                    orderDetails =new PickupDetails();
                }
            }
        }
        return orderDetails;
    }
    public void init(){
        orderDetails=new PickupDetails();
    }
    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

}
