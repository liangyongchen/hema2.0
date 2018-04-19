package com.hema.assist.common.base;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/6:下午5:06
 * Email: 656266591@qq.com
 * Desc:Fragment接口基类
 */
public interface IBaseFragment<T> {
    // 设置逻辑
    void setPresenter(T mIFragmentPresenter);
}
