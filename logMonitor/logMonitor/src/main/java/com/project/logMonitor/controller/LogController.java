package com.project.logMonitor.controller;

import com.project.logMonitor.entity.LogEntity;
import com.project.logMonitor.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
@CrossOrigin(origins = "http://localhost:3000")
public class LogController {
    @Autowired
    private LogService logService;
//   for single json data
//    @PostMapping
//    public String ingestLog(@RequestBody LogRequest logRequest){
//        logService.processLog(logRequest);
//        return "Log recieved Sucessfully";
//    }

    // for collection of data
    @PostMapping
    public List<LogEntity> saveLogs(@RequestBody List<LogEntity> logs) {
        return logService.saveLogs(logs);
    }

    // 2. GET LOGS (Filtering + Pagination)
    @GetMapping
    public Page<LogEntity> getLogs(
            @RequestParam(required = false)String level,
            @RequestParam(required = false)String service,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        return logService.getLogs(level, service, page, size);
    }
}
