package com.electrolytej.constants;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import androidx.annotation.IntDef;

/**
 * Copyright ® $ 2017
 * All right reserved.
 *
 * @author: jamesfchen
 * @since: Nov/07/2018  Wed
 */
public class MemoryUnit {
    public static final int BYTE = 1;
    public static final int KB = 1024;
    public static final int MB = 1024 * 1024;
    public static final int GB = 1024 * 1024 * 1024;

    @IntDef({BYTE, KB, MB, GB})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Unit {
    }
}
