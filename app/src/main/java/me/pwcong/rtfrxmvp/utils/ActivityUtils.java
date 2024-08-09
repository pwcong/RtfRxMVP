package me.pwcong.rtfrxmvp.utils;

import android.content.Intent;
import android.net.Uri;

import me.pwcong.rtfrxmvp.R;
import me.pwcong.rtfrxmvp.manager.ActivityManager;

/**
 * Created by pwcong on 2016/8/23.
 */
public class ActivityUtils {

    private ActivityUtils() {
    }

    public static void share(String message) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, message);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        ActivityManager.getInstance().getCurrentActivity()
                .startActivity(Intent.createChooser(intent, ResourceUtils.fromStringResId(R.string.share_to)));

    }

    public static void openUrl(String url) {

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));

        ActivityManager.getInstance().getCurrentActivity().startActivity(intent);

    }

}
