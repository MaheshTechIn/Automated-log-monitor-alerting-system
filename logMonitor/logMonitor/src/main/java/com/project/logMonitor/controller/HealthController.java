package com.project.logMonitor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController   // class handles the HTTP requests
public class HealthController{
    @GetMapping("/addition")
    public int add(){
        return  4+5;
    }
}