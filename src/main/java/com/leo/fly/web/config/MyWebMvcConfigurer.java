package com.leo.fly.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
//@EnableSwagger2
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    @Value("${file.photo.dir}")
    String imageBaseDir;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // TODO Auto-generated method stub
//        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");

//        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        //将所有/static/** 访问都映射到classpath:/static/ 目录下
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");

        registry.addResourceHandler("/video/**").addResourceLocations("file:"+imageBaseDir);

        registry.addResourceHandler("/img/**").addResourceLocations("file:"+imageBaseDir);
        //定义到硬盘
//        registry.addResourceHandler("/picture/**").addResourceLocations("file:D:/picture/");

        WebMvcConfigurer.super.addResourceHandlers(registry);
    }

}
