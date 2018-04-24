package com.hema.assist.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by 河马安卓 on 2018/4/20.
 */

public class StageApplyInfo implements Serializable {
    /**
     * WCYZ : 0   //  完成验证
     * SJRZ : 0   //  手机认证
     * DDTJ : 0   //  商品订单提交
     * banner : {"contentUrl":"  坚儿     ","imageUrl":"https://timgsa.baidu.com/timg?image=&quality=80&size=b9999_10000&sec=1524047779120&di=44e236fe3245cd9d670abd3dfcaf6128&imgtype=0&src=http%3A%2F%2Fpic4.nipic.com%2F20091216%2F1388021_214455008211_2.jpg","title":"  坚儿     "}
     * GRXX : 0   //  个人信息
     * DDDQR : 0  //  订单待确认
     * SFRZ : 1   //  身份认证
     * YHK : 0    //  银行卡
     */

    @SerializedName("WCYZ")
    public int WCYZ;

    @SerializedName("SJRZ")
    public int SJRZ;

    @SerializedName("DDTJ")
    public int DDTJ;

    @SerializedName("GRXX")
    public int GRXX;

    @SerializedName("DDDQR")
    public int DDDQR;

    @SerializedName("SFRZ")
    public int SFRZ;

    @SerializedName("YHK")
    public int YHK;

    @SerializedName("banner")
    public BannerBean banner;

    public static class BannerBean implements Serializable{
        /**
         * contentUrl :   坚儿
         * imageUrl : https://timgsa.baidu.com/timg?image=&quality=80&size=b9999_10000&sec=1524047779120&di=44e236fe3245cd9d670abd3dfcaf6128&imgtype=0&src=http%3A%2F%2Fpic4.nipic.com%2F20091216%2F1388021_214455008211_2.jpg
         * title :   坚儿
         */

        @SerializedName("contentUrl")
        public String contentUrl;

        @SerializedName("imageUrl")
        public String imageUrl;

        @SerializedName("title")
        public String title;

    }





}
