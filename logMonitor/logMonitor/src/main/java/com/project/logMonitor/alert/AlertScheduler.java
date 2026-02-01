package com.project.logMonitor.alert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class AlertScheduler {

    @Autowired
    private AlertService alertService;

    @Scheduled(fixedRate = 60000)
    public void monitorErrors(){
        alertService.checkErrorThreshold();
    }
}