package com.jh.rental.user.bean.ordermessage;

import com.jh.rental.user.utils.jason.LoadDialog;

/**
 * Created by 骏辉出行 on 2017/6/9.
 */

public class GetHotAddressList {

    /**
     * cityId : 0D25FB31E23F01B7E0532429030AA5CF
     * cityName : 深圳
     * adrName : 宝安机场
     * address : 广东省深圳市宝安区深圳市宝安国际机场深圳宝安国际机场
     * gdLng : 113.814549
     * gdLat : 22.63336
     * baiduLng : 113.821042698
     * baiduLat : 22.639027438
     * gugeLng : 113.814507122
     * gugeLat : 22.63328002
     * type : 2
     */

    private String cityId;
    private String cityName;
    private String adrName;
    private String address;
    private String gdLng;
    private String gdLat;
    private String baiduLng;
    private String baiduLat;
    private String gugeLng;
    private String gugeLat;
    private String type;

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAdrName() {
        return adrName;
    }

    public void setAdrName(String adrName) {
        this.adrName = adrName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGdLng() {
        return gdLng;
    }

    public void setGdLng(String gdLng) {
        this.gdLng = gdLng;
    }

    public String getGdLat() {
        return gdLat;
    }

    public void setGdLat(String gdLat) {
        this.gdLat = gdLat;
    }

    public String getBaiduLng() {
        return baiduLng;
    }

    public void setBaiduLng(String baiduLng) {
        this.baiduLng = baiduLng;
    }

    public String getBaiduLat() {
        return baiduLat;
    }

    public void setBaiduLat(String baiduLat) {
        this.baiduLat = baiduLat;
    }

    public String getGugeLng() {
        return gugeLng;
    }

    public void setGugeLng(String gugeLng) {
        this.gugeLng = gugeLng;
    }

    public String getGugeLat() {
        return gugeLat;
    }

    public void setGugeLat(String gugeLat) {
        this.gugeLat = gugeLat;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
