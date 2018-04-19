package com.hema.assist.common.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hema.assist.event.BaseEventBean;
import com.hema.assist.common.loger.AppLogger;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/6:上午10:34
 * Email: 656266591@qq.com
 * Desc:
 */
public abstract class BaseFragment extends Fragment {

    protected Context appContext;
    private String tag;
    protected View rootView;
    protected Unbinder unbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tag = getClass().getSimpleName();
        appContext = getActivity().getApplicationContext();

        if (getContentViewLayoutID() != 0) {
            rootView = LayoutInflater.from(getContext()).inflate(getContentViewLayoutID(), null);
        } else {
            AppLogger.e("You must return a right contentView layout resource Id");
            throw new IllegalArgumentException("You must return a right contentView layout resource Id");
        }

        if (isEventBindHere()) {
            EventBus.getDefault().register(this);
        }

        Bundle bundle = getArguments();
        if (bundle != null) {
            getBundleExtras(bundle);
        }

        unbinder = ButterKnife.bind(this,rootView);
        onCreateFinished();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return rootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        unRegisterEvent();
    }

    /********************** 抽象方法 ***************************/

    /**
     * get bundle data 该方法会优先于 event 执行 ，该方法调用后才会调用 isEventBindHere() 方法
     *
     * @param extras bundle bundle已判断，不为空
     */
    protected void getBundleExtras(Bundle extras) {
    }

    ;

    /**
     * bind layout resource file
     *
     * @return id of layout resource
     */
    protected abstract int getContentViewLayoutID();

    /**
     * onCreate执行完成
     */
    protected abstract void onCreateFinished();

    /********************** eventBus ***************************/

    /**
     * event 是否绑定在这里
     *
     * @return
     */
    protected boolean isEventBindHere() {
        return false;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEvent(BaseEventBean event) {
        onEventMainThread(event);
    }

    /**
     * 当重写 isEventBindHere 且返回值为true 当收到事件的事件该方法回被调用
     *
     * @param event
     */
    protected void onEventMainThread(BaseEventBean event) {
    }

    /**
     * 解除事件绑定
     */
    protected void unRegisterEvent() {
        if (isEventBindHere() && EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }
}
