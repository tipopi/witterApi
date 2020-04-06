package com.tipo.witter.tool;

/**
 *  基本常量池
 * @author  Tipo
 * @date 7/27/20192:47 PM
 * @version 1.0
 */
public class BaseStatic {
    public static final String CHARSET="utf-8";
    /**session权限属性的键*/
    public static final String KEY_SESSION_ROLE="_KEY_SESSION_ROLE";
    /**session账号属性的键*/
    public static final String KEY_SESSION_ACCOUT="_KEY_SESSION_ACCOUT";
    /**session信息map的键*/
    public static final String KEY_SESSION_INFO="_KEY_SESSION_INFO";
    public static final String KEY_SESSION_NAME="_KEY_SESSION_NAME";
    public static final String KEY_SESSION_TOKEN="X-Token";

    public static final String RESPONSE_CONTENT_TYPE_JSON = "application/json;charset=utf-8";
    public static final String FORM_DATA="multipart/form-data";
    public static final String BOOLEN_TRUE="true";
    public static final String BOOLEN_FALSE="false";
    public static final String COOKIE_NAME="username";
    public static final String COOKIE_ACCOUNT="account";
    public static final String COOKIE_REMENBER="remember";
    public static final String COOKIE_PATH="/";
    public static final String MD5_SALT="PILAOBAN";
    public static final String CORS_DEFULT="*";
    public static final String ADMIN_NAME="Tipo";
    /**分页每页总条数*/
    public static final Integer ROWS  = 25;
//    七牛云bucket
    public static final String ACCESS_KEY="MJm_bXHCN_sS_q30S76MoC1eO7MOWQAII8hN_sbE";
    public static final String SECRET_KEY="bY0Ovfvjw3vkied8i_U8tYq8arhximrzdaz8k_8e";
    public static final String BUCKET="witter-pi";
}
