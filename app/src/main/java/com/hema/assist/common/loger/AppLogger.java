package com.hema.assist.common.loger;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;
import com.hema.assist.common.utils.AndroidUtils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/5:下午2:41
 * Email: 656266591@qq.com
 * Desc: Logger工具
 */

public class AppLogger {

    private static final String TAG = "WTW";

    public static final boolean isDebug = AndroidUtils.isDebug();

    static {
        init();
    }

    public static void init(){

        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(true)  // (Optional) Whether to show thread info or not. Default true
                .methodCount(5)         // (Optional) How many method line to show. Default 2
                .methodOffset(5)        // (Optional) Hides internal method calls up to offset. Default 5
//                .logStrategy(customLog) // (Optional) Changes the log strategy to print out. Default LogCat
                .tag(TAG)   // (Optional) Global tag for every log. Default PRETTY_LOGGER
                .build();

        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));


    }

    public static void e(String msg) {
        if (isDebug){
            Logger.e(msg);
        }
    }

    public static void w(String msg) {
        if (isDebug){
            Logger.w(msg);
        }
    }

    public static void i(String msg) {
        if (isDebug){
            Logger.i(msg);
        }
    }

    public static void d(String msg) {
        if (isDebug){
            Logger.d(msg);
        }
    }

    public static void d(Object obj) {
        if (isDebug){
            Logger.d(obj);
        }
    }

    public static void v(String msg) {
        if (isDebug){
            Logger.v(msg);
        }
    }

    public static void json(String json) {
        if (isDebug){
            Logger.json(json);
        }
    }

    public static void xml(String xml) {
        if (isDebug){
            Logger.xml(xml);
        }
    }

    public static void printThrowable(Throwable ex){
        if (isDebug){
            final Writer result = new StringWriter();
            final PrintWriter printWriter = new PrintWriter(result);
            ex.printStackTrace(printWriter);
            String errorReport = result.toString();
            e(errorReport);
        }
    }

}
