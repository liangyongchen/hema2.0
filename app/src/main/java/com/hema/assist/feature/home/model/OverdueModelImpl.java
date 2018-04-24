package com.hema.assist.feature.home.model;

import com.hema.assist.feature.home.contract.OverdueContract;
import com.hema.assist.feature.home.service.HomeService;

import javax.inject.Inject;

/**
 * Created by 河马安卓 on 2018/4/24.
 */

public class OverdueModelImpl implements OverdueContract.Model {


    private HomeService saService;

    @Inject
    public OverdueModelImpl(HomeService service) {
        this.saService = service;
    }


}
