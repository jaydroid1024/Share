package com.jay.vlayoutdemo.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class ScreenHelper {
    public static final String SCREEN_HDPI_TAG = "hdpi";
    public static final String SCREEN_MDPI_TAG = "mdpi";
    public static final String SCREEN_XHDPI_TAG = "xhdpi";
    private static final String TAG = ScreenHelper.class.getSimpleName();

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static String getDensity(Context paramContext) {
        int i = paramContext.getResources().getDisplayMetrics().densityDpi;
        if (i <= 160) {
            return "mdpi";
        }
        if (i >= 320) {
            return "xhdpi";
        }
        return "hdpi";
    }


    @SuppressLint({"NewApi"})
    public static Message getMeasures(Activity paramContext) {
        Display display = ((WindowManager) paramContext.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        Point localPoint = new Point();
        int j;
        int i;
        if (Build.VERSION.SDK_INT >= 13) {
            display.getSize(localPoint);
            j = localPoint.x;
            i = localPoint.y;
        } else {
            /**
             * 替代的方法：
             DisplayMetrics dm = new DisplayMetrics();
             getWindowManager().getDefaultDisplay().getMetrics(dm);
             SCREEN_WIDTH = dm.widthPixels;
             SCREEN_HEIGHT = dm.heightPixels;
             */
            DisplayMetrics dm = new DisplayMetrics();
            paramContext.getWindowManager().getDefaultDisplay().getMetrics(dm);
            j = dm.widthPixels;
            i = dm.heightPixels;
        }
        Message message = new Message();
        message.arg1 = j;
        message.arg2 = i;
        return message;
    }

    @SuppressLint({"NewApi"})
    public static Message getMeasures(Context paramContext) {
        Display display = ((WindowManager) paramContext.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        Point localPoint = new Point();
        int j;
        int i;
        if (Build.VERSION.SDK_INT >= 13) {
            display.getSize(localPoint);
            j = localPoint.x;
            i = localPoint.y;
        } else {
            /**
             * 替代的方法：
             DisplayMetrics dm = new DisplayMetrics();
             getWindowManager().getDefaultDisplay().getMetrics(dm);
             SCREEN_WIDTH = dm.widthPixels;
             SCREEN_HEIGHT = dm.heightPixels;
             */
            j = display.getWidth();
            i = display.getHeight();
        }
        Message message = new Message();
        message.arg1 = j;
        message.arg2 = i;
        return message;
    }

    public static int getWidth(Context paramContext) {
        return getMeasures(paramContext).arg1;
    }

    public static int getWidth(Activity paramContext) {
        return getMeasures(paramContext).arg1;
    }
    public static int getHeight(Activity paramContext) {
        return getMeasures(paramContext).arg2;
    }
    public static int getHeight(Context paramContext) {
        return getMeasures(paramContext).arg2;
    }
}