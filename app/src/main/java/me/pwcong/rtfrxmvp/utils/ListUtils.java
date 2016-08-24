package me.pwcong.rtfrxmvp.utils;

import java.util.List;

/**
 * Created by pwcong on 2016/8/24.
 */
public abstract class ListUtils {

    public static boolean isNullOrEmpty(List list){

        if (null==list)
            return true;
        else if(list.size()<=0)
            return true;
        else
            return false;

    }

}
