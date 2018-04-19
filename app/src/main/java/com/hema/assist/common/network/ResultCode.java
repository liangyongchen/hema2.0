package com.hema.assist.common.network;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/8:上午11:32
 * Email: 656266591@qq.com
 * Desc: 服务器返回的状态码
 */
public interface ResultCode {

    //成功
    String RESULT_CODE_SUCCESS_00 = "00";
    //鉴权失败
    String RESULT_CODE_AUTH_FAIL_01 = "01";
    //参数错误
    String RESULT_CODE_PARAMS_ERR_02 = "02";
    //业务性失败
    String RESULT_CODE_BIZ_FAIL_03 = "03";
    //其他未知错误
    String RESULT_CODE_UNKNOW_ERR_04 = "04";
    //频率过快
    String RESULT_CODE_TOO_FAST_05 = "05";

}
