package me.pwcong.rtfrxmvp.utils;

import me.pwcong.rtfrxmvp.App;
import me.pwcong.rtfrxmvp.R;

/**
 * Created by pwcong on 2016/8/22.
 */
public abstract class StringUtils {

    public static String fromStringResId(int id){

        return App.getInstance().getResources().getString(id);

    }


}
