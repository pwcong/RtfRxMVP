package me.pwcong.rtfrxmvp.utils;

import android.content.Intent;

import me.pwcong.rtfrxmvp.R;
import me.pwcong.rtfrxmvp.manager.ActivityManager;

/**
 * Created by pwcong on 2016/8/23.
 */
public abstract class ActivityUtils {

    public static void share(String message) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, message);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        ActivityManager.getInstance().getCurrentActivity().startActivity(Intent.createChooser(intent, ResourceUtils.fromStringResId(R.string.share_to)));

    }


}
