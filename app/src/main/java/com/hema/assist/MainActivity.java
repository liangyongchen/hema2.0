package com.hema.assist;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.hema.assist.common.loger.AppLogger;
import com.hema.assist.feature.invest.InvestFragment;
import com.hema.assist.feature.mine.MineFragment;
import com.jaeger.library.StatusBarUtil;
import com.wtw.p2p.R;
import com.hema.assist.common.utils.ToastUtil;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/5:下午3:29
 * Email: 656266591@qq.com
 * Desc:
 */

public class MainActivity extends FragmentActivity {

    @BindView(R.id.rg_tabbar)
    RadioGroup tabbar;


    private Fragment mContent;
    private List<Fragment> mBaseFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        StatusBarUtil.setColor(MainActivity.this, getResources().getColor(R.color.app_nav_color));

        initFragments();

        tabbar.setOnCheckedChangeListener(new MyCheckedChangeListener());
        tabbar.check(R.id.rb_home);


        AppLogger.d("初始化成");
        AppLogger.w("有警告了");
        AppLogger.i("info");
        AppLogger.e("有错误了");
        ToastUtil.showToast(this,"toast来啦");
    }

    private void initFragments() {
        mBaseFragments = new ArrayList<>();
        //mBaseFragments.add(new HomeFragment());
        mBaseFragments.add(new InvestFragment());
        mBaseFragments.add(new MineFragment());
    }

    private class MyCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
            int position = 0;
            switch (i) {
                case R.id.rb_home:
                    position = 0;
                    break;
                case R.id.rb_invest:
                    position = 1;
                    break;
                case R.id.rb_mine:
                    position = 2;
                    break;
            }
            Fragment fragment = getFragment(position);
            switchFragment(mContent, fragment);

        }
    }

    private Fragment getFragment(int position) {
        if (mBaseFragments != null && mBaseFragments.size() > 0) {
            Fragment fg = mBaseFragments.get(position);
            return fg;
        }
        return null;
    }

    private void switchFragment(Fragment from, Fragment to) {

        if (mContent != to) {

            mContent = to;

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

            if (!to.isAdded()) {
                // 先判断是否被add过 
                if (from != null) {
                    ft.hide(from);
                }
                if (to != null) {
                    ft.add(R.id.fl_content, to).commit();
                }
            } else {
                if (from != null) {
                    ft.hide(from);
                }
                if (to != null) {
                    ft.show(to).commit();
                }
            }
        }

    }
}


