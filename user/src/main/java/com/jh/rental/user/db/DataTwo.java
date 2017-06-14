package com.jh.rental.user.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 骏辉出行 on 2017/5/19.
 */
@Entity
public class DataTwo {
    @Id
    long  id;
    @Unique
    String  name;
   @NotNull
    String  age;
@Generated(hash = 252360514)
public DataTwo(long id, String name, @NotNull String age) {
    this.id = id;
    this.name = name;
    this.age = age;
}
@Generated(hash = 1131115834)
public DataTwo() {
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
public String getAge() {
    return this.age;
}
public void setAge(String age) {
    this.age = age;
}
}
