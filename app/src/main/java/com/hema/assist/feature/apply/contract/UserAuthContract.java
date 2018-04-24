package com.hema.assist.feature.apply.contract;

import android.app.Activity;

import com.hema.assist.common.base.BasePresenter;
import com.hema.assist.feature.apply.adapter.UserAdapter;

import java.util.List;

/**
 * Created by 河马安卓 on 2018/4/24.
 */

public interface UserAuthContract {

    interface Model {

    }

    interface View {

        // 设置RecyclerView的数据
        void setRecyclerViewData(List<UserAdapter.ItemInfo> data);

    }

    interface Presenter extends BasePresenter<UserAuthContract.View> {

        // 获取 工作信息
        void getJobData(Activity ac);

        // 获取 家庭信息
        void getFamilyData(Activity ac);

        // 获取 联系信息
        void getContactData(Activity ac);

    }

}
