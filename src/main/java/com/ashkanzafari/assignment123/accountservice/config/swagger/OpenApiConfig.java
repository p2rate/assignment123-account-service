package com.ashkanzafari.assignment123.accountservice.config.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;


@Configuration
@OpenAPIDefinition(info = @Info(title = "Account Service",version = "1.0.0"))
public class OpenApiConfig {
}