package com.hema.assist.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 逾期管理info
 * Created by 河马安卓 on 2018/4/24.
 */

public class OverdueInfo implements Serializable {


    // 逾期客户姓名
    @SerializedName("name")
    public String name;

    // 逾期客户手机号码
    @SerializedName("phone")
    public String phone;

    // 逾期天数
    @SerializedName("day")
    public int day;

    // 逾期金额
    @SerializedName("money")
    public BigDecimal money;

    // 	逾期客户id
    @SerializedName("userId")
    public int userId;

}
