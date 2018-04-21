package com.hema.assist.component;

import com.hema.assist.feature.home.view.ChangePasswordActivity;
import com.hema.assist.feature.apply.view.StageApplyActivity;
import com.hema.assist.feature.home.view.HomeActivity;
import com.hema.assist.feature.login.view.LoginActivity;
import com.hema.assist.module.ModelModule;
import com.hema.assist.module.NetworkModule;
import com.hema.assist.module.PresenterModule;
import com.hema.assist.scope.ActivityScope;

import dagger.Component;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/7:上午11:30
 * Email: 656266591@qq.com
 * Desc:
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = {ModelModule.class, PresenterModule.class, NetworkModule.class})
public interface ActivityComponent {
    void inject(LoginActivity activity);

    void inject(HomeActivity activity);

    void inject(StageApplyActivity activity);

    void inject(ChangePasswordActivity activity);
}
