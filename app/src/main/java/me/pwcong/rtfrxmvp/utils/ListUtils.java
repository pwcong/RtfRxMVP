package me.pwcong.rtfrxmvp.utils;

import java.util.List;

/**
 * Created by pwcong on 2016/8/24.
 */
public class ListUtils {

    private ListUtils(){}

    public static boolean isNullOrEmpty(List list) {

        return null == list || list.size() <= 0;

    }

}
