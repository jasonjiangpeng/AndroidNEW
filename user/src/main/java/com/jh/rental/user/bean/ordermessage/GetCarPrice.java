package com.jh.rental.user.bean.ordermessage;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 骏辉出行 on 2017/6/9.
 */

public class GetCarPrice {

    /**
     * id : null
     * createBy : null
     * createDate : null
     * updateBy : null
     * updateDate : null
     * version : null
     * isDeleted : 0
     * subCpid : 1
     * startid : 1
     * endid : 2
     * modelid : 1
     * price : 900
     * type : 1
     * minhour : 1
     * maxhour : 19
     * carModel : {"id":null,"createBy":null,"createDate":null,"updateBy":null,"updateDate":null,"version":null,"isDeleted":"0","model":"x6","brand":"宝马","luggleNum":null,"seatNum":6,"remark":"舒适7座","carPicture":"http://pic33.nipic.com/20131011/11350592_170605502000_2.jpg","new":true}
     * new : true
     */

    private Object id;
    private Object createBy;
    private Object createDate;
    private Object updateBy;
    private Object updateDate;
    private Object version;
    private String isDeleted;
    private String subCpid;
    private String startid;
    private String endid;
    private String modelid;
    private int price;
    private int type;
    private int minhour;
    private int maxhour;
    private CarModelBean carModel;
    @SerializedName("new")
    private boolean newX;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Object getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Object createBy) {
        this.createBy = createBy;
    }

    public Object getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Object createDate) {
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

    public String getSubCpid() {
        return subCpid;
    }

    public void setSubCpid(String subCpid) {
        this.subCpid = subCpid;
    }

    public String getStartid() {
        return startid;
    }

    public void setStartid(String startid) {
        this.startid = startid;
    }

    public String getEndid() {
        return endid;
    }

    public void setEndid(String endid) {
        this.endid = endid;
    }

    public String getModelid() {
        return modelid;
    }

    public void setModelid(String modelid) {
        this.modelid = modelid;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getMinhour() {
        return minhour;
    }

    public void setMinhour(int minhour) {
        this.minhour = minhour;
    }

    public int getMaxhour() {
        return maxhour;
    }

    public void setMaxhour(int maxhour) {
        this.maxhour = maxhour;
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

    public static class CarModelBean {
        /**
         * id : null
         * createBy : null
         * createDate : null
         * updateBy : null
         * updateDate : null
         * version : null
         * isDeleted : 0
         * model : x6
         * brand : 宝马
         * luggleNum : null
         * seatNum : 6
         * remark : 舒适7座
         * carPicture : http://pic33.nipic.com/20131011/11350592_170605502000_2.jpg
         * new : true
         */

        private Object id;
        private Object createBy;
        private Object createDate;
        private Object updateBy;
        private Object updateDate;
        private Object version;
        private String isDeleted;
        private String model;
        private String brand;
        private Object luggleNum;
        private int seatNum;
        private String remark;
        private String carPicture;
        @SerializedName("new")
        private boolean newX;

        public Object getId() {
            return id;
        }

        public void setId(Object id) {
            this.id = id;
        }

        public Object getCreateBy() {
            return createBy;
        }

        public void setCreateBy(Object createBy) {
            this.createBy = createBy;
        }

        public Object getCreateDate() {
            return createDate;
        }

        public void setCreateDate(Object createDate) {
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

        public Object getLuggleNum() {
            return luggleNum;
        }

        public void setLuggleNum(Object luggleNum) {
            this.luggleNum = luggleNum;
        }

        public int getSeatNum() {
            return seatNum;
        }

        public void setSeatNum(int seatNum) {
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
