package com.fisher.helloandroid.test1_6;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Fisher
 * @Date 2019/3/2 10:19
 *
 * 活动管理器，目前包含：
 * 1.点击一次按钮退出所有活动的方法finishAll()
 **/


public class ActivityController {
    public static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    public static void finishAll() {
        for (Activity activity:activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
        activities.clear();
//        杀死自己的进程
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
