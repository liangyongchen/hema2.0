package com.hema.assist.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import retrofit2.http.Query;

/**
 * Created by 河马安卓 on 2018/4/20.
 */

public class StageApplyInfo implements Serializable {


    /**
     * 返回数据 为 1 是 已完成模块 0 是 非完成模块
     * 如果 返回只有 WCYZ 为 1 就是完成整个 流程
     *
     * WCYZ : 0  // 完成验证
     * SJRZ : 0  // 手机认证
     * GRXX : 0  // 个人信息
     * SFRZ : 1  // 身份认证
     * YHK : 1   // 银行卡
     */

    @SerializedName("WCYZ")
    private int WCYZ;

    @SerializedName("SJRZ")
    private int SJRZ;

    @SerializedName("GRXX")
    private int GRXX;

    @SerializedName("SFRZ")
    private int SFRZ;

    private int YHK;

    public int getWCYZ() {
        return WCYZ;
    }

    public void setWCYZ(int WCYZ) {
        this.WCYZ = WCYZ;
    }

    public int getSJRZ() {
        return SJRZ;
    }

    public void setSJRZ(int SJRZ) {
        this.SJRZ = SJRZ;
    }

    public int getGRXX() {
        return GRXX;
    }

    public void setGRXX(int GRXX) {
        this.GRXX = GRXX;
    }

    public int getSFRZ() {
        return SFRZ;
    }

    public void setSFRZ(int SFRZ) {
        this.SFRZ = SFRZ;
    }

    public int getYHK() {
        return YHK;
    }

    public void setYHK(int YHK) {
        this.YHK = YHK;
    }
}
