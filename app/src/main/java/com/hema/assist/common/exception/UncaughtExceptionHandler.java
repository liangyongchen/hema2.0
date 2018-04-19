package com.hema.assist.common.exception;

import com.hema.assist.common.loger.AppLogger;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/8:上午9:21
 * Email: 656266591@qq.com
 * Desc: 自定义错误处理,收集错误信息
 */
public class UncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        //读取stacktrace信息
        final Writer result = new StringWriter();
        final PrintWriter printWriter = new PrintWriter(result);
        ex.printStackTrace(printWriter);
        String errorReport = result.toString();
        AppLogger.e(errorReport);
    }
}