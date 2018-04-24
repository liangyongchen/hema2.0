package com.hema.assist.feature.home.view;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hema.assist.common.base.BaseActivity;
import com.hema.assist.common.utils.CommonUtil;
import com.hema.assist.common.utils.IntentUtil;
import com.hema.assist.feature.login.view.LoginActivity;
import com.wtw.p2p.R;

import butterknife.BindView;

public class SetActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.toolbar_back)
    ImageView toolbarBack;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar_news)
    ImageView toolbarNews;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.btn_change_pwd)
    LinearLayout btnChangePwd;
    @BindView(R.id.btn_hand_pwd)
    LinearLayout btnHandPwd;
    @BindView(R.id.btn_commit)
    Button btnCommit;


    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_set;
    }

    @Override
    protected void onCreateFinished() {
        toolbarTitle.setText("设置");
        toolbarBack.setOnClickListener(this);
        btnChangePwd.setOnClickListener(this);
        btnHandPwd.setOnClickListener(this);
        btnCommit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.toolbar_back:
                finish();
                break;
            case R.id.btn_change_pwd:
                IntentUtil.startActivity(this, ChangePasswordActivity.class, CommonUtil.enumActionType.ACTION_FORWARD);
                break;
            case R.id.btn_hand_pwd: // 手势密码
                IntentUtil.startActivity(this, HandPwdActivity.class, CommonUtil.enumActionType.ACTION_FORWARD);
                break;
            case R.id.btn_commit:
                IntentUtil.startActivity(this, LoginActivity.class, CommonUtil.enumActionType.ACTION_SIGN_OUT);
                break;

        }

    }


}
