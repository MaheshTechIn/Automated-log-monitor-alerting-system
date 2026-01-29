package com.project.logMonitor.controller;

import com.project.logMonitor.dto.MetricsResponse;
import com.project.logMonitor.service.MetricsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/metrics")
@CrossOrigin(origins = "http://localhost:3000")
public class MetricsController {

    private final MetricsService metricsService;

    public MetricsController(MetricsService metricsService) {
        this.metricsService = metricsService;
    }

    @GetMapping
    public MetricsResponse fetchMetrics() {
        return metricsService.getMetrics();
    }
}