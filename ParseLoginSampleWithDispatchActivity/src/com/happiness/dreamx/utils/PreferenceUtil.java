
package com.happiness.dreamx.utils;

import android.content.SharedPreferences;

import com.happiness.dreamx.dispatcher.SampleApplication;

public class PreferenceUtil {
    private static SharedPreferences mPref;
    private static SharedPreferences.Editor mEditor;

    public static void init() {
        mPref = SampleApplication.getAppContext().getSharedPreferences("happiness", 0);
        mEditor = mPref.edit();
    }

    public static void putString(final String key, final String value) {
        mEditor.putString(key, value);
        mEditor.commit();
    }

    public static void putInt(final String key, final int value) {
        mEditor.putInt(key, value);
        mEditor.commit();
    }

    public static void putBoolean(final String key, final boolean value) {
        mEditor.putBoolean(key, value);
        mEditor.commit();
    }

    public static boolean getBoolean(final String key) {
        return mPref.getBoolean(key, false);
    }

    public static boolean getBoolean(final String key, final boolean defaultVal) {
        return mPref.getBoolean(key, defaultVal);
    }

    public static int getInt(final String key) {
        return mPref.getInt(key, 0);
    }

    public static int getBoolean(final String key, final int defaultVal) {
        return mPref.getInt(key, defaultVal);
    }

    public static String getString(final String key) {
        return mPref.getString(key, null);
    }

    public static String getString(final String key, final String defaultVal) {
        return mPref.getString(key, defaultVal);
    }
}
