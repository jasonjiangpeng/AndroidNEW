package com.jh.rental.user.bean;

/**
 * Created by 骏辉出行 on 2017/6/9.
 */

public class OrderDetails {
 private  static   OrderDetails  orderDetails;
    private String  city; //城市
    private String   id;  //城市ID
    private String  citysub;  //出发地
    private String  descity;  //目的地
    private String  date;  //日期
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public String getDescity() {
        return descity;
    }
    public void setDescity(String descity) {
        this.descity = descity;
    }
    public String getCitysub() {
        return citysub;
    }
    public void setCitysub(String citysub) {
        this.citysub = citysub;
    }
    private OrderDetails() {
    }
    public static OrderDetails getOrderDetails(){
        if (orderDetails==null){
            synchronized (OrderDetails.class){
                if (orderDetails==null){
                    orderDetails =new OrderDetails();
                }
            }
        }
        return orderDetails;
    }
    public void init(){
        orderDetails=new OrderDetails();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
