package me.pwcong.rtfrxmvp.citypicker.utils;

/**
 * author zaaach on 2016/1/26.
 */
public class StringUtils {
    /**
     * 提取出城市或者县
     * @param city String
     * @param district String
     * @return String
     */
    public static String extractLocation(final String city, final String district){
        return district.contains("县") ? district.substring(0, district.length() - 1) : city.substring(0, city.length() - 1);
    }
}
