package com.tipo.witter.aspect;


import com.tipo.witter.annotation.Security;
import com.tipo.witter.enums.ResultEnum;
import com.tipo.witter.enums.RoleEnum;
import com.tipo.witter.pojo.Msg;
import com.tipo.witter.util.StringUtil;
import com.tipo.witter.util.code.CodeUtil;
import com.tipo.witter.util.http.RequestUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 *  安全aop，权限和token
 * @author  Tipo
 * @date 7/27/20192:03 PM
 * @version 1.0
 */
@Aspect
@Component
public class SecurityAspect {
    private final Logger log = LoggerFactory.getLogger(getClass());
    @Pointcut("execution(* com.tipo.witter.controller..*.*(..))")
    public void pointCut(){}
    /**
     * 暂时不使用token,只切controller和安全注解
     * @date 8:49 AM 8/1/2019
     * @param [point, security]
     * @return java.lang.Object
     **/
    @Around(value = "pointCut()&&@annotation(security)")
    public Object roleAop(ProceedingJoinPoint point, Security security)  throws Throwable{
        if (security.checkToken()){
            String s1=RequestUtil.getToken();
            log.info("sessionToken:"+s1);
            String s2= CodeUtil.getToken();
            log.info("requestToken:"+s2);
            if (!s1.equals(s2)|| StringUtil.isEmpty(s1)||StringUtil.isEmpty(s2)){
                return Msg.fail(ResultEnum.TOKEN_ERRO);
            }
        }
        if (security.createToken()){
            RequestUtil.createToken(CodeUtil.createToken());
            log.info("createtoken:"+RequestUtil.getToken());
        }
        RoleEnum[] roles=security.roles();
        if (roles.length>0){
            for(RoleEnum role:roles){
                if (role== RequestUtil.getRole()){
                    System.out.println(role);
                    return point.proceed();
                }
            }
        }
        return Msg.fail(ResultEnum.NO_AUTHORITY);
    }

}
