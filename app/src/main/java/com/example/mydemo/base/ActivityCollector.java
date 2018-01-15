package com.example.mydemo.base;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * 活动控制器
 * Author: CQE
 * Date: 2018/1/15.
 */

public class ActivityCollector {

    private static List<Activity> activityList = new ArrayList<>();

    //添加活动
    public static void addActivity(Activity activity) {
        activityList.add(activity);
    }

    //结束活动
    public static void removeActivity(Activity activity) {
        activityList.remove(activity);
    }

    //结束所有的活动
    public static void finishAllActivity(){
        for (Activity activity : activityList){
            if (!activity.isFinishing()){  // 判断活动是否结束
                activity.finish();
            }
        }
    }
}
