package com.hema.assist.module;

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
    @Provides
    @ActivityScope
    LoginContract.Presenter presenter(LoginPresenterImpl impl) {
        return impl;
    }

    @Provides
    @ActivityScope
    HomeContract.Presenter presenterHome(HomePresenterImpl impl) {
        return impl;
    }

    @Provides
    @ActivityScope
    StageApplyContract.Presenter presenterStageApply(StageApplyPresenterImpl impl) {
        return impl;
    }

    @Provides
    @ActivityScope
    ChangePasswordContract.Presenter presenterChangePwd(ChangePasswordPresenterImpl impl) {
        return impl;
    }


}
