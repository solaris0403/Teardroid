package com.tony.teardroid.common.util;

import android.util.Log;

/**
 * Created by user on 10/26/15.
 */
public class LogUtils {
    public static boolean isDebug = true;
    private static String className;//类名
    private static String methodName;//方法名
    private static int lineNumber;//行数

    private LogUtils() {
        throw new AssertionError();
    }

    /**
     * 根据应用自行判断Debug状态
     */
    public static boolean isDebuggable() {
        return isDebug;
    }

    private static String createLog(String log) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(methodName);
        buffer.append("(").append(className).append(":").append(lineNumber).append("):");
        buffer.append(log);
        return buffer.toString();
    }

    /**
     * 获取当前Log所处的位置
     *
     * @param sElements
     */
    private static void getMethodNames(StackTraceElement[] sElements) {
        className = sElements[1].getFileName();
        methodName = sElements[1].getMethodName();
        lineNumber = sElements[1].getLineNumber();
    }


    public static void e(Object arg) {
        if (!isDebuggable())
            return;
        // Throwable instance must be created before any methods
        getMethodNames(new Throwable().getStackTrace());
        Log.e(className, createLog(String.valueOf(arg)));
    }

    public static void e(String tag, Object arg) {
        if (!isDebuggable())
            return;
        // Throwable instance must be created before any methods
        getMethodNames(new Throwable().getStackTrace());
        Log.e(tag, createLog(String.valueOf(arg)));
    }

    public static void i(Object arg) {
        if (!isDebuggable())
            return;
        // Throwable instance must be created before any methods
        getMethodNames(new Throwable().getStackTrace());
        Log.i(className, createLog(String.valueOf(arg)));
    }

    public static void i(String tag, Object arg) {
        if (!isDebuggable())
            return;
        // Throwable instance must be created before any methods
        getMethodNames(new Throwable().getStackTrace());
        Log.i(tag, createLog(String.valueOf(arg)));
    }


    public static void d(Object arg) {
        if (!isDebuggable())
            return;
        // Throwable instance must be created before any methods
        getMethodNames(new Throwable().getStackTrace());
        Log.d(className, createLog(String.valueOf(arg)));
    }

    public static void d(String tag, Object arg) {
        if (!isDebuggable())
            return;
        // Throwable instance must be created before any methods
        getMethodNames(new Throwable().getStackTrace());
        Log.d(tag, createLog(String.valueOf(arg)));
    }

    public static void v(Object arg) {
        if (!isDebuggable())
            return;
        // Throwable instance must be created before any methods
        getMethodNames(new Throwable().getStackTrace());
        Log.v(className, createLog(String.valueOf(arg)));
    }

    public static void w(Object arg) {
        if (!isDebuggable())
            return;
        // Throwable instance must be created before any methods
        getMethodNames(new Throwable().getStackTrace());
        Log.w(className, createLog(String.valueOf(arg)));
    }

    public static void w(String tag, Object arg) {
        if (!isDebuggable())
            return;
        // Throwable instance must be created before any methods
        getMethodNames(new Throwable().getStackTrace());
        Log.w(tag, createLog(String.valueOf(arg)));
    }

    public static void wtf(Object arg) {
        if (!isDebuggable())
            return;
        getMethodNames(new Throwable().getStackTrace());
        Log.wtf(className, createLog(String.valueOf(arg)));
    }

    public static void wtf(String tag, Object arg) {
        if (!isDebuggable())
            return;
        // Throwable instance must be created before any methods
        getMethodNames(new Throwable().getStackTrace());
        Log.wtf(tag, createLog(String.valueOf(arg)));
    }
}
