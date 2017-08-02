package com.jh.rental.user.bean.login;

import com.jh.rental.user.view.actitity.login.Login_Act;

/**
 * Created by 骏辉出行 on 2017/6/7.
 */

public class SmsBean {
    /**
     * code : 10000
     * message : 发送成功！
     */

    private String code;
    private String message;

    public SmsBean(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
