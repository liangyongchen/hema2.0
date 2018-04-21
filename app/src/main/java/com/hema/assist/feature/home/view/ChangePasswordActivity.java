package com.hema.assist.feature.home.view;


import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.hema.assist.common.base.BaseActivity;
import com.hema.assist.common.network.APIUtils;
import com.hema.assist.component.ComponentFactory;
import com.hema.assist.feature.home.contract.ChangePasswordContract;
import com.wtw.p2p.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 认证模块
 * 修改密码模块
 */
public class ChangePasswordActivity extends BaseActivity {

    @Inject
    ChangePasswordContract.Presenter changePresenter;


    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_change_password;
    }

    @Override
    protected void onCreateFinished() {
        ComponentFactory.getActivityComponent().inject(this);
        ViewHolder holder = new ViewHolder(getWindow().getDecorView());
        changePresenter.attachUi(holder);
    }


    class ViewHolder implements ChangePasswordContract.View {
        @BindView(R.id.toolbar_back)
        ImageView toolbarBack;
        @BindView(R.id.toolbar_title)
        TextView toolbarTitle;
        @BindView(R.id.toolbar_news)
        ImageView toolbarNews;
        @BindView(R.id.toolbar)
        Toolbar toolbar;
        @BindView(R.id.et_oldPwd)
        EditText etOldPwd;
        @BindView(R.id.et_newPwd)
        EditText etNewPwd;
        @BindView(R.id.et_okPwd)
        EditText etOkPwd;
        @BindView(R.id.btn_commit)
        Button btnCommit;


        ViewHolder(View view) {
            ButterKnife.bind(this, view);

            initToobar();

            initEvent();

        }

        private void initEvent() {

            // region // 制定隐藏键盘

//            etOldPwd.setOnKeyListener(new View.OnKeyListener() {
//                @Override
//                public boolean onKey(View v, int keyCode, KeyEvent event) {
//                    if (keyCode == event.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
//                        changePresenter.editTextEdit(ChangePasswordActivity.this, etOldPwd);
//                    }
//                    return false;
//                }
//            });
//
//            etNewPwd.setOnKeyListener(new View.OnKeyListener() {
//                @Override
//                public boolean onKey(View v, int keyCode, KeyEvent event) {
//                    if (keyCode == event.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
//                        changePresenter.editTextEdit(ChangePasswordActivity.this, etNewPwd);
//                    }
//                    return false;
//                }
//            });

            // endregion

            etOkPwd.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if (keyCode == event.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
                        changePresenter.editTextEdit(ChangePasswordActivity.this, etOkPwd);
                    }
                    return false;
                }
            });

            btnCommit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    changePresenter.commitPwd(
                            APIUtils.token,
                            etOldPwd.getText().toString(),
                            etNewPwd.getText().toString(),
                            etOkPwd.getText().toString());
                }
            });

        }

        private void initToobar() {

            toolbarTitle.setText("修改密码");
            toolbarBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ChangePasswordActivity.this.finish();
                }
            });

        }


        @Override
        public void modifyPwdSuccess(String msg) {
            toast(msg);
        }

        @Override
        public void modifyPwdFailed(String error) {
            toast(error);
        }
    }
}
