package com.hema.assist.module;

import com.hema.assist.common.network.ServiceFactory;
import com.hema.assist.feature.apply.service.ApplyService;
import com.hema.assist.feature.home.service.HomeService;
import com.hema.assist.feature.login.service.LoginService;
import com.hema.assist.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/7:下午1:41
 * Email: 656266591@qq.com
 * Desc:网络模块
 */
@Module
public class NetworkModule {

    @Provides
    @ActivityScope
    LoginService loginService() {
        return ServiceFactory.getInstance().createService(LoginService.class);
    }

    @Provides
    @ActivityScope
    ApplyService stageApplyService() {
        return ServiceFactory.getInstance().createService(ApplyService.class);
    }

    @Provides
    @ActivityScope
    HomeService changePasswordService() {
        return ServiceFactory.getInstance().createService(HomeService.class);
    }

}
