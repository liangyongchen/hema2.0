package com.hema.assist.feature.apply.model;


import com.hema.assist.feature.apply.contract.UserAuthContract;
import com.hema.assist.feature.apply.service.ApplyService;

import javax.inject.Inject;


/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/6:下午4:06
 * Email: 656266591@qq.com
 * Desc:
 */
public class UserAuthModelImpl implements UserAuthContract.Model {

    private ApplyService saService;

    @Inject
    public UserAuthModelImpl(ApplyService service) {
        this.saService = service;
    }


}
