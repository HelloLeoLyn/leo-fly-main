package com.leo.fly.web.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

//@Configuration
//@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        Predicate<RequestHandler> selector = RequestHandlerSelectors.basePackage("com.leo.fly");
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .apiInfo(apiInfo())
                .select()
                .apis(selector)
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        //39.108.139.109
        //Port:8087
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("测试地址：http://39.108.139.109:8081/name")
//                .termsOfServiceUrl("https://github.com/zhoutaoo/SpringCloud")
                .version("2.0")
                .build();
    }

}
