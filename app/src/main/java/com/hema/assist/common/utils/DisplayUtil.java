package com.hema.assist.common.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/8:上午11:51
 * Email: 656266591@qq.com
 * Desc:
 */
public class DisplayUtil {

    public static void readyGo(Context activity,Class<?> cls) {
        readyGo(activity,cls,null);
    }

    public static void readyGo(Activity activity, Class<?> cls, int requestCode) {
        readyGo(activity,cls,null,requestCode);
    }

    public static void readyGo(Context activity,Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(activity, cls);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        activity.startActivity(intent);
    }

    public static void readyGo(Activity activity, Class<?> cls, Bundle bundle, int requestCode) {
        Intent intent = new Intent(activity, cls);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        activity.startActivityForResult(intent, requestCode);
    }

}
