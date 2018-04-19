package com.hema.assist.common.action;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/24:上午11:10
 * Email: 656266591@qq.com
 * Desc: A one-argument action.
 */

/**
 * A one-argument action.
 *
 * @param <T> the first argument type
 */
public interface Action1<T> extends Action {
    void call(T t);
}
