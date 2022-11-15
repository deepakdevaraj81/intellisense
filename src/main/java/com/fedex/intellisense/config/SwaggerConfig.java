package com.fedex.intellisense.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@EnableAutoConfiguration
@Configuration
@EnableSwagger2
//@Component
public class SwaggerConfig {
       @Bean
       public Docket userApi() {
            return new Docket(DocumentationType.SWAGGER_2)
                       .apiInfo(apiInfo())
                       .select()
                       .apis(RequestHandlerSelectors.basePackage("com.fedex.intellisense"))
                       .paths(PathSelectors.any())
                       .build();
       }

       private ApiInfo apiInfo() {

               return new ApiInfoBuilder()
                       .title("Intellisense APIs")
                       .description("REST APIs for Intellisense").build();
       }
}