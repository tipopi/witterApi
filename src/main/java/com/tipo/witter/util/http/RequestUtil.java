package com.tipo.witter.util.http;


import com.tipo.witter.enums.RoleEnum;
import com.tipo.witter.tool.BaseStatic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 *  与request有关的操作
 * @author  Tipo
 * @date 7/27/20192:23 PM
 * @version 1.0
 */
public class RequestUtil {
    private static Logger log = LoggerFactory.getLogger(RequestUtil.class);

    /**登录将账号权限放入*/
    public static void login(String accout,String name,RoleEnum role) throws UnsupportedEncodingException {
        HttpServletRequest request=getRequest();
        HttpServletResponse response=getResponse();
        name= URLEncoder.encode(name, BaseStatic.CHARSET );
        Cookie nameCookie=new Cookie(BaseStatic.COOKIE_NAME,name);
        nameCookie.setPath(BaseStatic.COOKIE_PATH);
        Cookie accountCookie=new Cookie(BaseStatic.COOKIE_ACCOUNT,accout);
        accountCookie.setPath(BaseStatic.COOKIE_PATH);
        response.addCookie(nameCookie);
        response.addCookie(accountCookie);
        request.getSession().setAttribute(BaseStatic.KEY_SESSION_ACCOUT,accout);
        request.getSession().setAttribute(BaseStatic.KEY_SESSION_NAME,name);
        request.getSession().setAttribute(BaseStatic.KEY_SESSION_ROLE,role);
    }
    /**设置记住的认证*/
    public static void setUserToken(String remember){
        Cookie tokenCookie=new Cookie(BaseStatic.COOKIE_REMENBER,remember);
        tokenCookie.setPath(BaseStatic.COOKIE_PATH);
        HttpServletResponse response=getResponse();
        response.addCookie(tokenCookie);
    }
    /**将角色常用信息放入*/
    public static void loginInfo(Map<String,Object> info){
        getRequest().getSession().setAttribute(BaseStatic.KEY_SESSION_INFO,info);
    }
    @SuppressWarnings("unchecked")
    public static Map<String,Object> getInfo(){
        return (Map<String, Object>)getRequest().getSession().getAttribute(BaseStatic.KEY_SESSION_INFO);
    }
    /**
     * 清除cookie
     * @date 8:09 AM 8/1/2019
     **/
    public static void logout(){
        HttpServletRequest request=getRequest();
        HttpServletResponse response=getResponse();
        Cookie nameCookie=new Cookie(BaseStatic.COOKIE_NAME,(String) request.getSession().getAttribute(BaseStatic.KEY_SESSION_NAME));
        nameCookie.setMaxAge(0);
        nameCookie.setPath(BaseStatic.COOKIE_PATH);
        Cookie accountCookie=new Cookie(BaseStatic.COOKIE_ACCOUNT,(String) request.getSession().getAttribute(BaseStatic.KEY_SESSION_ACCOUT));
        accountCookie.setMaxAge(0);
        accountCookie.setPath(BaseStatic.COOKIE_PATH);
        response.addCookie(nameCookie);
        response.addCookie(accountCookie);
        request.getSession().invalidate();
    }
    /**
     * 从session中拿权限
     * @date 8:10 AM 8/1/2019
     * @return com.template.enums.RoleEnum
     **/
    public static RoleEnum getRole(){
        Object obj=getRequest().getSession().getAttribute(BaseStatic.KEY_SESSION_ROLE);
        log.info("role="+obj);
        if (obj==null){return null;}
        return (RoleEnum)obj;
    }
    public static String getToken(){
        HttpServletRequest req = getRequest();
        return (String) req.getSession().getAttribute(BaseStatic.KEY_SESSION_TOKEN);

    }
    public static void createToken(String token){
        HttpServletRequest req = getRequest();
        req.getSession().setAttribute(BaseStatic.KEY_SESSION_TOKEN,token);
    }
    public static boolean isAjax() {
        return "XMLHttpRequest".equals(getRequest().getHeader("X-Requested-With")) || "XMLHttpRequest".equals(getRequest().getParameter("X-Requested-With"));
    }

    public static HttpServletRequest getRequest(){
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }
    public static HttpServletResponse getResponse(){
        return  ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    }
}
