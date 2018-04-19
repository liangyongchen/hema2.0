package com.hema.assist.common.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/8:上午9:07
 * Email: 656266591@qq.com
 * Desc:
 */
public class SPHelper {
    private static final String DEFAULT_NAME = "config";
    private static SharedPreferences sharedPreferences;

    /**
     * 必须在Application中进行初始化
     *
     * @param context
     */
    public static void init(Context context) {
        sharedPreferences = context.getSharedPreferences(DEFAULT_NAME, Context.MODE_PRIVATE);
    }

    private static void checkInit() {
        if (sharedPreferences == null) {
            throw new RuntimeException("SPHelper not init in Applicatiion");
        }
    }

    public static void saveStringData(String key, String data) {
        checkInit();
        sharedPreferences.edit().putString(key, data).apply();
    }

    public static void saveBooleanData(String key, Boolean data) {
        checkInit();
        sharedPreferences.edit().putBoolean(key, data).apply();
    }

    public static void saveLongData(String key, long data) {
        checkInit();
        sharedPreferences.edit().putLong(key, data).apply();
    }

    public static void saveIntData(String key, int data) {
        checkInit();
        sharedPreferences.edit().putInt(key, data).apply();
    }

    public static String getStringData(String key, String defValue) {
        checkInit();
        return sharedPreferences.getString(key, defValue);
    }

    public static boolean getBooleanData(String key, Boolean defValue) {
        checkInit();
        return sharedPreferences.getBoolean(key, defValue);
    }

    public static long getLongData(String key, long defValue) {
        checkInit();
        return sharedPreferences.getLong(key, defValue);
    }

    public static int getIntData(String key, int defValue) {
        checkInit();
        return sharedPreferences.getInt(key, defValue);
    }

    public static void removeKey(String key) {
        checkInit();
        sharedPreferences.edit().remove(key).apply();
    }

}

