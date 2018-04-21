package com.hema.assist.common.network;

import com.hema.assist.common.utils.DeviceUtil;
import com.hema.assist.common.utils.AndroidUtils;
import com.wtw.p2p.BuildConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/23:下午3:55
 * Email: 656266591@qq.com
 * Desc:
 */
public class APIUtils {

    // 登陆 token，保活时常 1 小时
    public static String token = "";
    public static String id = "";

    /**
     * 获取图形验证码URL
     *
     * @param temporaryToken
     * @param codetype
     * @return
     */
    public static String getImageCodeUrl(String temporaryToken, int codetype) {
        Map<String, String> params = new HashMap<>();
        params.put("tempToken", temporaryToken);
        params.put("codeType", codetype + "");
        String url = getWTWUrl("api/auth/account/getImgCode", params);

        return url;
    }

    /**
     * 获取网页URL （添加默认参数）
     *
     * @param originUrl
     * @param params
     * @return
     */
    public static String getWTWUrl(String originUrl, Map<String, String> params) {


        if (!originUrl.startsWith("http")) {

            originUrl = NetworkConfig.getServerHost() + NetworkConfig.PROJECT_NAME + "/" + originUrl;

        }
        StringBuilder url = new StringBuilder(originUrl);

        //添加默认参数
        int i = 0;

        for (Map.Entry<String, String> entry : getDefaultParams().entrySet()) {

            if (originUrl.contains("?")) {
                url.append("&" + entry.getKey() + "=" + entry.getValue());
            } else {
                if (i == 0) {
                    url.append("?" + entry.getKey() + "=" + entry.getValue());
                } else {
                    url.append("&" + entry.getKey() + "=" + entry.getValue());
                }
            }
            i++;
        }
        //外面传进来的参数
        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {

                url.append("&" + entry.getKey() + "=" + entry.getValue());

            }

        }

        return url.toString();
    }

    public static Map<String, String> getDefaultParams() {

        Map<String, String> params = new HashMap<>();
        params.put("clientType", "0");
        params.put("appVersion", BuildConfig.VERSION_NAME);
        String token = null;

        String deviceId = DeviceUtil.getDeviceId();
        String channel = AndroidUtils.getChannel();

        if (token != null) {
            params.put("token", token);
        }

        if (deviceId != null) {
            params.put("deviceId", deviceId);
        }

        if (channel != null) {
            params.put("appChannel", channel);
        }
        return params;
    }

}
