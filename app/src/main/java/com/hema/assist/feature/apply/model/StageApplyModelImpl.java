package com.hema.assist.feature.apply.model;

import com.hema.assist.common.action.Action3;
import com.hema.assist.common.base.BaseResult;
import com.hema.assist.entity.StageApplyInfo;
import com.hema.assist.feature.apply.contract.StageApplyContract;
import com.hema.assist.feature.apply.service.ApplyService;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/6:下午4:06
 * Email: 656266591@qq.com
 * Desc:
 */
public class StageApplyModelImpl implements StageApplyContract.Model {

    private ApplyService saService;

    @Inject
    public StageApplyModelImpl(ApplyService service) {
        this.saService = service;
    }


    @Override
    public void userInfoStep(int id, String token, Action3<Boolean, String, BaseResult<StageApplyInfo>> callBack) {

        saService.userInfoStep(id, token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> {
                    if (result.isSucess()) {
                        callBack.call(true, "获取成功", result);
                    } else {
                        callBack.call(false, result.message, null);
                    }
                }, throwable -> {
                    callBack.call(false, "获取失败", null);
                });

    }
}
