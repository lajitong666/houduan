package com.example.plus.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 接口文档配置文件
 * @author zuozhiwei
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.edu.hebut.xiaofang"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        //http://localhost:8080/swagger-ui.html
        return new ApiInfoBuilder()
                .title("消防安全项目-接口文档")
                .description("消防安全项目，小程序端和后台管理接口文档")
                .termsOfServiceUrl("www.xxx.com")
                .contact(new Contact("左志伟", "", "zuozhiwei0@qq.com"))
                .version("1.0")
                .build();
    }
}
