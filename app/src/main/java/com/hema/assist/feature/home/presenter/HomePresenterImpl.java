package com.hema.assist.feature.home.presenter;


import com.hema.assist.common.action.Action2;
import com.hema.assist.common.base.BasePresenterImpl;
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
public class HomePresenterImpl extends BasePresenterImpl<HomeContract.View> implements HomeContract.Presenter {

    private HomeContract.Model homeModel;

    @Inject
    public HomePresenterImpl(HomeContract.Model homeModel) {
        this.homeModel = homeModel;
    }


    @Override
    public void setData(BaseResult<LoginInfo> baseData) {
        homeModel.setData(baseData, new Action2<Boolean, LoginInfo>() {
            @Override
            public void call(Boolean aBoolean, LoginInfo loginInfo) {
                if (aBoolean) {
                    if (loginInfo != null) {
                        mUi.setData(loginInfo);
                        mUi.setSpinner(loginInfo.getSalePoints());
                    }
                }
            }
        });
    }

}
