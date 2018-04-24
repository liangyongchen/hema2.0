package com.hema.assist.feature.apply.presenter;


import android.app.Activity;

import com.hema.assist.common.base.BasePresenterImpl;
import com.hema.assist.feature.apply.adapter.UserAdapter.ItemInfo;
import com.hema.assist.feature.apply.contract.BankContract;
import com.hema.assist.feature.apply.contract.UserAuthContract;

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
public class BankPresenterImpl extends BasePresenterImpl<BankContract.View> implements BankContract.Presenter {

    private BankContract.Model model;

    @Inject
    public BankPresenterImpl(BankContract.Model model) {
        this.model = model;
    }

}
