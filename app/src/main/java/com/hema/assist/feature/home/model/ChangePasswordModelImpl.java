package com.hema.assist.feature.home.model;

import android.util.Base64;

import com.hema.assist.common.action.Action3;
import com.hema.assist.common.base.BaseResult;
import com.hema.assist.entity.ChangePwdInfo;
import com.hema.assist.feature.home.contract.ChangePasswordContract;
import com.hema.assist.feature.home.service.HomeService;

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
public class ChangePasswordModelImpl implements ChangePasswordContract.Model {

    private HomeService saService;

    @Inject
    public ChangePasswordModelImpl(HomeService service) {
        this.saService = service;
    }


    @Override
    public void commitPwd(String token, String oldPwd, String newPwd, Action3<Boolean, String, BaseResult<ChangePwdInfo>> callBack) {

        saService.modifyPwd(
                token,
                Base64.encodeToString(newPwd.getBytes(), Base64.DEFAULT),
                Base64.encodeToString(oldPwd.getBytes(), Base64.DEFAULT),
                true)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> {

                    if (result.isSucess()) {
                        callBack.call(true, "修改成功", result);
                    } else {
                        callBack.call(false, result.message, null);
                    }

                }, throwable -> {
                    callBack.call(false, "修改失败", null);
                });

    }
}
