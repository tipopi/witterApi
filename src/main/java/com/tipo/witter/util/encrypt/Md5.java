package com.tipo.witter.util.encrypt;


import com.tipo.witter.lambda.Md5Set;

import java.security.MessageDigest;

/**
 *  加盐不加盐 大厨说了算
 * @author  Tipo
 * @date 7/27/20193:56 PM
 * @version 1.0
 */
public class Md5 {
    private static final String SALT = "we_love_tipo";

    /**
     * 简易版，无言
     * @date 5:03 PM 8/10/2019
     * @param [password, useSalt]
     * @return java.lang.String
     **/
    public static String encode(String password,boolean useSalt){
        String salt=useSalt?SALT:"";
        return encode(password,salt);
    }
    /**
     * 满血版
     * @date 5:04 PM 8/10/2019
     * @param [password, salt]
     * @return java.lang.String
     **/
    public static String encode(String password,String salt) {
        password = password + salt;
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        char[] charArray = password.toCharArray();
        byte[] byteArray = new byte[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            byteArray[i] = (byte) charArray[i];
        }
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuilder hexValue = new StringBuilder();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }
    /**
     * 留个函数式接口 日后好相见,这么处理意义不大，本身是个连续操作，但是我就是想用
     * @date 5:04 PM 8/10/2019
     * @param [password, salt, set]
     * @return java.lang.String
     **/
    public static String encode(String password, String salt, Md5Set set){
        return set.setMd5(password+salt);
    }
}
