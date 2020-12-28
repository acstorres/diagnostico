package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
public class NaController {

    @GetMapping
    public ResponseEntity<Void> naEndpoint() {
        return ResponseEntity.ok(null);
    }
}
