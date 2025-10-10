package com.system.management.library.aplikasi.book.management.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @GetMapping({"/", "/api"})
    public ResponseEntity<String> api(){
        return ResponseEntity.ok("server is running");
    }

}
