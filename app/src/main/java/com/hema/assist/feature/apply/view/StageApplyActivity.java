package com.hema.assist.feature.apply.view;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.hema.assist.common.network.APIUtils;
import com.hema.assist.feature.apply.adapter.BannerAdapter;
import com.hema.assist.common.base.BaseActivity;
import com.hema.assist.common.utils.CommonUtil;
import com.hema.assist.common.utils.IntentUtil;
import com.hema.assist.common.views.BannerLayout;
import com.hema.assist.component.ComponentFactory;
import com.hema.assist.feature.apply.adapter.CardCertificationAdapter;
import com.hema.assist.feature.apply.contract.StageApplyContract;
import com.hema.assist.feature.apply.view.bank.BankActivity;
import com.hema.assist.feature.apply.view.idcard.IDCardActivity;
import com.hema.assist.feature.apply.view.phone.PhoneActivity;
import com.hema.assist.feature.apply.view.user.UserActivity;
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

            initEvent();

        }

        private void initEvent() {

            btnCommit.setOnClickListener(v -> {
                IntentUtil.startActivity(StageApplyActivity.this, UserActivity.class, CommonUtil.enumActionType.ACTION_FORWARD);
            });

        }

        private void initStageApply() {

        }

        private void initBanner() {

            // 去掉指示器
            authentication.setShowIndicator(false);

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
        public void setIvSpeedSrc(int id) {
            ivSpeed.setImageDrawable(getResources().getDrawable(id));
        }

        @Override
        public void userInfoStepSuccess(String msg, List<CardCertificationAdapter.ItemModel> data) {
            CardCertificationAdapter adapter1 = new CardCertificationAdapter(StageApplyActivity.this, data);

            adapter1.setOnItemClick((view, position, model) -> {

                if (model.isSign) {

                    switch (model.title) {
                        case R.string.SFRZ:
                            IntentUtil.startActivity(StageApplyActivity.this, IDCardActivity.class, CommonUtil.enumActionType.ACTION_FORWARD);
                            break;
                        case R.string.YHK:
                            IntentUtil.startActivity(StageApplyActivity.this, BankActivity.class, CommonUtil.enumActionType.ACTION_FORWARD);
                            break;
                        case R.string.GRXX:
                            IntentUtil.startActivity(StageApplyActivity.this, UserActivity.class, CommonUtil.enumActionType.ACTION_FORWARD);
                            break;
                        case R.string.SJRZ:
                            IntentUtil.startActivity(StageApplyActivity.this, PhoneActivity.class, CommonUtil.enumActionType.ACTION_FORWARD);
                            break;
                    }
                } else {
                    toast(String.format("该项 %s", model.btn));
                }

            });

            authentication.setAdapter(adapter1);
        }

        @Override
        public void userInfoStepFailed(String msg) {

        }


    }
}
