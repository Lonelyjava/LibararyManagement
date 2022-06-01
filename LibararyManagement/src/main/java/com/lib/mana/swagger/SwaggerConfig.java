package com.lib.mana.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableWebMvc
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	 	private static final String SWAGGER_API_VERSION = "1.0";
	    private static final String LICENSE_TEXT = "License";
	    private static final String title = "Uber Cab Booking Framework REST API";
	    private static final String description = "docs for test Framework";
	
	  private ApiInfo apiInfo() {
	        return new ApiInfoBuilder()
	                .title(title)
	                .description(description)
	                .license(LICENSE_TEXT)
	                .version(SWAGGER_API_VERSION)
	                .build();
	    }
	  
    @Bean
    public Docket userApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage("com.lib.mana.controller"))
                .paths(PathSelectors.any())
                .build();
    }
} 