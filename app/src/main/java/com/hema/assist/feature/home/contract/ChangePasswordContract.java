package com.hema.assist.feature.home.contract;

import android.app.Activity;
import android.widget.EditText;

import com.hema.assist.common.action.Action3;
import com.hema.assist.common.base.BasePresenter;
import com.hema.assist.common.base.BaseResult;
import com.hema.assist.entity.ChangePwdInfo;


/**
 * Created by 河马安卓 on 2018/4/20.
 */

public interface ChangePasswordContract {

    interface Model {

        // 提交修改密码
        void commitPwd(String token, String oldPwd, String newPwd, Action3<Boolean, String, BaseResult<ChangePwdInfo>> callBack);

    }

    interface View {

        // 修改密码提交
        void modifyPwdSuccess(String msg);

        void modifyPwdFailed(String error);

    }

    interface Presenter extends BasePresenter<View> {

        // 指定隐藏键盘
        void editTextEdit(Activity ac, EditText ev);

        // 提交修改密码
        void commitPwd(String token, String oldPwd, String newPwd, String okPwd);

    }

}
