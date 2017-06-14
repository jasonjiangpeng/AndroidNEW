package com.jh.rental.user.bean.intent;

import java.io.Serializable;

/**
 * Created by 骏辉出行 on 2017/6/6.
 */
/*航班信息*/
public class FlightMessage implements Serializable{
    private String date;
    private String flightNumber;

    public FlightMessage(String date, String flightNumber) {
        this.date = date;
        this.flightNumber = flightNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
}
