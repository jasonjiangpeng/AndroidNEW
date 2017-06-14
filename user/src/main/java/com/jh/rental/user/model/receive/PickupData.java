package com.jh.rental.user.model.receive;

import com.jh.rental.user.bean.ordermessage.GetAreaAddressList;

/**
 * Created by 骏辉出行 on 2017/6/8.
 */

public interface PickupData  {
    void getAreaAddressList(GetAreaAddressList GetAreaAddressList);
    void sendRequestData();
}
