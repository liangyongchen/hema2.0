package com.hema.assist.component;

import com.hema.assist.feature.apply.view.bank.BankActivity;
import com.hema.assist.feature.apply.view.phone.PhoneActivity;
import com.hema.assist.feature.apply.view.user.ContactActivity;
import com.hema.assist.feature.apply.view.user.FamilyActivity;
import com.hema.assist.feature.apply.view.user.JobActivity;
import com.hema.assist.feature.home.view.ChangePasswordActivity;
import com.hema.assist.feature.apply.view.StageApplyActivity;
import com.hema.assist.feature.home.view.HomeActivity;
import com.hema.assist.feature.home.view.OverdueActivity;
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

    // 登陆界面
    void inject(LoginActivity activity);

    // 主界面
    void inject(HomeActivity activity);

    // 申请状态
    void inject(StageApplyActivity activity);

    // 修改密码
    void inject(ChangePasswordActivity activity);

    // 工作信息
    void inject(JobActivity activity);

    // 家庭信息
    void inject(FamilyActivity activity);

    // 联系信息
    void inject(ContactActivity activity);

    // 银行卡认证
    void inject(BankActivity activity);

    // 手机认证
    void inject(PhoneActivity activity);

    // 逾期管理
    void inject(OverdueActivity activity);

}
