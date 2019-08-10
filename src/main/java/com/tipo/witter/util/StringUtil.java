package com.tipo.witter.util;

/**
 *  字符判空
 * @author  Tipo
 * @date 7/27/20191:11 PM
 * @version 1.0
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
