package com.hema.assist.feature.login.view;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hema.assist.common.base.BaseActivity;
import com.hema.assist.common.base.BaseResult;
import com.hema.assist.common.utils.CommonUtil;
import com.hema.assist.common.utils.IntentUtil;
import com.hema.assist.common.utils.SPHelper;
import com.hema.assist.entity.LoginInfo;
import com.hema.assist.feature.home.view.HomeActivity;
import com.wtw.p2p.R;
import com.hema.assist.component.ComponentFactory;
import com.hema.assist.feature.login.contract.LoginContract;


import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/6:下午4:20
 * Email: 656266591@qq.com
 * Desc:
 */
public class LoginActivity extends BaseActivity {


    @Inject
    LoginContract.Presenter loginPresenter;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreateFinished() {
        ComponentFactory.getActivityComponent().inject(this);
        loginPresenter.attachUi(new ViewHolder(getWindow().getDecorView()));
        loginPresenter.getImageCode(); // 不能再 初始化 ViewHolder 中 获取，生命周期是初始化完成才能获取接口LoginContract.View
        toast("初始化完成了");
    }


    class ViewHolder implements LoginContract.View {
        @BindView(R.id.et_login_name)
        EditText etLoginName;
        @BindView(R.id.et_pwd)
        EditText etPwd;
        @BindView(R.id.btn_login)
        Button btnLogin;
        @BindView(R.id.et_code)
        EditText etCode;
        @BindView(R.id.iv_code)
        ImageView ivCode;
        @BindView(R.id.cb_sign_pwd)
        CheckBox cbSignPwd;
        @BindView(R.id.tv_back_pwd)
        TextView tvBackPwd;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);

            tvBackPwd.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG); // 文本设置下划线
            etLoginName.setText(SPHelper.getStringData("loginName", ""));
            cbSignPwd.setChecked(SPHelper.getBooleanData("loginCheckBox", false));


            cbSignPwd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked)
                        loginPresenter.saveLoginName(etLoginName.getText().toString(), isChecked);
                    else
                        loginPresenter.saveLoginName("", isChecked);
                }
            });

            // region // 指定键盘隐藏

            etLoginName.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if (keyCode == event.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
                        loginPresenter.editTextEdit(LoginActivity.this, etLoginName);
                    }
                    return false;
                }
            });

            etPwd.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if (keyCode == event.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
                        loginPresenter.editTextEdit(LoginActivity.this, etPwd);
                    }
                    return false;
                }
            });

            etCode.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if (keyCode == event.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
                        loginPresenter.editTextEdit(LoginActivity.this, etCode);
                    }
                    return false;
                }
            });

            // endregion

            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    loginPresenter.login(etLoginName.getText().toString(), etPwd.getText().toString(), etCode.getText().toString());
                }
            });

            ivCode.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    loginPresenter.getImageCode();
                }
            });

        }

        @Override
        public void loginSuccess(String msg, BaseResult<LoginInfo> data) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("login", data);
            IntentUtil.startActivity(LoginActivity.this, HomeActivity.class, bundle, CommonUtil.enumActionType.ACTION_FORWARD);
        }

        @Override
        public void loginFailed(String error) {
            toast(error);
            etCode.setText("");
        }

        @Override
        public void showImgCode(String imageUrl) {
            Glide.with(getBaseContext()).load(imageUrl).into(ivCode);
        }
    }
}
