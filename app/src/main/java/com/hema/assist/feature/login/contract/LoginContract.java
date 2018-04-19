package com.hema.assist.feature.login.contract;


import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

import com.hema.assist.common.action.Action2;
import com.hema.assist.common.action.Action3;
import com.hema.assist.common.base.BaseActivity;
import com.hema.assist.common.base.BasePresenter;
import com.hema.assist.common.base.BaseResult;
import com.hema.assist.entity.LoginInfo;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/6:下午4:09
 * Email: 656266591@qq.com
 * Desc:
 */
public interface LoginContract {
    interface Model {

        /**
         * 获取登录图片验证码
         *
         * @param callBack
         */
        void getImgCode(Action2<Boolean, String> callBack);

        /**
         * 登录
         *
         * @param name     用户名
         * @param password 密码
         * @param code     图片验证码
         * @param callBack 回调
         */
        void login(String name, String password, String code, Action3<Boolean, String,BaseResult<LoginInfo>> callBack);
    }

    interface View {

        void showImgCode(String imageUrl);

        void loginSuccess(String msg, BaseResult<LoginInfo> data);

        void loginFailed(String error);

    }

    interface Presenter extends BasePresenter<View> {
        //登录
        void login(String name, String password, String code);

        //获取图片验证码
        void getImageCode();

        // 指定隐藏键盘
        void editTextEdit(Activity ac, EditText ev);

        // 保存记住标识的账号用户名
        void saveLoginName(String loginName, boolean isChecked);
    }
}
