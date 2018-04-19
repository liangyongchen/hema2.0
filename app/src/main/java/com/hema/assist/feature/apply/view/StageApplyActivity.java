package com.hema.assist.feature.apply.view;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.hema.assist.common.base.BaseActivity;
import com.hema.assist.common.views.BannerLayout;
import com.hema.assist.component.ComponentFactory;
import com.hema.assist.feature.apply.contract.StageApplyContract;
import com.hema.assist.feature.home.view.HomeActivity;
import com.wtw.p2p.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StageApplyActivity extends BaseActivity {

    @Inject
    StageApplyContract.Presenter saPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage_apply);
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_stage_apply;
    }

    @Override
    protected void onCreateFinished() {
        ComponentFactory.getActivityComponent().inject(this);
        ViewHolder holder = new ViewHolder(getWindow().getDecorView());
        saPresenter.attachUi(holder);
    }


    class ViewHolder implements StageApplyContract.View {
        @BindView(R.id.toolbar_back)
        ImageView toolbarBack;
        @BindView(R.id.toolbar_title)
        TextView toolbarTitle;
        @BindView(R.id.toolbar_news)
        ImageView toolbarNews;
        @BindView(R.id.toolbar)
        Toolbar toolbar;
        @BindView(R.id.banner)
        BannerLayout banner;
        @BindView(R.id.iv_Speed)
        ImageView ivSpeed;
        @BindView(R.id.authentication)
        BannerLayout authentication;
        @BindView(R.id.btn_commit)
        Button btnCommit;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);

            initToobar();

        }

        private void initToobar() {

            toolbarTitle.setText("分期申请");
            toolbarBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    StageApplyActivity.this.finish();
                }
            });

            toolbarNews.setVisibility(View.VISIBLE);
            toolbarNews.setImageDrawable(getResources().getDrawable(R.drawable.list_search_s2));

        }


    }
}
