package com.project.logMonitor.repository;

import com.project.logMonitor.entity.LogEntity;
//import org.hibernate.query.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface LogRepository extends JpaRepository<LogEntity, Long> {

    Page<LogEntity> findByLevel(String level, Pageable pageable);
    Page<LogEntity> findByService(String service, Pageable pageable);
    Page<LogEntity> findByLevelAndService(String level, String service, Pageable pageable);

    long countByLevel(String level);

    @Query("SELECT COUNT(l) FROM LogEntity l")
    long countTotalLogs();

    long countByLevelAndTimestampAfter(
            String level,
            LocalDateTime time
    );

}

