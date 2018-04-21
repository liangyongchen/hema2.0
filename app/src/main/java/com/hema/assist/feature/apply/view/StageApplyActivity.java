package com.hema.assist.feature.apply.view;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.hema.assist.common.base.BaseResult;
import com.hema.assist.common.network.APIUtils;
import com.hema.assist.entity.StageApplyInfo;
import com.hema.assist.feature.apply.adapter.BannerAdapter;
import com.hema.assist.common.base.BaseActivity;
import com.hema.assist.common.utils.CommonUtil;
import com.hema.assist.common.utils.IntentUtil;
import com.hema.assist.common.views.BannerLayout;
import com.hema.assist.component.ComponentFactory;
import com.hema.assist.feature.apply.adapter.CardCertificationAdapter;
import com.hema.assist.feature.apply.contract.StageApplyContract;
import com.wtw.p2p.R;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StageApplyActivity extends BaseActivity {

    @Inject
    StageApplyContract.Presenter saPresenter;

    private int id;

    @Override
    protected void getBundleExtras(Bundle extras) {
        super.getBundleExtras(extras);
        if (extras != null) {
            id = extras.getInt("id");
        }
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
        saPresenter.getBannerData();
        if (!StringUtils.isEmpty(String.valueOf(id)))
            saPresenter.userInfoStep(id, APIUtils.token);
    }


    class ViewHolder implements StageApplyContract.View {

        // region // 初始化

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

        // endregion

        ViewHolder(View view) {
            ButterKnife.bind(this, view);

            initToobar();

            initBanner();

            initStageApply();

        }

        private void initStageApply() {

        }

        private void initBanner() {


        }

        private void initToobar() {

            toolbarTitle.setText("分期申请");
            toolbarBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    IntentUtil.destroyActivity(StageApplyActivity.this, CommonUtil.enumActionType.ACTION_FORWARD);
                }
            });

            toolbarNews.setVisibility(View.VISIBLE);
            toolbarNews.setImageDrawable(getResources().getDrawable(R.drawable.list_search_s2));

        }


        @Override
        public void setBanner(List<String> data) {
            BannerAdapter adapter = new BannerAdapter(StageApplyActivity.this, data);
            adapter.setOnBannerItemClickListener(new BannerLayout.OnBannerItemClickListener() {
                @Override
                public void onItemClick(int position) {
                    StageApplyActivity.this.toast(String.format(" 点击了 %s 项 ", position));
                }
            });

            banner.setAdapter(adapter);
            // 设置指示器图片
            banner.setIndicatorDrawble(getResources().getDrawable(R.drawable.indicator),
                    getResources().getDrawable(R.drawable.un_indicator));

        }

        @Override
        public void setCard(List<CardCertificationAdapter.ItemModel> data) {

            CardCertificationAdapter adapter1 = new CardCertificationAdapter(StageApplyActivity.this, data);
            adapter1.setOnBannerItemClickListener(new BannerLayout.OnBannerItemClickListener() {
                @Override
                public void onItemClick(int position) {
                    StageApplyActivity.this.toast(String.format(" 点击了 %s 项 ", position));
                }
            });

            adapter1.setOnItemClick(new CardCertificationAdapter.ItemClick() {
                @Override
                public void onItemClick(View v, int position) {
                    // 认证跳转
                    toast(String.format("跳转 %s  ，点击了", position));

                }
            });

            authentication.setAdapter(adapter1);
            authentication.setShowIndicator(false);
        }

        @Override
        public void setIvSpeedSrc(int id) {
            ivSpeed.setImageDrawable(getResources().getDrawable(id));
        }

        @Override
        public void setStageAplly() {

        }

        @Override
        public void userInfoStepSuccess(String msg, BaseResult<StageApplyInfo> callBack) {

        }

        @Override
        public void userInfoStepFailed(String msg) {

        }


    }
}
