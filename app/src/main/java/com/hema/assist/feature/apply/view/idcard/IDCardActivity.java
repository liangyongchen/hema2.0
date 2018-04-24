package com.hema.assist.feature.apply.view.idcard;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.hema.assist.common.base.BaseActivity;
import com.hema.assist.common.utils.CommonUtil;
import com.hema.assist.common.utils.FragmentUtil;
import com.wtw.p2p.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IDCardActivity extends BaseActivity {


    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_idcard;
    }

    @Override
    protected void onCreateFinished() {
        ViewHolder holder = new ViewHolder(getWindow().getDecorView());
    }


    class ViewHolder {
        @BindView(R.id.toolbar_back)
        ImageView toolbarBack;
        @BindView(R.id.toolbar_title)
        TextView toolbarTitle;
        @BindView(R.id.toolbar_news)
        ImageView toolbarNews;
        @BindView(R.id.toolbar)
        Toolbar toolbar;
        @BindView(R.id.frameLayout)
        FrameLayout frameLayout;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);

            initToolbar();

            initFragment();
        }

        private void initToolbar() {

            toolbarTitle.setText("身份认证");

            toolbarBack.setOnClickListener(v -> finish());

            toolbarNews.setVisibility(View.VISIBLE);
            toolbarNews.setImageDrawable(getResources().getDrawable(R.drawable.list_gohome_s3));

        }

        private void initFragment() {

            FragmentUtil.FragmentStartAdd(IDCardActivity.this, getSupportFragmentManager(), R.id.frameLayout, new IDCardScan(), CommonUtil.enumActionType.ACTION_FORWARD2);

        }

    }
}
