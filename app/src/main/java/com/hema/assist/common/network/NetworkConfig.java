package com.hema.assist.common.network;

import com.hema.assist.app.EnvType;
import com.wtw.p2p.BuildConfig;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/7:下午2:30
 * Email: 656266591@qq.com
 * Desc:
 */
public class NetworkConfig {
    // 超时时间
    public static final long DEFAULT_TIMEOUT = 20;
    /**
     * 测试环境
     */
    public static final String DEVELOP_URL = "http://106.15.79.13:26100/";
//    public static final String DEVELOP_URL = "http://192.168.0.131:8080/";
    /**
     * 生产环境
     */
    public static final String PRODUCT_URL = "http://106.15.79.13:26100/";
//    public static final String PRODUCT_URL = "http://192.168.0.131:8080/";

    public static final String PROJECT_NAME = "sale";

    public static String getServerHost() {

        //测试环境
        if (BuildConfig.ENV_TYPE == EnvType.DEVELOP) {

            return DEVELOP_URL;
            //生产环境
        } else if (BuildConfig.ENV_TYPE == EnvType.PRODUCT) {

            return PRODUCT_URL;

        }
        return PRODUCT_URL;
    }

}
