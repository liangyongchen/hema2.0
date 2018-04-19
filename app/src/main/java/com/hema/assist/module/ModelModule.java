package com.hema.assist.module;

import com.hema.assist.feature.apply.contract.StageApplyContract;
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

    @Provides
    @ActivityScope
    LoginContract.Model model(LoginModelImpl impl) {
        return impl;
    }

    @Provides
    @ActivityScope
    HomeContract.Model modelHome(HomeModelImpl impl) {
        return impl;
    }

    @Provides
    @ActivityScope
    StageApplyContract.Model modelStageApply(StageApplyModelImpl impl) {
        return impl;
    }

}
