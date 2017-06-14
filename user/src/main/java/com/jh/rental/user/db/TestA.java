package com.jh.rental.user.db;

import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Unique;

/**
 * Created by 俊辉出行 on 2017/5/19.
 */

public class TestA {
    @Id(autoincrement = true)
    private  Long id;
    @Unique
    private  String name;
    @Property(nameInDb = "price")
    private     String prices;
    private int sell_num;
}
