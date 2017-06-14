package com.jh.rental.user.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 骏辉出行 on 2017/5/18.
 */
@Entity
public class Test_shop {
 public  static final int Type_Cart=0x01;
 public  static final int Type_Love=0x03;
    @Id(autoincrement = true)
    private  Long id;
    @Unique
    private  String name;
    @Property(nameInDb = "price")
    private     String prices;
    private int sell_num;
    @Generated(hash = 52158358)
    public Test_shop(Long id, String name, String prices, int sell_num) {
        this.id = id;
        this.name = name;
        this.prices = prices;
        this.sell_num = sell_num;
    }
    @Generated(hash = 578561940)
    public Test_shop() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPrices() {
        return this.prices;
    }
    public void setPrices(String prices) {
        this.prices = prices;
    }
    public int getSell_num() {
        return this.sell_num;
    }
    public void setSell_num(int sell_num) {
        this.sell_num = sell_num;
    }


    
}
