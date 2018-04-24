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

    // 登陆界面
    @Provides
    @ActivityScope
    LoginService loginService() {
        return ServiceFactory.getInstance().createService(LoginService.class);
    }

    // 申请认证模块服务
    @Provides
    @ActivityScope
    ApplyService stageApplyService() {
        return ServiceFactory.getInstance().createService(ApplyService.class);
    }

    // 主界面
    @Provides
    @ActivityScope
    HomeService changePasswordService() {
        return ServiceFactory.getInstance().createService(HomeService.class);
    }

}
