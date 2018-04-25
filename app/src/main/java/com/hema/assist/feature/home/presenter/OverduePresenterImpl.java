package com.hema.assist.feature.home.presenter;


import android.app.Activity;

import com.hema.assist.common.base.BasePresenterImpl;
import com.hema.assist.entity.OverdueInfo;
import com.hema.assist.feature.home.contract.OverdueContract;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/6:下午4:06
 * Email: 656266591@qq.com
 * Desc:
 */
public class OverduePresenterImpl extends BasePresenterImpl<OverdueContract.View> implements OverdueContract.Presenter {

    private OverdueContract.Model homeModel;

    @Inject
    public OverduePresenterImpl(OverdueContract.Model homeModel) {
        this.homeModel = homeModel;
    }


    @Override
    public void getRecyclerViewData(Activity ac) {

        List<OverdueInfo> list = new ArrayList<>();

        list.add(new OverdueInfo());
        list.add(new OverdueInfo());
        list.add(new OverdueInfo());
        list.add(new OverdueInfo());
        list.add(new OverdueInfo());
        list.add(new OverdueInfo());
        list.add(new OverdueInfo());
        list.add(new OverdueInfo());
        list.add(new OverdueInfo());
        list.add(new OverdueInfo());

        mUi.setRecyclerViewData(list);

    }

}
