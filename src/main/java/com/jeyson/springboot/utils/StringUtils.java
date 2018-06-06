package com.jeyson.springboot.utils;

/**
 * @Author: liujishuai
 * @Time: 2018/2/28 16:31
 * @Description:
 */
public class StringUtils {
    /**
     * 判断字符串是否是邮箱格式
     *
     * @param str
     * @return
     */
    public static boolean isEmail(String str) {
        if (str.matches("[_a-z\\d\\-\\./]+@[_a-z\\d\\-]+(\\.[_a-z\\d\\-]+)*(\\.(info|biz|com|edu|gov|net|am|bz|cn|cx|hk|jp|tw|vc|vn))$")) {
            return true;
        }
        return false;
    }
}
