package com.hema.assist.feature.home.presenter;

import android.app.Activity;
import android.widget.EditText;

import com.hema.assist.common.action.Action3;
import com.hema.assist.common.base.BasePresenterImpl;
import com.hema.assist.common.base.BaseResult;
import com.hema.assist.common.utils.EditTextUilt;
import com.hema.assist.entity.ChangePwdInfo;
import com.hema.assist.feature.home.contract.ChangePasswordContract;

import org.apache.commons.lang3.StringUtils;

import javax.inject.Inject;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/6:下午4:06
 * Email: 656266591@qq.com
 * Desc:
 */
public class ChangePasswordPresenterImpl extends BasePresenterImpl<ChangePasswordContract.View> implements ChangePasswordContract.Presenter {

    private ChangePasswordContract.Model changeModel;

    @Inject
    public ChangePasswordPresenterImpl(ChangePasswordContract.Model changeModel) {
        this.changeModel = changeModel;
    }


    @Override
    public void editTextEdit(Activity ac, EditText ev) {
        EditTextUilt.requestFocusTokenHide(ac, ev);
    }

    @Override
    public void commitPwd(String token, String oldPwd, String newPwd, String okPwd) {

        if (StringUtils.isEmpty(token) || StringUtils.isEmpty(oldPwd) || StringUtils.isEmpty(newPwd) || StringUtils.isEmpty(okPwd)) {
            mUi.modifyPwdFailed("");
        }

        if (!isError(token, oldPwd, newPwd, okPwd)) {

            changeModel.commitPwd(token, oldPwd, newPwd, new Action3<Boolean, String, BaseResult<ChangePwdInfo>>() {
                @Override
                public void call(Boolean aBoolean, String s, BaseResult<ChangePwdInfo> changePwdInfoBaseResult) {
                    if (aBoolean) {
                        mUi.modifyPwdSuccess(s);
                    } else {
                        mUi.modifyPwdFailed(s);
                    }
                }
            });

        }

    }


    // 判断数据是否为空
    private boolean isError(String token, String oldPwd, String newPwd, String okPwd) {
        boolean isError = false;

        if (StringUtils.isEmpty(token)) {
            isError = true;
            mUi.modifyPwdFailed("token为空");
            return isError;
        }

        if (StringUtils.isEmpty(oldPwd)) {
            isError = true;
            mUi.modifyPwdFailed("请输入旧密码");
            return isError;
        }

        if (StringUtils.isEmpty(newPwd)) {
            isError = true;
            mUi.modifyPwdFailed("请输入新密码");
            return isError;
        }

        if (StringUtils.isEmpty(okPwd)) {
            isError = true;
            mUi.modifyPwdFailed("请再次输入新密码");
            return isError;
        }

        if (!newPwd.equals(okPwd)) {
            isError = true;
            mUi.modifyPwdFailed("新密码不一致");
            return isError;
        }

        return isError;
    }

}
