package com.project.logMonitor.repository;

import com.project.logMonitor.entity.AlertEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertRepository extends JpaRepository<AlertEntity, Long> {
    long count();
}
