package me.pwcong.rtfrxmvp.utils;

import me.pwcong.rtfrxmvp.App;
import me.pwcong.rtfrxmvp.R;

/**
 * Created by pwcong on 2016/8/22.
 */
public abstract class ResourceUtils {

    public static String fromStringResId(int id){
        return App.getInstance().getResources().getString(id);
    }

    public static float fromDimenResId(int id){

        return App.getInstance().getResources().getDimension(id);

    }


}
