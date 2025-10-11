package com.system.management.library.aplikasi.book.management.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // semua endpoint
                        .allowedOrigins("*") // izinkan semua origin
                        .allowedMethods("*") // izinkan semua metode HTTP
                        .allowedHeaders("*") // izinkan semua header
                        .allowCredentials(false); // harus false kalau pakai allowedOrigins("*")
            }
        };
    }
}
    