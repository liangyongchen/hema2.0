package com.hema.assist.common.network.interceptor;

import com.hema.assist.common.utils.DeviceUtil;
import com.wtw.p2p.BuildConfig;
import com.hema.assist.common.utils.AndroidUtils;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/8:上午9:28
 * Email: 656266591@qq.com
 * Desc:
 */
public class BaseParameterInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl.Builder urlBuilder = request.url()
                .newBuilder().addQueryParameter("clientType", "0")
                .addQueryParameter("deviceId", DeviceUtil.getDeviceId())
                .addQueryParameter("version", BuildConfig.VERSION_NAME)
                .addQueryParameter("appChannel", AndroidUtils.getChannel());
        //登录就传token
//            if(UserManager.getInstance().isLogin()){
//                urlBuilder.addQueryParameter("userToken", UserManager.getInstance().getToken());
//            }

        Request requestWithBaseParam = request.newBuilder()
                .url(urlBuilder.build()).build();
        return chain.proceed(requestWithBaseParam);
    }
}
