package com.jh.rental.user.bean;

/**
 * Created by 骏辉出行 on 2017/6/9.
 */

public class SimpleObject {
    private Object object;
    private static SimpleObject simpleObject;

    private SimpleObject() {

    }
 public static SimpleObject getNewIntance(){
     if (simpleObject==null){
         synchronized (SimpleObject.class){
             return new SimpleObject();
         }
     }
     return simpleObject;
 }
    public Object getObject() {

        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
