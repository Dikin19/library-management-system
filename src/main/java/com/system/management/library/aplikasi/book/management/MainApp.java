package com.system.management.library.aplikasi.book.management;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class MainApp {
//
//	public static void main(String[] args) {
//		SpringApplication.run(MainApp.class, args);
//        System.out.println("Server can be run on http://localhost:8080 ");
//	}
//
//}

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Library Management API",
                version = "1.0",
                description = "API documentation for Library Management System"
        )
)
public class MainApp {
    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
        System.out.println("Server can be run on http://localhost:8080 ");
    }
}

