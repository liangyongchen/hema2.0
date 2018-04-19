package com.hema.assist.feature.login.presenter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

import com.hema.assist.common.action.Action2;
import com.hema.assist.common.action.Action3;
import com.hema.assist.common.base.BaseActivity;
import com.hema.assist.common.base.BasePresenterImpl;
import com.hema.assist.common.base.BaseResult;
import com.hema.assist.common.utils.EditTextUilt;
import com.hema.assist.common.utils.SPHelper;
import com.hema.assist.entity.LoginInfo;
import com.hema.assist.feature.login.contract.LoginContract;

import java.io.Serializable;

import javax.inject.Inject;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/6:下午4:09
 * Email: 656266591@qq.com
 * Desc:
 */
public class LoginPresenterImpl extends BasePresenterImpl<LoginContract.View> implements LoginContract.Presenter {

    private LoginContract.Model loginModel;

    @Inject
    public LoginPresenterImpl(LoginContract.Model loginModel) {
        this.loginModel = loginModel;
    }

    @Override
    public void getImageCode() {

        loginModel.getImgCode(new Action2<Boolean, String>() {
            @Override
            public void call(Boolean aBoolean, String url) {

                if (aBoolean) {
                    mUi.showImgCode(url);
                } else {
                    mUi.loginFailed("获取图形验证码失败");
                }

            }
        });

    }

    @Override
    public void editTextEdit(Activity ac, EditText ev) {
        EditTextUilt.requestFocusTokenHide(ac, ev);
    }

    @Override
    public void saveLoginName(String loginName, boolean isChecked) {
        SPHelper.saveStringData("loginName", loginName);
        SPHelper.saveBooleanData("loginCheckBox", isChecked);
    }

    @Override
    public void login(String name, String password, String code) {
        loginModel.login(name, password, code, new Action3<Boolean, String, BaseResult<LoginInfo>>() {
            @Override
            public void call(Boolean aBoolean, String s, BaseResult<LoginInfo> loginInfoBaseResult) {
                if (aBoolean) {
                    mUi.loginSuccess(s, loginInfoBaseResult);
                } else {
                    getImageCode();
                    mUi.loginFailed(s);
                }
            }
        });
    }
}
