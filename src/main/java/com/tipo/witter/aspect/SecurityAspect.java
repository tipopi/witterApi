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
 * 安全aop，权限和token
 *
 * @author Tipo
 * @version 1.0
 * @date 7/27/20192:03 PM
 */
@Aspect
@Component
public class SecurityAspect {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Pointcut("execution(* com.tipo.witter.controller..*.*(..))")
    public void pointCut() {
    }

    /**
     * token启用，只用于csrf
     *
     * @return java.lang.Object
     * @date 8:49 AM 8/1/2019
     **/
    @Around(value = "pointCut()&&@annotation(security)")
    public Object roleAop(ProceedingJoinPoint point, Security security) throws Throwable {
        if (security.checkToken()) {
            String s1 = RequestUtil.getToken();
            log.info("sessionToken:" + s1);
            String s2 = CodeUtil.getToken();
            log.info("requestToken:" + s2);
            if (StringUtil.isEmpty(s1) || StringUtil.isEmpty(s2) || !s1.equals(s2)) {
                return Msg.fail(ResultEnum.TOKEN_ERRO);
            }
        }
        if (security.createToken()) {
            RequestUtil.createToken(CodeUtil.createToken());
            log.info("createToken:" + RequestUtil.getToken());
        }
        RoleEnum[] roles = security.roles();
        if (roles.length > 0) {
            if (roles[0] == RoleEnum.LOGIN) {
                return point.proceed();
            }
            for (RoleEnum role : roles) {
                if (role == RequestUtil.getRole()) {
                    return point.proceed();
                }
            }
        }
        return Msg.fail(ResultEnum.NO_AUTHORITY);
    }

}
