package com.hema.assist.feature.apply.contract;

import com.hema.assist.common.action.Action2;
import com.hema.assist.common.base.BasePresenter;
import com.hema.assist.common.base.BaseResult;
import com.hema.assist.entity.LoginInfo;

import java.util.List;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/6:下午4:06
 * Email: 656266591@qq.com
 * Desc:
 */
public interface StageApplyContract {

    interface Model {


    }

    interface View {

        void setBanner(List<String> data);

        void setStageAplly();

    }

    interface Presenter extends BasePresenter<View> {

        void getBanner();

        void getStageAplly();



    }


}

