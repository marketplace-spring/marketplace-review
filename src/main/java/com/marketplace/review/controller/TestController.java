package com.marketplace.review.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
public class TestController {

    @Value("${test.name}")
    public String name;

    @GetMapping("/test")
    public ResponseEntity<?> test() {
        return ResponseEntity.ok(this.name);
    }
}
