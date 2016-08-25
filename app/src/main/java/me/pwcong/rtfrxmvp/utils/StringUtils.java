package me.pwcong.rtfrxmvp.utils;

/**
 * Created by pwcong on 2016/8/25.
 */
public abstract class StringUtils {

    public static boolean isNullOrEmpty(String s){

        if(s==null||s.isEmpty()){
            return true;
        }else {
            return false;
        }

    }

}
