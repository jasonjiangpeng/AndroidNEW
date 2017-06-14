package com.jh.rental.user.bean.login;

/**
 * Created by 骏辉出行 on 2017/6/7.
 */

public class SmsBean {
    /**
     * code : 10000
     * message : 发送成功！
     */

    private int code;
    private String message;

    public SmsBean(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
