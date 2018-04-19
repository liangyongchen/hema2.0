package com.hema.assist.feature.home.model;

import com.hema.assist.common.action.Action2;
import com.hema.assist.common.base.BaseResult;
import com.hema.assist.entity.LoginInfo;
import com.hema.assist.feature.home.contract.HomeContract;

import javax.inject.Inject;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/6:下午4:06
 * Email: 656266591@qq.com
 * Desc:
 */
public class HomeModelImpl implements HomeContract.Model {


    @Inject
    public HomeModelImpl() {

    }


    @Override
    public void setData(BaseResult<LoginInfo> data, Action2<Boolean, LoginInfo> action2) {

        if (data.isSucess()) {
            action2.call(true, data.getData());
        } else {
            action2.call(false, null);
        }

    }

}
