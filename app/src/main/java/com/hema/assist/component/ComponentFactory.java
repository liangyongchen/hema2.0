package com.hema.assist.component;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/7:上午11:48
 * Email: 656266591@qq.com
 * Desc:
 */
public class ComponentFactory {

    private static AppComponent sAppComponent;
    private static Lock sLock = new ReentrantLock();

    public static AppComponent getAppComponent() {
        if (sAppComponent == null) {
            sLock.lock();
            if (sAppComponent == null) {
                sAppComponent = DaggerAppComponent.builder().build();
            }
            sLock.unlock();
        }
        return sAppComponent;
    }

    public static ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder().appComponent(getAppComponent()).build();
    }

}
