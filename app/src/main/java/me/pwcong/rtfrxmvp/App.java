package me.pwcong.rtfrxmvp;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

/**
 * Created by pwcong on 2016/8/19.
 */
public class App extends Application {

    public static App instance = null;

    static {

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO);

    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static App getInstance() {
        return instance;
    }

}
