package com.hema.assist.feature.apply.presenter;


import com.hema.assist.common.base.BasePresenterImpl;
import com.hema.assist.feature.apply.contract.PhoneContract;

import javax.inject.Inject;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/6:下午4:06
 * Email: 656266591@qq.com
 * Desc:
 */
public class PhonePresenterImpl extends BasePresenterImpl<PhoneContract.View> implements PhoneContract.Presenter {

    private PhoneContract.Model model;

    @Inject
    public PhonePresenterImpl(PhoneContract.Model model) {
        this.model = model;
    }

}
