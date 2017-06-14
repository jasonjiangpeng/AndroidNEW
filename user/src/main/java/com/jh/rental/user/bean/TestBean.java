package com.jh.rental.user.bean;

/**
 * Created by 骏辉出行 on 2017/5/22.
 */

public class TestBean {
private  static TestBean testBean;
    private String jason;
    private  int age;
    private String  kas;

    public TestBean(String jason, int age, String kas) {
        this.jason = jason;
        this.age = age;
        this.kas = kas;
    }
    private TestBean() {
    }
    public String getJason() {
        return jason;
    }
    public void setJason(String jason) {
        this.jason = jason;
    }
    public  static TestBean getTestBean() {
        if (testBean==null){
            testBean=new TestBean();
        }
        return testBean;
    }
    public static void   init(){
        if (testBean!=null){
            testBean=new TestBean();
        }
    }
    public void setTestBean(TestBean testBean) {
        this.testBean = testBean;
    }
    public static Boolean isNull(){
        if (testBean==null){
            return true;
        }
        return false;
    }

}
