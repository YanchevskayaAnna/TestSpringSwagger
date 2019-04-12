package com.epam.producing.testProject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //.apis(RequestHandlerSelectors.basePackage("com.epam.producing.testProject"))
                .apis(RequestHandlerSelectors.basePackage("com.epam.producing.testProject.web"))
                .paths(regex("/employees.*"))
                .build()
                .apiInfo(apiInfo());
//                .securitySchemes(Arrays.asList(securityScheme()))
//                .securityContexts(Arrays.asList(securityContext()));;
    }

//    @Bean
//    public SecurityConfiguration security() {
//        return SecurityConfigurationBuilder.builder()
//                .clientId(CLIENT_ID)
//                .clientSecret(CLIENT_SECRET)
//                .scopeSeparator(" ")
//                .useBasicAuthenticationWithAccessCodeGrant(true)
//                .build();
//    }

    private ApiInfo apiInfo() {
        return new ApiInfo("My REST API",
                "about employee & addresses",
                "1.0.0", "Terms of service",
                 new Contact("Anna Y", "https://www.epam.com/", "hanna_yanchevska@epam.com"),
                "License of API", "API license URL", Collections.emptyList());
    }
}
