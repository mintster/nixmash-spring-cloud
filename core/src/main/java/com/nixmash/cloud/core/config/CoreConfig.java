package com.nixmash.cloud.core.config;

import com.nixmash.cloud.core.auditors.CurrentTimeDateTimeService;
import com.nixmash.cloud.core.auditors.DateTimeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by daveburke on 5/26/17.
 */
@Configuration
@ComponentScan(basePackages = "com.nixmash.cloud.core")
@PropertySource("classpath:core.properties")
public class CoreConfig {

    @Bean
    DateTimeService currentTimeDateTimeService() {
        return new CurrentTimeDateTimeService();
    }
}
