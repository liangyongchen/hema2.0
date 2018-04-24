package com.hema.assist.feature.home.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hema.assist.common.base.BaseActivity;
import com.hema.assist.common.base.BaseResult;
import com.hema.assist.common.utils.CommonUtil;
import com.hema.assist.common.utils.IntentUtil;
import com.hema.assist.component.ComponentFactory;
import com.hema.assist.entity.LoginInfo;
import com.hema.assist.feature.apply.view.StageApplyActivity;
import com.hema.assist.feature.home.contract.HomeContract;
import com.wtw.p2p.R;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity {

    @Inject
    HomeContract.Presenter homePresenter;

    public BaseResult<LoginInfo> mData;

    // 标记门店用户id
    private int ID;

    @Override
    protected void getBundleExtras(Bundle extras) {
        super.getBundleExtras(extras);
        if (extras != null) {
            mData = (BaseResult<LoginInfo>) extras.getSerializable("login");
        } else {
            finish();
        }
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_home;
    }

    @Override
    protected void onCreateFinished() {
        ComponentFactory.getActivityComponent().inject(this);
        ViewHolder holder = new ViewHolder(getWindow().getDecorView());
        homePresenter.attachUi(holder);
        homePresenter.setData(mData);
    }


    class ViewHolder implements HomeContract.View, NavigationView.OnNavigationItemSelectedListener {

        // region // 初始化控件

        @BindView(R.id.toolbar_back)
        ImageView toolbarBack;
        @BindView(R.id.toolbar_title)
        TextView toolbarTitle;
        @BindView(R.id.toolbar_news)
        ImageView toolbarNews;
        @BindView(R.id.toolbar)
        Toolbar toolbar;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_role)
        TextView tvRole;
        @BindView(R.id.sale_points)
        AppCompatSpinner salePoints;
        @BindView(R.id.btn_stage_apply)
        LinearLayout btnStageApply;
        @BindView(R.id.btn_calculator)
        LinearLayout btnCalculator;
        @BindView(R.id.btn_apply)
        LinearLayout btnApply;
        @BindView(R.id.btn_order)
        LinearLayout btnOrder;
        @BindView(R.id.nav_view)
        NavigationView navView;
        @BindView(R.id.drawer_layout)
        DrawerLayout drawerLayout;


        // 个人中心
        private TextView tvOwnName; // 销售名称
        private ImageView ivAvatar;  // 先手头像
        private TextView tv_month_commission;  // 本月佣金
        private TextView tv_month_achievement; // 本月业绩
        private TextView tv_today_achievement; // 今日业绩

        // endregion

        ViewHolder(View view) {
            ButterKnife.bind(this, view);

            initToolbar();

            initHeader();

            initEvent();

        }

        private void initEvent() {

            btnStageApply.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle b = new Bundle();
                    b.putInt("id", ID);
                    IntentUtil.startActivity(HomeActivity.this, StageApplyActivity.class, b, CommonUtil.enumActionType.ACTION_FORWARD);
                }
            });


            btnCalculator.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });


            btnApply.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });


            btnOrder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            // 消息处理
            toolbarNews.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

        }

        // 初始化 header 控件
        void initHeader() {
            View header = navView.getHeaderView(0);
            tv_month_commission = (TextView) header.findViewById(R.id.tv_month_commission);
            tv_month_achievement = (TextView) header.findViewById(R.id.tv_month_achievement);
            tv_today_achievement = (TextView) header.findViewById(R.id.tv_today_achievement);
            tvOwnName = (TextView) header.findViewById(R.id.tv_own_name);
            ivAvatar = (ImageView) header.findViewById(R.id.iv_avatar);
        }

        // 初始化 Toolbar 绑定 DrawerLayout 侧滑界面
        private void initToolbar() {
            toolbar.setTitle("");
            setSupportActionBar(toolbar);

            // region // toolbar  +  DrawerLayout 使用


            // 左上角图标可用
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//            getSupportActionBar().setHomeButtonEnabled(true);
//            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                    HomeActivity.this,
//                    drawerLayout, toolbar,
//                    R.string.navigation_drawer_open,
//                    R.string.navigation_drawer_close);
//
//            drawerLayout.addDrawerListener(toggle);
//            toggle.syncState();
//            toggle.setDrawerIndicatorEnabled(false);
//            // 要替换的图标
//            toggle.setHomeAsUpIndicator(R.drawable.login_yh_s2);
//            // 给图标设置点击事件，用于开启DrawerLayout侧边布局
//            toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    drawerLayout.openDrawer(GravityCompat.START);
//                }
//            });


            // endregion

            toolbarTitle.setText("河马分期");

            toolbarBack.setImageDrawable(getResources().getDrawable(R.drawable.login_yh_s2));
            toolbarBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            });

            toolbarNews.setVisibility(View.VISIBLE);
            toolbarNews.setImageDrawable(getResources().getDrawable(R.drawable.news_s3));

            navView.setNavigationItemSelectedListener(this);
        }

        @Override
        public void setSpinner(List<LoginInfo.SalePointsBean> data) {
            if (data != null && data.size() > 0) {
                ArrayAdapter arrayAdapter = new ArrayAdapter(HomeActivity.this, R.layout.spinner_text, data);
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                salePoints.setAdapter(arrayAdapter);
                salePoints.setSelection(0); // 默认选择第一个
                ID = data.get(0).getId();// 开始默认选择第一个门店id
                salePoints.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        ID = data.get(position).getId();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                ID = data.get(0).getId();// 开始默认选择第一个门店id
            }
        }

        @Override
        public void setData(LoginInfo model) {
            tvName.setText(String.format("%s ", model.getName()));
            tvRole.setText(String.format("/ %s ", model.getRole()));
            tvOwnName.setText(model.getName());

            // 头像设置
            Glide.with(getBaseContext()).load(model.getAvatar()).error(getResources().getDrawable(R.drawable.logo_s3)).into(ivAvatar);
        }

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {

                case R.id.home_overdue: // 逾期管理
                    IntentUtil.startActivity(HomeActivity.this, OverdueActivity.class, CommonUtil.enumActionType.ACTION_FORWARD);
                    break;
                case R.id.home_exception_handle: // 异常处理
                    break;
                case R.id.home_bank: // 银行代扣
                    break;
                case R.id.home_alter_pwd: // 修改密码
                    IntentUtil.startActivity(HomeActivity.this, ChangePasswordActivity.class, CommonUtil.enumActionType.ACTION_FORWARD);
                    break;
                case R.id.home_problem: // 常见问题
                    break;
                case R.id.home_feedback: // 问题反馈
                    IntentUtil.startActivity(HomeActivity.this, AuestionBackActivity.class, CommonUtil.enumActionType.ACTION_FORWARD);
                    break;
                case R.id.home_set: // 设置中心
                    IntentUtil.startActivity(HomeActivity.this, SetActivity.class, CommonUtil.enumActionType.ACTION_FORWARD);
                    break;
            }

            return true;
        }
    }


}
