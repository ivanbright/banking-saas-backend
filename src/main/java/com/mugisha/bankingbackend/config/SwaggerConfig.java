package com.mugisha.bankingbackend.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI bankingApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Banking API")
                        .description("API documentation for Banking Backend")
                        .version("1.0"));
    }
}
