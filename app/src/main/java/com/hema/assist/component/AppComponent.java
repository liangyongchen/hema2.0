package com.hema.assist.component;

import com.hema.assist.app.App;
import com.hema.assist.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/7:上午11:34
 * Email: 656266591@qq.com
 * Desc:
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    App app();

}
