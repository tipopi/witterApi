package com.tipo.witter.util;

/**
 * @Description 字符判空
 * @autor Tipo
 * @Date 7/27/20191:11 PM
 * @Version 1.0
 */
public class StringUtil {
    public static boolean isNotEmpty(String str) {
        if (str != null && str.length() != 0) {
            return true;
        }
        return false;
    }


    public static boolean isEmpty(String str) {
        if (str != null && str.length() != 0) {
            return false;
        }
        return true;
    }
}
