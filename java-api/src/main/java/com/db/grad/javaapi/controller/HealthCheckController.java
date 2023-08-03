package com.db.grad.javaapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HealthCheckController {
    @GetMapping("/status")
    public String getStatus() {
        return "Bonds API is up and running!";
    }
}
