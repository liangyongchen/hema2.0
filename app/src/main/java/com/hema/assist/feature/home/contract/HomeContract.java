package com.hema.assist.feature.home.contract;

import android.os.Bundle;

import com.hema.assist.common.action.Action1;
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
public interface HomeContract {

    interface Model {

        void setData(BaseResult<LoginInfo> data, Action2<Boolean, LoginInfo> action2);

    }

    interface View {

        void setSpinner(List<LoginInfo.SalePointsBean> data);

        void setData(LoginInfo model);

    }

    interface Presenter extends BasePresenter<View> {

        void setData(BaseResult<LoginInfo> data);
    }


}

