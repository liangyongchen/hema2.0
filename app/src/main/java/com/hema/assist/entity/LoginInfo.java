package com.hema.assist.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/7:下午4:41
 * Email: 656266591@qq.com
 * Desc:
 */
public class LoginInfo implements Serializable {


    /**
     * token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1bnNhbWUiOjMyOCwiaXNzIjoiaG1kc19hZ2VudCIsImV4cCI6MTUyNDAzMTA1MSwiaWF0IjoxNTIzOTQ0NjUxfQ.AAvVRQZJ1HrMZ8PR2SnKpVqVpfdEwROVpaoCxUsyoRY
     * salePoints : [{"id":441926,"district":"寮步镇","province":"广东省","city":"东莞市","salePointName":"东莞市阿里巴巴有限公司","salePointAddress":"东莞市寮步镇寮城西路2号（寮步大天桥）","salePointNo":"DLSHDG0101"}]
     * shop : null
     * role : SA
     * avatar : null
     * name : 黄玲
     * exp : null
     * errorTimes : null
     * leftTimes : null
     */

    @SerializedName("token")
    private String token;

    @SerializedName("shop")
    private String shop;

    @SerializedName("role")
    private String role;

    @SerializedName("avatar")
    private String avatar;

    @SerializedName("name")
    private String name;

    @SerializedName("exp")
    private int exp;

    @SerializedName("errorTimes")
    private int errorTimes;

    @SerializedName("leftTimes")
    private int leftTimes;

    @SerializedName("salePoints")
    private List<SalePointsBean> salePoints;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getErrorTimes() {
        return errorTimes;
    }

    public void setErrorTimes(int errorTimes) {
        this.errorTimes = errorTimes;
    }

    public int getLeftTimes() {
        return leftTimes;
    }

    public void setLeftTimes(int leftTimes) {
        this.leftTimes = leftTimes;
    }

    public List<SalePointsBean> getSalePoints() {
        return salePoints;
    }

    public void setSalePoints(List<SalePointsBean> salePoints) {
        this.salePoints = salePoints;
    }


    public static class SalePointsBean implements Serializable {
        /**
         * id : 441926
         * district : 寮步镇
         * province : 广东省
         * city : 东莞市
         * salePointName : 东莞市阿里巴巴有限公司
         * salePointAddress : 东莞市寮步镇寮城西路2号（寮步大天桥）
         * salePointNo : DLSHDG0101
         */
        @SerializedName("id")
        private int id;

        @SerializedName("district")
        private String district;

        @SerializedName("province")
        private String province;

        @SerializedName("city")
        private String city;

        @SerializedName("salePointName")
        private String salePointName;

        @SerializedName("salePointAddress")
        private String salePointAddress;

        @SerializedName("salePointNo")
        private String salePointNo;


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getSalePointName() {
            return salePointName;
        }

        public void setSalePointName(String salePointName) {
            this.salePointName = salePointName;
        }

        public String getSalePointAddress() {
            return salePointAddress;
        }

        public void setSalePointAddress(String salePointAddress) {
            this.salePointAddress = salePointAddress;
        }

        public String getSalePointNo() {
            return salePointNo;
        }

        public void setSalePointNo(String salePointNo) {
            this.salePointNo = salePointNo;
        }

        @Override
        public String toString() {
            return getSalePointAddress();
        }
    }
}
