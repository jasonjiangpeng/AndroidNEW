package com.jh.rental.user.bean;

/**
 * Created by 骏辉出行 on 2017/6/9.
 */

public class CityData {
    private String city;
    private String dataid;
    private double gdLng;
    private double gdLat;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getId() {
        return dataid;
    }

    public void setId(String id) {
        this.dataid = id;
    }

    public CityData(String city,String id) {
        this.city = city;
        this.dataid = id;
    }

    public CityData() {

    }
}
