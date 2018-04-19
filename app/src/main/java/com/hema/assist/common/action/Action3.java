package com.hema.assist.common.action;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/24:上午11:13
 * Email: 656266591@qq.com
 * Desc: A three-argument action.
 */

/**
 * A three-argument action.
 * @param <T1> the first argument type
 * @param <T2> the second argument type
 * @param <T3> the third argument type
 */
public interface Action3<T1, T2, T3> extends Action {
    void call(T1 t1, T2 t2, T3 t3);
}
