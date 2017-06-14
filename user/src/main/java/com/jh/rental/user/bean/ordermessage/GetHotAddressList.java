package com.jh.rental.user.bean.ordermessage;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 骏辉出行 on 2017/6/9.
 */

public class GetHotAddressList {

    /**
     * id : a1
     * createBy : null
     * createDate : 2017-06-06 07:21:56
     * updateBy : null
     * updateDate : null
     * version : null
     * isDeleted : 0
     * cityId : 111
     * adrName : 落马洲
     * address : 就在华强北啊
     * gdLng : 34.034432524
     * gdLat : 34.034432524
     * baiduLng : 34.034432524
     * baiduLat : 34.034432524
     * gugeLng : 34.034432524
     * gugeLat : 34.034432524
     * type : 2
     * new : false
     */

    private String id;
    private Object createBy;
    private String createDate;
    private Object updateBy;
    private Object updateDate;
    private Object version;
    private String isDeleted;
    private String cityId;
    private String adrName;
    private String address;
    private double gdLng;
    private double gdLat;
    private double baiduLng;
    private double baiduLat;
    private double gugeLng;
    private double gugeLat;
    private int type;
    @SerializedName("new")
    private boolean newX;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Object createBy) {
        this.createBy = createBy;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Object getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Object updateBy) {
        this.updateBy = updateBy;
    }

    public Object getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Object updateDate) {
        this.updateDate = updateDate;
    }

    public Object getVersion() {
        return version;
    }

    public void setVersion(Object version) {
        this.version = version;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
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

    public double getGdLng() {
        return gdLng;
    }

    public void setGdLng(double gdLng) {
        this.gdLng = gdLng;
    }

    public double getGdLat() {
        return gdLat;
    }

    public void setGdLat(double gdLat) {
        this.gdLat = gdLat;
    }

    public double getBaiduLng() {
        return baiduLng;
    }

    public void setBaiduLng(double baiduLng) {
        this.baiduLng = baiduLng;
    }

    public double getBaiduLat() {
        return baiduLat;
    }

    public void setBaiduLat(double baiduLat) {
        this.baiduLat = baiduLat;
    }

    public double getGugeLng() {
        return gugeLng;
    }

    public void setGugeLng(double gugeLng) {
        this.gugeLng = gugeLng;
    }

    public double getGugeLat() {
        return gugeLat;
    }

    public void setGugeLat(double gugeLat) {
        this.gugeLat = gugeLat;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isNewX() {
        return newX;
    }

    public void setNewX(boolean newX) {
        this.newX = newX;
    }
}
