package com.jh.rental.user.bean.location;

/**
 * Created by 骏辉出行 on 2017/6/9.
 */

public class HotAddress {
    private String name;
    private String address;


    public HotAddress(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
