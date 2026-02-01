package com.project.logMonitor.repository;

import com.project.logMonitor.entity.AlertEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface AlertRepository extends JpaRepository<AlertEntity, Long> {
    long count();
    boolean existsByTypeAndCreatedAtAfter(
            String type,
            LocalDateTime time
    );
}
