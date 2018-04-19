package com.hema.assist.feature.apply.model;

import com.hema.assist.common.action.Action2;
import com.hema.assist.common.base.BaseResult;
import com.hema.assist.entity.LoginInfo;
import com.hema.assist.feature.apply.contract.StageApplyContract;
import com.hema.assist.feature.apply.service.StageApplyService;
import com.hema.assist.feature.home.contract.HomeContract;

import javax.inject.Inject;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/6:下午4:06
 * Email: 656266591@qq.com
 * Desc:
 */
public class StageApplyModelImpl implements StageApplyContract.Model {

    private StageApplyService saService;

    @Inject
    public StageApplyModelImpl(StageApplyService service) {
        this.saService = service;
    }


}
