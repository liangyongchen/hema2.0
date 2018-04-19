package com.hema.assist.common.base;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/6:下午4:43
 * Email: 656266591@qq.com
 * Desc:
 */
public abstract class BasePresenterImpl<T> implements BasePresenter<T> {
    protected T mUi;

    @Override
    public void attachUi(T ui) {
        mUi = ui;
    }

    @Override
    public void startWork() {

    }

    @Override
    public void stopWork() {

    }
}
