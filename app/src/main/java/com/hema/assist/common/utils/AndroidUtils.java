package com.hema.assist.common.utils;

import com.meituan.android.walle.WalleChannelReader;
import com.hema.assist.app.App;
import com.wtw.p2p.BuildConfig;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/7:下午2:47
 * Email: 656266591@qq.com
 * Desc:
 */
public class AndroidUtils {


    public static boolean isDebug(){
        return BuildConfig.DEBUG;
    }

    /**
     * 获取渠道
     *
     * @return
     */
    public static String getChannel() {

        String channel = WalleChannelReader.getChannel(App.context);

        if (channel == null) {
            channel = "yyb";//默认应用宝
        }

        return channel;

    }

}
