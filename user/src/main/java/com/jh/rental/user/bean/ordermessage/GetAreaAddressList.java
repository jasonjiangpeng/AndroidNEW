package com.jh.rental.user.bean.ordermessage;

import java.util.List;

/**
 * Created by 骏辉出行 on 2017/6/8.
 */

public class GetAreaAddressList {

    /**
     * areaName : 热门
     * orderTag : 1
     * addressList : [{"id":"111","name":"香港","imgUrl":null,"orderBy":1,"gdLng":12.132456,"gdLat":12.132456,"baiduLng":12.132456,"baiduLat":12.132456,"gugeLng":12.132456,"gugeLat":12.132456,"isHot":1,"state":1,"level":4,"parentId":null,"createDate":1496732661000,"createBy":"1","updateDate":null,"updateBy":null,"version":0,"isDeleted":"0"},{"id":"112","name":"深圳","imgUrl":null,"orderBy":2,"gdLng":98.7654321,"gdLat":98.7654321,"baiduLng":98.7654321,"baiduLat":98.7654321,"gugeLng":98.7654321,"gugeLat":98.7654321,"isHot":1,"state":1,"level":4,"parentId":null,"createDate":1496732656000,"createBy":"1","updateDate":1495852918000,"updateBy":null,"version":0,"isDeleted":"0"}]
     */

    private String areaName;
    private int orderTag;
    private List<AddressListBean> addressList;

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public int getOrderTag() {
        return orderTag;
    }

    public void setOrderTag(int orderTag) {
        this.orderTag = orderTag;
    }

    public List<AddressListBean> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<AddressListBean> addressList) {
        this.addressList = addressList;
    }

    public static class AddressListBean {
        /**
         * id : 111
         * name : 香港
         * imgUrl : null
         * orderBy : 1
         * gdLng : 12.132456
         * gdLat : 12.132456
         * baiduLng : 12.132456
         * baiduLat : 12.132456
         * gugeLng : 12.132456
         * gugeLat : 12.132456
         * isHot : 1
         * state : 1
         * level : 4
         * parentId : null
         * createDate : 1496732661000
         * createBy : 1
         * updateDate : null
         * updateBy : null
         * version : 0
         * isDeleted : 0
         */

        private String id;
        private String name;
        private Object imgUrl;
        private int orderBy;
        private double gdLng;
        private double gdLat;
        private double baiduLng;
        private double baiduLat;
        private double gugeLng;
        private double gugeLat;
        private int isHot;
        private int state;
        private int level;
        private Object parentId;
        private long createDate;
        private String createBy;
        private Object updateDate;
        private Object updateBy;
        private int version;
        private String isDeleted;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(Object imgUrl) {
            this.imgUrl = imgUrl;
        }

        public int getOrderBy() {
            return orderBy;
        }

        public void setOrderBy(int orderBy) {
            this.orderBy = orderBy;
        }

        public double getGdLng() {
            return gdLng;
        }

        public void setGdLng(double gdLng) {
            this.gdLng = gdLng;
        }

        public double getGdLat() {
            return gdLat;
        }

        public void setGdLat(double gdLat) {
            this.gdLat = gdLat;
        }

        public double getBaiduLng() {
            return baiduLng;
        }

        public void setBaiduLng(double baiduLng) {
            this.baiduLng = baiduLng;
        }

        public double getBaiduLat() {
            return baiduLat;
        }

        public void setBaiduLat(double baiduLat) {
            this.baiduLat = baiduLat;
        }

        public double getGugeLng() {
            return gugeLng;
        }

        public void setGugeLng(double gugeLng) {
            this.gugeLng = gugeLng;
        }

        public double getGugeLat() {
            return gugeLat;
        }

        public void setGugeLat(double gugeLat) {
            this.gugeLat = gugeLat;
        }

        public int getIsHot() {
            return isHot;
        }

        public void setIsHot(int isHot) {
            this.isHot = isHot;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public Object getParentId() {
            return parentId;
        }

        public void setParentId(Object parentId) {
            this.parentId = parentId;
        }

        public long getCreateDate() {
            return createDate;
        }

        public void setCreateDate(long createDate) {
            this.createDate = createDate;
        }

        public String getCreateBy() {
            return createBy;
        }

        public void setCreateBy(String createBy) {
            this.createBy = createBy;
        }

        public Object getUpdateDate() {
            return updateDate;
        }

        public void setUpdateDate(Object updateDate) {
            this.updateDate = updateDate;
        }

        public Object getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(Object updateBy) {
            this.updateBy = updateBy;
        }

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public String getIsDeleted() {
            return isDeleted;
        }

        public void setIsDeleted(String isDeleted) {
            this.isDeleted = isDeleted;
        }
    }
}
