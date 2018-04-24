package com.hema.assist.module;

import com.hema.assist.feature.apply.contract.BankContract;
import com.hema.assist.feature.apply.contract.PhoneContract;
import com.hema.assist.feature.apply.contract.UserAuthContract;
import com.hema.assist.feature.apply.presenter.BankPresenterImpl;
import com.hema.assist.feature.apply.presenter.PhonePresenterImpl;
import com.hema.assist.feature.apply.presenter.UserAuthPresenterImpl;
import com.hema.assist.feature.home.contract.ChangePasswordContract;
import com.hema.assist.feature.apply.contract.StageApplyContract;
import com.hema.assist.feature.home.presenter.ChangePasswordPresenterImpl;
import com.hema.assist.feature.apply.presenter.StageApplyPresenterImpl;
import com.hema.assist.feature.home.contract.HomeContract;
import com.hema.assist.feature.home.presenter.HomePresenterImpl;
import com.hema.assist.feature.login.contract.LoginContract;
import com.hema.assist.scope.ActivityScope;
import com.hema.assist.feature.login.presenter.LoginPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/7:上午11:30
 * Email: 656266591@qq.com
 * Desc:Presenter模块
 */
@Module
public class PresenterModule {

    // 登陆界面
    @Provides
    @ActivityScope
    LoginContract.Presenter presenter(LoginPresenterImpl impl) {
        return impl;
    }

    // 主界面
    @Provides
    @ActivityScope
    HomeContract.Presenter presenterHome(HomePresenterImpl impl) {
        return impl;
    }

    // 申请认证
    @Provides
    @ActivityScope
    StageApplyContract.Presenter presenterStageApply(StageApplyPresenterImpl impl) {
        return impl;
    }

    // 修改密码
    @Provides
    @ActivityScope
    ChangePasswordContract.Presenter presenterChangePwd(ChangePasswordPresenterImpl impl) {
        return impl;
    }

    // 个人信息
    @Provides
    @ActivityScope
    UserAuthContract.Presenter presenterUser(UserAuthPresenterImpl impl) {
        return impl;
    }

    // 银行卡认证
    @Provides
    @ActivityScope
    BankContract.Presenter presenterBank(BankPresenterImpl impl) {
        return impl;
    }

    // 银行卡认证
    @Provides
    @ActivityScope
    PhoneContract.Presenter presenterPhone(PhonePresenterImpl impl) {
        return impl;
    }

}
