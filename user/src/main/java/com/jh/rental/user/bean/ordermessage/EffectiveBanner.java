package com.jh.rental.user.bean.ordermessage;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 骏辉出行 on 2017/6/7.
 */

public class EffectiveBanner {

    /**
     * id : 1
     * createBy : null
     * createDate : 2017-05-27 02:53:41
     * updateBy : null
     * updateDate : null
     * version : null
     * isDeleted : 0
     * img : http://pic.qiantucdn.com/58pic/12/95/68/62V58PICMT4.jpg
     * url : http://www.baidu.com
     * code : 2
     * type : 2
     * startdate : 1494995496000
     * enddate : 1503808304000
     * orderTag : 1
     * new : false
     */

    private String id;
    private Object createBy;
    private String createDate;
    private Object updateBy;
    private Object updateDate;
    private Object version;
    private String isDeleted;
    private String img;
    private String url;
    private String code;
    private int type;
    private long startdate;
    private long enddate;
    private int orderTag;
    @SerializedName("new")
    private boolean newX;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Object createBy) {
        this.createBy = createBy;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Object getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Object updateBy) {
        this.updateBy = updateBy;
    }

    public Object getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Object updateDate) {
        this.updateDate = updateDate;
    }

    public Object getVersion() {
        return version;
    }

    public void setVersion(Object version) {
        this.version = version;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getStartdate() {
        return startdate;
    }

    public void setStartdate(long startdate) {
        this.startdate = startdate;
    }

    public long getEnddate() {
        return enddate;
    }

    public void setEnddate(long enddate) {
        this.enddate = enddate;
    }

    public int getOrderTag() {
        return orderTag;
    }

    public void setOrderTag(int orderTag) {
        this.orderTag = orderTag;
    }

    public boolean isNewX() {
        return newX;
    }

    public void setNewX(boolean newX) {
        this.newX = newX;
    }

}
