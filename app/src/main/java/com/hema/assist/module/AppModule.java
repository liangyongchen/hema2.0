package com.hema.assist.module;

import com.hema.assist.app.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/7:上午11:14
 * Email: 656266591@qq.com
 * Desc:
 */
@Module
public class AppModule {
    @Singleton
    @Provides
    App app(){
        return App.sInstance;
    }
}
