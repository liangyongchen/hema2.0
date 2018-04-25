package com.hema.assist.feature.home.view;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hema.assist.common.base.BaseActivity;
import com.hema.assist.common.base.BaseListActivity;
import com.hema.assist.component.ComponentFactory;
import com.hema.assist.entity.OverdueInfo;
import com.hema.assist.feature.home.adapter.OverdueAdapter;
import com.hema.assist.feature.home.contract.OverdueContract;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;
import com.wtw.p2p.R;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 逾期管理
 */
public class OverdueActivity extends BaseActivity {

    @Inject
    OverdueContract.Presenter presenter;

    @Override
    protected int getContentViewLayoutID() {
//        return R.layout.activity_overdue;
        return R.layout.layout_base_list;
    }

    @Override
    protected void onCreateFinished() {
        ComponentFactory.getActivityComponent().inject(this);
        ViewHolder holder = new ViewHolder(getWindow().getDecorView());
        presenter.attachUi(holder);
        presenter.getRecyclerViewData(this);
    }

    class ViewHolder extends BaseListActivity.ViewHolder implements OverdueContract.View {

        private OverdueAdapter adapter;
        private List<OverdueInfo> mData = new ArrayList<>();


        ViewHolder(View view) {
            super(view);

            ButterKnife.bind(this, view);

            initToolbar();

            initRecyclerView();

            initEvent();

        }

        private void initEvent() {

            refreshLayout.setOnRefreshLoadmoreListener(new OnRefreshLoadmoreListener() {
                @Override
                public void onLoadmore(RefreshLayout refreshlayout) {

                    toast("加载更多");

                    refreshlayout.getLayout().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            refreshlayout.finishLoadmore();
                            // refreshLayout.finishLoadmoreWithNoMoreData(); //设置之后，将不会再触发加载事件
                        }
                    }, 2000);

                }

                @Override
                public void onRefresh(RefreshLayout refreshlayout) {
                    toast("刷新");
                    refreshlayout.getLayout().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            refreshlayout.finishRefresh();
                            refreshlayout.resetNoMoreData();//恢复上拉状态
                        }
                    }, 2000);


                }
            });


        }

        private void initRecyclerView() {

            adapter = new OverdueAdapter(R.layout.overdue_list, mData);

            recyclerView.setLayoutManager(new LinearLayoutManager(OverdueActivity.this));

            recyclerView.setAdapter(adapter);

        }

        private void initToolbar() {
            toolbarTitle.setText("逾期管理");
            toolbarBack.setOnClickListener(v -> {
                finish();
            });
            toolbarNews.setVisibility(View.VISIBLE);
            toolbarNews.setImageDrawable(getResources().getDrawable(R.drawable.list_search_s2));

        }

        @Override
        public void setRecyclerViewData(List<OverdueInfo> data) {

            mData = data;
            if (adapter == null) {
                initRecyclerView();
            }
            adapter.setData(mData);

        }
    }
}
