package com.project.logMonitor.service;

import com.project.logMonitor.dto.MetricsResponse;
import com.project.logMonitor.repository.AlertRepository;
import com.project.logMonitor.repository.LogRepository;
import org.springframework.stereotype.Service;

    @Service
    public class MetricsService {

        private final LogRepository logRepository;
        private final AlertRepository alertRepository;

        public MetricsService(LogRepository logRepository, AlertRepository alertRepository) {
            this.logRepository = logRepository;
            this.alertRepository = alertRepository;
        }

        public MetricsResponse getMetrics() {
            MetricsResponse response = new MetricsResponse();

            response.setTotalLogs(logRepository.countTotalLogs());
            response.setErrorLogs(logRepository.countByLevel("ERROR"));
            response.setWarnLogs(logRepository.countByLevel("WARN"));
            response.setInfoLogs(logRepository.countByLevel("INFO"));
            response.setTotalAlerts(alertRepository.count());

            return response;
        }
    }

