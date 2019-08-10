package com.tipo.witter;

import com.tipo.witter.filter.CorsFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author  Tipo
 * @date 7/27/20192:03 PM
 * @version 1.0
 */
@SpringBootApplication
@MapperScan("com.tipo.witter.mapper")
public class WitterApplication {

	public static void main(String[] args) {
		SpringApplication.run(WitterApplication.class, args);
	}

	/**
	 * 配置跨域,满足浏览器同源策略
	 * @date 8:11 AM 8/1/2019
	 * @param
	 * @return org.springframework.boot.web.servlet.FilterRegistrationBean
	 **/
	@Bean
	public FilterRegistrationBean corsFilterSeting(){
		FilterRegistrationBean registrationBean=new FilterRegistrationBean<CorsFilter>(getCors());
		registrationBean.addUrlPatterns("/*");
		registrationBean.setName("CorsFilter");
		registrationBean.setOrder(1);
		return registrationBean;
	}
	@Bean
	public CorsFilter getCors(){
		CorsFilter filter=new CorsFilter();
		//测试时匹配所有来源
		filter.setAllowOrigin("*")
				.setAllowCredentials("true")
				.setAllowHeaders("Content-Type,X-Token")
				.setAllowMethods("GET,POST,PUT,DELETE,OPTIONS");
		return filter;

	}

}
