package com.tipo.witter.filter;



import com.tipo.witter.tool.BaseStatic;
import com.tipo.witter.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 *  用AOP重构一下，Filter感觉有点不灵活
 * @author  Tipo
 * @date 7/26/20193:20 PM
 * @version 1.2
 */
public class CorsFilter implements Filter {
    private Logger log = LoggerFactory.getLogger(getClass());

    private String allowOrigin;
    private String allowMethods;
    private String allowCredentials;
    private String allowHeaders;
    private String exposeHeaders;

    public CorsFilter setAllowOrigin(String allowOrigin) {
        this.allowOrigin = allowOrigin;
        return this;
    }

    public CorsFilter setAllowMethods(String allowMethods) {
        this.allowMethods = allowMethods;
        return this;
    }

    public CorsFilter setAllowCredentials(String allowCredentials) {
        this.allowCredentials = allowCredentials;
        return this;
    }

    public CorsFilter setAllowHeaders(String allowHeaders) {
        this.allowHeaders = allowHeaders;
        return this;
    }

    public CorsFilter setExposeHeaders(String exposeHeaders) {
        this.exposeHeaders = exposeHeaders;
        return this;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        allowOrigin = filterConfig.getInitParameter("allowOrigin");
//        allowMethods = filterConfig.getInitParameter("allowMethods");
//        allowCredentials = filterConfig.getInitParameter("allowCredentials");
//        allowHeaders = filterConfig.getInitParameter("allowHeaders");
//        exposeHeaders = filterConfig.getInitParameter("exposeHeaders");
    }



    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String currentOrigin = request.getHeader("Origin");
        log.debug("currentOrigin : " + currentOrigin);

        if (StringUtil.isNotEmpty(allowOrigin)) {
            //测试用* 上线去掉
            if (BaseStatic.CORS_DEFULT.equals(allowOrigin)) {
                response.setHeader("Access-Control-Allow-Origin",
                        currentOrigin);
            } else {
                List<String> allowOriginList = Arrays
                        .asList(allowOrigin.split(","));
                log.debug("allowOriginList : " + allowOrigin);
                if (!CollectionUtils.isEmpty(allowOriginList)) {
                    if (allowOriginList.contains(currentOrigin)) {
                        response.setHeader("Access-Control-Allow-Origin",
                                currentOrigin);
                    }
                }
            }

        }
        if (StringUtil.isNotEmpty(allowMethods) && StringUtil.isNotEmpty(allowCredentials) && StringUtil.isNotEmpty(allowHeaders)) {
            response.setHeader("Access-Control-Allow-Methods", allowMethods);
            response.setHeader("Access-Control-Allow-Credentials", allowCredentials);
            response.setHeader("Access-Control-Allow-Headers", allowHeaders);

        }
        if (StringUtil.isNotEmpty(exposeHeaders)) {
            response.setHeader("Access-Control-Expose-Headers", exposeHeaders);
        }
        chain.doFilter(req, res);

    }

    @Override
    public void destroy() {

    }

}

