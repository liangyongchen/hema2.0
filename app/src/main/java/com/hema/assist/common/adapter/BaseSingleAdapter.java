package com.hema.assist.common.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/8:下午5:43
 * Email: 656266591@qq.com
 * Desc:
 */
public abstract class BaseSingleAdapter<T , K extends BaseViewHolder> extends BaseQuickAdapter<T,K> {

    public BaseSingleAdapter(int layoutResId, @Nullable List<T> data) {
        super(layoutResId, data);
    }

    public BaseSingleAdapter(@Nullable List<T> data) {
        super(data);
    }

    public BaseSingleAdapter(int layoutResId) {
        super(layoutResId);
    }
}
