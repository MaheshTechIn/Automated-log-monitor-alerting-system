package com.project.logMonitor.service;

import com.project.logMonitor.dto.LogRequest;
import com.project.logMonitor.entity.LogEntity;
import com.project.logMonitor.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {

    @Autowired
    private LogRepository logRepository;
    public Page<LogEntity> getLogs(
            String level,
            String service,
            int page,
            int size
    ){
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());

        if(level != null && service != null){
            return logRepository.findByLevelAndService(level, service, pageable);
        }
        else if(level != null){
            return logRepository.findByLevel(level, pageable);
        }
        else if(service != null){
            return logRepository.findByService(service, pageable);
        }
        return logRepository.findAll(pageable);
    }

    public void processLog(LogRequest logRequest){
        LogEntity entity = new LogEntity();
        entity.setLevel(logRequest.getLevel());
        entity.setService((logRequest.getService()));
        entity.setMessage(logRequest.getMessage());
        entity.setTimestamp(logRequest.getTimestamp());

        logRepository.save(entity);
    }

    public List<LogEntity> saveLogs(List<LogEntity> logs) {
        return logRepository.saveAll(logs);
    }
}
