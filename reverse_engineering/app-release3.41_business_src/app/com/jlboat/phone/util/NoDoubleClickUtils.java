package com.jlboat.phone.util;
public class NoDoubleClickUtils {
    private static final int SPACE_TIME = 500;
    private static long lastClickTime;

    static NoDoubleClickUtils()
    {
        com.jlboat.phone.util.NoDoubleClickUtils.lastClickTime = 0;
        return;
    }

    public NoDoubleClickUtils()
    {
        return;
    }

    public static declared_synchronized boolean isDoubleClick()
    {
        try {
            int v3_2;
            Throwable v1_1 = System.currentTimeMillis();
        } catch (Throwable v1_0) {
            throw v1_0;
        }
        if ((v1_1 - com.jlboat.phone.util.NoDoubleClickUtils.lastClickTime) <= 500) {
            v3_2 = 1;
        } else {
            v3_2 = 0;
        }
        com.jlboat.phone.util.NoDoubleClickUtils.lastClickTime = v1_1;
        return v3_2;
    }
}
