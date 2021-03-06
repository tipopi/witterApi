package com.tipo.witter.util.code;

import com.tipo.witter.tool.BaseStatic;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.sql.Timestamp;
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
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader(BaseStatic.KEY_SESSION_TOKEN);
    }
}
