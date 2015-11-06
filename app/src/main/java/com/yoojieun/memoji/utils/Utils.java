package com.yoojieun.memoji.utils;

import android.util.Log;

/**
 * Created by yoojieun on 2015. 11. 6..
 */
public class Utils {
    private final static String LOG_TAG = "memoji";
    private final static boolean IS_DEBUG = true ;

    public static void log (String msg) {
        if (IS_DEBUG == true) {
            Log.v(LOG_TAG, msg);
        }
    }

}
