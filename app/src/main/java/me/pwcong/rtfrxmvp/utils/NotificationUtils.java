package me.pwcong.rtfrxmvp.utils;

import android.app.Notification;

import me.pwcong.rtfrxmvp.manager.NotificationManager;

/**
 * Created by pwcong on 2016/9/2.
 */
public class NotificationUtils {

    private NotificationUtils() {
    }

    public static void notify(String tag, int id, Notification notification) {

        NotificationManager.getInstance().notify(tag, id, notification);

    }

    public static void notify(int id, Notification notification) {

        NotificationManager.getInstance().notify(id, notification);

    }

}
