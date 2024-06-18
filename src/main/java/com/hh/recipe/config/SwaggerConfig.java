package com.hh.recipe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //配置要扫描的包
                .apis(RequestHandlerSelectors.basePackage("com.hh.recipe.controller"))
                //过滤扫描的路径
//                .paths(PathSelectors.any())
                .build()
                .groupName("何昊");

    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "hh的swaggerApi文档",
                "在小的帆也能远航",
                "v1.1.1",
                "http://localhoat:1105/",
                new Contact("何昊", "http://localhoat:1105", "hh11-05@qq.com"),
                "License of API", "API license URL", java.util.Collections.emptyList());
    }

}