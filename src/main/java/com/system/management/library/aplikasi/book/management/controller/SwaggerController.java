package com.system.management.library.aplikasi.book.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SwaggerController {

    @GetMapping("/")
    public String home() {
        // arahkan ke Swagger UI HTML internal (tanpa redirect ke /swagger-ui/index.html)
        return "forward:/swagger-ui/index.html";
    }
}
