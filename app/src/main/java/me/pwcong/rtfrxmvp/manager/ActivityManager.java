package me.pwcong.rtfrxmvp.manager;

import android.app.Activity;
import android.util.Log;

import java.util.Vector;

/**
 * Created by pwcong on 2016/8/23.
 */
public class ActivityManager {

    private final String TAG=getClass().getSimpleName();

    private static ActivityManager manager;

    private ActivityManager(){
    }

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
        Log.i(TAG, "register: "+activity);
        Log.i(TAG, "register: ALL "+activities.toString());

    }

    public void unregister(Activity activity){
        if(activities.contains(activity)){
            activities.remove(activity);
        }
        Log.i(TAG, "unregister: "+activity);
        Log.i(TAG, "unregister: ALL"+activities.toString());
    }

    public void removeAll(){

        currentActivity=null;

        for (Activity t:activities){
            t.finish();
        }
        activities.clear();

        Log.i(TAG, "removeAll: OK");
        Log.i(TAG, "removeAll: ALL"+activities.toString());
    }

    public Activity getCurrentActivity(){
        return currentActivity;
    }

    public static void setCurrentActivity(Activity currentActivity) {
        ActivityManager.currentActivity = currentActivity;
    }
}
