package me.pwcong.rtfrxmvp.manager;

import android.app.Activity;

import java.util.Vector;

/**
 * Created by pwcong on 2016/8/23.
 */
public class ActivityManager {

    private static ActivityManager manager;

    private static Activity currentActivity;

    private static Vector<Activity> activities=new Vector<>();

    public static synchronized ActivityManager getInstance(){

        if(null==manager){
            manager=new ActivityManager();
        }
        return manager;
    }

    public void register(Activity activity){
        activities.add(activity);
        currentActivity=activity;
    }

    public void unregister(Activity activity){
        if(activities.contains(activity)){
            activities.remove(activity);
        }
    }

    public void removeAll(){
        activities.clear();
        currentActivity=null;

    }

    public Activity getCurrentActivity(){
        return currentActivity;
    }


}
