package com.project.logMonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class LogMonitoringSystemApplication {

	public static void main(String[] args) {

		SpringApplication.run(LogMonitoringSystemApplication.class, args);
		System.out.println("Hello log monitoring");
	}

}
