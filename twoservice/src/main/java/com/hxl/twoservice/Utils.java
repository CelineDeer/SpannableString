package com.hxl.twoservice;

import android.app.ActivityManager;
import android.content.Context;

import java.util.List;

/**
 * Created by hp_laptop on 2017/6/26.
 */


public class Utils {

    /**
     * 判断进程是否还在运行
     * @return
     */
    public static Boolean isProgressRunning(Context context,String serviceName){

        Boolean isRunning = false;
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);

        List<ActivityManager.RunningAppProcessInfo> progressInfos = manager.getRunningAppProcesses();
        for (ActivityManager.RunningAppProcessInfo info: progressInfos
             ) {
            if (info.equals(serviceName)){
                isRunning = true;
            }
        }
        return isRunning;
    }
}
