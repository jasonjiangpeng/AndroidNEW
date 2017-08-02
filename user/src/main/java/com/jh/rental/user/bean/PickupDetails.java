package com.jh.rental.user.bean;

/**
 * Created by 骏辉出行 on 2017/6/9.
 */

public class PickupDetails {
 private  static PickupDetails orderDetails;
    private String  writeflightNo;
    private String  writedate;
    private String  flightNo; //航班号
    private String  date; //日期
    private String arriveName; //到达目的地
    private String arriveAddress; //到达目的地
    private String  arriveTime; //到达时间
    private String  waycity; //途径城市
    private String  departcity; //城市出发地点
    private String  descitys; //城市目的地点
    private String  mancounts; //人数
    private String  child; //小孩人数
    private String  carmessage;
    private String  luggage; //行李
    private int  price;
    private String dcrMobile;
    private String  modelId;
    private double  startLag;
    private double  startLng;
    private double endLag;
    private double endLng;
    private String bannerContent;
  public static void destroy(){
      orderDetails=null;
  }
    public String getBannerContent() {
        return bannerContent;
    }

    public void setBannerContent(String bannerContent) {
        this.bannerContent = bannerContent;
    }

    private String  endCityName;
    private String  endCityAddress;
    public String getModelId() {
        return modelId;
    }
    public void setModelId(String modelId) {
        this.modelId = modelId;
    }
    public String getDcrMobile() {
        return dcrMobile;
    }
    public void setDcrMobile(String dcrMobile) {
        this.dcrMobile = dcrMobile;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getWriteflightNo() {
        return writeflightNo;
    }

    public void setWriteflightNo(String writeflightNo) {
        this.writeflightNo = writeflightNo;
    }

    public String getWritedate() {
        return writedate;
    }

    public void setWritedate(String writedate) {
        this.writedate = writedate;
    }

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

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getArriveName() {
        return arriveName;
    }
    public void setArriveName(String arriveName) {
        this.arriveName = arriveName;
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

    public double getStartLag() {
        return startLag;
    }

    public void setStartLag(double startLag) {
        this.startLag = startLag;
    }

    public double getStartLng() {
        return startLng;
    }

    public void setStartLng(double startLng) {
        this.startLng = startLng;
    }

    public double getEndLag() {
        return endLag;
    }

    public void setEndLag(double endLag) {
        this.endLag = endLag;
    }

    public double getEndLng() {
        return endLng;
    }

    public void setEndLng(double endLng) {
        this.endLng = endLng;
    }

    public String getEndCityName() {
        return endCityName;
    }

    public void setEndCityName(String endCityName) {
        this.endCityName = endCityName;
    }

    public String getEndCityAddress() {
        return endCityAddress;
    }

    public void setEndCityAddress(String endCityAddress) {
        this.endCityAddress = endCityAddress;
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
    public static PickupDetails crePickupDetails(){
        if (orderDetails!=null){
            orderDetails=null;
        }
        orderDetails=new PickupDetails();
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

    public String getArriveAddress() {
        return arriveAddress;
    }

    public void setArriveAddress(String arriveAddress) {
        this.arriveAddress = arriveAddress;
    }

}
