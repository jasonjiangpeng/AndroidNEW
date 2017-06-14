package com.jh.rental.user.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 骏辉出行 on 2017/5/19.
 */
@Entity
public class DataOne  {
    @Id
    long  id;
    @Unique
    public String name;
    @Generated(hash = 1566633143)
    public DataOne(long id, String name) {
        this.id = id;
        this.name = name;
    }
    @Generated(hash = 937578340)
    public DataOne() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }


}
