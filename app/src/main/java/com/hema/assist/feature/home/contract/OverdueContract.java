package com.hema.assist.feature.home.contract;


import android.app.Activity;

import com.hema.assist.common.base.BasePresenter;
import com.hema.assist.entity.OverdueInfo;

import java.util.List;


/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/6:下午4:06
 * Email: 656266591@qq.com
 * Desc:
 */
public interface OverdueContract {

    interface Model {

    }

    interface View {

        void setRecyclerViewData(List<OverdueInfo> data);

    }

    interface Presenter extends BasePresenter<View> {


        // 获取预期管理数据
        void getRecyclerViewData(Activity ac);

    }


}

