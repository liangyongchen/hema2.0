package com.hema.assist.feature.home.view;

import com.chad.library.adapter.base.BaseViewHolder;
import com.wtw.p2p.R;
import com.hema.assist.common.base.BaseListFragment;
import com.hema.assist.entity.LoginInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/1/27:下午5:52
 * Email: 656266591@qq.com
 * Desc:
 */

public class HomeFragment extends BaseListFragment<LoginInfo> {



    @Override
    protected int getAdapterItemResId() {
        return R.layout.content_item;
    }

    @Override
    protected void onCreateFinished() {
        super.onCreateFinished();

        List<LoginInfo> list = new ArrayList<>();
//        list.add(new LoginInfo());
//        list.add(new LoginInfo());
//        list.add(new LoginInfo());
//        list.add(new LoginInfo());
//        list.add(new LoginInfo());
//        list.add(new LoginInfo());
//        list.add(new LoginInfo());

        setSingleRecyclerData(list);
        refreshLayout.setEnableRefresh(true);
        refreshLayout.setEnableLoadmore(false);

    }

    @Override
    protected void convert(BaseViewHolder helper, LoginInfo item) {

        helper.getLayoutPosition();

    }

    @Override
    protected void refresData() {

        List<LoginInfo> list = new ArrayList<>();
        list.add(new LoginInfo());
        list.add(new LoginInfo());
        list.add(new LoginInfo());
        list.add(new LoginInfo());
        list.add(new LoginInfo());
        list.add(new LoginInfo());
        list.add(new LoginInfo());

        setSingleRecyclerData(list);

    }

    @Override
    protected void loadMoreData() {
        List<LoginInfo> list = new ArrayList<>();
        list.add(new LoginInfo());
        list.add(new LoginInfo());
        list.add(new LoginInfo());
        list.add(new LoginInfo());
        list.add(new LoginInfo());
        list.add(new LoginInfo());
        list.add(new LoginInfo());
        list.add(new LoginInfo());
        list.add(new LoginInfo());
        list.add(new LoginInfo());
        list.add(new LoginInfo());
        list.add(new LoginInfo());
        list.add(new LoginInfo());
        list.add(new LoginInfo());
        list.add(new LoginInfo());
        list.add(new LoginInfo());
        list.add(new LoginInfo());
        list.add(new LoginInfo());
        list.add(new LoginInfo());
        list.add(new LoginInfo());
        list.add(new LoginInfo());

        setSingleRecyclerData(list);
    }


}
