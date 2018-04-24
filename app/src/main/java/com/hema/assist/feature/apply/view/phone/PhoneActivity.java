package com.hema.assist.feature.apply.view.phone;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.hema.assist.common.base.BaseActivity;
import com.hema.assist.component.ComponentFactory;
import com.hema.assist.feature.apply.contract.PhoneContract;
import com.wtw.p2p.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PhoneActivity extends BaseActivity {

    @Inject
    PhoneContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_phone;
    }

    @Override
    protected void onCreateFinished() {

        ComponentFactory.getActivityComponent().inject(this);
        ViewHolder viewHolder = new ViewHolder(getWindow().getDecorView());
        presenter.attachUi(viewHolder);
    }

    class ViewHolder implements PhoneContract.View {
        @BindView(R.id.toolbar_back)
        ImageView toolbarBack;
        @BindView(R.id.toolbar_title)
        TextView toolbarTitle;
        @BindView(R.id.toolbar_news)
        ImageView toolbarNews;
        @BindView(R.id.toolbar)
        Toolbar toolbar;
        @BindView(R.id.et_phone)
        EditText etPhone;
        @BindView(R.id.et_Pwd)
        EditText etPwd;
        @BindView(R.id.btn_next)
        Button btnNext;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);

            initToolbar();
        }

        private void initToolbar() {

            toolbarTitle.setText("手机认证");

            toolbarBack.setOnClickListener(v -> finish());

            toolbarNews.setVisibility(View.VISIBLE);
            toolbarNews.setImageDrawable(getResources().getDrawable(R.drawable.list_gohome_s3));

        }
    }
}
