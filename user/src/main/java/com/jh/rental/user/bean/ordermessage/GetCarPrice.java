package com.jh.rental.user.bean.ordermessage;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 骏辉出行 on 2017/6/9.
 */

public class GetCarPrice {

    /**
     * id :
     * id1 :
     * createBy :
     * createDate :
     * updateBy :
     * updateDate :
     * version :
     * isDeleted : 0
     * subCpid : 0
     * nationId :
     * cityId :
     * startId : 20170630111435000004
     * endId : 20170701180722000008
     * modelId : 20170627135307001
     * price : 0.01
     * floorPrice :
     * type : 1
     * useType :
     * minhour :
     * maxhour :
     * carDirection :
     * carModel : {"id":"20170627135307001","id1":"20170627135307001","createBy":"","createDate":"","updateBy":"","updateDate":"","version":"","isDeleted":"0","model":"埃尔法10系","brand":"丰田","brandId":"","guide":"","luggleNum":2,"seatNum":7,"remark":"暂无","carPicture":"http://osjqtdyqk.bkt.clouddn.com/cdnarf10.png","new":false}
     * modelDetailList : [{"id":"20170627135307001","id1":"20170627135307001","createBy":"admin","createDate":"2017-07-07 17:20:22","updateBy":"admin","updateDate":"2017-06-27 19:09:26","version":1,"isDeleted":"0","brandId":"2017062713530001","modelId":"20170627135307001","model":"10系","brand":"丰田","luggleNum":2,"seatNum":7,"remark":"暂无","carPicture":"http://osjqtdyqk.bkt.clouddn.com/cdnarf10.png","new":false}]
     * new : true
     */

    private String id;
    private String id1;
    private String createBy;
    private String modelNames;
    private String createDate;

    public String getModelNames() {
        return modelNames;
    }

    public void setModelNames(String modelNames) {
        this.modelNames = modelNames;
    }

    private String updateBy;
    private String updateDate;
    private String version;
    private String isDeleted;
    private String subCpid;
    private String nationId;
    private String cityId;
    private String startId;
    private String endId;
    private String modelId;
    private double price;
    private String floorPrice;
    private String type;
    private String useType;
    private String minhour;
    private String maxhour;
    private String carDirection;
    private CarModelBean carModel;
    @SerializedName("new")
    private boolean newX;
    private List<ModelDetailListBean> modelDetailList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId1() {
        return id1;
    }

