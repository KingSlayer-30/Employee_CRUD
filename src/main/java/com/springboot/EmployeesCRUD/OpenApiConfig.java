package com.springboot.EmployeesCRUD;

import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenApiCustomizer customerGlobalHeaderOpenApiCustomizer() {
        return openApi -> openApi.info(new Info()
                .title("Employees CRUD API")
                .description("API documentation for Employees CRUD operations")
                .version("1.0.0")
                .contact(new io.swagger.v3.oas.models.info.Contact()
                        .name("Dev-Team")
                        .url("https://www.dev-team.com/")
                        .email("dev-team@gmail.com")));
    }
}
