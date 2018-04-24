package com.hema.assist.feature.apply.view.user;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hema.assist.common.base.BaseActivity;
import com.wtw.p2p.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserActivity extends BaseActivity {


    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_user;
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
        @BindView(R.id.tv_job)
        TextView tvJob;
        @BindView(R.id.btn_job)
        LinearLayout btnJob;
        @BindView(R.id.tv_home)
        TextView tvHome;
        @BindView(R.id.btn_home)
        LinearLayout btnHome;
        @BindView(R.id.tv_contact)
        TextView tvContact;
        @BindView(R.id.btn_contact)
        LinearLayout btnContact;
        @BindView(R.id.btn_next)
        Button btnNext;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);

            initToolbar();
            
            initEvent();
            
        }

        private void initEvent() {

            btnJob.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            btnHome.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            btnContact.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

        }

        private void initToolbar() {

            toolbarTitle.setText("个人信息");

            toolbarBack.setOnClickListener(v ->  finish());
        }


    }
}
