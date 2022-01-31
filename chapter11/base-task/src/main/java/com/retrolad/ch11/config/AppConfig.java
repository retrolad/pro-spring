package com.retrolad.ch11.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@Import({DataServiceConfig.class})
// Enables detection of @Scheduled annotation
@EnableScheduling
public class AppConfig {
}
