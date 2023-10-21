package com.schedule.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.schedule.manager.**.**.repository")
public class ScheduleManagementServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScheduleManagementServerApplication.class, args);
    }

}
