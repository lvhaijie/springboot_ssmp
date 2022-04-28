package com.lhj.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.servlet.Filter;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
public class CommonConfig {

    //跨域请求过滤器
    @Bean
    public FilterRegistrationBean<Filter> corsBean() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //是否允许跨域请求带cookie ，true为允许
        corsConfiguration.setAllowCredentials(true);
        //跨域访问时间
        corsConfiguration.setMaxAge(36000L);
        //跨域访问地址
        corsConfiguration.addAllowedOriginPattern("*");
        //跨域请求方法
        corsConfiguration.setAllowedMethods(Stream.of("POST", "GET", "DELETE", "PUT", "OPTIONS")
                .collect(Collectors.toList()));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        CorsFilter corsFilter = new CorsFilter(source);
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        bean.setFilter(corsFilter);
        //数值越靠前请求越先进入
        bean.setOrder(-1000);
        return bean;
    }

    //密码加密
    @Bean
    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
        return new PasswordEncoder() {
            @Override
            public String encode( CharSequence rawPassword ) {
                return rawPassword.toString();
            }

            @Override
            public boolean matches( CharSequence rawPassword, String encodedPassword ) {
                return encodedPassword.equals(rawPassword.toString());
            }
        };
    }
}

