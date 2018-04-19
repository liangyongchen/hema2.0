package com.hema.assist.feature.apply.presenter;

import com.hema.assist.common.action.Action2;
import com.hema.assist.common.base.BasePresenterImpl;
import com.hema.assist.common.base.BaseResult;
import com.hema.assist.entity.LoginInfo;
import com.hema.assist.feature.apply.contract.StageApplyContract;
import com.hema.assist.feature.home.contract.HomeContract;

import javax.inject.Inject;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/6:下午4:06
 * Email: 656266591@qq.com
 * Desc:
 */
public class StageApplyPresenterImpl extends BasePresenterImpl<StageApplyContract.View> implements StageApplyContract.Presenter {

    private StageApplyContract.Model homeModel;

    @Inject
    public StageApplyPresenterImpl(StageApplyContract.Model homeModel) {
        this.homeModel = homeModel;
    }


}
