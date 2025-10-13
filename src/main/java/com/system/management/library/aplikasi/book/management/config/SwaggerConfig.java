package com.system.management.library.aplikasi.book.management.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Components;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
// link http://localhost:8080/swagger-ui.html
@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Muhammad Sodikin",
                        email = "muhamad.sodikin@mail.com"
                ),
                description = "Swagger documentation for Aplikasi Book management",
                title = "Swagger Aplikasi Book managements",
                version = "1.0.0",
                license = @License(
                        name = "Libray Management System",
                        url = "https://www.msodikin.web.id/"
                ),
                termsOfService = "Terms of service"
        ),
        servers = {
                @Server(
                        description = "Development",
                        url = "http://localhost:8080/"
                ),
                @Server(
                        description = "Production",
                        url = "https://library.msodikin.web.id/"
                )
        },
        security = {
                @SecurityRequirement(
                        name = "bearerAuth"
                )
        }
)
@SecurityScheme(
        name = "bearerAuth",
        description = "JWT auth description",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        // Menghilangkan schemas dengan tidak menambahkan components
                );
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .pathsToMatch("/**")
                .packagesToScan("com.system.management.library")
                .build();
    }
}
