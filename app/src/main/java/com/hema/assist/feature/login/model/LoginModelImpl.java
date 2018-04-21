package com.hema.assist.feature.login.model;

import android.util.Base64;

import com.hema.assist.common.action.Action2;
import com.hema.assist.common.action.Action3;
import com.hema.assist.common.base.BaseResult;
import com.hema.assist.common.network.APIUtils;
import com.hema.assist.entity.LoginInfo;
import com.hema.assist.feature.login.contract.LoginContract;
import com.hema.assist.feature.login.service.LoginService;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/6:下午4:09
 * Email: 656266591@qq.com
 * Desc:
 */
public class LoginModelImpl implements LoginContract.Model {

    private LoginService loginService;

    private String temporaryToken;

    @Inject
    public LoginModelImpl(LoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    public void getImgCode(Action2<Boolean, String> callBack) {

        loginService.getTempToken()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).
                subscribe(result -> {
                    if (result.isSucess()) {
                        this.temporaryToken = result.data.tempToken;

                        String url = APIUtils.getImageCodeUrl(temporaryToken, 0);

                        callBack.call(true, url);

                    } else {
                        callBack.call(false, null);
                    }

                }, throwable -> {
                    callBack.call(false, null);
                });

    }


    @Override
    public void login(String name, String password, String code, Action3<Boolean, String, BaseResult<LoginInfo>> callBack) {

        loginService.login(name, Base64.encodeToString(password.getBytes(), Base64.DEFAULT), code, this.temporaryToken, true)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> {

                    if (result.isSucess()) {
                        APIUtils.token = result.getData().getToken();
                        callBack.call(true, "登录成功", result);
                    } else {
                        callBack.call(false, result.message, null);
                    }

                }, throwable -> {
                    callBack.call(false, "登录失败", null);
                });

    }


}
