package me.pwcong.rtfrxmvp.utils;

/**
 * Created by pwcong on 2016/8/25.
 */
public class StringUtils {

    private StringUtils() {
    }

    /**
     * 判断字符串是否为null或长度为0
     *
     * @param string 待校验字符串
     * @return {@code true}: 空<br>
     *         {@code false}: 不为空
     */
    public static boolean isEmpty(CharSequence string) {
        return string == null || string.length() == 0;
    }

    /**
     * 判断字符串是否为null或全为空格
     *
     * @param string 待校验字符串
     * @return {@code true}: null或全空格<br>
     *         {@code false}: 不为null且不全空格
     */
    public static boolean isSpace(String string) {
        return (string == null || string.trim().length() == 0);
    }

    /**
     * null转为长度为0的字符串
     *
     * @param string 待转字符串
     * @return string为null转为长度为0字符串，否则不改变
     */
    public static String null2Length0(String string) {
        return string == null ? "" : string;
    }

    /**
     * 返回字符串长度
     *
     * @param string 字符串
     * @return null返回0，其他返回自身长度
     */
    public static int length(CharSequence string) {
        return string == null ? 0 : string.length();
    }

    /**
     * 首字母大写
     *
     * @param string 待转字符串
     * @return 首字母大写字符串
     */
    public static String upperFirstLetter(String string) {
        if (isEmpty(string) || !Character.isLowerCase(string.charAt(0))) {
            return string;
        }
        return String.valueOf((char) (string.charAt(0) - 32)) + string.substring(1);
    }

    /**
     * 首字母小写
     *
     * @param string 待转字符串
     * @return 首字母小写字符串
     */
    public static String lowerFirstLetter(String string) {
        if (isEmpty(string) || !Character.isUpperCase(string.charAt(0))) {
            return string;
        }
        return String.valueOf((char) (string.charAt(0) + 32)) + string.substring(1);
    }

    /**
     * 转化为半角字符
     *
     * @param string 待转字符串
     * @return 半角字符串
     */
    public static String toDBC(String string) {
        if (isEmpty(string)) {
            return string;
        }
        char[] chars = string.toCharArray();
        for (int i = 0, len = chars.length; i < len; i++) {
            if (chars[i] == 12288) {
                chars[i] = ' ';
            } else if (65281 <= chars[i] && chars[i] <= 65374) {
                chars[i] = (char) (chars[i] - 65248);
            } else {
                chars[i] = chars[i];
            }
        }
        return new String(chars);
    }

    /**
     * 转化为全角字符
     *
     * @param string 待转字符串
     * @return 全角字符串
     */
    public static String toSBC(String string) {
        if (isEmpty(string)) {
            return string;
        }
        char[] chars = string.toCharArray();
        for (int i = 0, len = chars.length; i < len; i++) {
            if (chars[i] == ' ') {
                chars[i] = (char) 12288;
            } else if (33 <= chars[i] && chars[i] <= 126) {
                chars[i] = (char) (chars[i] + 65248);
            } else {
                chars[i] = chars[i];
            }
        }
        return new String(chars);
    }

}
