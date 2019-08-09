package com.tipo.witter.enums;/**
 * Created by tl2p on 7/26/2019.
 */

/**
 * @Description 简单的返回结果集
 * @Autor Tipo
 * @Date 7/26/201911:11 AM
 * @Version 1.0
 */
public enum ResultEnum {
    //账号或密码错误
    FAIL(0),
    //成功
    SUCCESS(1),
    //无操作权限
    NO_AUTHORITY(2),
    //异常
    EXCEPTION(3),
    //参数不正确
    PARAM_NOT_SUIT(4),
    //参数不能为空
    PARAM_NOT_EMPTY(5),
    //文件大小不正常
    FILE_SIZE_NOT_SUIT(6),
    //文件类型不正确
    FILE_TYPE_NOT_SUIT(7),
    //Token错误
    TOKEN_ERRO(8),
    ;

    private Integer code;

    private ResultEnum(Integer code) {
        this.code = code;
    }

    public int value() {
        return this.code;
    }

    public static ResultEnum getResult(Integer code){
        for (ResultEnum res: ResultEnum.values()) {
            Integer in=res.value();
            if (in.equals(code)){
                return res;
            }
        }
        return null;
    }
}
