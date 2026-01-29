package com.project.logMonitor.alert;

import com.project.logMonitor.entity.AlertEntity;
import com.project.logMonitor.repository.AlertRepository;
import com.project.logMonitor.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
//
//@Service
//public class AlertService {
//    private  static  final int ERROR_THRESHOLD = 2;
//
//    @Autowired
//    private LogRepository logRepository;
//
//    @Autowired
//    private AlertRepository alertRepository;
//
//    public void checkErrorThreshold(){
//        long errorCount  = logRepository.countByLevel("ERROR");
//
//        if(errorCount >= ERROR_THRESHOLD){
//            AlertEntity alert = new AlertEntity();
//            alert.setType("ERROR_THRESHOLD");
//            alert.setMessage("Error logs crossed threshold. count "+errorCount);
//            alert.setCreatedAt(LocalDateTime.now().toString());
//
//            alertRepository.save(alert);
//
//            System.out.println("🚨 ALERTs Triggered successfully");
//
//        }
//    }
//}
@Service
public class AlertService {

    private static final int ERROR_THRESHOLD = 2;
    private static final int WINDOW_MINUTES = 5;

    @Autowired
    private LogRepository logRepository;

    @Autowired
    private AlertRepository alertRepository;

    public void checkErrorThreshold() {

        LocalDateTime windowStart =
                LocalDateTime.now().minusMinutes(WINDOW_MINUTES);

        long errorCount =
                logRepository.countByLevelAndTimestampAfter(
                        "ERROR", windowStart
                );

        if (errorCount >= ERROR_THRESHOLD) {

            AlertEntity alert = new AlertEntity();
            alert.setType("ERROR_THRESHOLD");
            alert.setMessage(
                    "ERROR logs >= " + ERROR_THRESHOLD +
                            " in last " + WINDOW_MINUTES + " minutes"
            );
            alert.setCreatedAt(LocalDateTime.now().toString());

            alertRepository.save(alert);

            System.out.println("🚨 ALERT Triggered (window-based)");
        }
    }
}