    public void setId1(String id1) {
        this.id1 = id1;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getSubCpid() {
        return subCpid;
    }

    public void setSubCpid(String subCpid) {
        this.subCpid = subCpid;
    }

    public String getNationId() {
        return nationId;
    }

    public void setNationId(String nationId) {
        this.nationId = nationId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getStartId() {
        return startId;
    }

    public void setStartId(String startId) {
        this.startId = startId;
    }

    public String getEndId() {
        return endId;
    }

    public void setEndId(String endId) {
        this.endId = endId;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getFloorPrice() {
        return floorPrice;
    }

    public void setFloorPrice(String floorPrice) {
        this.floorPrice = floorPrice;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUseType() {
        return useType;
    }

    public void setUseType(String useType) {
        this.useType = useType;
    }

    public String getMinhour() {
        return minhour;
    }

    public void setMinhour(String minhour) {
        this.minhour = minhour;
    }

    public String getMaxhour() {
        return maxhour;
    }

    public void setMaxhour(String maxhour) {
        this.maxhour = maxhour;
    }

    public String getCarDirection() {
        return carDirection;
    }

    public void setCarDirection(String carDirection) {
        this.carDirection = carDirection;
    }

    public CarModelBean getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModelBean carModel) {
        this.carModel = carModel;
    }

    public boolean isNewX() {
        return newX;
    }

    public void setNewX(boolean newX) {
        this.newX = newX;
    }

    public List<ModelDetailListBean> getModelDetailList() {
        return modelDetailList;
    }

    public void setModelDetailList(List<ModelDetailListBean> modelDetailList) {
        this.modelDetailList = modelDetailList;
    }

    public static class CarModelBean {
        /**
         * id : 20170627135307001
         * id1 : 20170627135307001
         * createBy :
         * createDate :
         * updateBy :
         * updateDate :
         * version :
         * isDeleted : 0
         * model : 埃尔法10系
         * brand : 丰田
         * brandId :
         * guide :
         * luggleNum : 2
         * seatNum : 7
         * remark : 暂无
         * carPicture : http://osjqtdyqk.bkt.clouddn.com/cdnarf10.png
         * new : false
         */

        private String id;
        private String id1;
        private String createBy;
        private String createDate;
        private String updateBy;
        private String updateDate;
        private String version;
        private String isDeleted;
        private String model;
        private String brand;
        private String brandId;
        private String guide;
        private String luggleNum;
        private String seatNum;
        private String remark;
        private String carPicture;
        @SerializedName("new")
        private boolean newX;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getId1() {
            return id1;
        }

        public void setId1(String id1) {
            this.id1 = id1;
        }

        public String getCreateBy() {
            return createBy;
        }

        public void setCreateBy(String createBy) {
            this.createBy = createBy;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public String getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(String updateBy) {
            this.updateBy = updateBy;
        }

        public String getUpdateDate() {
            return updateDate;
        }

        public void setUpdateDate(String updateDate) {
            this.updateDate = updateDate;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getIsDeleted() {
            return isDeleted;
        }

        public void setIsDeleted(String isDeleted) {
            this.isDeleted = isDeleted;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getBrandId() {
            return brandId;
        }

        public void setBrandId(String brandId) {
            this.brandId = brandId;
        }

        public String getGuide() {
            return guide;
        }

        public void setGuide(String guide) {
            this.guide = guide;
        }

        public String getLuggleNum() {
            return luggleNum;
        }

        public void setLuggleNum(String luggleNum) {
            this.luggleNum = luggleNum;
        }

        public String getSeatNum() {
            return seatNum;
        }

        public void setSeatNum(String seatNum) {
            this.seatNum = seatNum;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getCarPicture() {
            return carPicture;
        }

        public void setCarPicture(String carPicture) {
            this.carPicture = carPicture;
        }

        public boolean isNewX() {
            return newX;
        }

        public void setNewX(boolean newX) {
            this.newX = newX;
        }
    }

    public static class ModelDetailListBean {
        /**
         * id : 20170627135307001
         * id1 : 20170627135307001
         * createBy : admin
         * createDate : 2017-07-07 17:20:22
         * updateBy : admin
         * updateDate : 2017-06-27 19:09:26
         * version : 1
         * isDeleted : 0
         * brandId : 2017062713530001
         * modelId : 20170627135307001
         * model : 10系
         * brand : 丰田
         * luggleNum : 2
         * seatNum : 7
         * remark : 暂无
         * carPicture : http://osjqtdyqk.bkt.clouddn.com/cdnarf10.png
         * new : false
         */

        private String id;
        private String id1;
        private String createBy;
        private String createDate;
        private String updateBy;
        private String updateDate;
        private String version;
        private String isDeleted;
        private String brandId;
        private String modelId;
        private String model;
        private String brand;
        private String luggleNum;
        private String seatNum;
        private String remark;
        private String carPicture;
        @SerializedName("new")
        private boolean newX;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getId1() {
            return id1;
        }

        public void setId1(String id1) {
            this.id1 = id1;
        }

        public String getCreateBy() {
            return createBy;
        }

        public void setCreateBy(String createBy) {
            this.createBy = createBy;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public String getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(String updateBy) {
            this.updateBy = updateBy;
        }

        public String getUpdateDate() {
            return updateDate;
        }

        public void setUpdateDate(String updateDate) {
            this.updateDate = updateDate;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getIsDeleted() {
            return isDeleted;
        }

        public void setIsDeleted(String isDeleted) {
            this.isDeleted = isDeleted;
        }

        public String getBrandId() {
            return brandId;
        }

        public void setBrandId(String brandId) {
            this.brandId = brandId;
        }

        public String getModelId() {
            return modelId;
        }

        public void setModelId(String modelId) {
            this.modelId = modelId;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getLuggleNum() {
            return luggleNum;
        }

        public void setLuggleNum(String luggleNum) {
            this.luggleNum = luggleNum;
        }

        public String getSeatNum() {
            return seatNum;
        }

        public void setSeatNum(String seatNum) {
            this.seatNum = seatNum;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getCarPicture() {
            return carPicture;
        }

        public void setCarPicture(String carPicture) {
            this.carPicture = carPicture;
        }

        public boolean isNewX() {
            return newX;
        }

        public void setNewX(boolean newX) {
            this.newX = newX;
        }
    }
}
