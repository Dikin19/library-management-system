package com.system.management.library.aplikasi.book.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApp {

	public static void main(String[] args) {
		SpringApplication.run(MainApp.class, args);
        System.out.println("Server can be run on http://localhost:8080 ");
	}

}
