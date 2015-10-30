package com.mutils.library.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.mutils.library.R;

import java.lang.reflect.Field;

/**
 * Android4.4实现沉浸式状态栏，需在style里面添加
 * "<item name="android:fitsSystemWindows">true</item>"
 * Created by chao on 2015/10/29.
 */
public class ImmerseStatusBar {

    public static int getStatusBarHeight(Context context) {
        Class<?> c;
        Object obj;
        Field field;
        int x, sbar = 0;
        try {
            c = Class.forName("com.android.internal.R$dimen");
            obj = c.newInstance();
            field = c.getField("status_bar_height");
            x = Integer.parseInt(field.get(obj).toString());
            sbar = context.getResources().getDimensionPixelSize(x);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sbar;
    }

    //Another way to get status bar height

//    private int getStatusBarHeight(Context context) {
//        int sbar = 0;
//        Resources res = context.getResources();
//        int resourceId = res.getIdentifier("status_bar_height", "dimen", "android");
//        if (resourceId > 0) {
//            sbar = res.getDimensionPixelSize(resourceId);
//        }
//        return sbar;
//    }

    public static void init(Activity activity) {
        //version 4.4
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            return;
        }
        Window window = activity.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        ViewGroup decorViewGroup = (ViewGroup) window.getDecorView();
        View statusBarView = new View(activity);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, getStatusBarHeight(activity));
        params.gravity = Gravity.TOP;
        statusBarView.setLayoutParams(params);
        if (R.color.colorPrimary > 0) {
            statusBarView.setBackgroundResource(R.color.colorPrimary);
        } else {
            statusBarView.setBackgroundColor(Color.BLACK);
        }
        decorViewGroup.addView(statusBarView);
    }

    public static void init(Activity activity, int resId) {
        //version 4.4
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            return;
        }
        Window window = activity.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        ViewGroup decorViewGroup = (ViewGroup) window.getDecorView();
        View statusBarView = new View(activity);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, getStatusBarHeight(activity));
        params.gravity = Gravity.TOP;
        statusBarView.setLayoutParams(params);
        statusBarView.setBackgroundResource(resId);
        decorViewGroup.addView(statusBarView);
    }

}
