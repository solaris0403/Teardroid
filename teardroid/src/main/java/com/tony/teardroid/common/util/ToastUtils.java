package com.tony.teardroid.common.util;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.widget.Toast;

import android.os.Handler;

/**
 * @author Tony E-mail:solaris0403@gmail.com
 * @version Create Data：Jul 20, 2015 10:57:41 AM
 */
public class ToastUtils {
    public static boolean isShow = true;
    private static Context mContext;
    protected static Toast mToast;
    private static String mOldMsg;
    private static long mFirstTime = 0;
    private static long mSecondTime = 0;
    public static final int SHOW_SHORT = 0;
    public static final int SHOW_LONG = 1;
    public static final int SHOW_TIME = 2;

    private static Handler msgHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SHOW_SHORT:
                    showToast(mContext, msg.getData().getString("TEXT"), Toast.LENGTH_SHORT);
                    break;
                case SHOW_LONG:
                    showToast(mContext, msg.getData().getString("TEXT"), Toast.LENGTH_LONG);
                    break;
                case SHOW_TIME:
                    showToast(mContext, msg.getData().getString("TEXT"), msg.getData().getInt("TIME"));
                    break;
                default:
                    break;
            }
        }
    };

    /**
     * To control the continuous output point in time
     *
     * @param context
     * @param s
     * @param duration
     */
    public static void showToast(Context context, String s, int duration) {
        if (mToast == null) {
            mToast = Toast.makeText(context, s, duration);
            mToast.show();
            mFirstTime = System.currentTimeMillis();
        } else {
            mSecondTime = System.currentTimeMillis();
            if (s.equals(mOldMsg)) {
                if (mSecondTime - mFirstTime > duration) {
                    mToast.show();
                }
            } else {
                mOldMsg = s;
                mToast.setText(s);
                mToast.show();
            }
        }
        mFirstTime = mSecondTime;
    }

    /**
     * Short Toast
     *
     * @param context
     * @param string
     */
    public static void showShort(Context context, String string) {
        if (isShow) {
            showToast(context, string, Toast.LENGTH_SHORT);
        }
    }

    /**
     * Short Toast
     *
     * @param context
     * @param string
     */
    public static void showShort(Context context, int string) {
        if (isShow) {
            showToast(context, context.getString(string), Toast.LENGTH_SHORT);
        }
    }

    /**
     * Long Toast
     *
     * @param context
     * @param string
     */
    public static void showLong(Context context, String string) {
        if (isShow) {
            showToast(context, string, Toast.LENGTH_LONG);
        }
    }

    /**
     * Long Toast
     *
     * @param context
     * @param string
     */
    public static void showLong(Context context, int string) {
        if (isShow) {
            showToast(context, context.getString(string), Toast.LENGTH_LONG);
        }
    }

    /**
     * Custom time Toast
     *
     * @param context
     * @param string
     * @param duration
     */
    public static void showTime(Context context, String string, int duration) {
        if (isShow) {
            showToast(context, string, duration);
        }
    }

    /**
     * Custom time Toast
     *
     * @param context
     * @param string
     * @param duration
     */
    public static void showTime(Context context, int string, int duration) {
        if (isShow) {
            showToast(context, context.getString(string), duration);
        }
    }

    /**
     * Short toast in thread
     *
     * @param context
     * @param resId
     */
    public static void showShortInThread(Context context, int resId) {
        mContext = context;
        Message msg = msgHandler.obtainMessage(SHOW_SHORT);
        Bundle bundle = new Bundle();
        bundle.putString("TEXT", context.getResources().getString(resId));
        msg.setData(bundle);
        msgHandler.sendMessage(msg);
    }

    /**
     * Short toast in thread
     *
     * @param context
     * @param string
     */
    public static void showShortInThread(Context context, String string) {
        mContext = context;
        Message msg = msgHandler.obtainMessage(SHOW_SHORT);
        Bundle bundle = new Bundle();
        bundle.putString("TEXT", string);
        msg.setData(bundle);
        msgHandler.sendMessage(msg);
    }

    /**
     * Long toast in thread
     *
     * @param context
     * @param resId
     */
    public static void showLongInThread(Context context, int resId) {
        mContext = context;
        Message msg = msgHandler.obtainMessage(SHOW_LONG);
        Bundle bundle = new Bundle();
        bundle.putString("TEXT", context.getResources().getString(resId));
        msg.setData(bundle);
        msgHandler.sendMessage(msg);
    }

    /**
     * Long toast in thread
     *
     * @param context
     * @param string
     */
    public static void showLongInThread(Context context, String string) {
        mContext = context;
        Message msg = msgHandler.obtainMessage(SHOW_LONG);
        Bundle bundle = new Bundle();
        bundle.putString("TEXT", string);
        msg.setData(bundle);
        msgHandler.sendMessage(msg);
    }

    /**
     * Custom time toast in thread
     *
     * @param context
     * @param resId
     * @param time
     */
    public static void showTimeInThread(Context context, int resId, int time) {
        mContext = context;
        Message msg = msgHandler.obtainMessage(SHOW_TIME);
        Bundle bundle = new Bundle();
        bundle.putString("TEXT", context.getResources().getString(resId));
        bundle.putInt("TIME", time);
        msg.setData(bundle);
        msgHandler.sendMessage(msg);
    }

    /**
     * Custom time toast in thread
     *
     * @param context
     * @param string
     * @param time
     */
    public static void showTimeInThread(Context context, String string, int time) {
        mContext = context;
        Message msg = msgHandler.obtainMessage(SHOW_TIME);
        Bundle bundle = new Bundle();
        bundle.putString("TEXT", string);
        bundle.putInt("TIME", time);
        msg.setData(bundle);
        msgHandler.sendMessage(msg);
    }
}
