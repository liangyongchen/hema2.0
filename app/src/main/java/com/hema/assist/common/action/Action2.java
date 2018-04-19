package com.hema.assist.common.action;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/24:上午11:11
 * Email: 656266591@qq.com
 * Desc: A two-argument action.
 */

/**
 * A two-argument action.
 *
 * @param <T1> the first argument type
 * @param <T2> the second argument type
 */
public interface Action2<T1, T2> extends Action {
    void call(T1 t1, T2 t2);
}
