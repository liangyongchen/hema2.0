package com.hema.assist.app;

import android.app.Application;
import android.content.Context;

import com.hema.assist.common.utils.DeviceUtil;
import com.hema.assist.common.utils.SPHelper;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreater;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreater;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.wtw.p2p.R;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/1/27:下午10:52
 * Email: 656266591@qq.com
 * Desc:
 */

public class App extends Application {

    public static App sInstance;
    public static Context context;

    //static 代码段可以防止内存泄露
    static {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreater(new DefaultRefreshHeaderCreater() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                ClassicsHeader header = new ClassicsHeader(context);
                header.getTitleText().setTextColor(context.getResources().getColor(R.color.color_hex_333333));
                header.setBackgroundColor(context.getResources().getColor(R.color.app_default_background_color));
                header.setEnableLastTime(false);
                return header;
                //return new ClassicsHeader(context);//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
            }
        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreater(new DefaultRefreshFooterCreater() {
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                //指定为经典Footer，默认是 BallPulseFooter
                ClassicsFooter footer = new ClassicsFooter(context);
                footer.getTitleText().setTextColor(context.getResources().getColor(R.color.color_hex_333333));
                footer.setSpinnerStyle(SpinnerStyle.Scale);
                footer.setBackgroundColor(context.getResources().getColor(R.color.app_default_background_color));
                return footer;
            }
        });
    }

    @Override
    public void onCreate() {
        super.onCreate();

        sInstance = this;
        context = getApplicationContext();
        initApp();

    }

    private void initApp(){
        SPHelper.init(this);
        DeviceUtil.init(this);
//        Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler());
    }
}
