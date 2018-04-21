package com.hema.assist.entity;

import java.io.Serializable;

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

    public int WCYZ;

    public int SJRZ;

    public int GRXX;

    public int SFRZ;

    public int YHK;

}
