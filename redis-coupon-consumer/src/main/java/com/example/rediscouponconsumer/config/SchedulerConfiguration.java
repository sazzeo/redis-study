package com.example.rediscouponconsumer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
public class SchedulerConfiguration {


    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {

    }
}
