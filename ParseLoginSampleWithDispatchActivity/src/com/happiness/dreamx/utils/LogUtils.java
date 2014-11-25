
package com.happiness.dreamx.utils;

import android.util.Log;

public class LogUtils {

    public static void e(String TAG, String msg) {
        Log.e("Happy-" + TAG, msg);
    }

    public static void i(String TAG, String msg) {
        Log.i("Happy-" + TAG, msg);
    }

    public static void d(String TAG, String msg) {
        Log.d("Happy-" + TAG, msg);
    }
}
