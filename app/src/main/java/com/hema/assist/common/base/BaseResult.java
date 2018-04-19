package com.hema.assist.common.base;

import com.hema.assist.common.network.ResultCode;

import java.io.Serializable;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/8:上午11:06
 * Email: 656266591@qq.com
 * Desc:
 */
public class  BaseResult<T> implements Serializable {
    public String message;
    public String code;
    public boolean sucess;
    public T data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isSucess() {
        return this.code.equals(ResultCode.RESULT_CODE_SUCCESS_00);
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
