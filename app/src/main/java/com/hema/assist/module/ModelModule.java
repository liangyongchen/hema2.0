package com.hema.assist.module;

import com.hema.assist.feature.apply.contract.BankContract;
import com.hema.assist.feature.apply.contract.PhoneContract;
import com.hema.assist.feature.apply.contract.UserAuthContract;
import com.hema.assist.feature.apply.model.BankModelImpl;
import com.hema.assist.feature.apply.model.PhoneModelImpl;
import com.hema.assist.feature.apply.model.UserAuthModelImpl;
import com.hema.assist.feature.home.contract.ChangePasswordContract;
import com.hema.assist.feature.apply.contract.StageApplyContract;
import com.hema.assist.feature.home.model.ChangePasswordModelImpl;
import com.hema.assist.feature.apply.model.StageApplyModelImpl;
import com.hema.assist.feature.home.contract.HomeContract;
import com.hema.assist.feature.home.model.HomeModelImpl;
import com.hema.assist.feature.login.contract.LoginContract;
import com.hema.assist.feature.login.model.LoginModelImpl;
import com.hema.assist.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/23:下午3:04
 * Email: 656266591@qq.com
 * Desc:
 */
@Module
public class ModelModule {

    // 登陆界面
    @Provides
    @ActivityScope
    LoginContract.Model model(LoginModelImpl impl) {
        return impl;
    }

    // 主界面
    @Provides
    @ActivityScope
    HomeContract.Model modelHome(HomeModelImpl impl) {
        return impl;
    }

    // 申请认证界面
    @Provides
    @ActivityScope
    StageApplyContract.Model modelStageApply(StageApplyModelImpl impl) {
        return impl;
    }

    // 修改密码
    @Provides
    @ActivityScope
    ChangePasswordContract.Model changeApply(ChangePasswordModelImpl impl) {
        return impl;
    }

    // 个人信息
    @Provides
    @ActivityScope
    UserAuthContract.Model userAuthModel(UserAuthModelImpl impl) {
        return impl;
    }

    // 银行卡认证
    @Provides
    @ActivityScope
    BankContract.Model userAuthModel(BankModelImpl impl) {
        return impl;
    }

    // 手机认证
    @Provides
    @ActivityScope
    PhoneContract.Model userAuthModel(PhoneModelImpl impl) {
        return impl;
    }


}
