package me.pwcong.rtfrxmvp;

import android.app.Application;

/**
 * Created by pwcong on 2016/8/19.
 */
public class App extends Application {

    public static App instance =null;

    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
    }

    public static App getInstance(){
        return instance;
    }

}
