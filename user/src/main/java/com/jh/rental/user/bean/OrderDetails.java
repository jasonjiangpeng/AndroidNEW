package com.jh.rental.user.bean;

/**
 * Created by 骏辉出行 on 2017/6/9.
 */

public class OrderDetails {
    private static OrderDetails orderDetails;
    private String city; //城市
    private String id;  //城市ID
    private String endCityID;  //城市ID
    private String citysub;  //出发地
    private String descity;  //目的地
    private String waycity1;  //目的地
    private String startLng;  //开始经度
    private String startLag;  //开始纬度
    private String endLng; //结束精度
    private String endLag;//结束唯独
    private String begintime;
    private String modelId;
    private String startAdrName;
    private String endAdrName;
    private String startAddress;
    private String endAddress;
    private String orderNo;
    private String orderId;
    private String cityId;
    private String imgUrl;
    private String userCouponId;
    private String destinationID;
    private String circleId;
    private String scenId;
    private String carShowLuggmu;

    public String getCarShowLuggmu() {
        return carShowLuggmu;
    }

    public void setCarShowLuggmu(String carShowLuggmu) {
        this.carShowLuggmu = carShowLuggmu;
    }

    public String getScenId() {
        return scenId;
    }

    public void setScenId(String scenId) {
        this.scenId = scenId;
    }

    private int seatNum;

    public int getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }

    public String getCircleId() {
        return circleId;
    }

    public void setCircleId(String circleId) {
        this.circleId = circleId;
    }

    private String startCityId;

    public String getStartCityId() {
        return startCityId;
    }

    public void setStartCityId(String startCityId) {
        this.startCityId = startCityId;
    }

    public String getDestinationID() {
        return destinationID;
    }

    public void setDestinationID(String destinationID) {
        this.destinationID = destinationID;
    }

    public String getUserCouponId() {
        return userCouponId;
    }

    public void setUserCouponId(String userCouponId) {
        this.userCouponId = userCouponId;
    }

    public static void setOrderDetails(OrderDetails orderDetails) {
        OrderDetails.orderDetails = orderDetails;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getBegintime() {
        return begintime;
    }

    public void setBegintime(String begintime) {
        this.begintime = begintime;
    }

    public String getEndCityID() {
        return endCityID;
    }

    public void setEndCityID(String endCityID) {
        this.endCityID = endCityID;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStartAdrName() {
        return startAdrName;
    }

    public void setStartAdrName(String startAdrName) {
        this.startAdrName = startAdrName;
    }

    public String getEndAdrName() {
        return endAdrName;
    }

    public void setEndAdrName(String endAdrName) {
        this.endAdrName = endAdrName;
    }

    public String getStartAddress() {
        return startAddress;
    }

    public void setStartAddress(String startAddress) {
        this.startAddress = startAddress;
    }

    public String getEndAddress() {
        return endAddress;
    }

    public void setEndAddress(String endAddress) {
        this.endAddress = endAddress;
    }

    public String getCcrMobile() {
        return ccrMobile;
    }

    public void setCcrMobile(String ccrMobile) {
        this.ccrMobile = ccrMobile;
    }

    private String ccrMobile;//乘车人电话
    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getWaycity1() {
        return waycity1;
    }

    public void setWaycity1(String waycity1) {
        this.waycity1 = waycity1;
    }

    public String getWaycity2() {
        return waycity2;
    }

    public void setWaycity2(String waycity2) {
        this.waycity2 = waycity2;
    }

    private String waycity2;  //目的地

    /*用车如期*/

    public String getStartLng() {
        return startLng;
    }

    public void setStartLng(String startLng) {
        this.startLng = startLng;
    }

    public String getStartLag() {
        return startLag;
    }

    public void setStartLag(String startLag) {
        this.startLag = startLag;
    }

    public String getEndLng() {
        return endLng;
    }

    public void setEndLng(String endLng) {
        this.endLng = endLng;
    }

    public String getEndLag() {
        return endLag;
    }

    public void setEndLag(String endLag) {
        this.endLag = endLag;
    }

    private String date;  //日期
    /*人*/
    private String man;
    /*小孩*/
    private String child;
    /*车*/
    private String car;
    /*行李*/
    private String luggage;
    private String passenger;
    private int coupon;
    /*车价格*/
    private int price;

    public int getCoupon() {
        return coupon;
    }

    public void setCoupon(int coupon) {
        this.coupon = coupon;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPassenger() {
    /*    if (passenger==null){
            return "";
        }*/
        return passenger;
    }

    public void setPassenger(String passenger) {
        this.passenger = passenger;
    }

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

    public String getMan() {
        return man;
    }

    public void setMan(String man) {
        this.man = man;
    }

    public String getChild() {
        return child;
    }

    public void setChild(String child) {
        this.child = child;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getLuggage() {
        return luggage;
    }

    public void setLuggage(String luggage) {
        this.luggage = luggage;
    }

    public int getSize() {
        int a = 1;
        if (citysub != null) {
            a++;
        }
        if (descity != null) {
            a++;
        }
        if (waycity1 != null) {
            a++;
        }
        if (waycity2 != null) {
            a++;
        }

        return a - 1;
    }


    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public static void setValue(String cityid, String imgurl) {
        OrderDetails.creOredeDetails();
        OrderDetails.getOrderDetails().setCityId(cityid);
        OrderDetails.getOrderDetails().setImgUrl(imgurl);
    }

    public static OrderDetails getOrderDetails() {
        if (orderDetails == null) {
            synchronized (OrderDetails.class) {
                if (orderDetails == null) {
                    orderDetails = new OrderDetails();
                }
            }
        }
        return orderDetails;
    }

    public static OrderDetails creOredeDetails() {
        if (orderDetails != null) {
            orderDetails = null;
        }
        orderDetails = new OrderDetails();
        return orderDetails;
    }
    public static void destroy(){
        orderDetails=null;
    }

    public void init() {
        if (orderDetails != null) {
            orderDetails = new OrderDetails();
        }

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
