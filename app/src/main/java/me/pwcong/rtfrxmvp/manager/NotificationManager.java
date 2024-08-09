package me.pwcong.rtfrxmvp.manager;

import android.content.Context;

import me.pwcong.rtfrxmvp.App;

/**
 * Created by pwcong on 2016/9/2.
 */
public class NotificationManager {

    private NotificationManager() {
    }

    private static android.app.NotificationManager instance;

    public static synchronized android.app.NotificationManager getInstance() {
        if (null == instance) {
            instance = (android.app.NotificationManager) App.getInstance()
                    .getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return instance;
    }

}
