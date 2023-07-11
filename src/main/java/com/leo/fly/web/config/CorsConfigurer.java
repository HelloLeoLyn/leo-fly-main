package com.leo.fly.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

// 解决跨域问题
@Configuration
public class CorsConfigurer {

    @Bean
    public CorsFilter CorsFilter(){

        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        //  允许哪些域来访问，这里*代表全部
        corsConfiguration.addAllowedHeader("*");
        // 允许哪些请求头
        corsConfiguration.addAllowedMethod("*");
        //  允许哪些请求方式 get post put delete
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**",corsConfiguration);

        return new CorsFilter(source);
    }
}
