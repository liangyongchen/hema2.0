package com.hema.assist.common.utils;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

import com.hema.assist.app.App;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/5:下午3:29
 * Email: 656266591@qq.com
 * Desc:Toast工具
 */

public class ToastUtil {

    private static Toast toast = null;

    public static void showToast(String msg) {
        showToast(App.context,msg,Toast.LENGTH_SHORT);
    }

    public static void showToast(Context context, String msg) {
        showToast(context,msg,Toast.LENGTH_SHORT);
    }

    public static void showToast(Context context, String msg,int duration) {
        if (toast == null) {
            toast = Toast.makeText(context, msg,duration);
        } else {
            toast.setText(msg);
        }
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    /**
     * 调试的时候使用，发布版本不toast
     * @param msg
     */
    public static void showDebugToast(String msg){
        if (AndroidUtils.isDebug()){
            ToastUtil.showToast(App.context,msg);
        }
    }
}
