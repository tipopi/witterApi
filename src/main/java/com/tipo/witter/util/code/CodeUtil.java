package com.tipo.witter.util.code;

import com.tipo.witter.tool.BaseStatic;
import com.sun.jmx.snmp.Timestamp;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.UUID;

/**
 * @author Tipo
 * @version 1.0
 * @date 7/30/20195:30 PM
 */
public class CodeUtil {
    public static String createToken() {
            return UUID.randomUUID().toString();
    }

    public static String createSalt() {
        return new Timestamp(System.currentTimeMillis()).toString();
    }
    public static String getToken() {
        String token =  ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader(BaseStatic.KEY_SESSION_TOKEN);
        return token;
    }
}
