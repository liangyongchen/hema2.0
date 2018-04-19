package com.hema.assist.common.utils;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import java.util.UUID;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/8:上午9:09
 * Email: 656266591@qq.com
 * Desc:
 */
public class DeviceUtil {

    private static final String SP_DEVICE_KEY = "sp_device_key";
    private static String device_id = null;
    private static Context appContext;

    public static void init(Context context) {
        if (context == null) {
            throw new RuntimeException("init method context is NULL");
        }
        appContext = context.getApplicationContext();
    }

    /**
     * deviceID的组成为：渠道标志+识别符来源标志+hash后的终端识别符
     * <p/>
     * 渠道标志为：
     * 1，andriod（a）
     * <p/>
     * 识别符来源标志：
     * 1， wifi mac地址（wifi）；
     * 2， IMEI（imei）；
     * 3， 序列号（sn）；
     * 4， id：随机码。若前面的都取不到时，则随机生成一个随机码，需要缓存。
     *
     * @return
     */
    public static String getDeviceId() {
        if (device_id != null) {
            return device_id;
        }

        device_id = SPHelper.getStringData(SP_DEVICE_KEY, null);
        if (!TextUtils.isEmpty(device_id)) {
            return device_id;
        }

        return createUUID(appContext);
    }

    /**
     * 加锁，防止生成多个
     *
     * @param appContext
     * @return
     */
    private static synchronized String createUUID(Context appContext) {
        if (device_id != null) {
            return device_id;
        }

        device_id = SPHelper.getStringData(SP_DEVICE_KEY, null);
        if (!TextUtils.isEmpty(device_id)) {
            return device_id;
        }

        if (appContext == null) {
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();
        try {
            //wifi mac地址
            WifiManager wifi = (WifiManager) appContext.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
            WifiInfo info = wifi.getConnectionInfo();
            String wifiMac = info.getMacAddress();
//            LogUtil.i("wifiMac:" + wifiMac);
            if (!TextUtils.isEmpty(wifiMac)) {
                stringBuilder.append(wifiMac);
            }

            //IMEI（imei）
            TelephonyManager tm = (TelephonyManager) appContext.getSystemService(Context.TELEPHONY_SERVICE);
            String imei = tm.getDeviceId();
//            LogUtil.i("imei:" + imei);
            if (!TextUtils.isEmpty(imei)) {
                stringBuilder.append(imei);
            }

            //序列号（sn）
//            String sn = tm.getSimSerialNumber();
//            LogUtil.i(TAG, "sn:" + sn);
//            if(!TextUtils.isEmpty(sn)){
//                stringBuilder.append(sn);
//            }

            //如果上面都没有， 则生成一个id：随机码
            if (stringBuilder.length() == 0) {
                String uuid = UUID.randomUUID().toString();
                stringBuilder.append(uuid);
            }
        } catch (Exception e) {
            e.printStackTrace();
            stringBuilder.append(UUID.randomUUID().toString());
        }

        //MD5 加密 保证16位
        device_id = MD5Util.getMd5(stringBuilder.toString(), false);
////        device_id = "a" + md5;

        SPHelper.saveStringData(SP_DEVICE_KEY, device_id);

        return device_id;
    }

}
