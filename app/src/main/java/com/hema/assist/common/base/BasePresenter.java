package com.hema.assist.common.base;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/6:下午4:42
 * Email: 656266591@qq.com
 * Desc:
 */
public interface BasePresenter<T> {
    /**
     *  绑定Ui
     */
    void attachUi(T t);

    /**
     * 开始工作
     */
    void startWork();

    /**
     * 停止工作
     */
    void stopWork();
}
