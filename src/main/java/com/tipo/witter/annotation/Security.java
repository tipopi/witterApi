package com.tipo.witter.annotation;


import com.tipo.witter.enums.RoleEnum;

import java.lang.annotation.*;

/**
 *  安全注解，包括权限和token
 * @author Tipo
 * @date 7/27/201911:33 AM
 * @version 1.0
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Security {
    //权限身份,可以标多个权限
    RoleEnum[] roles() default {RoleEnum.VISITOR};
//    //是否生成token
//    boolean createToken () default true;
//    //是否使用token
//    boolean checkToken() default false;

}
