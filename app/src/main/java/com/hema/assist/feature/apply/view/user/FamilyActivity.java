package com.hema.assist.feature.apply.view.user;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hema.assist.common.adapter.DividerListItemDecoration;
import com.hema.assist.common.base.BaseActivity;
import com.hema.assist.component.ComponentFactory;
import com.hema.assist.feature.apply.adapter.UserAdapter;
import com.hema.assist.feature.apply.contract.UserAuthContract;
import com.wtw.p2p.R;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 家庭信息
 */
public class FamilyActivity extends BaseActivity {

    @Inject
    UserAuthContract.Presenter jobPresenter;


    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_user_data;
    }

    @Override
    protected void onCreateFinished() {
        ComponentFactory.getActivityComponent().inject(this);
        ViewHolder viewHolder = new ViewHolder(getWindow().getDecorView());
        jobPresenter.attachUi(viewHolder);
        jobPresenter.getFamilyData(this);
    }

    class ViewHolder implements UserAuthContract.View {

        // region //  控件

        @BindView(R.id.toolbar_back)
        ImageView toolbarBack;
        @BindView(R.id.toolbar_title)
        TextView toolbarTitle;
        @BindView(R.id.toolbar_news)
        ImageView toolbarNews;
        @BindView(R.id.toolbar)
        Toolbar toolbar;
        @BindView(R.id.tv_msg)
        TextView tvMsg;
        @BindView(R.id.rv_list)
        RecyclerView rvList;

        // endregion

        private UserAdapter adapter;
        private List<UserAdapter.ItemInfo> mData = new ArrayList<>();

        ViewHolder(View view) {
            ButterKnife.bind(this, view);

            initToolbar();

            initRecyclerView();

        }

        private void initRecyclerView() {

            adapter = new UserAdapter(FamilyActivity.this, mData);

            // 监听提交
            adapter.setOnCommitData((v, data) -> {

            });

            rvList.setAdapter(adapter);
            rvList.setLayoutManager(new LinearLayoutManager(FamilyActivity.this));
            rvList.addItemDecoration(new DividerListItemDecoration(FamilyActivity.this, LinearLayoutManager.VERTICAL));

        }


        private void initToolbar() {

            toolbarTitle.setText("工作信息");
            tvMsg.setText("请完善家庭信息");
            toolbarBack.setOnClickListener(v -> finish());

            toolbarNews.setVisibility(View.VISIBLE);
            toolbarNews.setImageDrawable(getResources().getDrawable(R.drawable.list_gohome_s3));

        }


        @Override
        public void setRecyclerViewData(List<UserAdapter.ItemInfo> data) {
            mData = data;
            if (adapter == null) {
                initRecyclerView();
            }
            adapter.setData(mData);
        }


    }


}
