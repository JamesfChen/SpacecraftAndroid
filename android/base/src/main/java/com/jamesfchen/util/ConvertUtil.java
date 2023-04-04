package com.jamesfchen.util;

import androidx.annotation.FloatRange;

import com.jamesfchen.common.util.Util;

/**
 * Copyright ® 2019
 * All right reserved.
 * Code Link : https://github.com/HawksJamesf/Spacecraft
 *
 * @author: hawksjamesf
 * @email: hawksjamesf@gmail.com
 * @since: Mar/03/2019  Sun
 */
public class ConvertUtil {

    public static int dp2px(@FloatRange final float dpValue) {
        final float scale = com.jamesfchen.common.util.Util.getApp().getBaseContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }


    public static int px2dp(final float pxValue) {
        final float scale = Util.getApp().getBaseContext().getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
