package me.pwcong.rtfrxmvp.manager;

import android.content.Context;
import android.content.SharedPreferences;

import me.pwcong.rtfrxmvp.App;
import me.pwcong.rtfrxmvp.conf.Constants;

/**
 * Created by pwcong on 2016/8/25.
 */
public class SharedPreferencesManager {

    private SharedPreferencesManager() {
    }

    private static SharedPreferences instance;

    public static synchronized SharedPreferences getInstance() {

        if (null == instance) {
            instance = App.getInstance().getSharedPreferences(Constants.PRE_NAME, Context.MODE_PRIVATE);
        }
        return instance;

    }

}
