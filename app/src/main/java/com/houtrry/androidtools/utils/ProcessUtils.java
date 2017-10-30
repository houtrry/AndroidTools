package com.houtrry.androidtools.utils;

import android.app.ActivityManager;
import android.content.Context;

/**
 * @author: houtrry
 * @time: 2017/10/30 14:59
 * @version: $Rev$
 * @desc: 进程相关
 */

public class ProcessUtils {
    /**
     * 获取当前进程Id
     *
     * @return 当前进程Id
     */
    public static int getProcessId() {
        return android.os.Process.myPid();
    }

    /**
     * 获取当前进程名称
     *
     * @param context 上下文
     * @return 当前进程名称
     */
    public static String getProcessName(Context context) {
        int pid = android.os.Process.myPid();
        ActivityManager mActivityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcess : mActivityManager
                .getRunningAppProcesses()) {
            if (appProcess.pid == pid) {

                return appProcess.processName;
            }
        }
        return null;
    }
}
