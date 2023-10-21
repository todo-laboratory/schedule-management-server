package com.schedule.manager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootTest
@EnableJpaRepositories(basePackages = "com.schedule.manager.**.**.repository")
class ScheduleManagementServerApplicationTests {

    @Test
    void contextLoads() {
    }

}
